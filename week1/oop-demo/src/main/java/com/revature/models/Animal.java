package com.revature.models;

// implicitely extends Object
public class Animal extends Object{

	private String species;
	private boolean hasFeet;
	private float weight;

	public Animal() {
		// super();
		super(); //Object()
	}
	
	public Animal(String species, boolean hasFeet, float weight) {
		super();
		this.species = species;
		this.hasFeet = hasFeet;
		this.weight = weight;
	}

	public double move() {
		return 0;
	}
	
	public double move(double speed) {
		return speed;
	}
	
	public double move(double speed, int multiplier) {
		return speed * multiplier;
	}

	public String getSpecies() {
		return species;
	}

	public float getWeight() {
		return weight;
	}

	// this refers to the instance to avoid variable shadowing
	public void setWeight(float weight) {
		if (weight < 0) {
			System.out.println("Weight cannot be below 0.");
			this.weight = 0;
		} else {
			this.weight = weight;
		}

	}

	// Method from the Object class, needs to be overriden to provide helpful information
	@Override
	public String toString() {
		return "This animal has: species=" + species + ", hasFeet=" + hasFeet + ", weight=" + weight + ".";
	}

	public boolean isHasFeet() {
		return hasFeet;
	}

	public void setHasFeet(boolean hasFeet) {
		this.hasFeet = hasFeet;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasFeet ? 1231 : 1237);
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (hasFeet != other.hasFeet)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}
	
	
}
