class TopLeader {
    constructor(id, displayName, rating, tier, wins){
        this.id = id;
        this.displayName = displayName;
        this.rating = rating;
        this.tier = tier;
        this.wins = wins;
    }
    


    draw(container) {
        // const containerNav = document.createElement("div");
        // containerNav.innerHTML = this.#drawNavBar(containerNav);

        const characterElem = document.createElement("div");
        characterElem.setAttribute("class", "row");
        
        const tableBodyElem = this.#drawTable(characterElem);

        this.#addAttribute("Position: ", this.id, tableBodyElem);
        this.#addAttribute("Name: ", this.displayName, tableBodyElem);
        this.#addAttribute("Rating: ", this.rating, tableBodyElem);
        this.#addAttribute("Tier: ", this.tier, tableBodyElem);
        this.#addAttribute("Wins: ", this.wins, tableBodyElem);

        container.appendChild(characterElem);
    }

    #drawImage(url, isIcon = false) {
        const divColElem = document.createElement("div");
        divColElem.setAttribute("class", "col-sm-2");

        const imgElem = document.createElement("img");
        imgElem.setAttribute("class", "img-thumbnail" +(isIcon?" icon":""));
        imgElem.setAttribute("src", url);

        

        divColElem.appendChild(imgElem);

        return (divColElem);
    }

    #drawTable(parent) {
        const divColElem = document.createElement("div");
        divColElem.setAttribute("class", "col-sm-10");

        const tableElem = document.createElement("table");
        tableElem.setAttribute("class", "table");

        const tableBody = document.createElement("tbody");
        
        tableElem.appendChild(tableBody);
        divColElem.appendChild(tableElem);
        parent.appendChild(divColElem);

        //faz return ao body da tabela
        return tableBody;
    }


    #addAttribute(label, value, parent) {
        const tr = document.createElement("tr");

        const thElem = document.createElement("th");
        thElem.setAttribute("class", "property");
        thElem.setAttribute("scope", "row");
        thElem.innerText = label;

        const tdElem = document.createElement("td");
        tdElem.innerHTML = value;

        tr.appendChild(thElem);
        tr.appendChild(tdElem);

        parent.appendChild(tr);
    }
}


