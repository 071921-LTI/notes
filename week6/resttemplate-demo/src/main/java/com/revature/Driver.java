package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Pokemon;

public class Driver {

	public static void main(String[] args) {
		
		String url = "https://pokeapi.co/api/v2/pokemon/";

		RestTemplate rt = new RestTemplate();
		Pokemon p = rt.getForObject(url + "1", Pokemon.class);
		ResponseEntity<Pokemon[]> response =
				  rt.getForEntity(
				  "someUrl",
				  Pokemon[].class);
		Pokemon[] pokemons = response.getBody();
		
		System.out.println(p);
	}

}
