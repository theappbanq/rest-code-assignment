package ir.barsavanet.shortenurlbackend.data.repositories;

import ir.barsavanet.shortenurlbackend.data.entities.UrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammad
 */
@Repository
public interface UrlRepository extends CrudRepository<UrlEntity, Long> {
    
}
