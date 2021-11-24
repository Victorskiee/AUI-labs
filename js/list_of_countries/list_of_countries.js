import {clearElementChildren, createLinkCell, createTextCell, createButtonCell} from "../js_scripts/utilities.js";
import {getBackendUrl} from "../js_scripts/configuration.js";

window.addEventListener('load', () => {
    fetchAndDisplayCountries();
});

function fetchAndDisplayCountries() {
   const xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
       if (this.readyState === 4 && this.status === 200){
           displayCountries(JSON.parse(this.responseText));
       }
   };

   xhttp.open('GET', getBackendUrl() + '/api/countries', true);
   xhttp.send();
}

/**
 * Updates the DOM tree in order to display users.
 *
 * @param {{countries: string[]}} countries
 */
function displayCountries(countries) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    countries.countries.forEach(country => tableBody.appendChild(createTableRow(country)));
}

function createTableRow(country) {
   let tr = document.createElement("tr");
   const tdText = createTextCell(country.name);
   const tdLink = createLinkCell('view', '../view_of_country/view_of_country.html?country=' + country.name);
   const tdEdit = createLinkCell('edit', '../edit_of_country/edit_of_country.html?country=' + country.name);
   const tdDelete = createButtonCell('delete', () => deleteCountry(country.name));
   tr.appendChild(tdText);
   tr.appendChild(tdLink);
   tr.appendChild(tdEdit);
   tr.appendChild(tdDelete);
   return tr;
}

function deleteCountry(country) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 202){
            fetchAndDisplayCountries();
        }
    };
    
    xhttp.open("DELETE", getBackendUrl() + '/api/countries/' + country, true);
    xhttp.send();
}