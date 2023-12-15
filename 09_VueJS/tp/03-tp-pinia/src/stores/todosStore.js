import { ref, reactive } from 'vue'
import { defineStore } from 'pinia'
import { v4 as uuid } from 'uuid';

export const useTodosStore = defineStore('todos', () => {
const todos = ref([]);


const addTodo = (data) => {
  const todo = {
    id: uuid(),
    text: data,
    favorite: false,
  }
  todos.value.push(todo);
}

const changeFavoriteStatus = (id) => {
  todos.value.forEach((t) => {
    if(t.id === id){
      t.favorite ? t.favorite = false : t.favorite = true;
    }
  })
}

const removeTodo = (todo) => { 
  let index;
  todos.value.forEach((t, i) => {t.id === todo.id ? index = i : null})
  todos.value.splice(index,1);
}
return {todos,addTodo, changeFavoriteStatus, removeTodo };
})
