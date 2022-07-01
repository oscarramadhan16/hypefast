package com.demo.hypefast.controllers;

import com.demo.hypefast.controllers.response.UrlShortenedResponse;
import com.demo.hypefast.entities.UrlShortenedEntity;
import com.demo.hypefast.exceptions.NotFoundException;
import com.demo.hypefast.services.IUrlShortener;
import com.demo.hypefast.services.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urlShortener")
public class UrlShortenerController {
    private final IUrlShortener iUrlShortener;

    public UrlShortenerController(IUrlShortener iUrlShortener) {
        this.iUrlShortener = iUrlShortener;
    }

    @PostMapping()
    public ResponseEntity<UrlShortenedResponse> exec(@RequestParam("url") String url) throws NotFoundException {
        UrlShortenedEntity urlShortenedEntity = this.iUrlShortener.execute(url);
        return ResponseEntity.ok(new UrlShortenedResponse(urlShortenedEntity));
    }
}
