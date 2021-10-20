package com.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Handler {

    @Autowired
    private Connectivity connection;

    public void connect() {
        connection.buildConnection();
    }

    public void postTweet(String tweet) throws TwitterException {
        connection.getInstance().updateStatus(tweet);
    }

    public List<String> getTimeline() throws TwitterException {
        return connection.getInstance().getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public List<String> searchTimeline(String q) throws TwitterException {
        Query query = new Query(q);
        QueryResult result = connection.getInstance().search(query);
        return result.getTweets().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
