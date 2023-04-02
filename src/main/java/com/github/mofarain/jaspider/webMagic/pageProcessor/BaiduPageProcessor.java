package com.github.mofarain.jaspider.webMagic.pageProcessor;

import com.github.mofarain.jaspider.webMagic.BaiduProcess;
import com.github.mofarain.jaspider.webMagic.downloader.OkHttpDownloader;
import com.github.mofarain.jaspider.webMagic.downloader.SeleniumDownloader;
import com.github.mofarain.jaspider.webMagic.pipeLine.MysqlPipeLine;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class BaiduPageProcessor implements PageProcessor {

    private static final String[] urls = new String[]{
            "https://www.baidu.com/",
    };

    @Override
    public void process(Page page) {
        System.out.println("Jaspider 爬取 " + page.getUrl() + " 成功：");
        System.out.println(page.getHtml());
        new BaiduProcess().process(page);
    }

    private Site site = Site.me();

    @Override
    public Site getSite() {
        return site;
    }


//    @Scheduled(cron = "0 18 8 * * *")
    @Scheduled(fixedRate = 1000 * 60 * 60 * 10)
    public void run() {
        Spider.create(new BaiduPageProcessor()).addUrl(urls)
                .setDownloader(new OkHttpDownloader())
                .addPipeline(new MysqlPipeLine())
                .addPipeline(new ConsolePipeline())
                .thread(1)
                .run();
    }
}
