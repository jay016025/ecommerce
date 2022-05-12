package idv.jay.ecommerce.order.controller;

import idv.jay.ecommerce.order.dto.Commodity;
import idv.jay.ecommerce.order.repo.CommodityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommodityController {

    private final CommodityMapper mapper;

    @GetMapping("commodity")
    public List<Commodity> selectAllCommodity() {

        return mapper.selectAll();
    }

    @PostMapping("order")
    public ResponseEntity<Void> createOrder() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
