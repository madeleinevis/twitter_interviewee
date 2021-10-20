package com.core;

import lombok.extern.java.Log;
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

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TwitterConfig.class})
@TestPropertySource(value="twitter.properties")
@SpringBootTest(classes={Connectivity.class, Handler.class})
public class TwitterIntegrationTest {

    @Autowired
    Connectivity connectivity;

    @Autowired
    Handler handler;

    @Before
    public void setUp(){
        handler.connect();
    }

    @Test
    public void GivenValidAccount_WhenRetrievingTwitterClient_ThenNoException(){
        connectivity.buildConnection();
    }

    @Test
    public void GivenString_WhenSubmitTweet_ThenNoException() throws TwitterException {
        handler.postTweet("Tester tweet.");
    }

    @Test
    public void GivenValidAccount_WhenRetrievingTwitterTimeline_ThenNoException() throws TwitterException {
        log.info((handler.getTimeline()).toString());
    }

    @Test
    public void GivenQuery_WhenSearchingTwitterTimeline_ThenReturnResult_AndNoException() throws TwitterException {
        log.info((handler.searchTimeline("test")).toString());
    }

    @Test
    public void GivenValidAccount_WhenListeningForStream_ThenNoException() {
        handler.streamFeed();
    }
}
