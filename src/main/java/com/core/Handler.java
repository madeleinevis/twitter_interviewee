package com.core;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Log
@Component
public class Handler {

    private Map<String, User> users;
    private User currentUser;

    @Value("${password.user1}")
    private String user1Pw;
    @Value("${password.user2}")
    private String user2Pw;
    @Value("${password.user3}")
    private String user3Pw;
    @Value("${password.user4}")
    private String user4Pw;
    @Value("${password.user5}")
    private String user5Pw;

    @Autowired
    public Handler() {
        users = new HashMap<>();
    }

    @PostConstruct
    private void init(){
        log.info(user1Pw);
        log.info(user2Pw);
        log.info(user3Pw);
        log.info(user4Pw);
        log.info(user4Pw);

        users.put("user1", new User("user1", user1Pw));
        users.put("user2", new User("user2", user2Pw));
        users.put("user3", new User("user3", user3Pw));
        users.put("user4", new User("user4", user4Pw));
        users.put("user5", new User("user5", user5Pw));
    }

    public void run(){}

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
