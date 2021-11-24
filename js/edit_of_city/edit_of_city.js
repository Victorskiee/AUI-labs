import {getParameterByName} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => updateInfoAction(event));

    fetchAndDisplayCity();
});

function fetchAndDisplayCity(){
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

    xhttp.open("GET", getBackendUrl() + '/api/countries/' + getParameterByName('country')
        + '/cities/' + getParameterByName('city'), true);
    xhttp.send();
}

function updateInfoAction(event){
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 202){
            console.log('zaktualizowano!');
            fetchAndDisplayCity();
        }
    };

    xhttp.open("PUT", getBackendUrl() + '/api/countries/' + getParameterByName('country')
        + '/cities/' + getParameterByName('city'), true);

    const request = {
        'name': document.getElementById('name').value,
        'nrOfStreets': document.getElementById('nrOfStreets').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(request));
}