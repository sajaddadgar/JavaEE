package model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Person")
@Table(name = "PERSON")

// baraye 1 JPQL @NamedQuery
@NamedQuery(name = "query0", query = "select o from Person o")

// baraye chand ta JPQL @NamedQueries
@NamedQueries({
        @NamedQuery(name = "query1", query = "select o from Person o"),
        @NamedQuery(name = "query2", query = "select o from Person o where id=:id")
})

// baraye sql ast
// tip: dar akhar bayad class ham behesh ezafe konim
@NamedNativeQuery(name = "query3", query = "select * from person", resultClass = Person.class)

public class Person implements Serializable {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;

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
