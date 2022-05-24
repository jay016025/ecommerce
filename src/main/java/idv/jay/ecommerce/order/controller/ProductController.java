package idv.jay.ecommerce.order.controller;

import idv.jay.ecommerce.order.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("createProduct")
    public ResponseEntity createProduct(@RequestBody ProductDto dto) {


        return ResponseEntity.ok().body("");
    }
}
