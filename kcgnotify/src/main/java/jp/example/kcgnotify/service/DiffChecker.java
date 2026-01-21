package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiffChecker {

    public List<Notice> findNew(List<Notice> current, List<Notice> previous) {
        List<Notice> result = new ArrayList<>();

        for (Notice n : current) {
            if (!previous.contains(n)) {
                result.add(n);
            }
        }
        return result;
    }
}
