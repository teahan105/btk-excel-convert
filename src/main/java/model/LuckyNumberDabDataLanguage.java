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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lucky_number_dab_data_id")
    private LuckyNumberDabDatum luckyNumberDabData;

    @Column(name = "overall", length = Integer.MAX_VALUE)
    private String overall;

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

    public LuckyNumberDabDatum getLuckyNumberDabData() {
        return luckyNumberDabData;
    }

    public void setLuckyNumberDabData(LuckyNumberDabDatum luckyNumberDabData) {
        this.luckyNumberDabData = luckyNumberDabData;
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

}