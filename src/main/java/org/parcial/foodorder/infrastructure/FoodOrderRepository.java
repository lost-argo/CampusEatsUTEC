package org.parcial.foodorder.infrastructure;

import org.parcial.foodorder.domain.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}