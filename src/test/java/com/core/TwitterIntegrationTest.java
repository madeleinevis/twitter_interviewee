package com.core;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TwitterConfig.class})
@TestPropertySource(value="twitter.properties")
@SpringBootTest(classes={Connectivity.class})
public class TwitterIntegrationTest {

    @Autowired
    Connectivity connectivity;

    @BeforeEach
    private void setUp(){
        connectivity = new Connectivity();
    }

    @Test
    public void GivenValidAccount_WhenRetrievingTwitterClient_ThenNoException(){
        connectivity.buildConnection();
    }
}
