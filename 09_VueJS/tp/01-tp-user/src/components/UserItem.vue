<script setup>
import {ref, defineEmits} from 'vue';
const toggleUpdate = ref(false);
const resultMessage = ref('');
const success = ref(false);
const emit = defineEmits(['update-user', 'remove-user', 'show-result'])
const props = defineProps({
    id: {
        Type: String,
        required: true,
    },
    name: {
        Type: String,
        required: true,
    },
    email: {
        Type: String,
        required: true,
    },
    index: {
        Type: Number,
        required: true,
    },
});

const nameInput = ref(props.name);
const emailInput = ref(props.email);

const emitUpdateUser = () => {
    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+\.[a-zA-Z]{2,}$/;
    if (nameInput.value !== '' && emailInput.value !== '') {
        if (pattern.test(emailInput.value)) {
            resultMessage.value = 'L\'utilisateur à bien été mis à jour';
            success.value = true;
            emit('update-user', nameInput.value, emailInput.value, props.id, success.value, resultMessage.value);
            toggleUpdate.value = false;
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
    <tr v-if="!toggleUpdate" class="align-middle">
        <td>{{ name }}</td>
        <td>{{ email }}</td>
        <td>
            <button class="btn btn-info mx-5" @click="toggleUpdate = !toggleUpdate">Modifier</button>
            <button class="btn btn-danger" @click="emit('remove-user', index)">Supprimer</button>
        </td>
    </tr>
    <tr v-else class="align-middle">
        <td><input type="text" v-model="nameInput" @keyup.enter="emitUpdateUser"></td>
        <td><input type="email" name="email" id="email" v-model="emailInput" @keyup.enter="emitUpdateUser"></td>
        <td>
            <button class="btn btn-info mx-5" @click="emitUpdateUser">Valider</button>
            <button class="btn btn-dark" @click="toggleUpdate = !toggleUpdate">Cancel</button>
        </td>
    </tr>
</template>

<style scoped>
td {
    width: 400px;
}
</style>