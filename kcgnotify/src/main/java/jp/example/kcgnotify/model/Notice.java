package jp.example.kcgnotify.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Notice {

    private final String title;
    private final String content;
    private final LocalDateTime publishedAt;

    public Notice(String title, String content, LocalDateTime publishedAt) {
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.publishedAt = Objects.requireNonNull(publishedAt);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }
}
