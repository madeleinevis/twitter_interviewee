package com.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

@Component
public class Handler {

    @Autowired
    private Connectivity connection;

    public void connect(){
        connection.buildConnection();
    }

    public void postTweet(String tweet) throws TwitterException {
        connection.getInstance().updateStatus(tweet);
    }
}
