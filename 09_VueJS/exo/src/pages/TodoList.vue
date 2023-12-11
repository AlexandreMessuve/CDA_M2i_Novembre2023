<script setup>
import {ref} from 'vue';
import AddTodo from '../components/todo-list/AddTodo.vue';
import TodoItem from '../components/todo-list/TodoItem.vue'
const todos = ref([]);

const addTodo = newTodoText =>{
    todos.value.push({text: newTodoText, checked: false});
    console.log(todos.value)
}

const delTodo = index => {
    todos.value.splice(index,1);
}

const checkTodo = (check, index)=> {
    todos.value[index].checked = check;
}

const updateTodo = (value, index) => {
    todos.value[index].text = value;
}
</script>

<template>
<h1>TodoList</h1>
<AddTodo @add-todo="addTodo"/>
<div v-if="todos.length > 0">
    <h1>Liste des tâches : </h1>
    <ul>
        <TodoItem v-for="(todo, index)  in todos" :key="index" :todo="todo.text" :checked="todo.checked" :index="index" @del-todo="delTodo" @check-todo="checkTodo" @update-todo="updateTodo"/>
    </ul>
</div>
<div v-else>
    <h1>Il ni a aucune tâche</h1>
</div>
</template>
<style scoped>
ul{
    padding: 0;
}
</style>
