package com.company;

import twitter4j.Twitter;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Puller puller = new Puller();

        String[] code = puller.pull("https://news.google.com/news/rss/headlines/section/geo/enschede");
    }
}
