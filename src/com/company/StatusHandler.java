package com.company;

import twitter4j.Status;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class that handles the timeline of your twitter account.
 *
 * Noah Freriksen
 * 402535
 */

class StatusHandler extends TimeLineReader {

    private Status newest;

    /**
     * Function that checks your timeline. If there is a new tweet; handle it
     * @throws twitter4j.TwitterException when API calls are failed
     */
    void check() throws twitter4j.TwitterException, IOException, java.lang.InterruptedException {

        // Get all tweets from timeline
        List<Status> statusList;
        Puller puller = new Puller();
        Tweeter tweeter = new Tweeter();

        while(true) {
            TimeUnit.SECONDS.sleep(10);
            statusList = read();
            // Check if there is a new tweet
            if (statusList.get(0) != newest) {
                newest = statusList.get(0);
                String location = retrieveLoc(newest);

                if (!location.equals("")) {
                    Bot bot = new Bot(newest, location);
                    bot.start();
                }
            }
        }
    }

    /**
     * Function that retrieves the location out of a status. Format of text should be: "SOME TEXT #LOCATION" or just "#LOCATION"
     * @param status status that the location needs to be retrieved from
     * @return location as string or empty string when failed
     * @throws IllegalArgumentException when status is in wrong format
     */
    private String retrieveLoc(Status status) throws IllegalArgumentException{
        String text = status.getText();

        try {
            if (text.contains("#")) {
                return text.substring(text.indexOf("#")+1);
            } else {
                throw new IllegalArgumentException("Wrong format");
            }
        }

        catch (IllegalArgumentException e){
            return "";
        }
    }
}
