package jp.example.kcgnotify.service;

import org.springframework.stereotype.Component;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;

@Component
public class DiffChecker {

    private final NoticeStore store;

    public DiffChecker(NoticeStore store) {
        this.store = store;
    }

    public boolean isNew(Notice notice) {
        return store.isNew(notice);
    }
}
