package idv.jay.ecommerce.order.controller;

import com.google.common.collect.Lists;
import idv.jay.ecommerce.order.dto.Commodity;
import idv.jay.ecommerce.order.dto.OrderDto;
import idv.jay.ecommerce.order.repo.CommodityMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
    @WebMvcTest: 只啟動 controller layer
    controllers: 告訴springBoot只需載入此 controller 與 其 dependency,
                 如無加入此參數,springBoot將會載入所有 controller 與 其dependency。
 */
@WebMvcTest(controllers = CommodityController.class)
public class TestMockCommodityController {

    @Autowired
    MockMvc mvc;

    @MockBean
    CommodityMapper mapper;

    @Test
    public void testSelectAllCommodity() throws Exception {

        Mockito.when(mapper.selectAll())
                .thenReturn(Lists.newArrayList(new Commodity(), new Commodity()));

        /*
            perform: 發起請求
            MockMvcRequestBuilders: 建立請求體
            andExpect: 期望
            jsonPath: 可使用 json path 操作符，$ 為根目錄
         */
        mvc.perform(MockMvcRequestBuilders.get("/commodity"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void testCreateOrder() throws Exception {

        //Arrange
        OrderDto order = new OrderDto();
        order.setId(3);
        order.setAmount(499);
        order.setStatus("receivable");

        mvc.perform(MockMvcRequestBuilders.post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());

    }

}
