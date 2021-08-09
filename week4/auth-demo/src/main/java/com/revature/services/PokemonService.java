package com.revature.services;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonService {

	boolean addPokemon(Pokemon pokemon);
	List<Pokemon> getPokemon();
	Pokemon getPokemonById(int id);
	// Should return a list of all of the pokemons associated with this user
	List<Pokemon> getPokemonsByUserId(int user_id);
}
