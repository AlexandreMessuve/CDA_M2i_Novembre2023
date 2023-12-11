<script setup>
import Exercice01 from '../components/exos/Exercice01.vue';
import Exercice02 from '../components/exos/Exercice02.vue';
import Exercice03 from '../components/exos/Exercice03.vue';
import Exercice04 from '../components/exos/Exercice04.vue';
import Exercice05 from '../components/exos/Exercice05.vue';
import Exercice06 from '../components/exos/Exercice06.vue';
</script>

<template>
  <h1>Mes exos</h1>
  <div class="exos">
    <Exercice01 />
    <Exercice02 />
    <Exercice03 />
    <Exercice04 />
    <Exercice05 />
    <Exercice06 />
  </div>
</template>
<style scoped>
  .exos{
    display:flex;
    flex-wrap:wrap;
    justify-content: space-around;
  }
</style>
