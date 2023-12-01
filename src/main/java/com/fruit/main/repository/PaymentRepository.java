package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
