<script setup>
import { inject } from 'vue';
import Customers from '../components/Customers.vue';
const {customerName} = inject('customerName');
</script>

<template>
    <h1 class="text-center">Cette page affiche la liste des clients</h1>
    <h5 class="text-center">Cliquer sur une carte pour affiche le nom en dessous</h5>
    <h5 class="text-center">Cliquer sur "Plus de detail" redirige vers une nouvelle page qui affiche les informations du client</h5>
    <Customers class="container" />
    <div v-if="customerName !== ''" class="alert alert-primary text-center">
        {{ customerName }}
    </div>
</template>