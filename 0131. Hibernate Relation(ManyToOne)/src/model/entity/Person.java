package model.entity;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(name = "FAMILY", columnDefinition = "VARCHAR2(20)")
    private String family;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK")
    private Car car;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
