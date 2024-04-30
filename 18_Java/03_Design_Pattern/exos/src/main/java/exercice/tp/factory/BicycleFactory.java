package exercice.tp.factory;

import exercice.tp.entity.AbstractProductBuilder;
import exercice.tp.entity.Product;

public class BicycleFactory extends ProductFactory{

    @Override
    public Product createProduct(AbstractProductBuilder bicycleBuilder) {
        return bicycleBuilder.build();
    }
}
