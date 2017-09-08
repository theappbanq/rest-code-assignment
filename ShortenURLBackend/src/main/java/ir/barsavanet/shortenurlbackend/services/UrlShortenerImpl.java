package ir.barsavanet.shortenurlbackend.services;

import ir.barsavanet.shortenurlbackend.config.AppConfig;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohammad
 */
@Component
public class UrlShortenerImpl implements UrlShortener {

    public URI getShortenUrl(String uri) throws URISyntaxException {
        return new URI(String.format("%s/%s/%s",
                AppConfig.SERVER_URL, AppConfig.REDIRECT_PATH, uri));
    }
}
