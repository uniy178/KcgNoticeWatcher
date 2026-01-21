package jp.example.kcgnotify.model;

import java.util.Objects;

public class Notice {

    private String title;

    public Notice(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notice)) return false;
        Notice notice = (Notice) o;
        return Objects.equals(title, notice.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
