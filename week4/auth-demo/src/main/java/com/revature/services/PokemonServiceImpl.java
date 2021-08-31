package com.revature.services;

import java.util.List;

import com.revature.daos.PokemonDao;
import com.revature.daos.PokemonPostgres;
import com.revature.models.Pokemon;

public class PokemonServiceImpl implements PokemonService {

    PokemonDao pd = new PokemonPostgres();

    @Override
    public int addPokemon(Pokemon pokemon) {
        // TODO Auto-generated method stub
        return pd.addPokemon(pokemon);
    }

    @Override
    public List<Pokemon> getPokemon() {
        // TODO Auto-generated method stub
        return pd.getPokemons();
    }

    @Override
    public Pokemon getPokemonById(int id) {
        // TODO Auto-generated method stub
        return pd.getPokemonById(id);
    }

    @Override
    public List<Pokemon> getPokemonsByUserId(int user_id) {
        // TODO Auto-generated method stub
        return pd.getPokemonsByUserId(user_id);
    }
    
}
