package com.nloukas.test;

import org.junit.BeforeClass;
import org.junit.Test;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static Twitter twitter = new TwitterFactory().getInstance();

    @BeforeClass
    public static void authenticate()
    {
        //  My Application's Consumer and Auth Access Token
        twitter.setOAuthConsumer("<consumerKey>", "<consumerSecret>");
        twitter.setOAuthAccessToken(new AccessToken("<token>", "<tokenSecret>"));
    }

    @Test
    public void testFirstSearchTest() throws TwitterException
    {
        QueryResult res = twitter.search(new Query("tweet"));

    }
}
