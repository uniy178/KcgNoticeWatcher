package jp.example.kcgnotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // ← 定期実行を使うため必須
public class KcgNoticeWatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(KcgNoticeWatcherApplication.class, args);
    }
}
