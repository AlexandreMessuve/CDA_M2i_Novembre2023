package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Electronic extends Product{
    private int batteryDuration;

    @Override
    public String toString() {
        return super.toString()+
                ", batteryDuration=" + batteryDuration +
                ")";
    }
}
