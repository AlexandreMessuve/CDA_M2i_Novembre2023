<script setup>
import { ref } from 'vue';
let message = ref('Bienvenue');

const reverseMess = () => {
    message.value = message.value.split('').reverse().join('');
};

const addExclamation = () => {
    message.value += '!';
}

const alertMess = () => {
    alert(message.value);
}
</script>

<template>
    <div class="container">
        <h4>Exercice01</h4>
        <div class="exo">
            <h2>{{ message }}</h2>
            <div class="button">
                <button v-on:click="reverseMess()">Mettre le message à l'envers</button>
                <button v-on:click="addExclamation()">Ajouter un "!" à la fin du message</button>
                <a v-on:click.prevent="false" href="" id="link" v-on:click="alertMess()">Afficher le message</a>
            </div>
    
        </div>

    </div>
</template>

<style scoped >
    .button{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }
</style>

