<script setup>
import { ref, computed } from 'vue';
const isToggle = ref(false);
const numberLists = ref([10, 30, 40, 20, 10, 40]);

const addNumber = () => {
    const number = Math.round((Math.random() * 90));
    numberLists.value.push(number);
}

const delNumber = () => {
    const index = Math.floor(Math.random() * ((numberLists.value.length - 1) - 0) + 0);
    const newTab = numberLists.value.filter((val, i) => i != index);
    numberLists.value = newTab;
}

const reverseList = () => {
    numberLists.value.reverse();
}

const showList = computed(() => {
    return isToggle.value ? 'Cacher la liste' : 'Afficher la liste';
})
</script>

<template>
    <div class="container">
        <h4>Exercice04</h4>
        <div class="exo">
            <div class="button">
                <button @click="isToggle = !isToggle">{{ showList }}</button>
                <button @click="addNumber" v-if="isToggle">Ajouter élément</button>
                <button @click="delNumber" v-if="isToggle && numberLists.length !== 0">Supprimer élément</button>
                <button @click="reverseList" v-if="isToggle && numberLists.length > 1">Inverser la liste</button>
            </div>
            <div class="list" v-if="!isToggle">
                <p style="margin: 10px;">La liste est cachée</p>
            </div>
            <div class="list" v-if="isToggle && numberLists.length !== 0">
                <ul>
                    <li v-for="number in numberLists" :key="number.index">
                        {{ number }}
                    </li>
                </ul>
            </div>
            <div class="list" v-else-if="isToggle && numberLists.length === 0">
                <p style="margin-left: 10px;">Il ni a aucun élément dans la liste</p>
            </div>
        </div>
    </div>
</template>

<style scoped>
div.list {
    margin-left: 10px;
    height: 300px;
    width: 100%;
    overflow-y: auto;



}

ul {
    padding: 0;


}

li {
    list-style-type: none;
}

.button {
    display: flex;
    flex-wrap: wrap;
    margin-left: 130px;
    width: 100%;
}

@media screen and (min-width: 1000px) {
    .button {
        margin-left: 10px;
    }
}</style>
