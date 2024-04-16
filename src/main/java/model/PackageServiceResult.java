package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import java.time.Instant;

@Entity
@Table(name = "package_service_results")
public class PackageServiceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('package_service_results_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_storage_url", length = Integer.MAX_VALUE)
    private String imageStorageUrl;

    @Column(name = "lucky_number", length = Integer.MAX_VALUE)
    private String luckyNumber;

    @Column(name = "lucky_external_link", length = Integer.MAX_VALUE)
    private String luckyExternalLink;

    @ColumnDefault("now()")
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