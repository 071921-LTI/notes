package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		if(sf == null || sf.isClosed() == true) {
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return sf;
	}
}
