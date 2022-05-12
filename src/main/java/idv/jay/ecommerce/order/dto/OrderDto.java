package idv.jay.ecommerce.order.dto;

import lombok.Data;

@Data
public class OrderDto {

    private Integer id;
    private Integer amount;
    private String status;
}
