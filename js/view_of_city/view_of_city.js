import {getParameterByName, createTextCell, clearElementChildren, setTextNode} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    fetchAndDisplayCity();
});

function fetchAndDisplayCity(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            displayCity(JSON.parse(this.responseText));
        }
    };

    xhttp.open("GET", getBackendUrl() + '/api/countries/' + getParameterByName('country') + '/cities/' +
        + getParameterByName('city'), true);
    xhttp.send();
}

function displayCity(city){
    setTextNode('id', city.id);
    setTextNode('name', city.name);
    setTextNode('country', city.country);
    setTextNode('nrOfStreets', city.nrOfStreets);
    setTextNode('city_name', city.name);
}