package ir.barsavanet.shortenurlbackend.web.services;

import ir.barsavanet.shortenurlbackend.config.AppConfig;
import ir.barsavanet.shortenurlbackend.services.ShortenUrlService;
import ir.barsavanet.shortenurlbackend.services.models.UrlModel;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammad
 */
@RestController
@RequestMapping(AppConfig.BASE_API_PATH)
public class ShortenUrlController {

    private static final Logger log = LoggerFactory.getLogger(ShortenUrlController.class);

    @Autowired
    ShortenUrlService services;

    @RequestMapping
    public List<UrlModel> findAll() {
        return services.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody String url) throws Throwable {
        //Need validation here
        UrlModel model = null;
        try {
            model = services.addUrl(url);
            return ResponseEntity.created(getResourceUri(model.getId())).build();
        } catch (URISyntaxException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        UrlModel entity = services.deleteUrl(id);
        if(null != entity) {
            return ResponseEntity.accepted().build();
        }
        
        return ResponseEntity.notFound().build();
    }

    private URI getResourceUri(Long id) throws URISyntaxException {
        return new URI(String.format("%s/%d", AppConfig.BASE_API_PATH, id));
    }
}
