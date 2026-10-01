package org.parcial.foodorder.application;

import org.modelmapper.ModelMapper;
import org.parcial.foodorder.domain.FoodOrder;
import org.parcial.foodorder.domain.FoodOrderService;
import org.parcial.foodorder.dto.PagedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/foodorder")
public class ProductController {
    private final FoodOrderService foodOrderService;
    private final ModelMapper modelmapper;

    public ProductController(FoodOrderService foodOrderService, ModelMapper modelMapper) {
        this.foodOrderService = foodOrderService;
        this.modelmapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<PagedResponseDto<FoodOrder>> getAllProducts(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<FoodOrder> productsPage = foodOrderService.getAllProducts(pageable);
        PagedResponseDto<FoodOrder> responseDto = new PagedResponseDto<>(productsPage);
        return ResponseEntity.ok(responseDto);
    }
}