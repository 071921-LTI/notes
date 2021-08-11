package com.revature.models;

public class Pokemon {

	private int id;
	private String name;
	private Trainer trainer;
	private int poke_id;
	public Pokemon(int id, String name, Trainer trainer, int poke_id) {
		super();
		this.id = id;
		this.name = name;
		this.trainer = trainer;
		this.poke_id = poke_id;
	}
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public int getPoke_id() {
		return poke_id;
	}
	public void setPoke_id(int poke_id) {
		this.poke_id = poke_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + poke_id;
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (poke_id != other.poke_id)
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", trainer=" + trainer + ", poke_id=" + poke_id + "]";
	}
	
	
}
