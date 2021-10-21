package com.core;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Log
@Component
public class Connectivity {
    Configuration config;

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
        Twitter twitter = tf.getInstance();
        return twitter;
    }

    public TwitterStream getStreamInstance(){
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                // TODO: have a print statement to see the tweets
                log.info("STATUS: " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                log.info("STATUS DELETION: " + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                log.info("TRACK LIMITATION NOTICE: " + i);
            }

            @Override
            public void onScrubGeo(long l, long l1) {
                log.info("SCRUB GEO EVENT: UserID: " + l + " UpToStatusID: " + l1);
            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {
                log.info("GOT STALL WARNING: " + stallWarning);
            }

            @Override
            public void onException(Exception e) {
                e.printStackTrace();
            }
        };
        if(config == null) setCb();
        TwitterStreamFactory tsf = new TwitterStreamFactory(config);
        TwitterStream twitterStream = tsf.getInstance();
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
