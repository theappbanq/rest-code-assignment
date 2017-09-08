
package ir.barsavanet.shortenurlbackend.services;

import ir.barsavanet.shortenurlbackend.TestAppConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Mohammad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = TestAppConfiguration.class)
public class ShortenUrlServiceTest {
    
    public ShortenUrlServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testCreateUrl() {
    }

    @org.junit.Test
    public void testAddUrl() throws Exception {
    }

    @org.junit.Test
    public void testDeleteUrl() throws Exception {
    }

    @org.junit.Test
    public void testFindUrlById() throws Exception {
    }

    @org.junit.Test
    public void testFindAll() {
    }
    
}
