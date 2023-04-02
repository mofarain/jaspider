package com.github.mofarain.jaspider.webMagic.downloader;

import okhttp3.*;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.PlainText;

import java.io.IOException;

@Component
public class OkHttpDownloader implements Downloader {
    @Override
    public Page download(us.codecraft.webmagic.Request req, Task task) {
        OkHttpClient client = new OkHttpClient();

        String url = req.getUrl();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        String json = "";
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                json = responseBody.toString();
            } else {
                System.out.println("Request failed with response code " + response.code());
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        Page page = new Page();
        page.setRawText(json);
        page.setUrl(new PlainText(req.getUrl()));
        page.setRequest(req);
        return page;
    }

    @Override
    public void setThread(int i) {

    }
}
