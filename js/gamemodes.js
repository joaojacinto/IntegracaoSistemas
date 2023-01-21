class Gamemodes {
    constructor(displayName, duration, displayIcon){
        this.displayName = displayName;
        this.duration = duration;
        this.displayIcon = displayIcon;
    }
    


    draw(container) {
        // const containerNav = document.createElement("div");
        // containerNav.innerHTML = this.#drawNavBar(containerNav);

        const characterElem = document.createElement("div");
        characterElem.setAttribute("class", "row");

        characterElem.appendChild(this.#drawImage(this.displayIcon, false))
        
        const tableBodyElem = this.#drawTable(characterElem);

        this.#addAttribute("Name: ", this.displayName, tableBodyElem);
        this.#addAttribute("Duration: ", this.duration, tableBodyElem);

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


