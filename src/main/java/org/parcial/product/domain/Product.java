package org.parcial.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.parcial.store.domain.Store;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    Store storeId;
    @NotBlank
    String name;
    BigDecimal price;
    @Size(min = -1)
    Integer stock;
    String status;
}
