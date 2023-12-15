<script setup>
import { ref } from 'vue';
import { useTodosStore } from '../stores/todosStore.js';

const task = ref('');
const { addTodo } = useTodosStore();

const beforeSubmit = () => {
    addTodo(task.value);
    task.value = '';
}
</script>

<template>
    <form class="mt-3" @submit.prevent="beforeSubmit">
        <label class="form-label" for="todo">Votre tâche</label>
        <input class="form-control w-25 d-inline" type="text" name="todo" id="todo" v-model="task">
        <button class="btn btn-outline-primary">Add</button>
    </form>
</template>

<style scoped>
</style>
