import {getParameterByName} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    const countryForm = document.getElementById('countryForm');
    countryForm.addEventListener('submit', event => updateInfoAction(event));

    fetchAndDisplayCountry();
});

function fetchAndDisplayCountry(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            let response = JSON.parse(this.responseText);
            for (const [key, value] of Object.entries(response)){
                let input = document.getElementById(key);
                if (input){
                    input.value = value;
                }
            }
        }
    };

    xhttp.open("GET", getBackendUrl() + '/api/countries/' + getParameterByName('country'),true);
    xhttp.send();
}

function updateInfoAction(event){
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            fetchAndDisplayCountry();
            console.log('zaktualizowano!');
        }
    };

    xhttp.open("PUT", getBackendUrl() + '/api/countries/' + getParameterByName('country'), true);

    const request = {
        'nrOfInhabitants': document.getElementById('nrOfInhabitants').value,
        'gdpChange': document.getElementById('gdpChange').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(request));
}