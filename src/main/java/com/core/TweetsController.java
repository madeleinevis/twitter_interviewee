package com.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsController {

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
    @GetMapping("/get")
    public String getAll(){
        return "Getting Tweets.";
    }

    //TODO: Post tweets
    @GetMapping("/post")
    public String postTweet(){
        return "Posting tweets";
    }

}
