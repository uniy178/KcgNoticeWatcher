package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoticeDiffChecker {
    private final NoticeStore store;

    public NoticeDiffChecker(NoticeStore store) {
        this.store = store;
    }

    public List<Notice> findNewNotices(List<Notice> latestList) {
        // すでにStoreにある（通知済み）ものは除外する
        return latestList.stream()
                .filter(n -> !store.contains(n))
                .collect(Collectors.toList());
    }
}