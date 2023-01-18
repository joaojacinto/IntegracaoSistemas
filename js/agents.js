class Agents {
    constructor(displayName, description, fullPortrait, role, displayIcon, abilities){
        this.displayName = displayName;
        this.description = description;
        this.fullPortrait = fullPortrait;
        this.role = role;
        this.displayIcon = displayIcon;
        this.abilities = abilities;
    }


    draw(container) {
        // const containerNav = document.createElement("div");
        // containerNav.innerHTML = this.#drawNavBar(containerNav);

        const characterElem = document.createElement("div");
        characterElem.setAttribute("class", "row");

        characterElem.appendChild(this.#drawImage(this.fullPortrait))
        
        const tableBodyElem = this.#drawTable(characterElem);

        this.#addAttribute("Name: ", this.displayName, tableBodyElem);
        this.#addAttribute("Descrição: ", this.description, tableBodyElem);
        this.#addAttribute("Image: ", this.fullPortrait, tableBodyElem);
        this.#addAttribute("Role: ", this.role, tableBodyElem);
        this.#addAttribute("Icons: ", this.displayIcon.map(icon => this.#drawImage(icon).innerHTML), tableBodyElem);
        this.#addAttribute("Abilities: ", this.abilities, tableBodyElem);

        container.appendChild(characterElem);
    }

    #drawImage(url) {
        const divColElem = document.createElement("div");
        divColElem.setAttribute("class", "col-sm-2");

        const imgElem = document.createElement("img");
        imgElem.setAttribute("class", "img-thumbnail");
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


