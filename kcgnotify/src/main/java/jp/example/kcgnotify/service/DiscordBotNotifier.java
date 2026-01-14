package jp.example.kcgnotify.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.springframework.stereotype.Component;

/*
  Discord BOT を使って通知を送るクラス
  Webhookではなく、BOTとしてメッセージを投稿する
 */
@Component
public class DiscordBotNotifier {

    // 本来は application.yml から読む
    private static final String BOT_TOKEN = "";//ここにBOTトークン
    private static final String CHANNEL_ID = "";//チャンネルID

    private JDA jda;

    //Spring 起動時に BOT を起動する
     
    @PostConstruct
    public void startBot() throws Exception {
        jda = JDABuilder.createDefault(BOT_TOKEN).build();
        jda.awaitReady(); // BOT が完全に起動するまで待つ
        System.out.println("Discord BOT 起動完了");
    }

    //Spring 終了時に BOT を停止する
     
    @PreDestroy
    public void shutdownBot() {
        if (jda != null) {
            jda.shutdown();
        }
    }

    //チャンネルへ通知を送信
    public void sendMessage(String message) {
        TextChannel channel = jda.getTextChannelById(CHANNEL_ID);
        if (channel == null) {
            System.err.println("チャンネルが見つかりません");
            return;
        }

        channel.sendMessage(message).queue();
    }
}
