package jp.example.kcgnotify.store;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jp.example.kcgnotify.model.Notice;

@Component
public class NoticeStore {

    private final Set<String> titles = new HashSet<>();

    public boolean isNew(Notice notice) {
        return !titles.contains(notice.getTitle());
    }

    public void save(Notice notice) {
        titles.add(notice.getTitle());
    }
}
