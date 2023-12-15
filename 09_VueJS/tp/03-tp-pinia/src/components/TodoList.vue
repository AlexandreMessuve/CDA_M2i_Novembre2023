<script setup>
import { ref} from 'vue';
import { useTodosStore } from '../stores/todosStore.js';
import TodoCard from './TodoCard.vue';
const { todos} = useTodosStore();
const isFavorite = ref(false);


</script>
<template>
    <h1>Liste des tâche</h1>
    <template v-if="todos.length > 0" :key="todos.length">
        <button class="btn btn-dark" @click="isFavorite = false">All task</button>
        <button class="btn btn-outline-info" @click="isFavorite = true">Favorite todo</button>
        <div class="d-flex flex-column align-items-center">
            <template v-if="isFavorite">
                <div  v-for="(todo, index) in todos.filter(t => t.favorite)" :key="todo.index">
                    <TodoCard :todo="todo" :index="index" />
                </div>
            </template>
            <template v-else>
                <div  v-for="(todo, index) in todos" :key="todo.index">
                    <TodoCard :todo="todo" :index="index" />
                </div>
            </template>
        </div>
    </template>

    <template v-else>
        <h3>Aucune tâche actuellement</h3>
    </template>
</template>
