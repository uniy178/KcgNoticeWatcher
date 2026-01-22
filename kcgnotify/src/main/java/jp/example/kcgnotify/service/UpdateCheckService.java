package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;
import org.springframework.stereotype.Service;

@Service
public class UpdateCheckService {

    private final KcgWebScraper scraper;
    private final DiffChecker diffChecker;
    private final DiscordNotifier notifier;
    private final NoticeStore store;

    public UpdateCheckService(
            KcgWebScraper scraper,
            DiffChecker diffChecker,
            DiscordNotifier notifier,
            NoticeStore store
    ) {
        this.scraper = scraper;
        this.diffChecker = diffChecker;
        this.notifier = notifier;
        this.store = store;
    }

    public void check() {
        try {
            Notice current = scraper.fetch();
            Notice previous = store.getLast();

            if (diffChecker.hasDiff(previous, current)) {
                notifier.notify(current);
                store.save(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
