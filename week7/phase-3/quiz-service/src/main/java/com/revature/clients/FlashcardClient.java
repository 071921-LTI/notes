package com.revature.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Flashcard;

@FeignClient(name = "flashcard")
public interface FlashcardClient {

	@GetMapping
	List<Flashcard> getAll();
	
	@GetMapping("/port")
	String retrievePort();
}
