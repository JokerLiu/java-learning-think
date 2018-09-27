package com.example.schedule;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package com.example.schedule
 * @auther joker
 * @date 2018/5/8 18:00
 */
@Api(description = "测试任务")
@Component
@EnableScheduling
@Slf4j
public class TestTask {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void timerRate() {
        log.info("定时任务已经启动，当前时间：" + sdf.format(new Date()));
    }
}
