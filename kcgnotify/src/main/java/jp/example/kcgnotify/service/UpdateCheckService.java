package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import jp.example.kcgnotify.store.NoticeStore;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Notice> current = scraper.fetch();
        List<Notice> previous = store.load();

        List<Notice> added = diffChecker.findNew(current, previous);

        for (Notice notice : added) {
            notifier.send(notice.getTitle());
        }

        store.save(current);
    }
}
