package ir.barsavanet.shortenurlbackend.web.services;

import ir.barsavanet.shortenurlbackend.config.AppConfig;
import ir.barsavanet.shortenurlbackend.services.ShortenUrlService;
import ir.barsavanet.shortenurlbackend.services.models.UrlModel;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammad
 */
@RestController
@RequestMapping(AppConfig.REDIRECT_PATH)
public class UrlRedirectorController {

    @Autowired
    ShortenUrlService service;

    @RequestMapping(value = "{id}")
    public void redirect(@PathVariable Long id, HttpServletResponse response) {
        UrlModel url = service.findUrlById(id);
        if (null != url) {
            response.setHeader("Location", url.getOrgUrl());
            response.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }
    }
}
