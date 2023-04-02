package com.github.mofarain.jaspider.webMagic.pipeLine;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class MysqlPipeLine implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        String url = resultItems.get("baidu");
        String title = resultItems.get("title");
        System.out.println("MysqlPipeLine 获取数据成功：");
        System.out.println("地址：" + url);
        System.out.println("标题：" + title);
    }
}
