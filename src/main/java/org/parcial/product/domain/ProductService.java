package org.parcial.product.domain;

import org.parcial.product.dto.PagedResponseDto;
import org.parcial.product.infrastructure.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<PagedResponseDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
