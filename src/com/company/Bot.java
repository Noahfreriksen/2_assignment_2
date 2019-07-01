package com.company;

import twitter4j.Status;
import java.io.IOException;

/**
 * Class that runs threads of a new request for news
 */
public class Bot extends Thread {

    private Status status;
    private String location;

    /**
     * Constructor
     * @param s twitter Status
     * @param l location that was searched for
     */
    Bot(Status s, String l){
        this.status = s;
        this.location = l;
    }

    /**
     * Method that runs a new thread
     */
    public void run(){
        try {
            provideNews();
        }

        catch(IOException | twitter4j.TwitterException e){
            System.out.println(e);
        }
    }

    /**
     * Method that gets the news from google and tweets it back to the user
     * @throws IOException for print
     * @throws twitter4j.TwitterException when API calls are failed
     */
    private void provideNews() throws IOException, twitter4j.TwitterException {
        Puller puller = new Puller();
        Tweeter tweeter = new Tweeter();

        String[] info = puller.pull(location);
        tweeter.tweet(status.getUser().getScreenName(), location, info[0] + "\n" + info[1]);
        System.out.println(location);
    }

}
