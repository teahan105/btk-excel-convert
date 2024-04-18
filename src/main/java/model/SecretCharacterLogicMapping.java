package model;

import javax.persistence.*;

@Entity
@Table(name = "secret_character_logic_mapping")
public class SecretCharacterLogicMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "character_match", nullable = false)
    private Short characterMatch;

    @Column(name = "total_number", nullable = false)
    private Short totalNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCharacterMatch() {
        return characterMatch;
    }

    public void setCharacterMatch(Short characterMatch) {
        this.characterMatch = characterMatch;
    }

    public Short getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Short totalNumber) {
        this.totalNumber = totalNumber;
    }

}