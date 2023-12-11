<script setup>
import { ref } from 'vue';
const name = ref('');
const email = ref('');
const result = ref(false);
const success = ref(false);
const resultMessage = ref('');
const emit = defineEmits('add-user');
const resultClass = ref('');
const emitAddUser = (e) => {
    e.preventDefault();
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/;
    if (name.value !== '' && email.value !== '') {
        if (pattern.test(email.value)) {
            emit('add-user', name.value, email.value);
            name.value = '';
            email.value = '';
            resultMessage.value = 'L\'utilisateur à bien été ajouté';
            success.value = true;
        } else {
            resultMessage.value = 'L\'email n\'est pas valide';
        }
    } else {
        resultMessage.value = 'Veuillez remplir tous les champs obligatoire !'
    }
    if (success.value) {
        resultClass.value = 'alert-success';
        success.value = false;
    } else {
        resultClass.value = 'alert-danger';
    }
    result.value = true;
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
        <div v-if="result">
            <div class="rounded-2 alert alert-dismissible fade show" role="alert" :class="resultClass">
                {{ resultMessage }}
                <button type="button" class="btn-close" @click="result = !result" aria-label="Close">
                </button>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary mt-2">Ajouter</button>
        </div>
    </form>
</template>