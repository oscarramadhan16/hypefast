package com.demo.hypefast.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "hypefast", name = "url_shortened")
public class UrlShortenedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT", nullable = false)
    private int id;

    @Column(name = "original_url", columnDefinition = "VARCHAR", length = 255, nullable = false, unique = true)
    private String originalUrl;

    @Column(name = "shortened_url", columnDefinition = "VARCHAR", length = 6, nullable = false, unique = true)
    private String shortenedUrl;

    @Column(name = "redirect_counter", columnDefinition = "INT", nullable = false)
    private int redirectCounter;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public UrlShortenedEntity() {}

    public UrlShortenedEntity(int id, String originalUrl, String shortenedUrl, int redirectCounter, Date createdAt) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.redirectCounter = redirectCounter;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
