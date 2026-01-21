package jp.example.kcgnotify.store;

import jp.example.kcgnotify.model.Notice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticeStore {

    private List<Notice> cache = new ArrayList<>();

    public List<Notice> load() {
        return new ArrayList<>(cache);
    }

    public void save(List<Notice> notices) {
        this.cache = new ArrayList<>(notices);
    }
}
