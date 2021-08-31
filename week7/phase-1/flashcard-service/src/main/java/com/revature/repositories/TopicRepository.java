package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
