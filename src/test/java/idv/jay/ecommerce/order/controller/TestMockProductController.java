package idv.jay.ecommerce.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import idv.jay.ecommerce.order.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProductController.class)
public class TestMockProductController {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProduct() throws Exception {

        ProductDto dto = new ProductDto();
        dto.setProductName("ice cream");
        dto.setDesc("100ML");
        dto.setPrice(new BigDecimal(12));
        dto.setUnit("CUP");

        String param = objectMapper.writeValueAsString(dto);
        mockMvc.perform(MockMvcRequestBuilders.post("/createProduct")
                        .content(param)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
