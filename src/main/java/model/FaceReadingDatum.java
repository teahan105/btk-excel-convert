package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "face_reading_data")
public class FaceReadingDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('face_reading_data_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sign_code", length = Integer.MAX_VALUE)
    private String signCode;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignCode() {
        return signCode;
    }

    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

}