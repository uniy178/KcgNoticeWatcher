package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UpdateCheckService {
    private final KcgWebScraper scraper;
    private final NoticeDiffChecker diffChecker;
    private final DiscordNotifier notifier;
    private final NoticeStore store;

    public UpdateCheckService(KcgWebScraper scraper, NoticeDiffChecker diffChecker, 
                              DiscordNotifier notifier, NoticeStore store) {
        this.scraper = scraper;
        this.diffChecker = diffChecker;
        this.notifier = notifier;
        this.store = store;
    }

    public void checkUpdate() {
        System.out.println("更新チェックを開始します...");

        // 1. サイトから取得
        List<Notice> latest = scraper.scrapeLatestNotices();
        
        // 2. 新着だけを抽出
        List<Notice> newNotices = diffChecker.findNewNotices(latest);

        // 3. 通知して保存
        for (Notice n : newNotices) {
            notifier.send("【新着】" + n.getTitle() + "\n" + n.getUrl());
            store.add(n);
        }

        System.out.println("チェック完了。新着件数: " + newNotices.size());
    }
}