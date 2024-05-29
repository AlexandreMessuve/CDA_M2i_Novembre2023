package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    protected int id;
    protected String street;
    protected String city;

    @OneToOne(mappedBy = "address")
    protected Client client;
    @Override
    public String toString() {
        return "street=" + street + '\'' +
                ", city='" + city + '\'';
    }
}
