import Car from "./car.js";

const listCars = [];

// Fonction pour créer une fenêtre modale
const createModal = (form, titleText) => {
    const modal = document.createElement('div');
    modal.className = 'modal';
    modal.id = 'modal';

    const modalContent = document.createElement('div');
    const modalTitle = document.createElement('h2');
    modalTitle.textContent = titleText;
    form.id = 'my-form';
    modalContent.className = 'modal-content';
    modalContent.id = 'modal-content';
    const btnCloseModal = document.createElement('button');
    btnCloseModal.id = 'btn-close-modal';
    btnCloseModal.textContent = 'x';

    modalContent.appendChild(btnCloseModal);
    modalContent.appendChild(modalTitle);
    modalContent.appendChild(form);

    modal.appendChild(modalContent);
    document.querySelector('body').appendChild(modal);

    document.getElementById('btn-close-modal')?.addEventListener('click', () => {
        removeModal(modal);
    });

    document.getElementById('modal')?.addEventListener('click', (e) => {
        if (e.currentTarget === e.target) removeModal(modal);
    });
}

// Fonction pour ajouter des attributs au formulaire
const addAttributeForm = (input, id, inputType, label, labelText) => {
    input.id = id;
    input.name = id;
    input.type = inputType;
    label.textContent = labelText;
    label.for = id;
}

// Fonction pour créer un champ de saisie
const createInputField = (id, inputType, labelText) => {
    const div = document.createElement('div');
    const label = document.createElement('label');
    const input = document.createElement('input');

    addAttributeForm(input, id, inputType, label, labelText);

    div.appendChild(label);
    div.appendChild(input);
    return div;
}


const addForm = (obj = null) => {

    const form = document.createElement('form');

    const divMarque = createInputField('marque', 'text', 'Marque :');
    const divModel = createInputField('model', 'text', 'Modèle :');
    const divYear = createInputField('year', 'number', 'Année :');
    const divColor = createInputField('color', 'text', 'Couleur :');
    const submit = document.createElement('button');
    submit.type = 'submit';
    divYear.lastChild.min = 1960;
    divYear.lastChild.max = 2023;

    if (obj) {
        divMarque.lastChild.value = obj.Marque;
        divModel.lastChild.value = obj.Model;
        divYear.lastChild.value = obj.Year;
        divColor.lastChild.value = obj.Color;
        submit.textContent = 'Mise à jour'
    } else {
        submit.textContent = 'Ajouter';
    }


    form.appendChild(divMarque);
    form.appendChild(divModel);
    form.appendChild(divYear);
    form.appendChild(divColor);
    form.appendChild(submit);

    return form;
}

const removeModal = (modalId) => {
    modalId.remove();
}

const createTd = (value) => {
    const td = document.createElement('td');
    td.textContent = value;
    return td;
}

const updateRow = (tr) => {
    const id = Number(tr.id.replace(new RegExp("[^(0-9)]", "g"), ''));
    listCars.map((car) => {
        if (car.Id === id) {
            const tdMarque = document.getElementById(`marque-${car.Id}`);
            const tdModel = document.getElementById(`model-${car.Id}`);
            const tdYear = document.getElementById(`year-${car.Id}`);
            const tdColor = document.getElementById(`color-${car.Id}`);
            const tdUpdatedAt = document.getElementById(`updated-${car.Id}`);
            const form = addForm(car);
            createModal(form, 'Formulaire de mise à jour');
            form.addEventListener('submit', (e) => {
                e.preventDefault();
                const marque = e.target.marque.value.trim().toLowerCase();
                const model = e.target.model.value.trim().toLowerCase();
                const year = e.target.year.value;
                const color = e.target.color.value.trim();
                const modal = document.getElementById('modal');
                if (marque && model && year && color) {
                    car.Marque = marque;
                    car.Model = model;
                    car.Year = year;
                    car.Color = color;
                    car.UpdatedAt = new Date();
                    tdMarque.textContent = car.Marque;
                    tdModel.textContent = car.Model;
                    tdYear.textContent = car.Year;
                    tdColor.textContent = car.Color;
                    tdUpdatedAt.textContent = car.UpdatedAt;
                    modal.remove();
                } else {
                    const p = document.createElement('p');
                    const button = document.createElement('button');
                    button.textContent = 'x';
                    button.addEventListener('click', () => {
                        p.remove();
                    })
                    p.style.color = 'red';
                    p.textContent = 'Un ou plusieurs champs sont vide !!!';
                    p.appendChild(button);
                    document.getElementById('modal-content').appendChild(p)
                }

                form.reset();
            });

        }

    });

}

const addRow = (tbody, obj) => {
    const tr = document.createElement('tr');
    tr.id = `row${obj.Id}`;
    const tdId = createTd(obj.Id);
    const tdMarque = createTd(obj.Marque);
    const tdModel = createTd(obj.Model);
    const tdYear = createTd(obj.Year);
    const tdColor = createTd(obj.Color);
    const tdCreatedAt = createTd(obj.CreatedAt);
    const tdUpdatedAt = createTd(obj.UpdatedAt ? obj.UpdatedAt : 'Jamais');
    const updateButton = document.createElement('button');
    const deleteButton = document.createElement('button');
    const tdActions = document.createElement('td');
    tdMarque.id = `marque-${obj.Id}`;
    tdModel.id = `model-${obj.Id}`;
    tdYear.id = `year-${obj.Id}`;
    tdColor.id = `color-${obj.Id}`;
    tdUpdatedAt.id = `updated-${obj.Id}`;
    tdActions.appendChild(deleteButton);
    tdActions.appendChild(updateButton);
    deleteButton.textContent = 'Supprimer';
    updateButton.textContent = 'Modifier';
    deleteButton.addEventListener('click', () => {
        tr.remove();
    });

    updateButton.addEventListener('click', () => {
        updateRow(tr);
    });
    tr.appendChild(tdId);
    tr.appendChild(tdMarque);
    tr.appendChild(tdModel);
    tr.appendChild(tdYear);
    tr.appendChild(tdColor);
    tr.appendChild(tdCreatedAt);
    tr.appendChild(tdUpdatedAt);
    tr.appendChild(tdActions);

    tbody.appendChild(tr);
}
document.getElementById('show-modal-add-car').addEventListener('click', () => {
    const form = addForm();
    createModal(form, 'Formulaire d\'ajout de voiture');
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        const marque = e.target.marque.value.trim().toLowerCase();
        const model = e.target.model.value.trim().toLowerCase();
        const year = e.target.year.value;
        const color = e.target.color.value.trim();
        const modal = document.getElementById('modal');
        if (marque && model && year && color) {
            const newCar = new Car();
            newCar.Marque = marque;
            newCar.Model = model;
            newCar.Year = year;
            newCar.Color = color;
            listCars.push(newCar);
            addRow(document.getElementById('table-body'), newCar);
            modal.remove();
        } else {
            const p = document.createElement('p');
            const button = document.createElement('button');
            button.textContent = 'x';
            button.addEventListener('click', () => {
                p.remove();
            })
            p.style.color = 'red';
            p.textContent = 'Un ou plusieurs champs sont vide !!!';
            p.appendChild(button);
            document.getElementById('modal-content').appendChild(p);
        }

        form.reset();
    });
});