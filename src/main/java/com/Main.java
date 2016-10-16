package com;

import com.service.FileUploadServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-app.xml", "spring-db.xml", "spring-mvc.xml");
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
        taskExecutor.execute((Runnable) new FileUploadServiceImpl());
        taskExecutor.execute((Runnable) new FileUploadServiceImpl());
        taskExecutor.execute((Runnable) new FileUploadServiceImpl());
        for (;;){
            int count = taskExecutor.getActiveCount();
            System.out.println("Active Threads: " + count);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            if (count == 0){
                taskExecutor.shutdown();
                break;
            }
        }


    }
}
