import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router';
import Home from './pages/Home.vue';
import Exercices from './pages/Exercices.vue';
import Rick from './pages/Rick.vue';
import TodoList from './pages/TodoList.vue';


const routes = [
    {path: '/',name:'Home', component: Home},
    {path: '/exercices',name:'Exercices', component: Exercices},
    {path: '/rick', name: 'Rick', component: Rick},
    {path: '/todo-list', name: 'TodoList', component: TodoList}
]
const router = createRouter({
    history: createWebHistory(''),
    routes
});

export default router;

