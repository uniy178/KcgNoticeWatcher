package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DiscordNotifier {

    @Value("${discord.webhook.url}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void notify(Notice notice) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // ★ 通知文を固定
        Map<String, String> body = Map.of(
                "content", "🔔 監視Webが更新されました"
        );

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(webhookUrl, entity, String.class);
    }
}
