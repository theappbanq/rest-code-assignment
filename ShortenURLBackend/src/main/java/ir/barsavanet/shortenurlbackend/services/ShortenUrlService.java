package ir.barsavanet.shortenurlbackend.services;

import ir.barsavanet.shortenurlbackend.data.entities.UrlEntity;
import ir.barsavanet.shortenurlbackend.data.repositories.UrlRepository;
import ir.barsavanet.shortenurlbackend.services.models.UrlModel;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammad
 */
@Service
public class ShortenUrlService {

    private static final Logger log = LoggerFactory.getLogger(ShortenUrlService.class);
    
    public static AtomicLong idCounter = new AtomicLong(1);

    @Autowired
    UrlShortener shortener;
    
    @Autowired
    UrlRepository repository;

    public UrlEntity createUrl(String orgUrl) {
        long id = idCounter.incrementAndGet();
        UrlEntity urlEntity = new UrlEntity(id, orgUrl);
        return urlEntity;
    }

    public UrlModel addUrl(String url) throws URISyntaxException {
        UrlEntity entity = createUrl(url);
        repository.save(entity);
        return UrlModel.create(entity.getId(), entity.getOrgUrl(), shortener);
    }

    public UrlModel deleteUrl(Long id) throws URISyntaxException {
        UrlModel result = null;
        UrlEntity entity = repository.findOne(id);
        if (null != entity) {
            repository.delete(id);
            result = UrlModel.create(entity.getId(), entity.getOrgUrl(), shortener);
        }
        return result;
    }
    
    public UrlModel findUrlById(Long id) throws URISyntaxException {
        UrlModel result = null;
        UrlEntity entity = repository.findOne(id);
        if (null != entity) {
            result = UrlModel.create(entity.getId(), entity.getOrgUrl(), shortener);
        }
        return result;
    }
    
    public List<UrlModel> findAll() {
        Iterable<UrlEntity> all = repository.findAll();
        List<UrlModel> result = new ArrayList<>();
        all.forEach((url) -> {
            try {
                result.add(UrlModel.create(url.getId(), url.getOrgUrl(), shortener));
            } catch (URISyntaxException ex) {
                log.error(ex.getMessage(), ex);
            }
        });
        
        return result;
    }
}
