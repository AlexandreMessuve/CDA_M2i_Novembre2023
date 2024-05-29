package exercice.observable.entity;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int stockLevel;
}
