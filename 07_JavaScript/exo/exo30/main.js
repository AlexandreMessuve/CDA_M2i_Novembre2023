
//Importation des classes Dog, Cat, dogRace et catRace depuis le fichier "animals.js".
import { Dog, Cat, dogRace, catRace } from "./animals.js";


//Récupération des éléments HTML nécessaires.
const form = document.getElementById('my-form');
const raceSelect = document.getElementById('race');
const tableBody = document.getElementById('table-body');

//Stockage des animaux
const listAnimals = [];


//Fonction pour ajouter une ligne dans le tableau HTML avec les informations d'un animal.
const addRow = (obj, tbody) => {
    const tr = document.createElement('tr');
    const tdType = document.createElement('td');
    const tdRace = document.createElement('td');
    const tdName = document.createElement('td');
    const tdYear = document.createElement('td');
    const tdColor = document.createElement('td');

    tdType.textContent = obj.type === 'cat' ? 'Chat' : 'Chien';
    tdRace.textContent = obj.race;
    tdName.textContent = obj.name;
    tdYear.textContent = obj.year;
    tdColor.textContent = obj.color;

    tbody.appendChild(tr).appendChild(tdType);
    tbody.appendChild(tr).appendChild(tdRace);
    tbody.appendChild(tr).appendChild(tdName);
    tbody.appendChild(tr).appendChild(tdYear);
    tbody.appendChild(tr).appendChild(tdColor);
}


//Ajoute les options de race correspondantes à la sélection d'animal.

document.getElementById('animal').addEventListener('change', (e) => {
    while (raceSelect.options.length > 1) {
        raceSelect.remove(1);
    }
    if (e.target.value === 'cat') {
        catRace.forEach((race) => {
            const option = document.createElement('option');
            option.value = race;
            option.textContent = race;
            raceSelect.appendChild(option);
        })
    } else if (e.target.value === 'dog') {
        dogRace.forEach((race) => {
            const option = document.createElement('option');
            option.value = race;
            option.textContent = race;
            raceSelect.appendChild(option);
        })
    }
})


//Ajoute un nouvel animal dans le tableau listAnimals et affiche une nouvelle ligne dans le tableau HTML.
form.addEventListener('submit', (e) => {
    e.preventDefault();
    if (e.target.animal.value && e.target.race.value && e.target.name.value && e.target.year.value) {
        const race = e.target.race.value;
        const name = e.target.name.value;
        const year = e.target.year.value;
        const color = e.target.color.value ? e.target.color.value : 'Non renseigné';
        if (e.target.animal.value === 'cat') {
            const cat = new Cat(race, name, year, color)
            listAnimals.push(cat);
            addRow(cat, tableBody)
        } else {
            const dog = new Dog(race, name, year, color);
            listAnimals.push(dog);
            addRow(dog, tableBody)
        }

        form.reset();
    }
})
