// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiURL = 'http://localhost:8080/hello-servlet/hello';

async function getData() {

    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        populateData(data);
    } else{
        console.log('Unable to retrieve data.')
    }
  
}

function populateData(response) {
    console.log(response);

}