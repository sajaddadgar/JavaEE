package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(name = "FAMILY", columnDefinition = "VARCHAR2(20)")
    private String family;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK")
    private List<Car> car;

    public Person() {
    }

    public Person(String name, String family, List<Car> car) {
        this.name = name;
        this.family = family;
        this.car = car;
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
}
