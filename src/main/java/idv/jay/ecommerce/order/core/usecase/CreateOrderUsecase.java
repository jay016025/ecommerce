package idv.jay.ecommerce.order.core.usecase;

import idv.jay.ecommerce.order.dto.OrderDto;
import idv.jay.ecommerce.order.core.outgoing.CommodityRepo;
import lombok.RequiredArgsConstructor;

/*
    @RequiredArgsConstructor: lombok 提供: 為有final field建立建構子，且掛上@Autowired
    此種注入方式: Constructor injection
 */
@RequiredArgsConstructor
public class CreateOrderUsecase {


    private final CommodityRepo repo;

    public void excute(OrderDto order) {

        order.setStatus("receivable");

        if(order.getAmount() == null) {throw new RuntimeException("Amount no given");}

        if(order.getAmount() < 499) {order.setAmount(order.getAmount() + 50);}

        repo.save(order);
    }
}
