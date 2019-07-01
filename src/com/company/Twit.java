package com.company;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Class that can tweet strings to twitter
 * Noah Freriksen
 * 402535
 */
class Twit {

    private Twitter twitter;

    /**
     * Constructor for the tweeter class
     */
    Twit(){
        ConfigurationBuilder cb = new ConfigurationBuilder();

        /*
        Change these parameters for your application
        You can retrieve these parameters from your twitter developer application
         */
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Z9rhbDTZB0p5bLKmNalNiecX4")
                .setOAuthConsumerSecret("xo0sK8XL8N8w1rTGRncVO0PpkVwGtWPBeaEix2D1KdFgSK1sWs")
                .setOAuthAccessToken("1144520339554258944-D4XjxVK5vP45UYw6kZyZocGW2ncEBJ")
                .setOAuthAccessTokenSecret("Kkrmz2nyfojiEa01TAt8RhLUM0gUkEIoo6DOnjgtudC60");
        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    Twitter getTwitter(){
        return twitter;
    }
}
