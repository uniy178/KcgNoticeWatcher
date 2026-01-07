package jp.example.kcgnotify.service;

import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DiscordNotifier {
    // 自分のWebhook URLをここに貼る
    private static final String WEBHOOK_URL = "YOUR_DISCORD_WEBHOOK_URL";
    private final OkHttpClient client = new OkHttpClient();

    public void send(String message) {
        // Discord Webhookが期待するJSON形式
        String json = "{\"content\": \"" + message + "\"}";
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) System.err.println("通知失敗: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}