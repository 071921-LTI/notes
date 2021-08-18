import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokehome',
  templateUrl: './pokehome.component.html',
  styleUrls: ['./pokehome.component.css']
})
export class PokehomeComponent implements OnInit {

  constructor(private pokeService: PokemonService) { }

  ngOnInit(): void {
  }

  // ?: is to specify that it's ok for the value to be null/undefined
  pokemon?: Pokemon;
  @Output() onGetPokemon:EventEmitter<any> = new EventEmitter();

  getPokemon(id: any): void{
    /*
     make a GET HTTP request to the pokeAPI using the passed in id
        - set pokemon field to the received pokemon
        - pass pokemon to the PokemonComponent
     */
    this.pokeService.getPokemonById(id).subscribe(
      response => {
        this.pokemon = response;
        this.onGetPokemon.emit();
      }
    )
  }
}
