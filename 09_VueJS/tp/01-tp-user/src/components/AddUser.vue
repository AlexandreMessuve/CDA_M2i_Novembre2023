<script setup>
import { ref, defineEmits } from 'vue';
const name = ref('');
const email = ref('');
const success = ref(false);
const resultMessage = ref('');
const emit = defineEmits(['add-user', 'show-result']);
const emitAddUser = (e) => {
    e.preventDefault();
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/;
    if (name.value !== '' && email.value !== '') {
        if (pattern.test(email.value)) {
            resultMessage.value = 'L\'utilisateur à bien été ajouté';
            success.value = true;
            emit('add-user', name.value, email.value, success.value, resultMessage.value);
            name.value = '';
            email.value = '';
            
        } else {
            resultMessage.value = 'L\'email n\'est pas valide';
            success.value = false;
        }
    } else {
        resultMessage.value = 'Veuillez remplir tous les champs obligatoire !';
        success.value = false;
    }
    if(!success.value){
        emit('show-result', success.value, resultMessage.value);
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