package com.github.mofarain.jaspider.webMagic.pipeLine;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class RedisPipeLine implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {

    }
}
