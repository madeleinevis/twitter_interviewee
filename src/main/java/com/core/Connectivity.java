package com.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class Connectivity {
    Configuration config;
    Twitter twitter;
    TwitterStream twitterStream;

    @Value("${madeleine.consumerKey}")
    String consumerKey;

    @Value("${madeleine.consumerKeySecret}")
    String consumerKeySecret;

    @Value("${madeleine.accessToken}")
    String accessToken;

    @Value("${madeleine.accessTokenSecret}")
    String accessTokenSecret;

    public Twitter buildConnection(){
        if(config == null) setCb();
        TwitterFactory tf = new TwitterFactory(config);
        twitter = tf.getInstance();
        return twitter;
    }

    public Twitter getInstance() {
        return twitter;
    }

    public TwitterStream getStreamInstance(){
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                // TODO: have a print statement to see the tweets
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}

            @Override
            public void onTrackLimitationNotice(int i) {}

            @Override
            public void onScrubGeo(long l, long l1) {}

            @Override
            public void onStallWarning(StallWarning stallWarning) {}

            @Override
            public void onException(Exception e) {}
        };
        if(config == null) setCb();
        TwitterStreamFactory tsf = new TwitterStreamFactory(config);
        twitterStream = tsf.getInstance();
        twitterStream.addListener(listener);
        return twitterStream;
    }

    public void setCb() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        config = cb.build();
    }
}
