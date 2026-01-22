package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KcgWebScraper {

    @Value("${kcg.target.url}")
    private String targetUrl;

    public Notice fetch() throws Exception {
        Document doc = Jsoup.connect(targetUrl).get();
        String text = doc.title() + " / " + doc.select("body").text();
        return new Notice(text);
    }
}
