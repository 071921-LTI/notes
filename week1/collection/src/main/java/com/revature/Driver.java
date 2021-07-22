package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.revature.models.Animal;
import com.revature.models.AnimalComparator;

public class Driver {

	
	public static void main(String[] args) {
		Integer[] intArr = {1, 2, 3, 4};
		String[] stringArr = {"Hello", "World", "!"};
		
		printAll(intArr);
		printAll(stringArr);
		
		// Used to enforce type safety
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		
		Iterator<Integer> i = arrList.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		
		Iterator<Integer> j = hashSet.iterator();
		while(j.hasNext()) {
			System.out.println(j.next());
		}
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll.peek());
		System.out.println(ll.pop());
		System.out.println(ll.pop());
		
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "String");
		hm.put(2, "World");
		hm.put(3, "!");
		
		for(Integer h: hm.keySet()) {
			System.out.println(hm.get(h));
		}
		
		Animal a = new Animal(1, "John");
		Animal a2 = new Animal(2, "Joe");
		Animal a3 = new Animal(5, "James");
		
		System.out.println(a.compareTo(a3));
		
		ArrayList<Animal> al = new ArrayList<>();
		al.add(a2);
		al.add(a3);
		al.add(a);
		
		System.out.println(al);
		
		Collections.sort(al, new AnimalComparator());
		
		System.out.println(al);
	}
	
//	public static void printAll(Integer[] arr) {
//		for(Integer i:arr) {
//			System.out.println(i);
//		}
//	}
//	
//	public static void printAll(String[] arr) {
//		for(String i:arr) {
//			System.out.println(i);
//		}
//	}
	
	public static <T> void printAll(T[] arr) {
		for(T i:arr) {
			System.out.println(i);
		}
	}
}
