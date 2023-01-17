"use strict"

function callAPI(url, callback) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.onload = () => {
        callback(JSON.parse(xhttp.responseText));
    }
    xhttp.send();
}


function fetchAgents() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";
    

    callAPI("https://valorant-api.com/v1/agents", (agents) => {
        console.log(agents);

        agents.forEach(data => {
            const agent = new Agents(
                data.displayName, 
                data.description, 
                data.fullPortrait, 
                data.role, 
                data.abilities  
            );
            agent.draw(containerElement);
        })
    })
}


window.addEventListener("load", () => {
    console.log("Olá Mundo!");
    fetchAgents();
})
