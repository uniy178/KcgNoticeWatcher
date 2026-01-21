package jp.example.kcgnotify.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.example.kcgnotify.model.Notice;

@Service
public class KcgWebScraper {

    // テスト用：固定データ
    public List<Notice> fetchNotices() {
        return List.of(
            new Notice(
                "【テスト】KCGポータル更新",
                "これはスクレイピング前の仮通知です。",
                LocalDateTime.now()
            )
        );
    }
}
