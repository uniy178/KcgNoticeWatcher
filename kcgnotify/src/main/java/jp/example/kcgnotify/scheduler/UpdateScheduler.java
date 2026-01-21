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

    @Scheduled(fixedRate = 300000) // 5分
    public void run() {
        updateCheckService.check();
    }
}
