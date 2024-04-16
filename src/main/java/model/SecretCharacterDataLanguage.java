package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "secret_character_data_languages")
public class SecretCharacterDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('secret_character_data_languages_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secret_character_data_id")
    private SecretCharacterDatum secretCharacterData;

    @Column(name = "character_name", nullable = false, length = Integer.MAX_VALUE)
    private String characterName;

    @Column(name = "personality", nullable = false, length = Integer.MAX_VALUE)
    private String personality;

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

    public SecretCharacterDatum getSecretCharacterData() {
        return secretCharacterData;
    }

    public void setSecretCharacterData(SecretCharacterDatum secretCharacterData) {
        this.secretCharacterData = secretCharacterData;
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

}