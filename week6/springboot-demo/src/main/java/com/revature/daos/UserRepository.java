package com.revature.daos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//	@Transactional(isolation=Isolation.SERIALIZABLE, rollbackFor=Exception.class)
	User findUserByUsername(String username);
	
//	@Query("Select u from User u WHERE .... ")
//	List<User> findSomethingBySomething();
	
}
