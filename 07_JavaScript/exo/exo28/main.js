const listPerson = [];
let countPerson = 1;
document.getElementById('button-input').addEventListener(('click'), () => {
    const tablePerson = document.getElementById('table-person');
    const lastnameInput = document.getElementById('input-lastname');
    const firstnameInput = document.getElementById('input-firstname');
    const dateInput = document.getElementById('input-date');
    const errorLastname = document.getElementById('error-lastname');
    const errorFirstname = document.getElementById('error-firstname');
    const errorDate = document.getElementById('error-date');

    errorLastname.textContent = '';
    errorFirstname.textContent = '';
    errorDate.textContent = '';

    //Vérifie si le champ nom est vide
    if (!lastnameInput.value.trim()) {
        // Affiche une erreur si le champ nom est vide
        error(errorLastname, 'Le nom doit être saisie', 'red');
    }
    //Vérifie si le champ prénom est vide
    if (!firstnameInput.value.trim()) {
        // Affiche une erreur si le champ prénom est vide
        error(errorFirstname, 'Le prénom doit être saisie', 'red');
    }
    //Vérifie si le champ date est vide
    if (!dateInput.value) {
        // Affiche une erreur si le champ date est vide
        error(errorDate, 'Le date doit être saisie', 'red');
    }

    // Vérifie si tous les champs sont remplis
    if (lastnameInput.value.trim() && firstnameInput.value.trim() && dateInput.value) {
        // Crée un nouvel objet personne avec les valeurs des champs
        const newPerson = {
            id: countPerson++,
            lastname: lastnameInput.value.toUpperCase(),
            firstname: firstnameInput.value.substring(0, 1).toUpperCase() + firstnameInput.value.substring(1).toLowerCase(),
            dateNaiss: dateInput.value
        }
        // Réinitialise les champs
        lastnameInput.value = '';
        firstnameInput.value = '';
        dateInput.value = '';
        // Ajoute la nouvelle personne à la liste des personnes
        listPerson.push(newPerson);
        // Vide le tbody sur la page html
        tablePerson.innerHTML = '';

        // Parcourt la liste des personnes
        listPerson.forEach((person, index) => {
            // Crée une nouvelle ligne pour chaque personne
            const tr = document.createElement('tr');
            const tdId = document.createElement('td');
            const tdLastname = document.createElement('td');
            const tdFirstname = document.createElement('td');
            const tdDateNaiss = document.createElement('td');

            // Remplit les cellules avec les informations de la personne
            tdId.textContent = person.id;
            tdLastname.textContent = person.lastname;
            tdFirstname.textContent = person.firstname;
            tdDateNaiss.textContent = person.dateNaiss;
            tablePerson.appendChild(tr).appendChild(tdId);
            tablePerson.appendChild(tr).appendChild(tdLastname);
            tablePerson.appendChild(tr).appendChild(tdFirstname);
            tablePerson.appendChild(tr).appendChild(tdDateNaiss);
        })
    }


}
);

const error = (error, errorContent, color) => {
    error.style.color = color;
    error.textContent = errorContent;
}