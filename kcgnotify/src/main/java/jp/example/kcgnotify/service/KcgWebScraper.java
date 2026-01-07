package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class KcgWebScraper {
    private static final String KCG_URL = ""; // URLを入力

    public List<Notice> scrapeLatestNotices() {
        List<Notice> list = new ArrayList<>();
        try {
            // サイトのHTMLを取得
            Document doc = Jsoup.connect(KCG_URL).get();
            // お知らせの一覧（aタグなど）を特定して抽出
            // ※セレクタは実際のサイト構造に合わせて調整が必要
            Elements elements = doc.select(".news-list a"); 

            elements.forEach(el -> {
                String title = el.text();
                String url = el.absUrl("href");
                list.add(new Notice(title, url));
            });
        } catch (Exception e) {
            System.err.println("スクレイピングに失敗しました: " + e.getMessage());
        }
        return list;
    }
}