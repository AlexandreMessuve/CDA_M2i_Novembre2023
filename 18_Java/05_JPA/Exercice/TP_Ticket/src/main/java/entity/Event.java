package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private int id;

    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_location")
    private Location location;

    @OneToMany(mappedBy = "event")
    private List<Ticket> ticketList;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @Column(columnDefinition = "VARCHAR(8)")
    private LocalTime time;

    private int numberOfPlace;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfPlace=" + numberOfPlace +
                "}\n";
    }
}
