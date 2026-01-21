package jp.example.kcgnotify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;

@Service
public class UpdateCheckService {

    private final KcgWebScraper scraper;
    private final DiffChecker diffChecker;
    private final NoticeStore store;
    private final DiscordNotifier notifier;

    public UpdateCheckService(
            KcgWebScraper scraper,
            DiffChecker diffChecker,
            NoticeStore store,
            DiscordNotifier notifier) {

        this.scraper = scraper;
        this.diffChecker = diffChecker;
        this.store = store;
        this.notifier = notifier;
    }

    public void check() {
        List<Notice> notices = scraper.fetchNotices();

        for (Notice notice : notices) {
            if (diffChecker.isNew(notice)) {
                notifier.send(notice);
                store.save(notice);
            }
        }
    }
}
