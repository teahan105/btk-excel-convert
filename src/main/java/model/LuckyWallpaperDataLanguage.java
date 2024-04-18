package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "lucky_wallpaper_data_languages")
public class LuckyWallpaperDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('lucky_wallpaper_data_languages_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "lucky_meaning", length = Integer.MAX_VALUE)
    private String luckyMeaning;

    @Column(name = "topic_result", nullable = false, length = Integer.MAX_VALUE)
    private String topicResult;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    @Column(name = "image_storage_url", length = Integer.MAX_VALUE)
    private String imageStorageUrl;

    public String getImageStorageUrl() {
        return imageStorageUrl;
    }

    public void setImageStorageUrl(String imageStorageUrl) {
        this.imageStorageUrl = imageStorageUrl;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Language getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Language languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLuckyMeaning() {
        return luckyMeaning;
    }

    public void setLuckyMeaning(String luckyMeaning) {
        this.luckyMeaning = luckyMeaning;
    }

    public String getTopicResult() {
        return topicResult;
    }

    public void setTopicResult(String topicResult) {
        this.topicResult = topicResult;
    }

}