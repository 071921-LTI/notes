package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class PokemonPostgres implements PokemonDao{

	@Override
	public Pokemon getPokemonById(int id) {
	Pokemon pokemon = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from pokemons where id = ? ;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int p_id = rs.getInt("id");
				String nickname = rs.getString("nickname");
				int poke_id = rs.getInt("poke_id");
				User user = new User(rs.getInt("user_id"));
				
				pokemon = new Pokemon(p_id, user, nickname, poke_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemon;
	}

	@Override
	public List<Pokemon> getPokemons() {
		List<Pokemon> pokemons = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from pokemons;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Pokemon pokemon;
				int p_id = rs.getInt("id");
				String nickname = rs.getString("nickname");
				int poke_id = rs.getInt("poke_id");
				User user = new User(rs.getInt("user_id"));
				
				pokemon = new Pokemon(p_id, user, nickname, poke_id);
				pokemons.add(pokemon);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemons;
	}

	@Override
	public List<Pokemon> getPokemonsByUserId(int userId) {
		List<Pokemon> pokemons = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from pokemons where user_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Pokemon pokemon;
				int p_id = rs.getInt("id");
				String nickname = rs.getString("nickname");
				int poke_id = rs.getInt("poke_id");
				User user = new User(rs.getInt("user_id"));
				
				pokemon = new Pokemon(p_id, user, nickname, poke_id);
				pokemons.add(pokemon);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemons;
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		int id = -1;
		String sql = "insert into pokemons (nickname, poke_id, user_id) values (?,?,?);";

		try (Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pokemon.getNickname());
			ps.setInt(2, pokemon.getPok_id());
			ps.setInt(3, pokemon.getUser().getId());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
