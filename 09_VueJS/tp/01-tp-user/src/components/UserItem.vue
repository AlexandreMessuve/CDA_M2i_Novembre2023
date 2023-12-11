<script setup>
import {ref} from 'vue';
const toggleUpdate = ref(false);
const result = ref(false);
const resultMessage = ref('');
const resultClass = ref('');
const success = ref(false);
const emit = defineEmits('update-user')
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
            emit('update-user', nameInput.value, emailInput.value, props.id);
            resultMessage.value = 'L\'utilisateur à bien été mis à jour';
            success.value = true;
            toggleUpdate.value = false;
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
    <tr v-if="!toggleUpdate" class="align-middle">
        <td>{{ name }}</td>
        <td>{{ email }}</td>
        <td>
            <button class="btn btn-info mx-5" @click="toggleUpdate = !toggleUpdate">Modifier</button>
            <button class="btn btn-danger" @click="$emit('remove-user', index)">Supprimer</button>
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
    <tr v-if="result">
        <td colspan="3">
            <div class="rounded-2 alert alert-dismissible fade show" role="alert" :class="resultClass">
                {{ resultMessage }}
                <button type="button" class="btn-close" @click="result = !result" aria-label="Close">
                </button>
            </div>
        </td>
    </tr>
</template>

<style scoped>
td {
    width: 400px;
}
</style>