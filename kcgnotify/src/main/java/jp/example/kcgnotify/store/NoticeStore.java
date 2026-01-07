package jp.example.kcgnotify.store;

import jp.example.kcgnotify.model.Notice;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

/**
 * 通知済みのお知らせを一時的に保存しておくクラス
 * 将来的にファイル保存(JSON)などに差し替えやすいよう分離
 */
@Component
public class NoticeStore {
    // 重複を許さないSetで管理
    private final Set<Notice> notifiedNotices = new HashSet<>();

    public boolean contains(Notice notice) {
        return notifiedNotices.contains(notice);
    }

    public void add(Notice notice) {
        notifiedNotices.add(notice);
    }
}