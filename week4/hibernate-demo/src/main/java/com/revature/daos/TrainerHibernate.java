package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;

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
		/*
		Using hibernate defined method
		Trainer t= null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			t = s.get(Trainer.class, id);
		}
		return t;
		*/
		/*
		 * Native Query
		Trainer t= null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String sql = "select * from trainers where t_id = :trainerId ;";
			NativeQuery<Trainer> nq = s.createNativeQuery(sql, Trainer.class);
			nq.setParameter("trainerId", id);
			t = nq.getSingleResult();
		}
		return t;
		*/
		/*
		 * HQL Query
		 * 
		 * */
		Trainer t= null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Trainer where id = :trainerId";
			TypedQuery<Trainer> nq = s.createQuery(hql, Trainer.class);
			nq.setParameter("trainerId", id);
			t = nq.getSingleResult();
		}
		return t;
		
		
//		Trainer t= null;
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//			CriteriaBuilder cb = s.getCriteriaBuilder();
//			CriteriaQuery<Trainer> cq = cb.createQuery(Trainer.class);
//			Root<Trainer> root = cq.from(Trainer.class);
//			
//			Predicate predicateForId = cb.equal(root.get("id"), id);
//			Predicate predicateForName = cb.equal(root.get("name"), "Kevin");
//			Predicate predicateForIdAndName = cb.and(predicateForId, predicateForName);
//			
//			cq.select(root).where(predicateForIdAndName);
//			
//			t = s.createQuery(cq).getSingleResult();
//		}
//		return t;
	}

	@Override
	public List<Trainer> getAll() {
		List<Trainer> trainers = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			// Use the classname that been mapped, not the table name
//			trainers = s.createQuery("FROM Trainer", Trainer.class).list();
			trainers = s.createNamedQuery("getAllNq", Trainer.class).getResultList();
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
