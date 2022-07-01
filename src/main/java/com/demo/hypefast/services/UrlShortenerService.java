package com.demo.hypefast.services;

import com.demo.hypefast.entities.UrlShortenedEntity;
import com.demo.hypefast.exceptions.NotFoundException;
import com.demo.hypefast.repositories.UrlShortenedRepository;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class UrlShortenerService implements IUrlShortener {
    private final UrlShortenedRepository urlShortenedRepository;

    public UrlShortenerService(UrlShortenedRepository urlShortenedRepository) {
        this.urlShortenedRepository = urlShortenedRepository;
    }

    public String getShortenedUrl(String textToBeShortened) {
        return Hashing.murmur3_32().hashString(textToBeShortened, StandardCharsets.UTF_8).toString();
    }

    private UrlShortenedEntity create(String url) {
        UrlShortenedEntity entity = new UrlShortenedEntity();
        entity.setOriginalUrl(url);
        entity.setShortenedUrl("shortened.com/" + getShortenedUrl(url).substring(0,6));
        entity.setRedirectCounter(0);
        return this.urlShortenedRepository.save(entity);
    }

    private UrlShortenedEntity getByShortened(String shortened) throws NotFoundException {
        UrlShortenedEntity entity = this.urlShortenedRepository.findOneByShortenedUrl(shortened);
        if (entity == null) {
            throw new NotFoundException("url doesn't exist");
        }
        return entity;
    }

    private UrlShortenedEntity redirect(UrlShortenedEntity entity) {
        entity.setRedirectCounter(entity.getRedirectCounter() + 1);
        return this.urlShortenedRepository.save(entity);
    }

    @Override
    public UrlShortenedEntity execute(String url) throws NotFoundException {
        if (url.length() == 20) {
            return redirect(getByShortened(url));
        }
        UrlShortenedEntity entity = this.urlShortenedRepository.findOneByOriginalUrl(url);
        if (entity != null) {
            return entity;
        }
        return create(url);
    }
}
