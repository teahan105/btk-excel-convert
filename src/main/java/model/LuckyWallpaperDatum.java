package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "lucky_wallpaper_data")
public class LuckyWallpaperDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('lucky_wallpaper_data_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_storage_url", length = Integer.MAX_VALUE)
    private String imageStorageUrl;

    @Column(name = "topic_type", length = 50)
    private String topicType;

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

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

}