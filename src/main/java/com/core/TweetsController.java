package com.core;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;

@RestController
public class TweetsController {

    Gson gson = new Gson();
    @Autowired
    Handler handler;

    @GetMapping("/")
    public String index(){
        return "Greetings from the Tweets Controller!";
    }

    //TODO: Login to twitter
    @PostMapping("/login")
    public String login(){
        return "Logging in.";
    }

    //TODO: Get tweets
    @RequestMapping("/get")
    public String getAll(){ // TODO: specify user
        try {
            List<String> tweets = handler.getTimeline();
            return gson.toJson(tweets);
        }catch(TwitterException e){
            e.printStackTrace();
        }
        return "Getting Tweets.";
    }

    //TODO: Post tweets
    @GetMapping("/post")
    public String postTweet(){
        return "Posting tweets";
    }

}
