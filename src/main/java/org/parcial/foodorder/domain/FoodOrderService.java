package org.parcial.foodorder.domain;

import org.parcial.foodorder.infrastructure.FoodOrderRepository;
import org.parcial.product.dto.PagedResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;

    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public Page<PagedResponseDto> getAllProducts(Pageable pageable) {
        return FoodOrderRepository.findAll(pageable);
    }
}