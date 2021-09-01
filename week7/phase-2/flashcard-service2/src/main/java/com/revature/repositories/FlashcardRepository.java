package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {

}
