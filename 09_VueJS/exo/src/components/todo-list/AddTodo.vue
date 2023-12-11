<script setup>
import {ref} from 'vue';

const newTodoText = ref('');
const emit = defineEmits(['add-todo']);
const emitAddTodo = () => {
    emit('add-todo', newTodoText.value);
    newTodoText.value = '';
}
</script>

<template>
    <div>
        <input type="text" placeholder="saisir une tâche" v-model="newTodoText" @keyup.enter="emitAddTodo" required>
        <button @click="emitAddTodo">Ajouter</button>
    </div>
</template>

<style scoped>
</style>