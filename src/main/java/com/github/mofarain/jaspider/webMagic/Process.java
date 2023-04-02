package com.github.mofarain.jaspider.webMagic;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

@Component
public interface Process {
    public void process(Page page);

    public void saveNews(Page page);

    public void addNewsPage(Page page);

    public void addDetailPage(Page page);

    public void isYesterday(Page page);
}
