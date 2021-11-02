package com.core;

import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Log
@RestController
public class Controller {

    Gson gson = new Gson();

    @Autowired
    Handler handler;

    @GetMapping("/")
    public String index() { return "Greetings from the Tweets Controller!"; }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password){
        log.info("LOGIN CALLED.");
        boolean response = handler.login(username, password);
        if(response){
            return new ResponseEntity<>("Login Successful.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error Occurred.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/post")
    public ResponseEntity postTweet(@RequestParam("username") String username, @RequestParam("tweet")String tweet){
        boolean response = handler.postTweet(username, tweet);
        if(response){
            return ResponseEntity.ok("Post Successful.");
        }else{
            return ResponseEntity.badRequest().body("Error occurred.");
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity getTweets(@RequestParam("username") String username) {
        try{
            Map<Integer, String[]> response = handler.getTweets(username);
            if(!response.isEmpty()) {
                log.info("Sending: " + gson.toJson(response));
                return ResponseEntity.ok(gson.toJson(response));
            }
        }catch(Exception e){
            log.info("Error occurred: " + e);
        }
        return ResponseEntity.badRequest().body("Error occurred.");
    }
}
