package jp.example.kcgnotify.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class DiscordNotifier {

    private static final String WEBHOOK_URL = "ここにWebhook";
    private final OkHttpClient client = new OkHttpClient();

    public void send(String message) {
        String json = "{\"content\":\"" + message + "\"}";
        RequestBody body = RequestBody.create(
                json, MediaType.get("application/json")
        );

        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            // OK
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
