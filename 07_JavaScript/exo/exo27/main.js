document.getElementById('button-input').addEventListener(('click'), () => {
    const listName = document.getElementById('listed-name');
    const nameInput = document.querySelector('input#input-name');
    const error = document.getElementById('error');

    if (nameInput.value !== "") {
        error.textContent = "";
        const li = document.createElement('li');
        listName.appendChild(li).textContent = nameInput.value;
        nameInput.value = "";
    } else {
        error.style.color = 'red';
        error.textContent = 'Le champs est vide';

    }

}
);
