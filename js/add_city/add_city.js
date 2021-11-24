import {getParameterByName} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    const cityForm = document.getElementById('cityForm');
    cityForm.addEventListener('submit', event => updateInfoAction(event));
});

function updateInfoAction(event){
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 201){
            console.log('created!');
        }
    };

    xhttp.open("POST", getBackendUrl() + '/api/countries/' + getParameterByName('country')
        + '/cities',true);

    const request = {
        'name': document.getElementById('name').value,
        'nrOfStreets': document.getElementById('nrOfStreets').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(request));
}