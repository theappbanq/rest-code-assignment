package ir.barsavanet.shortenurlbackend.services;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Mohammad
 */
public interface UrlShortener {
    public URI getShortenUrl(String uri) throws URISyntaxException;
}
