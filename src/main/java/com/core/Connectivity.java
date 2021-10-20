package com.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class Connectivity {
    ConfigurationBuilder cb;
    Twitter twitter;

    @Value("${madeleine.consumerKey}")
    String consumerKey;

    @Value("${madeleine.consumerKeySecret}")
    String consumerKeySecret;

    @Value("${madeleine.accessToken}")
    String accessToken;

    @Value("${madeleine.accessTokenSecret}")
    String accessTokenSecret;

    public Twitter buildConnection(){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        return twitter;
    }

    public Twitter getInstance() {
        return twitter;
    }

}
