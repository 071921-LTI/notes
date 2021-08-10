package com.revature.daos;

import java.util.List;

import com.revature.models.Trainer;

public interface TrainerDao {

	Trainer add(Trainer t);
	Trainer getById(int id);
	List<Trainer> getAll();
	void update(Trainer t);
	void delete(Trainer t);
}
