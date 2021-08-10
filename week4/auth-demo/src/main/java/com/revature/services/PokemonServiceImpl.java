package com.revature.services;

import java.util.List;

import com.revature.daos.PokemonDao;
import com.revature.daos.PokemonPostgres;
import com.revature.models.Pokemon;

public class PokemonServiceImpl implements PokemonService {
	PokemonDao pd = new PokemonPostgres();
	@Override
	public boolean addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		if(pd.addPokemon(pokemon) == -1) {
			return false;
			} else {
				return true;
			}
	}

	@Override
	public List<Pokemon> getPokemon() {
		return pd.getPokemons();
	}

	@Override
	public Pokemon getPokemonById(int id) {
		return pd.getPokemonById(id);
	}

	@Override
	public List<Pokemon> getPokemonsByUserId(int user_id) {
		return pd.getPokemonsByUserId(user_id);
	}
	
}
