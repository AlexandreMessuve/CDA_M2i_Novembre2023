package exercice.stategy.entity;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NavigationSystem {
    private String destination;
    private NavigationStrategy navigationStrategy;
    public void changeStrategy(NavigationStrategy navigation){
        this.navigationStrategy = navigation;
    }
    public void navigate(){
        navigationStrategy.navigate(destination);
    }
}
