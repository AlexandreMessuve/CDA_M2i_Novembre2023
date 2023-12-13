import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CustomersView from '../views/CustomersView.vue';
import CustomersDetailView from '../views/CustomersDetailView.vue';

const routes = [
    {
        path:'/', 
        component: HomeView
    },
    {
        path:'/customers', 
        component:CustomersView
    },
    {
        path:'/customers/:customerId', 
        component:CustomersDetailView
    }
];

const router = createRouter(
    {
    history: createWebHistory(),
    routes
}
);

export default router;