package jp.example.kcgnotify.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.example.kcgnotify.model.Notice;

@Service
public class DiscordNotifier {

    @Value("${discord.webhook.url}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void send(Notice notice) {
        String message = """
        📢 新しいお知らせ

        ■ %s
        %s
        """.formatted(
            notice.getTitle(),
            notice.getContent()
        );

        restTemplate.postForObject(
            webhookUrl,
            Map.of("content", message),
            String.class
        );
    }
}
