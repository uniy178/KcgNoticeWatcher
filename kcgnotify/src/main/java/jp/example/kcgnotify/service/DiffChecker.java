package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.springframework.stereotype.Service;

@Service
public class DiffChecker {

    public boolean hasDiff(Notice oldNotice, Notice newNotice) {
        if (oldNotice == null) {
            return true;
        }
        return !oldNotice.getContent().equals(newNotice.getContent());
    }
}
