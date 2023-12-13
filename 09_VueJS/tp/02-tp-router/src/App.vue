<script setup>
import { ref, provide } from 'vue';
import customersList from './bdd/customerlist.json';
import customer1 from './bdd/customer1.json';
import customer2 from './bdd/customer2.json';
import customer3 from './bdd/customer3.json';
import Headers from './components/headers/Header.vue';

const customersDetailList = ref([
  customer1,
  customer2,
  customer3
]);
const customerName = ref('');

function changeName(name) {
  customerName.value = name
}

provide('customersList', { customersList });
provide('customersDetailList', {customersDetailList});
provide('customerName', {customerName, changeName})
</script>

<template>
<header>
  <Headers />
</header>
<main>
  <router-view></router-view>
</main>
<footer>
  <h3 class="text-center">Mon footer</h3>
</footer>
</template>

<style scoped>
main {
  height: 100vh;
}
</style>
