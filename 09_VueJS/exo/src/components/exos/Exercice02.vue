<script setup>
import { reactive, computed } from 'vue';
let personne = reactive({
    firstname: 'Messuve',
    lastname: 'Alexandre',
    birthday: new Date('1997-12-30'),
});

let year = computed(() => {
    const currentDate = new Date();
    let year = currentDate.getFullYear() - personne.birthday.getFullYear();
    const month = currentDate.getMonth() - personne.birthday.getMonth();
    if (month < 0 || (month === 0 && currentDate.getDate() < personne.birthday.getDate())) {
        year--;
    }
    return year
})

const addYear = () => {
    const newYear = Math.floor(Math.random() * (2023 - 1800) + 1800);
    personne.birthday = new Date(`${newYear}-12-30`);
}
</script>

<template>
    <div class="container">
        <h4>Exercice02</h4>
        <div class="exo">
            <div>
                <h2>{{ `${personne.firstname} ${personne.lastname}` }} <i>{{ personne.birthday.toLocaleDateString() }}</i></h2>
                <p>Age: {{ year }}</p>
                <button @click="addYear()">Modifier l'année</button>
            </div>
        </div>
    </div>
</template>

