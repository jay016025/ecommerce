package idv.jay.ecommerce.order.core.usecase;

import idv.jay.ecommerce.order.core.entity.Product;
import idv.jay.ecommerce.order.dto.ProductDto;
import idv.jay.ecommerce.order.core.outgoing.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class TestCreateProductUsecase {

    private ProductRepo productRepo = Mockito.mock(ProductRepo.class);
    private CreateProductUsecase createProductUsecase = new CreateProductUsecase(productRepo);


    /*
        [] 1. product info created
        [] 2. product status should be 'on sale'
     */
    @Test
    public void createProductTest() {

        ProductDto dto = new ProductDto();
        dto.setProductName("ice cream");
        dto.setDesc("100ML");
        dto.setPrice(new BigDecimal(12));
        dto.setUnit("CUP");

        Product product = createProductUsecase.createProduct(dto);

        Mockito.verify(productRepo).save(product);
        Assertions.assertEquals("on sale", product.getStatus());
    }
}
