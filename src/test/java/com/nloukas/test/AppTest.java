package com.nloukas.test;

import org.junit.BeforeClass;
import org.junit.Test;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static Twitter twitter = new TwitterFactory().getInstance();

    @BeforeClass
    public static void authenticate() {
        //  My Application's Consumer and Auth Access Token
        twitter.setOAuthConsumer("", "");
        twitter.setOAuthAccessToken(new AccessToken("", ""));
    }

    @Test
    public void testFirstSearchTest() throws TwitterException {
        QueryResult res = twitter.search(new Query("casey neistat"));
        List<Status> statuses = res.getTweets();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }

    @Test
    public void testFirstSearchTest1() throws TwitterException {
        QueryResult res = twitter.search(new Query("casey neistat"));
        List<Status> statuses = res.getTweets();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }

    @Test
    public void testTimeline() throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }

    //@Test
    public void testPostTweet() throws TwitterException {
        Status status = twitter.updateStatus("Test");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }

    @Test
    public void testDM() throws TwitterException {
        ResponseList<DirectMessage> resp = twitter.getDirectMessages();
        for (DirectMessage dm : resp) {
            System.out.println(dm);
        }
    }
}
