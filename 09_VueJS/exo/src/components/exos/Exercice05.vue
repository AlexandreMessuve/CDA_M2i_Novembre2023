<script setup>
import { ref, computed } from 'vue';
const todoList = ref([]);
const todo = ref('');
const filter = ref('');
let idTodo = ref(0);
const filterCheck = ref([]);
const filterUnCheck = ref([]);

const filterToDoList = computed(() => {
    switch (filter.value) {
        case 'faite':
            filterCheck.value = todoList.value.filter((value) => value.checked);
            console.log(filterCheck.value)
            break;

        case 'faire':
            filterUnCheck.value = todoList.value.filter((value) => !value.checked);
            console.log(filterUnCheck.value)
            break;

        default:
            break;
    }
})

const isEmpty = computed(() => {
    return todoList.value.length === 0 ? true : false;
});
const addTodo = () => {
    idTodo.value = idTodo.value + 1;
    const todoObject = {
        id: idTodo.value,
        todo: todo.value,
        checked: false
    }
    todoList.value.push(todoObject);
    todo.value = '';
}

const todoListSort = () => {
    oldTab = todoList.value;
    const checkList = todoList.value.filter((value) => value.checked);
    todoList.value = checkList;
}
</script>

<template>
    <div class="container">
        <h4>Exercice05</h4>
        <div class="exo">
            <form @submit.prevent="addTodo">
                <input v-model="todo" name="todo" id="todo" type="text" placeholder="Ajouter une tache" required>
                <button type="submit">Ajouter</button>
            </form>
            <div v-if="isEmpty">
                <p>Il ni a aucune tâche pour l'instant</p>
            </div>
            <div v-else class="list">
                <select @change="filterToDoList" v-model="filter" name="todoFilter" id="todoFilter">
                    <option value="tous" selected>tous</option>
                    <option value="faite">faites</option>
                    <option value="faire">à faire</option>
                </select>
                <ul>
                    <li v-for="todo in (filter === 'faite' ? filterCheck : filter === 'faire' ? filterUnCheck : todoList)" :key="todo.id">
                        {{ todo.todo }} <input type="checkbox" v-model="todo.checked"> {{ todo.checked ? 'fait' : 'à faire'
                        }}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<style scoped>
.exo div.list ul{
    overflow-y: auto;
    height: 340px;
}
</style>
