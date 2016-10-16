package com;

import com.service.FileUploadServiceImpl;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
        appCtx.getEnvironment().setActiveProfiles("jpa", "postgres");
        appCtx.load("spring/spring-app.xml", "spring/spring-db.xml", "spring/spring-mvc.xml");
        appCtx.refresh();
        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) appCtx.getBean("taskExecutor");
        taskExecutor.execute(FileUploadServiceImpl::new);
        taskExecutor.execute(FileUploadServiceImpl::new);
        taskExecutor.execute(FileUploadServiceImpl::new);
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
