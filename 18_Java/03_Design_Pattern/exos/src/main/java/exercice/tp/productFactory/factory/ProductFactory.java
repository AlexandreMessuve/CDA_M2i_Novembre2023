package exercice.tp.productFactory.factory;

import exercice.tp.productFactory.entity.AbstractProductBuilder;
import exercice.tp.productFactory.entity.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(AbstractProductBuilder abstractProductBuilder);
}
