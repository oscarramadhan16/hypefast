package com.demo.hypefast.services;

import com.demo.hypefast.entities.UrlShortenedEntity;
import com.demo.hypefast.exceptions.NotFoundException;

public interface IUrlShortener {
    UrlShortenedEntity execute(String url) throws NotFoundException;
}
