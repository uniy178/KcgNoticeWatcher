package jp.example.kcgnotify.model;

import java.util.Objects;

/**
 * お知らせ1件のデータを保持するクラス
 */
public class Notice {
    private final String title;
    private final String url;

    public Notice(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() { return title; }
    public String getUrl() { return url; }

    // タイトルが同じなら同じお知らせと判定する（重複チェック用）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return Objects.equals(title, notice.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}