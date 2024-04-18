package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "face_reading_data_languages")
public class FaceReadingDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "face_reading_data_id")
    private FaceReadingDatum faceReadingData;

    @Column(name = "topic_result")
    @Type(type = "org.hibernate.type.TextType")
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

    public FaceReadingDatum getFaceReadingData() {
        return faceReadingData;
    }

    public void setFaceReadingData(FaceReadingDatum faceReadingData) {
        this.faceReadingData = faceReadingData;
    }

    public String getTopicResult() {
        return topicResult;
    }

    public void setTopicResult(String topicResult) {
        this.topicResult = topicResult;
    }

}