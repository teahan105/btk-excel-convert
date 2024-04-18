package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "package_service_results")
public class PackageServiceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_storage_url")
    @Type(type = "org.hibernate.type.TextType")
    private String imageStorageUrl;

    
    @Column(name = "lucky_number")
    private String luckyNumber;

    @Column(name = "lucky_external_link")
    @Type(type = "org.hibernate.type.TextType")
    private String luckyExternalLink;

    @Column(name = "created_at")
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageStorageUrl() {
        return imageStorageUrl;
    }

    public void setImageStorageUrl(String imageStorageUrl) {
        this.imageStorageUrl = imageStorageUrl;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getLuckyExternalLink() {
        return luckyExternalLink;
    }

    public void setLuckyExternalLink(String luckyExternalLink) {
        this.luckyExternalLink = luckyExternalLink;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}