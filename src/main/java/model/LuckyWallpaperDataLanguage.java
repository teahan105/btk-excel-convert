package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "lucky_wallpaper_data_languages")
public class LuckyWallpaperDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lucky_meaning")
    @Type(type = "org.hibernate.type.TextType")
    private String luckyMeaning;

    @Column(name = "topic_result", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String topicResult;

    @Column(name = "image_storage_url")
    @Type(type = "org.hibernate.type.TextType")
    private String imageStorageUrl;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Language getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Language languageCode) {
        this.languageCode = languageCode;
    }

}