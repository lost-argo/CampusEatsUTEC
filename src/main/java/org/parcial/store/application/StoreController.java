package org.parcial.store.application;

import org.modelmapper.ModelMapper;
import org.parcial.product.dto.PagedResponseDto;
import org.parcial.store.domain.StoreService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;
    private final ModelMapper modelmapper;

    public StoreController(StoreService storeService, ModelMapper modelMapper) {
        this.storeService = storeService;
        this.modelmapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<PagedResponseDto<ProductDto>> getAllProducts(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<ProductDto> productsPage = storeService.getAllProducts(pageable);
        PagedResponseDto<ProductDto> responseDto = new PagedResponseDto<>(productsPage);
        return ResponseEntity.ok(responseDto);
    }
}