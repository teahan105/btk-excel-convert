package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "secret_character_data_languages")
public class SecretCharacterDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @Column(name = "character_name", nullable = false)
    private String characterName;

    @Column(name = "personality", nullable = false)
    private String personality;

    @Column(name = "image_storage_url")
    @Type(type = "org.hibernate.type.TextType")
    private String imageStorageUrl;

    @Column(name = "total_number")
    private Integer totalNumber;

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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
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