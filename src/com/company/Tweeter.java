package com.company;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Class that can tweet strings to twitter
 * Noah Freriksen
 * 402535
 */
class Tweeter extends Twit {

    private Twitter twitter;

    /**
     * Constructor for the tweeter class
     */
    Tweeter(){
        twitter = getTwitter();
    }

    /**
     * @param tweet string to be tweeted
     * @throws twitter4j.TwitterException when twitter API calls are failed
     */
    void tweet(String user, String location, String text) throws twitter4j.TwitterException{
        String tweet = "@" + user + " The latest news in " + location + ": \n" + text;
        twitter.updateStatus(tweet);
    }
}
