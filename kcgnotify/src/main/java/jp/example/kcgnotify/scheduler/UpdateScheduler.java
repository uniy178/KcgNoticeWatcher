package jp.example.kcgnotify.scheduler;

import jp.example.kcgnotify.service.UpdateCheckService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateScheduler {

    private final UpdateCheckService service;

    public UpdateScheduler(UpdateCheckService service) {
        this.service = service;
    }

    @Scheduled(fixedDelayString = "${kcg.check.interval}")
    public void run() {
        System.out.println("=== Scheduler fired ===");
        service.check();
    }
}
