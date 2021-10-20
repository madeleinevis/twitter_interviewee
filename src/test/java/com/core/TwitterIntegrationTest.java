package com.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import twitter4j.TwitterException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TwitterConfig.class})
@TestPropertySource(value="twitter.properties")
@SpringBootTest(classes={Connectivity.class, Handler.class})
public class TwitterIntegrationTest {

    @Autowired
    Connectivity connectivity;

    @Autowired
    Handler handler;


    @Test
    public void GivenValidAccount_WhenRetrievingTwitterClient_ThenNoException(){
        connectivity.buildConnection();
    }

    @Test
    public void GivenString_WhenSubmitTweet_ThenNoException() throws TwitterException {
        handler.connect();
        handler.postTweet("Tester tweet.");
    }
}
