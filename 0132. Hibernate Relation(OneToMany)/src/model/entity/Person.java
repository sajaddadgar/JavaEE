package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "PERSON_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(name = "FAMILY", columnDefinition = "VARCHAR2(20)")
    private String family;

    // eager: har vaght ru "PERSON" select zad automatic ro "CAR" ham select zade va "CAR" oon person ham mikeshe biroon
    // lazy: har vaght niaz be "CAR" dashtam taze boro select bezan ru car
    // ******* eager behtare ********

    // maziat lazy: data ha ro hame ro ba ham nemiare va khurd khurd miare
    // badi lazy: connection hamishe bayad baz bashe
    // maziat eager: connection niaz nist baz bashe vali age ba "car" che kar nadashe bashi che dashte bashi, hamun aval miare

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK")
    private List<Car> carList;

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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
