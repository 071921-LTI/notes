package com.revature.daos;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonDao {

	Pokemon getPokemonById(int id);
	List<Pokemon> getPokemons();
	List<Pokemon> getPokemonsByUserId(int userId);
	int addPokemon(Pokemon pokemon);
}
