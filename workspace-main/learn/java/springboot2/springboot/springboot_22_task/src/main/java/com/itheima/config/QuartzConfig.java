package com.itheima.config;

import com.itheima.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        return JobBuilder
                .newJob(MyQuartz.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printJobTrigger() {
        ScheduleBuilder<? extends Trigger> scheduleBuilder
                = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder
                .newTrigger()
                .forJob(printJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
