package jp.example.kcgnotify;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jp.example.kcgnotify.service.UpdateCheckService;

@SpringBootApplication
public class KcgNoticeWatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(KcgNoticeWatcherApplication.class, args);
    }

    // 起動時に1回だけ実行（テスト用）
    @Bean
    CommandLineRunner test(UpdateCheckService service) {
        return args -> {
            service.check();
        };
    }
}
