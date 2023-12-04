//Importation des classes.
import Person from "./person.js";

//Récupération des éléments HTML nécessaires.
const form = document.getElementById('my-form');
const tableBody = document.getElementById('table-body');
const response = document.getElementById('response');
const error = document.getElementById('error');

//Stockage des personnes
const listPerson = [];

//Fonction pour ajouter une ligne dans le tableau HTML avec les informations d'une personne.
const addRow = (obj, tbody) => {
    const tr = document.createElement('tr');
    const tdId = document.createElement('td');
    const tdFullname = document.createElement('td');
    const tdBirthday = document.createElement('td');
    const tdGender = document.createElement('td');

    tdId.textContent = obj.getId();
    tdFullname.textContent = obj.getFullname();
    tdBirthday.textContent = obj.getBirth();
    tdGender.textContent = obj.getGender();

    tbody.appendChild(tr).appendChild(tdId);
    tbody.appendChild(tr).appendChild(tdFullname);
    tbody.appendChild(tr).appendChild(tdBirthday);
    tbody.appendChild(tr).appendChild(tdGender);
}

//Fonction pour ajouter une alerte avec un message dans une couleur spécifiée.
const addAlert = (alert, msg, textColor = 'black') => {
    const p = document.createElement('p');
    p.style.color = textColor;
    alert.appendChild(p).textContent = msg;
}

//Fonction pour supprimer toutes les alertes.
const deleteAlert = (alert) => {
    while (alert.hasChildNodes()) {
        alert.removeChild(alert.firstChild);
    }
}

//Ajoute une nouvelle personne dans le tableau listPerson et affiche une nouvelle ligne dans le tableau HTML.
form.addEventListener('submit', (e) => {
    deleteAlert(error);
    deleteAlert(response);
    e.preventDefault();
    if (e.target.firstname.value.trim() && e.target.lastname.value.trim() && e.target.birthday.value && e.target.gender.value) {
        const firstname = e.target.firstname.value.trim().toLowerCase();
        const lastname = e.target.lastname.value.trim().toLowerCase();
        const birthday = e.target.birthday.value;
        const gender = e.target.gender.value;
        const newPerson = new Person();

        if (!newPerson.setFirstname(firstname)) {
            const msgError = 'Je n\'aime pas ton prénom';
            addAlert(error, msgError, 'red');
            return;
        }
        newPerson.setLastname(lastname);
        newPerson.setBirth(birthday);
        newPerson.setGender(gender);

        listPerson.push(newPerson);

        const msgResponse = `Vous venez d\'ajouter ${newPerson.getFullname()}`;
        addAlert(response, msgResponse, 'green');
        addRow(newPerson, tableBody);
        form.reset();
    }
})
