package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
