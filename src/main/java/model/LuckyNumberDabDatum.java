package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "lucky_number_dab_data")
public class LuckyNumberDabDatum {
    @Id
    @ColumnDefault("nextval('lucky_number_dab_data_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sum_date_month")
    private Short sumDateMonth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getSumDateMonth() {
        return sumDateMonth;
    }

    public void setSumDateMonth(Short sumDateMonth) {
        this.sumDateMonth = sumDateMonth;
    }

}