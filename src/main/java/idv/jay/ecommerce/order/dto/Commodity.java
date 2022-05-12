package idv.jay.ecommerce.order.dto;

import lombok.Data;

@Data
public class Commodity {

    Integer id;
    String name;
    String description;
    Integer qty;
    Integer price;

}
