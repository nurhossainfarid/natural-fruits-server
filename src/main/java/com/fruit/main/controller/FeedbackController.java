package com.fruit.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.main.modal.Feedback;
import com.fruit.main.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackRepository feedbackRepo;

	// Get All Feedback
	@GetMapping("/all")
	public List<Feedback> getAllFeedback() {
		return feedbackRepo.findAll();
	}

	// Add a feedback
	@PostMapping("/add")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

	// Get feedback by id
	@GetMapping("/{fid}")
	public Optional<Feedback> getFeedbackById(@PathVariable("fid") Long id) {
		return feedbackRepo.findById(id);
	}

	// Update feedback
	@PatchMapping("/update")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return feedbackRepo.save(feedback);
	}

	// Delete feedback by id
	@DeleteMapping("/delete/{fid}")
	public String deleteProduct(@PathVariable("fid") Long id) {
		try {
			feedbackRepo.deleteById(id);
		} catch(Exception ex) {
			return "Failed";
		}
		
		return "Delete Successfully";
	}
}
