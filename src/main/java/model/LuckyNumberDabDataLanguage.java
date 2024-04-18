package model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "lucky_number_dab_data_languages")
public class LuckyNumberDabDataLanguage {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @Column(name = "overall")
    @Type(type = "org.hibernate.type.TextType")
    private String overall;

    @Column(name = "sum_date_month")
    private Short sumDateMonth;

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

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

    public Short getSumDateMonth() {
        return sumDateMonth;
    }

    public void setSumDateMonth(Short sumDateMonth) {
        this.sumDateMonth = sumDateMonth;
    }

}