package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schema_migrations")
public class SchemaMigration {
    @Id
    @Column(name = "version", nullable = false)
    private Long id;

    @Column(name = "dirty", nullable = false)
    private Boolean dirty = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

}