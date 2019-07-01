package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Noah Freriksen
 * 402535
 *
 * This class pull an RSS feed from news.google for a given location
 */

class Puller {

    /**
     * @param location place of requested news
     * @return String array with the title and link to the news
     * @throws IOException for readers
     */
    String[] pull(String location) throws IOException {

        // Initialize google news url with given location
        String url = "https://news.google.com/news/rss/headlines/section/geo/" + location;

        // Initialize some variables and the bufferedreader
        URL rssURL = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
        String title = "";
        String link = "";
        String line = in.readLine();

        // Skip the first title and link
        line = line.replace(line.substring(0,line.indexOf("</link>")+7),"");

        // Retrieve the title
        if (line.contains("<title>")){

            int firstPos = line.indexOf("<title>");
            String temp = line.substring(firstPos);
            temp = temp.replace("<title>","");
            int lastPos = temp.indexOf("</title>");
            temp = temp.substring(0, lastPos);
            title += temp + "\n";
        }

        // Retrieve the link
        if (line.contains("<link>")){
            int firstPos = line.indexOf("<link>");
            String temp = line.substring(firstPos);
            temp = temp.replace("<link>", "");
            int lastPos = temp.indexOf("</link>");
            temp = temp.substring(0,lastPos);
            link += temp + "\n";
        }

        /*
        Check if news was retrieved.
        If there was no news available change the title and link
         */
        if (title.contains("This feed is not available.")){
            title = "No news for this place";
            link = "";
        }

        // Close the bufferedreader
        in.close();

        // Store title and link into the to be returned string array
        String[] info = {title, link};

        return info;
    }

}
