package exercice.tp.productFactory.factory;

import exercice.tp.productFactory.entity.AbstractProductBuilder;
import exercice.tp.productFactory.entity.Product;

public class SmartPhoneFactory extends ProductFactory{
    @Override
    public Product createProduct(AbstractProductBuilder smartPhoneBuilder) {
        return smartPhoneBuilder.build();
    }
}
