package com.company;

import twitter4j.*;
import java.util.List;

/**
 * Class that retrieves your twitter timeline
 */
class TimeLineReader extends Twit{

    private Twitter twitter;

    TimeLineReader(){
        twitter = getTwitter();
    }

    /**
     * Function that reads the timeline and returns an array of type Status with all statuses
     * @return array of type Status
     * @throws twitter4j.TwitterException when twitter API calls are failed
     */
    List<Status> read() throws twitter4j.TwitterException{
        List<Status> statuses = twitter.getHomeTimeline();
        return statuses;
    }
}
