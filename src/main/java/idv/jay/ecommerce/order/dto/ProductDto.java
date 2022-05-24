package idv.jay.ecommerce.order.dto;

import idv.jay.ecommerce.order.core.entity.CreateProductCommand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto implements CreateProductCommand {

    private String productName;
    private String desc;
    private BigDecimal price;
    private String unit;
}
