package com.daun.industries.evgenyborisov.quoters;

import com.daun.industries.evgenyborisov.quoters.interfaces.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
        while(true){
            Thread.sleep(10000);
            Quoter terminatorQuoter = classPathXmlApplicationContext.getBean(Quoter.class);
            terminatorQuoter.sayQuote();
        }

    }
}
