package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "lucky_number_dow_data_languages")
public class LuckyNumberDowDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "day_of_week")
    private Short dayOfWeek;

    @Column(name = "topic_type", length = 50)
    private String topicType;

    @Column(name = "lucky_number")
    private String luckyNumber;

    @Column(name = "lucky_external_link")
    @Type(type = "org.hibernate.type.TextType")
    private String luckyExternalLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_code", referencedColumnName = "code")
    private Language languageCode;

    @Column(name = "overall")
    private String overall;

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

    public Language getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Language languageCode) {
        this.languageCode = languageCode;
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

}