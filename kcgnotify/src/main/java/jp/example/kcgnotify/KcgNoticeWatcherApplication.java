package jp.example.kcgnotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
public class KcgNoticeWatcherApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcgNoticeWatcherApplication.class, args);
    }
}