package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Housing extends Product{
    private int width;
    private int height;

    @Override
    public String toString() {
        return super.toString()+
                ", width=" + width +
                ", height=" + height +
                ")";
    }
}
