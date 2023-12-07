<script setup>
import { ref, computed } from 'vue';
const isToggle = ref(false);
const secondP = ref('color:red;');
const classesFirstP = computed(() => {
    return { 'red': isToggle.value }
})

const secondPClick = () => {
    if (secondP.value === 'color:red;') {
        secondP.value = 'color:blue;'
    } else {
        secondP.value = 'color:red;'
    }
}

</script>

<template>
    <div class="container">
        <h4>Exercice03</h4>
        <div class="exo">
            <div>
                <p :class="classesFirstP" @click="isToggle = !isToggle">Change de noir à rouge si on clique dessus et
                    inversement</p>
                <p @click="secondPClick" :style="secondP">Change de rouge à bleu si on clique dessus et inversement</p>
            </div>
        </div>
    </div>
</template>

<style scoped>
p.red {
    color: red;
}
</style>