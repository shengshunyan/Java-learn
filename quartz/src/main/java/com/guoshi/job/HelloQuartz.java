package com.guoshi.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.GregorianCalendar;

public class HelloQuartz {
    public static void main(String[] args) throws SchedulerException {
        // 1. 调度器Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2. 触发器
//        普通触发器
//        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
//                .startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
//                .endAt(new GregorianCalendar(2020, 10, 30, 12, 0, 0).getTime())
//                .build();

//        cron触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * 29 10 ?")) // 10月29日每2秒执行一次
                .build();

        // 3. JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // 4. 将JobDetail 和 触发器 增加到调度器中
        scheduler.scheduleJob(jobDetail, trigger);

        // 5. 启动，调度器开始工作
        scheduler.start();
    }
}
