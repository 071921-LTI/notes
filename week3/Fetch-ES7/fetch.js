// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

async function getData() {

    let userInput = document.getElementById('dataInput').value;

    let response = await fetch(apiURL + userInput);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        populateData(data);
    } else{
        console.log('Unable to retrieve data.')
    }
  
}

function populateData(response) {
    console.log(response);
    // Display pokemon information in the section tag of my html document

    let dataSection = document.getElementById('data');
   
   // Resets the innerHTML before loading new data
   dataSection.innerHTML ='';

   let nameTag = document.createElement('h3');
   nameTag.innerHTML = response.name.toUpperCase();
   
   let abilitiesArray = response.abilities;
   let abilities = document.createElement('ul');
   // Appending list elements to a ul
   for(let ability of abilitiesArray){
       let abilityLi = document.createElement('li');
       abilityLi.innerHTML = ability.ability.name;
       abilities.appendChild(abilityLi);
   }

   // Appending h3 and List to the section tag
   dataSection.appendChild(nameTag);
   dataSection.appendChild(abilities);

   // Appending sprites to section
   let spritesObject = response.sprites;
   for(let sprite in spritesObject){
       if(spritesObject[sprite] && spritesObject[sprite].length > 2){
           let spriteImg = document.createElement('img');
           spriteImg.src = spritesObject[sprite];
           dataSection.appendChild(spriteImg);
       }
   }
}