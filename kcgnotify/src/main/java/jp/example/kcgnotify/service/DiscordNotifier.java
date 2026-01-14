package jp.example.kcgnotify.service;

import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DiscordNotifier {

    private final OkHttpClient client = new OkHttpClient();

    // application.yml から読む想定（今は仮）
    private final String webhookUrl = System.getenv("DISCORD_WEBHOOK_URL");

    public void send(String message) {
        if (webhookUrl == null || webhookUrl.isEmpty()) {
            System.err.println("Discord Webhook URL が設定されていません");
            return;
        }

        String json = "{\"content\": \"" + escape(message) + "\"}";
        RequestBody body = RequestBody.create(
                json,
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(webhookUrl)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.err.println("通知失敗: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String escape(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n");
    }
}
