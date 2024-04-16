package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "package_service_result_languages")
public class PackageServiceResultLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('package_service_result_languages_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", referencedColumnName = "code")
    private Language languageCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "package_service_result_id", nullable = false)
    private PackageServiceResult packageServiceResult;

    @Column(name = "topic_result", length = Integer.MAX_VALUE)
    private String topicResult;

    @Column(name = "overall", length = Integer.MAX_VALUE)
    private String overall;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    @Column(name = "character_name", length = Integer.MAX_VALUE)
    private String characterName;

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

    public PackageServiceResult getPackageServiceResult() {
        return packageServiceResult;
    }

    public void setPackageServiceResult(PackageServiceResult packageServiceResult) {
        this.packageServiceResult = packageServiceResult;
    }

    public String getTopicResult() {
        return topicResult;
    }

    public void setTopicResult(String topicResult) {
        this.topicResult = topicResult;
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

}