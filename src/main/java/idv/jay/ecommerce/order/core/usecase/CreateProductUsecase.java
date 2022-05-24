package idv.jay.ecommerce.order.core.usecase;

import idv.jay.ecommerce.order.core.entity.CreateProductCommand;
import idv.jay.ecommerce.order.core.entity.Product;
import idv.jay.ecommerce.order.core.outgoing.ProductRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUsecase {

    private final ProductRepo productRepo;
    public Product createProduct(CreateProductCommand createProductCommand) {

        Product product = new Product();
        product.createProduct(createProductCommand);
        productRepo.save(product);
        return product;
    }
}
