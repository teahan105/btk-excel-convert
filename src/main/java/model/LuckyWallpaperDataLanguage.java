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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lucky_wallpaper_data_id")
    private LuckyWallpaperDatum luckyWallpaperData;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "lucky_meaning", length = Integer.MAX_VALUE)
    private String luckyMeaning;

    @Column(name = "topic_result", nullable = false, length = Integer.MAX_VALUE)
    private String topicResult;

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

    public LuckyWallpaperDatum getLuckyWallpaperData() {
        return luckyWallpaperData;
    }

    public void setLuckyWallpaperData(LuckyWallpaperDatum luckyWallpaperData) {
        this.luckyWallpaperData = luckyWallpaperData;
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