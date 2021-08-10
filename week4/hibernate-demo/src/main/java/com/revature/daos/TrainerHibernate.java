package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Trainer;
import com.revature.util.HibernateUtil;

public class TrainerHibernate implements TrainerDao {

	@Override
	public Trainer add(Trainer t) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		}
		return t;
	}

	@Override
	public Trainer getById(int id) {
		Trainer t= null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			t = s.get(Trainer.class, id);
		}
		return t;
	}

	@Override
	public List<Trainer> getAll() {
		List<Trainer> trainers = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			// Use the classname that been mapped, not the table name
			trainers = s.createQuery("FROM Trainer", Trainer.class).list();
		}
		return trainers;
	}

	@Override
	public void update(Trainer t) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		}
		
	}

	@Override
	public void delete(Trainer t) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		}	
	}

}
