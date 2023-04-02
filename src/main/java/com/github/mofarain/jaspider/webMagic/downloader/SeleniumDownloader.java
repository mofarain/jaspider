package com.github.mofarain.jaspider.webMagic.downloader;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;

@Component
public class SeleniumDownloader implements Downloader {
    @Override
    public Page download(Request request, Task task) {
        return null;
    }

    @Override
    public void setThread(int i) {

    }
}
