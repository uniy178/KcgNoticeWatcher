package jp.example.kcgnotify.scheduler;

import jp.example.kcgnotify.service.UpdateCheckService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateScheduler {
    private final UpdateCheckService updateCheckService;

    public UpdateScheduler(UpdateCheckService updateCheckService) {
        this.updateCheckService = updateCheckService;
    }

    // 5分(300,000ミリ秒)ごとに実行
    @Scheduled(fixedRate = 300000)
    public void task() {
        updateCheckService.checkUpdate();
    }
}