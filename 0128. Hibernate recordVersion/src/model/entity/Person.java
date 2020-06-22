package model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;

    @Version
    private int recordVersion;

    public int getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion) {
        this.recordVersion = recordVersion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
