// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

function getData() {

    // Retrieving the user input, in this case the pokemon id to be retrieved
    let userInput = document.getElementById('dataInput').value;

    // 4 Steps to make an AJAX call
    // 1: Create an XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    // 2: Set a callback function to the readystatechange event
    xhr.onreadystatechange = receiveData;

    // 3: Open the request/parameterize it
    xhr.open('GET', `${apiURL}${userInput}`);

    // 4: Send the request
    xhr.send();

    function receiveData(){
        let dataSection = document.getElementById('data');

        // Ready state is done, reponse has been retrieved
        if(xhr.readyState === 4){
            // Status code is in the 200s, meaning successful
            if(xhr.status >= 200 && xhr.status < 300){
                let response = xhr.responseText;
                // Converting JSON to JS object
                response = JSON.parse(response);
                // Data processing behavior
                populateData(response);
            } else{
                document.getElementById('data').innerHTML = "<img src=https://ih1.redbubble.net/image.731955024.9007/farp,small,wall_texture,product,750x1000.u3.jpg />";
            }
        }
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