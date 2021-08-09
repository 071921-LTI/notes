package com.revature.models;

public class Pokemon {

	private int id;
	private User user;
	private String nickname;
	private int pok_id;
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int id, User user, String nickname, int pok_id) {
		super();
		this.id = id;
		this.user = user;
		this.nickname = nickname;
		this.pok_id = pok_id;
	}

	public Pokemon(User user, String nickname, int pok_id) {
		super();
		this.user = user;
		this.nickname = nickname;
		this.pok_id = pok_id;
	}

	public Pokemon(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPok_id() {
		return pok_id;
	}

	public void setPok_id(int pok_id) {
		this.pok_id = pok_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + pok_id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (pok_id != other.pok_id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", user=" + user + ", nickname=" + nickname + ", pok_id=" + pok_id + "]";
	}
	
}
