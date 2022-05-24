package idv.jay.ecommerce.order.core.outgoing;

import idv.jay.ecommerce.order.core.entity.Product;

public interface ProductRepo {
    void save(Product product);
}
