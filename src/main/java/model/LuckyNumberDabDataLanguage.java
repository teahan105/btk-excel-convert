package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "lucky_number_dab_data_languages")
public class LuckyNumberDabDataLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('lucky_number_dab_data_languages_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_code", nullable = false, referencedColumnName = "code")
    private Language languageCode;

    @Column(name = "overall", length = Integer.MAX_VALUE)
    private String overall;

    @Column(name = "sum_date_month")
    private Short sumDateMonth;

    public Short getSumDateMonth() {
        return sumDateMonth;
    }

    public void setSumDateMonth(Short sumDateMonth) {
        this.sumDateMonth = sumDateMonth;
    }

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

}