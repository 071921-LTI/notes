package com.revature.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

@ExtendWith(MockitoExtension.class)
public class PokemonTest {

	private PokemonDao pd = new PokemonPostgres();
	private static MockedStatic<ConnectionUtil> mockedConnectionUtil;
	private static Connection connection;

	/*
	 * Used to create a connection to our H2/ in memory db instead of "production"
	 * database
	 */
	public static Connection getH2Connection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection("jdbc:h2:~/test");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@BeforeAll
	public static void init() throws SQLException {
		/*
		 * Mocking the ConnectionUtil class for the getConnectionFromEnv method to
		 * return a connection to the H2 while the mock is "open".
		 */
		mockedConnectionUtil = Mockito.mockStatic(ConnectionUtil.class);
		mockedConnectionUtil.when(ConnectionUtil::getConnectionFromEnv).then(I -> getH2Connection());
	}

	@AfterAll
	public static void end() {
		/*
		 * Drops h2 tables after tests.
		 */
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			RunScript.execute(c, new FileReader("teardown.sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * Closing resource, mocked behavior ends.
		 */
		mockedConnectionUtil.close();
	}

	@BeforeEach
	public void setUp() {
		/*
		 * Clear previous tables and recreates tables before each tests
		 */
		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			RunScript.execute(c, new FileReader("setup.sql"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Pokemon getPokemonById(int id); 
	 * List<Pokemon> getPokemons(); 
	 * List<Pokemon>
	 * getPokemonsByUserId(int userId); int addPokemon(Pokemon pokemon);
	 */
	
	@Test
	public void getByIdExists() {
		Pokemon expected = new Pokemon(1, new User(1), "Bulby", 1);
		assertEquals(pd.getPokemonById(1), expected);
	}
	
	@Test
	public void getByIdDoesNotExists() {
		assertNull(pd.getPokemonById(100));
	}
	
	
	@Test
	public void addPokemonValid() {
		assertEquals(pd.addPokemon(new Pokemon(new User(1), "Test", 1)), 3);
	}
	
	@Test
	public void addUserInvalid() {
		assertEquals(pd.addPokemon(new Pokemon(new User(1), null, 1)), -1);
	}
	
	@Test
	public void getPokemons() {
	List<Pokemon> pokemons = new ArrayList<>();
	pokemons.add(new Pokemon(1, new User(1), "Bulby", 1));
	pokemons.add(new Pokemon(2, new User(3), "Ivy", 2));
		assertEquals(pd.getPokemons(), pokemons);
	}
	
	@Test
	public void getPokemonsByUserId() {
	List<Pokemon> pokemons = new ArrayList<>();
	pokemons.add(new Pokemon(2, new User(3), "Ivy", 2));
		assertEquals(pd.getPokemonsByUserId(3), pokemons);
	}
}
