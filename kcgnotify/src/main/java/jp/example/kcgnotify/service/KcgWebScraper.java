package jp.example.kcgnotify.service;

import jp.example.kcgnotify.model.Notice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KcgWebScraper {

    public List<Notice> fetch() {
        List<Notice> list = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://www.kcg.ac.jp/").get();
            doc.select("li").forEach(e -> {
                list.add(new Notice(e.text()));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
