package com.github.mofarain.jaspider.webMagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

@Component
public class BaiduProcess implements Process{

    public static final String SOURCE = "baidu";

    @Override
    public void process(Page page) {
        System.out.println(SOURCE + ">开始处理 " + page.getUrl() + " 的内容：\n");
        Document doc = Jsoup.parse(page.getHtml().toString());
        String title = doc.select("title").first().text();
        System.out.println("title：" + title);
        page.getRequest().putExtra("title", title);
        saveNews(page);
    }

    @Override
    public void saveNews(Page page) {
        page.putField("baidu", page.getUrl().toString());
        page.putField("title", page.getRequest().getExtra("title"));
    }

    @Override
    public void addNewsPage(Page page) {

    }

    @Override
    public void addDetailPage(Page page) {

    }

    @Override
    public void isYesterday(Page page) {

    }
}
