package org.parcial.store.domain;

import org.parcial.product.dto.PagedResponseDto;
import org.parcial.store.infrastructure.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Page<PagedResponseDto> getAllProducts(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }
}
