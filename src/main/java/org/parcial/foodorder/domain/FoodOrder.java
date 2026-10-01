package org.parcial.foodorder.domain;

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
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    Store customerId;
    @NotBlank
    Long productId;
    @Size(min > 0)
    Integer quatity;
    ZonedDateTime createdAt;
    String status;
}
