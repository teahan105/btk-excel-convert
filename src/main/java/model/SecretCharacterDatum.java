package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "secret_character_data")
public class SecretCharacterDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('secret_character_data_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_storage_url", length = Integer.MAX_VALUE)
    private String imageStorageUrl;

    @Column(name = "total_number")
    private Integer totalNumber;

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

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

}