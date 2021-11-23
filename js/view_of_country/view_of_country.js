import {getParameterByName, clearElementChildren, createLinkCell, createButtonCell, createTextCell,
        setTextNode} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    fetchAndDisplayCountry();
    fetchAndDisplayCities();
});

function fetchAndDisplayCities(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            displayCities(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/countries/' + getParameterByName('country') + '/cities', true);
    xhttp.send();
}

/**
 * Updates the DOM tree in order to display characters.
 *
 * @param {{cities: {id: number, name:string}[]}} cities
 */
function displayCities(cities){
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    cities.cities.forEach(city => tableBody.appendChild(createTableRow(city)));
}

function createTableRow(city){
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(city.name));
    tr.appendChild(createLinkCell('edit', '../edit_of_city/edit_of_city.html?city='
        + getParameterByName('country') + '&city=' + city.id));
    tr.appendChild(createButtonCell('delete', () => deleteCity(city.id)));
    return tr;
}

function deleteCity(city){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 202){
            fetchAndDisplayCities();
        }
    }
    xhttp.open("DELETE", getBackendUrl() + '/api/countries/' + getParameterByName('country')
        + '/cities/' + city, true);
    xhttp.send();
}

function fetchAndDisplayCountry(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            displayCountry(JSON.parse(this.responseText))
        }
    }
    xhttp.open("GET", getBackendUrl() + '/api/countries/' + getParameterByName('country'), true);
    xhttp.send();
}

function displayCountry(country){
    setTextNode('country_name', country.name);
    setTextNode('gdp', country.gdpChange);
    setTextNode('citizens', country.nrOfInhabitants);
}