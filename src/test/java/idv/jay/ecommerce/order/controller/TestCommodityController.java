package idv.jay.ecommerce.order.controller;

import idv.jay.ecommerce.order.dto.Commodity;
import idv.jay.ecommerce.order.dto.OrderDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;

/*
    WebEnvironment.RANDOM_PORT: 代表啟動應用程式時port隨機，避免port衝突
    @SpringBootTest: 使用此 Annotation，代表直接啟動整個project
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCommodityController {

//  通過WebEnvironment.RANDOM_PORT，注入 port
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSelectAllCommodity() {

        List<Commodity> res = restTemplate.getForObject(
                "http://localhost:" + port + "/commodity", List.class);

        Assertions.assertEquals(2, res.size());

    }

    @Test
    public void testCreateOrder() {

        OrderDto order = new OrderDto();

//      HttpEntity 封裝一個http請求或http響應，這裡封裝一個請求
        HttpEntity<OrderDto> request = new HttpEntity<>(order, new HttpHeaders());

        ResponseEntity<Void> res = restTemplate.exchange(
                "http://localhost:" + port + "/order",
                HttpMethod.POST,
                request,
                Void.class
        );

        Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());

    }

}
