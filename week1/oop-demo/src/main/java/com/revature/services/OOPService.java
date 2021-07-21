package com.revature.services;

import com.revature.interfaces.Flyable;
import com.revature.models.Animal;
import com.revature.models.Human;

public class OOPService {

	public void encapsulate() {
		Animal a1 = new Animal();
		System.out.println(a1.getSpecies());
		System.out.println(a1.getWeight());
		a1.setWeight(56.5f);
		System.out.println(a1.getWeight());
		a1.setWeight(-102.8f);
		
		System.out.println(a1.getWeight());
		
		// toString() method needs to be overridden to provide helpful info
		System.out.println(a1);
	}
	
	public void inherit() {
		Human h = new Human();
		System.out.println(h.move());
		h.setName("Henry");
		System.out.println(h.getName());
	}
	
	public void polymorph() {
		Animal a = new Animal("zebra", true, 150f);
		
		System.out.println(a.move());
		System.out.println(a.move(2.2));
		System.out.println(a.move(2.2,10));
		
		Human h = new Human();
		
		System.out.println(h.move());
		
		Animal a1 = new Human();
		System.out.println("Human Animal: " +a1.move());
	}
	
	public void abstracted() {
		Flyable f = new Human();
		f.fly();
	}
}
