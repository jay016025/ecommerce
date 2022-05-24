package idv.jay.ecommerce.order.core.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private String productName;
    private String desc;
    private BigDecimal price;
    private String unit;
    private String status;

    public Product createProduct(CreateProductCommand createProductCommand) {
        this.productName = createProductCommand.getProductName();
        this.desc = createProductCommand.getDesc();
        this.unit = createProductCommand.getUnit();
        this.price = createProductCommand.getPrice();
        this.status = "on sale";
        return this;
    }
}
