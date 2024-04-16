package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "lucky_number_dow_data")
public class LuckyNumberDowDatum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('lucky_number_dow_data_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "day_of_week")
    private Short dayOfWeek;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    @Column(name = "lucky_number", length = Integer.MAX_VALUE)
    private String luckyNumber;

    @Column(name = "lucky_external_link", length = Integer.MAX_VALUE)
    private String luckyExternalLink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Short dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getLuckyExternalLink() {
        return luckyExternalLink;
    }

    public void setLuckyExternalLink(String luckyExternalLink) {
        this.luckyExternalLink = luckyExternalLink;
    }

}