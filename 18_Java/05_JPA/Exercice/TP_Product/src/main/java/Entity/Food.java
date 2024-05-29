package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Food extends Product{
    @Column(columnDefinition = "DATE")
    LocalDate expiryDate;

    @Override
    public String toString() {
        return super.toString() +
                "expiryDate=" + expiryDate.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ")";
    }
}
