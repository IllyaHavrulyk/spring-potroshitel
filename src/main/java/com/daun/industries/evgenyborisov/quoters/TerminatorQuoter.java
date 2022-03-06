package com.daun.industries.evgenyborisov.quoters;

import com.daun.industries.evgenyborisov.quoters.annotations.InjectRandomInt;
import com.daun.industries.evgenyborisov.quoters.annotations.Profiling;
import com.daun.industries.evgenyborisov.quoters.interfaces.Quoter;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2~!");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1~!");
        System.out.println(repeat);
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
