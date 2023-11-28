package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.OrderFruit;

public interface OrderFruitRepository extends JpaRepository<OrderFruit, Long> {

}
