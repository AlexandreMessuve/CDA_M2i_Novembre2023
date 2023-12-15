<script setup>
import AddTodoForm from '../components/AddTodoForm.vue';
import TodoList from '../components/TodoList.vue';
</script>

<template>
  <div class="header-todo text-center">
    <h1>Todo</h1>
    <img src="../assets/pinia.png" alt="pinia logo" height="130"/>
  </div>
  <div class="text-center">
    <AddTodoForm />
  </div>
  <div class="text-center">
    <TodoList />
  </div>
</template>

<style scoped> 
.header-todo{
  background-color: beige;
  height: 200px;
}
</style>
