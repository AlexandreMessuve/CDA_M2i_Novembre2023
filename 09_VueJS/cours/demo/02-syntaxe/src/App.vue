<script setup>
  import { ref } from 'vue';
  let count = ref(0);
  const addOne = () => {
    count.value++;
  }
  const resetCount = () => {
    count.value =0;
  }
</script>

<template>
  <h1>Mon titre de malade</h1>
  <span class="important">{{ count }}</span>
  <button v-on:click="addOne()">Add 1</button>
  <button v-on:click="resetCount()">Reset</button>
</template>

<style scoped>
.important {
  color: #ff3131;
  font-size: 10rem;
}
</style>