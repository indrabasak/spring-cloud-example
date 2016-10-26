package com.basaki.cloud.support.discovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by indra.basak on 10/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EurekaApplication.class)
@ActiveProfiles("test")
@WebIntegrationTest(randomPort = true)
public class EurekaApplicationTest {

    @Test
    public void loadContext() {
    }
}
