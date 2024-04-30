package exercice.tp.factory;

import exercice.tp.entity.AbstractProductBuilder;
import exercice.tp.entity.Product;

public class ComputerFactory extends ProductFactory{

    @Override
    public Product createProduct(AbstractProductBuilder computerBuilder) {
        return computerBuilder.build();
    }
}
