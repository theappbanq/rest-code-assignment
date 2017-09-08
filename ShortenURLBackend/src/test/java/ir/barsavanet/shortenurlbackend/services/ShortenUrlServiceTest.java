
package ir.barsavanet.shortenurlbackend.services;

import ir.barsavanet.shortenurlbackend.TestAppConfiguration;
import ir.barsavanet.shortenurlbackend.data.repositories.UrlRepository;
import ir.barsavanet.shortenurlbackend.services.models.UrlModel;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    ShortenUrlService service;
    
    UrlModel url;
    
    public ShortenUrlServiceTest() {
    }
    
    @Before
    public void setUp() throws URISyntaxException {
        this.url = service.addUrl("http://test.com/t");
        assertNotNull(this.url);
    }
    
    @After
    public void tearDown() throws URISyntaxException {
    }

    @org.junit.Test
    public void testFindUrlById() throws Exception {
        UrlModel model = service.findUrlById(this.url.getId());
        assertNotNull(model);
    }

    @org.junit.Test
    public void testFindAll() {
        List<UrlModel> all = service.findAll();
        assertNotNull(all);
        assertTrue(all.size() >= 1);
    }

    @Test
    public void testAddUrl() throws Exception {
        UrlModel model = service.addUrl("http://test.com/t1");
        assertNotNull(model);
    }

    @Test
    public void testDeleteUrl() throws Exception {
        UrlModel deleted = service.deleteUrl(this.url.getId());
        assertNotNull(deleted);
    }
    
}
