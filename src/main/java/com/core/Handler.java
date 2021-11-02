package com.core;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Log
@Component
public class Handler {

    private Map<String, User> users;
    private User currentUser;

    @Autowired
    public Handler() {
        users = new HashMap<>();
        users.put("user1", new User("user1", "user1"));
        users.put("user2", new User("user2", "user2"));
        users.put("user3", new User("user3", "user3"));
        users.put("user4", new User("user4", "user4"));
        users.put("user5", new User("user5", "user5"));
    }

    public void run(){

    }

    public boolean login(String username, String password){
        User attemptUser = users.get(username);
        if(attemptUser != null) {
            log.info("Saved pword: " + users.get(username).getPassword() + " given pword: " + password);
            if(attemptUser.getPassword().equals(password)){
                currentUser = attemptUser;
                log.info("Current user: " + currentUser.getUsername());
                return true;
            }
        }
        return false;
    }

    public Map<Integer, String[]> getTweets(String username){
        if(currentUser.getUsername().equals(username)){
            return currentUser.getTweets();
        }
        return null;
    }

    public boolean postTweet(String username, String tweet) {
        if(currentUser.getUsername().equals(username)){
            currentUser.addTweet(tweet);
            return true;
        }else{
            return false;
        }
    }
}
