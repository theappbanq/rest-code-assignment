package ir.barsavanet.shortenurlbackend.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

/**
 *
 * @author Mohammad
 */
@KeySpace("url")
public class UrlEntity {
    @Id
    Long id;
    String orgUrl;

    public UrlEntity() {
    }

    
    
    public UrlEntity(Long id, String orgUrl) {
        this.id = id;
        this.orgUrl = orgUrl;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }
    
}
