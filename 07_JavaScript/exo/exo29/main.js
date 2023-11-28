const errorUsername = document.getElementById('error-username');
const errorPassword = document.getElementById('error-password');
const form = document.getElementById('my-form');
const response = document.getElementById('form-submit');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');

// Fonction pour valider les entrées de l'utilisateur
const valdationInput = (input, error, minLength) => {
    // Ajoute un écouteur d'événement sur l'entrée
    input.addEventListener('input', (event) => {
        // Change la couleur du texte en blanc
        event.target.style.color = 'white';
        // Vérifie si la longueur de la valeur entrée est inférieure à la longueur minimale
        if (event.target.value.trim().length <= minLength) {
            // Cache la réponse du formulaire
            response.style.display = 'none';
            
            // Affiche le message d'erreur et change la couleur du background de l'input
            error.style.display = 'block';
            event.target.style.backgroundColor = 'red';

            //Désactive le bouton de soumission du formulaire
            document.getElementById('my-button').disabled = true;
        } else {
            //Cache le message d'erreur et change la couleur du background de l'input
            error.style.display = 'none';
            event.target.style.backgroundColor = 'green';

            //Active le bouton de soumission du formulaire
            document.getElementById('my-button').disabled = false;
        }
    })
}

valdationInput(usernameInput, errorUsername, 3);
valdationInput(passwordInput, errorPassword, 6);

form.addEventListener('submit', (event) => {
    //Empêche le comportement par défaut du formulaire
    event.preventDefault();

    const formTarget = event.target;

    // Vérifie si les champs d'utilisateur et de mot de passe sont remplis
    if (formTarget.password.value.trim() && formTarget.username.value.trim()) {
        // Crée un objet avec les détails de l'utilisateur
        const userDetails = {
            username: formTarget.username.value.trim(),
            password: formTarget.password.value.trim()
        }
        
        //Affiche la réponse 
        response.style.display = 'block';

        //Reset le formulaire
        form.reset();

        //Change le background des inputs en blanc
        formTarget.username.style.backgroundColor = 'white';
        formTarget.password.style.backgroundColor = 'white';

        //Affiche l'objet dans les logs.
        console.log(userDetails);
    }


})



