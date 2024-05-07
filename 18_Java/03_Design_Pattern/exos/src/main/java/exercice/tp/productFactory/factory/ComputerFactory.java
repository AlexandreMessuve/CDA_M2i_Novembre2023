package exercice.tp.productFactory.factory;

import exercice.tp.productFactory.entity.AbstractProductBuilder;
import exercice.tp.productFactory.entity.Product;

public class ComputerFactory extends ProductFactory{

    @Override
    public Product createProduct(AbstractProductBuilder computerBuilder) {
        return computerBuilder.build();
    }
}
