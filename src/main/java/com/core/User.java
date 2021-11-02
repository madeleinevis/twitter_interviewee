package com.core;

import org.assertj.core.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class User {

    private String username;
    private String password;
    private Map<Integer, String[]> tweets; // Tweet and Timestamp

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        tweets = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<Integer, String[]> getTweets() {
        return tweets;
    }

    public void addTweet(String tweet) {
        String time = DateUtil.now().toString();
        Random rnd = new Random();
        Integer index = rnd.nextInt(99999999);
        tweets.put(index, new String[]{tweet, time});
    }

    public void removeTweet(Integer index){
        tweets.remove(index);
    }
}
