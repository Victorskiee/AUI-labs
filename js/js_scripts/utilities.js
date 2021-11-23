
export function clearElementChildren(element) {
    while(element.firstChild){
        element.removeChild(element.firstChild);
    }
}
//
export function createButtonCell(text, action) {
    const td = document.createElement("td");
    const button = document.createElement("button");
    button.appendChild(document.createTextNode(text));
    button.classList.add('ui-control', 'ui-button');
    button.addEventListener('click', action);
    td.appendChild(button);
    return td;
}


export function createLinkCell(text, url) {
    const td = document.createElement("td");
    const link = document.createElement("a");
    link.appendChild(document.createTextNode(text));
    link.href = url;
    td.appendChild(link);
    return td;
}


export function createTextCell(text) {
    const td = document.createElement("td");
    td.appendChild(document.createTextNode(text));
    return td;
}


export function getParameterByName(name) {
    return new URLSearchParams(window.location.search).get(name);
}

export function setTextNode(id, text) {
    let element = document.getElementById(id);
    clearElementChildren(element);
    element.appendChild(document.createTextNode(text));
}
