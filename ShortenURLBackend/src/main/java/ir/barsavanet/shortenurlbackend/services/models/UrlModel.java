package ir.barsavanet.shortenurlbackend.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.barsavanet.shortenurlbackend.services.UrlShortener;
import java.net.URISyntaxException;

/**
 *
 * @author Mohammad
 */
public class UrlModel {
    Long id;
    String orgUrl;
    String shortenUrl;

    public UrlModel() {
    }

    public UrlModel(Long id, String orgUrl, String shortenUrl) {
        this.id = id;
        this.orgUrl = orgUrl;
        this.shortenUrl = shortenUrl;
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

    public String getShortenUrl() {
        return shortenUrl;
    }
    
    public static UrlModel create(Long id, String orgUrl,UrlShortener shortener) throws URISyntaxException {
        return new UrlModel(id, orgUrl, shortener.getShortenUrl(id.toString()).toString());
    }
    
}
