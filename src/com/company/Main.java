package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, twitter4j.TwitterException, java.lang.InterruptedException {
        Puller puller = new Puller();

        String[] code = puller.pull("enschede");
        System.out.println(code[0] + code[1]);

        StatusHandler handler = new StatusHandler();
        handler.check();

    }
}
