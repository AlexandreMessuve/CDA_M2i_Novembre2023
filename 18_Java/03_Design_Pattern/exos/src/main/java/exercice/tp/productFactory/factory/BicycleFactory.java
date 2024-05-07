package exercice.tp.productFactory.factory;

import exercice.tp.productFactory.entity.AbstractProductBuilder;
import exercice.tp.productFactory.entity.Product;

public class BicycleFactory extends ProductFactory{

    @Override
    public Product createProduct(AbstractProductBuilder bicycleBuilder) {
        return bicycleBuilder.build();
    }
}
