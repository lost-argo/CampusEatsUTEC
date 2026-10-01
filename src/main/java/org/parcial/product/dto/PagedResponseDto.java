package org.parcial.product.dto;

import org.springframework.data.domain.Page;
import java.util.List;

public class PagedResponseDto<T> {

    private List<T> content;
    int storeId;
    int name;
    long totalElements;

    public PagedResponseDto(Page<T> pageResult) {
    }
}

