package idv.jay.ecommerce.order.core.outgoing;

import idv.jay.ecommerce.order.dto.OrderDto;

public interface CommodityRepo {


    void save(OrderDto order);
}
