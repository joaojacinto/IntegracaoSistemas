"use strict"


window.addEventListener("load", () => {
    console.log("Olá Mundo!");
    fetchAgents();
    fetchMaps();
    fetchBundles();
    fetchWeapons();
    fetchGamemodes();
    fetchRanks();
    fetchLeader();
})


function fetchAgents() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("https://valorant-api.com/v1/agents?isPlayableCharacter=true", (agents) => {
        console.log(agents);

        agents.data.forEach(data => {
            const agent = new Agents(
                data.displayName, 
                data.description, 
                data.fullPortrait, 
                data.role?.displayName,
                data.abilities.map(ability => ability?.displayIcon), 
                data.abilities.map(ability => ability.displayName)
            );
            agent.draw(containerElement);
        })
    })
}

function fetchMaps() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("https://valorant-api.com/v1/maps", (maps) => {
        console.log(maps);

        maps.data.forEach(data => {
            const map = new Maps(
                data.displayName, 
                data.coordinates, 
                data.splash,
                data.displayIcon 
            );
            map.draw(containerElement);
        })
    })
}

function fetchBundles() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("https://valorant-api.com/v1/bundles", (bundles) => {
        console.log(bundles);

        bundles.data.forEach(data => {
            const bundle = new Bundles(
                data.displayName, 
                data.description, 
                data.displayIcon 
            );
            bundle.draw(containerElement);
        })
    })
}

function fetchWeapons() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("https://valorant-api.com/v1/weapons", (weapons) => {
        console.log(weapons);

        weapons.data.forEach(data => {
            const weapon = new Weapons(
                data.displayName, 
                data.shopData.category, 
                data.shopData.cost,
                data.displayIcon
            );
            weapon.draw(containerElement);
        })
    })
}

function fetchGamemodes() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("https://valorant-api.com/v1/gamemodes", (gamemodes) => {
        console.log(gamemodes);

        gamemodes.data.forEach(data => {
            const gamemode = new Gamemodes(
                data.displayName, 
                data.duration, 
                data.displayIcon
            );
            gamemode.draw(containerElement);
        })
    })
}

function fetchRanks() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("http://localhost:8080/api/ranks", (ranks) => {
        console.log(ranks);

        ranks.forEach(data => {
            const rank = new Ranks(
                data.tierName, 
                data.iconTierFile
            );
            rank.draw(containerElement);
        })
    })
}

function fetchLeader() {
    // const containerNav = document.getElementById("navbar");
    // containerNav.innerHTML = "";


    const containerElement = document.getElementById("container");
    containerElement.innerHTML = "";

    callAPI("http://localhost:8080/api/leader", (leader) => {
        console.log(leader);

        leader.forEach(data => {
            const leaders = new TopLeader(
                data.id, 
                data.displayName,
                data.rating,
                data.tier,
                data.wins
            );
            leaders.draw(containerElement);
        })
    })
}

function callAPI(url, callback) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.onload = () => {
        callback(JSON.parse(xhttp.responseText));
    }
    xhttp.send();[]
}
