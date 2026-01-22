package jp.example.kcgnotify.store;

import jp.example.kcgnotify.model.Notice;
import org.springframework.stereotype.Component;

@Component
public class NoticeStore {

    private Notice last;

    public Notice getLast() {
        return last;
    }

    public void save(Notice notice) {
        this.last = notice;
    }
}
