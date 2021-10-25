package com.fourjcore;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;

@RestController
public class TTweetsController {

    Gson gson = new Gson();
    @Autowired
    THandler tHandler;

    @GetMapping("/4j")
    public String index(){
        return "Greetings from the Tweets Controller!";
    }


    // TODO
    @RequestMapping(value = "/4jlogin", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        return "Logging in.";
    }

    @RequestMapping(value = "/4jget", method = RequestMethod.POST)
    public ResponseEntity getAll(){ // TODO: specify user
        try {
            List<String> tweets = tHandler.getTimeline();
            return ResponseEntity.ok(gson.toJson(tweets));
        }catch(TwitterException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("User not found.");
        }
    }

    @RequestMapping(value = "/4jpost", method = RequestMethod.POST)
    public ResponseEntity postTweet(@RequestParam("tweet-text") String tweet){ // TODO: Specify user
        try {
            tHandler.postTweet(tweet);
            return ResponseEntity.ok().build();
        }catch(TwitterException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to post status update.");
        }
    }

}
