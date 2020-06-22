package amirkabir.model.entity;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK")
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Person() {
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
}
