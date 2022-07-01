package com.demo.hypefast.controllers.response;

import com.demo.hypefast.entities.UrlShortenedEntity;

public class UrlShortenedResponse {
    private String originalUrl;
    private String shortenedUrl;
    private int redirectCounter;

    public UrlShortenedResponse(UrlShortenedEntity urlShortenedEntity) {
        this.originalUrl = urlShortenedEntity.getOriginalUrl();
        this.shortenedUrl = urlShortenedEntity.getShortenedUrl();
        this.redirectCounter = urlShortenedEntity.getRedirectCounter();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public int getRedirectCounter() {
        return redirectCounter;
    }

    public void setRedirectCounter(int redirectCounter) {
        this.redirectCounter = redirectCounter;
    }
}
