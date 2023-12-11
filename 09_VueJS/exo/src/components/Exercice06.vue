<script setup>
import { ref, computed, onMounted, onUnmounted } from 'vue';
const todoList = ref([]);
const todo = ref('');
const filter = ref('');
let idTodo = ref(0);
const filterCheck = ref([]);
const filterUnCheck = ref([]);

onMounted(() => {
    if (localStorage.key('todoList')) {
        console.log(true)
        todoList.value = JSON.parse(localStorage.getItem('todoList'))
    }
})

const saveLocaleStorage = () => {
    localStorage.setItem('todoList',JSON.stringify(todoList.value));
}

onUnmounted(() => saveLocaleStorage());
const filterToDoList = computed(() => {
    switch (filter.value) {
        case 'faite':
            filterCheck.value = todoList.value.filter((value) => value.checked);
            break;

        case 'faire':
            filterUnCheck.value = todoList.value.filter((value) => !value.checked);
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

</script>

<template>
    <div class="container">
        <h4>Exercice06</h4>
        <div class="exo">
            <form @submit.prevent="addTodo">
                <input v-model="todo" name="todo" id="todo" type="text" placeholder="Ajouter une tache" required>
                <button type="submit">Ajouter</button>
            </form>
            <div v-if="isEmpty">
                <p>Il ni a aucune tâche pour l'instant</p>
            </div>
            <div ref="list" v-else class="list">
                <select @change="filterToDoList" v-model="filter" name="todoFilter" id="todoFilter">
                    <option value="tous" selected>tous</option>
                    <option value="faite">faites</option>
                    <option value="faire">à faire</option>
                </select>
                <ul>
                    <li v-for="todo in (filter === 'faite' ? filterCheck : filter === 'faire' ? filterUnCheck : todoList)"
                        :key="todo.id">
                        {{ todo.todo }} <input type="checkbox" v-model="todo.checked"> {{ todo.checked ? 'fait' : 'à faire'
                        }}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<style scoped>
.exo div.list ul {
    overflow-y: auto;
    height: 340px;
}
</style>
