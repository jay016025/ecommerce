package idv.jay.ecommerce.order.core.usecase;

import idv.jay.ecommerce.order.dto.OrderDto;
import idv.jay.ecommerce.order.core.outgoing.CommodityRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/*
    @ExtendWith: junit5 擴展 Annotation;
    MockitoExtension.class: 擴展使用mockito API;
 */
@ExtendWith(MockitoExtension.class)
public class TestCreateOrderUsecase {

    @Mock
    private CommodityRepo repo;

    /*
        @InjectMocks: 將@Mock 的物件注入，但該注入的物件需有建構子;
     */
    @InjectMocks
    private CreateOrderUsecase usecase;

    @Test
    public void testStatusReceivable() {

        //Arrange
        OrderDto order = new OrderDto();
        order.setAmount(0);

        //Ack
        usecase.excute(order);

        //Assert
        Assertions.assertEquals("receivable", order.getStatus());

    }

    @Test
    public void testNoAmountShouldThrowRuntimeException() {

        //Arrange
        OrderDto order = new OrderDto();

        //Assert
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                usecase.excute(order);
            }
        });
    }

    @Test
    public void testTotalAmountLess499() {

        //Arrange
        int totalPrice = 480;
        int targetPrice = totalPrice + 50;
        OrderDto order = new OrderDto();
        order.setAmount(totalPrice);

        //Ack
        usecase.excute(order);

        //Assert
        Assertions.assertEquals(targetPrice, order.getAmount());

    }

    @Test
    public void testTotalAmountOver499() {

        //Arrange
        int totalPrice = 500;
        OrderDto order = new OrderDto();
        order.setAmount(totalPrice);

        //Ack
        usecase.excute(order);

        //Assert
        Assertions.assertEquals(totalPrice, order.getAmount());

    }

    @Test
    public void testShouldSave() {

        //Arrange
        int totalPrice = 1000;
        OrderDto order = new OrderDto();
        order.setAmount(totalPrice);

        //Ack
        usecase.excute(order);

        //Assert
        Mockito.verify(repo, Mockito.times(1)).save(order);
    }
}
