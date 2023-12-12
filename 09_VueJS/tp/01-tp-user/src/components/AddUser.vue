<script setup>
import { ref, defineEmits, inject } from 'vue';

// Déclaration des variables réactives
const name = ref(''); // Variable réactive pour le nom de l'utilisateur
const email = ref(''); // Variable réactive pour l'email de l'utilisateur
const success = ref(false); // Variable réactive pour indiquer si l'ajout de l'utilisateur a réussi ou non
const resultMessage = ref(''); // Variable réactive pour stocker le message de résultat
const resultSuccess = inject('success').resultSuccess;
// Définition des événements émis par le composant
const emit = defineEmits(['add-user', 'show-result', 'update-success']);

// Fonction pour ajouter un utilisateur
const emitAddUser = (e) => {
    e.preventDefault();
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/; // Expression régulière pour valider l'email

    if (name.value !== '' && email.value !== '') { // Vérifie si le nom et l'email ne sont pas vides
        if (pattern.test(email.value)) { // Vérifie si l'email est valide en utilisant l'expression régulière
            resultMessage.value = 'L\'utilisateur à bien été ajouté'; // Définit le message de résultat en cas de succès
            success.value = true; // Indique que l'ajout de l'utilisateur a réussi
            emit('add-user', name.value, email.value, success.value, resultMessage.value); // Émet l'événement 'add-user' avec les données de l'utilisateur
        } else {
            resultMessage.value = 'L\'email n\'est pas valide'; // Définit le message de résultat en cas d'email invalide
            success.value = false; // Indique que l'ajout de l'utilisateur a échoué
        }
    } else {
        resultMessage.value = 'Veuillez remplir tous les champs obligatoire !'; // Définit le message de résultat en cas de champs vides
        success.value = false; // Indique que l'ajout de l'utilisateur a échoué
    }

    if (!success.value) {
        emit('show-result', success.value, resultMessage.value); // Émet l'événement 'show-result' avec le statut de succès et le message de résultat
    }
    if (resultSuccess.value) {
        name.value = ''; // Réinitialise la valeur du nom
        email.value = ''; // Réinitialise la valeur de l'email
    }

}
</script>

<template>
    <form @submit="emitAddUser">
        <div>
            <label class="form-text" for="name">Nom : </label>
            <input id="name" name="name" type="text" class="form-control" placeholder="Nom" v-model="name">
        </div>
        <div>
            <label class="form-text" for="name">Email : </label>
            <input id="email" name="email" type="email" class="form-control" placeholder="Email" v-model="email">
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary mt-2">Ajouter</button>
        </div>
    </form>
</template>
