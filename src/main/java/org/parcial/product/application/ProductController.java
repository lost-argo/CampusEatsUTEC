package org.parcial.product.application;

import org.modelmapper.ModelMapper;
import org.parcial.product.domain.ProductService;
import org.parcial.product.dto.PagedResponseDto;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelmapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelmapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<PagedResponseDto<ProductDto>> getAllProducts(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<ProductDto> productsPage = productService.getAllProducts(pageable);
        PagedResponseDto<ProductDto> responseDto = new PagedResponseDto<>(productsPage);
        return ResponseEntity.ok(responseDto);
    }
}