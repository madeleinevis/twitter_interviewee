package com.fourjcore;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import twitter4j.TwitterException;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TTwitterConfig.class})
@TestPropertySource(value="classpath:twitter.properties")
@SpringBootTest(classes={TConnectivity.class, THandler.class})
public class TwitterIntegrationTest {

    @Autowired
    TConnectivity TConnectivity;

    @Autowired
    THandler tHandler;

    @Before
    public void setUp(){
        tHandler.connect();
    }

    @Test
    public void GivenValidAccount_WhenRetrievingTwitterClient_ThenNoException(){
        TConnectivity.buildConnection();
    }

    @Test
    public void GivenString_WhenSubmitTweet_ThenNoException() throws TwitterException {
        tHandler.postTweet("Tester tweet.");
    }

    @Test
    public void GivenValidAccount_WhenRetrievingTwitterTimeline_ThenNoException() throws TwitterException {
        log.info((tHandler.getTimeline()).toString());
    }

    @Test
    public void GivenQuery_WhenSearchingTwitterTimeline_ThenReturnResult_AndNoException() throws TwitterException {
        log.info((tHandler.searchTimeline("test")).toString());
    }

    @Test
    public void GivenValidAccount_WhenListeningForStream_ThenNoException() {
        tHandler.streamFeed();
    }
}
