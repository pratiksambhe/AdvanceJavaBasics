package com.example.AUg5_SpringProject.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedularJobs {

    @Scheduled(fixedRate = 4500)
    public void task1() {
        System.out.println("fixed Schedular " + System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 6000)
    public void task2() {
        System.out.println("fixed Delay " + System.currentTimeMillis());
    }

    @Scheduled(initialDelay = 5000,fixedRate = 4000)
    public void task3() {
        System.out.println("initialdelay " + System.currentTimeMillis());
    }

    @Scheduled(cron = "2 * * * * *")
    public void task4(){
        System.out.println("cron job "+System.currentTimeMillis());
    }
}
