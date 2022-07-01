package com.demo.hypefast.repositories;

import com.demo.hypefast.entities.UrlShortenedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenedRepository extends JpaRepository<UrlShortenedEntity,Long> {
    UrlShortenedEntity findOneByShortenedUrl(String shortenedUrl);
    UrlShortenedEntity findOneByOriginalUrl(String originalUrl);
}
