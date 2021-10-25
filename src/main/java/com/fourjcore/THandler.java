package com.fourjcore;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

@Log
@PropertySource(value="classpath:twitter.properties")
@Component
public class THandler {

    @Autowired
    private TConnectivity connection;

    Twitter twitter;
    TwitterStream twitterStream;

    public void run(){
        connect();
        streamFeed();
    }


    public void connect() {
        twitter = connection.buildConnection();
    }

    public void postTweet(String tweet) throws TwitterException {
        twitter.updateStatus(tweet);
    }

    public List<String> getTimeline() throws TwitterException {
        return twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public List<String> searchTimeline(String q) throws TwitterException {
        Query query = new Query(q);
        QueryResult result = twitter.search(query);
        return result.getTweets().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public void streamFeed(){
        twitterStream = connection.getStreamInstance();
    }

    public void updateTwitterStreamFiltering(String keyword){
        String [] keywords = keyword.split(" ");
        FilterQuery filter = new FilterQuery();
        filter.track(keywords);
        twitterStream.filter(filter);
    }

}
