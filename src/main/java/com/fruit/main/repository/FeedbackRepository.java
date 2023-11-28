package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
