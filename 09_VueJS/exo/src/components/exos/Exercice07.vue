<script setup>
import { ref, computed, onMounted, onUnmounted, watchEffect } from 'vue';
const nameRick = ref(null);
const infoRicksList = ref([]);
const error = ref(null);
const prev = ref(null);
const next = ref(null);
const mapDetail = async (tab) => {
    const rickTab = [];
    prev.value = tab.info.prev;
    next.value = tab.info.next;
    const results = await tab.results;
    await results.forEach((value) => {
        const detail = {
            id: value.id,
            name: value.name,
            species: value.species,
            status: value.status,
            type: value.type,
            gender: value.gender,
            origin: value.origin.name,
            pict: value.image,
            location: value.location.name,

        }
        rickTab.push(detail);
    });
    return rickTab;
}
watchEffect(async () => {
    if (nameRick.value) {
        try {
            const response = await fetch(`https://rickandmortyapi.com/api/character?name=${nameRick.value}`);
            const infoRicks = await response.json();
            if (await infoRicks.error) {
                error.value = `${nameRick.value} n'existe pas !`;
                return
            }
            infoRicksList.value = await mapDetail(infoRicks);
            error.value = null;
        } catch (e) {
            error.value = e.message;
            console.log(e);

        }
    }
})

const getNewPage = async (url) => {
    try {
        const response = await fetch(url);
        const infoRicks = await response.json();
        infoRicksList.value = await mapDetail(infoRicks);
        error.value = null;
        window.scrollTo(0, 0);

    } catch (e) {
        error.value = e.message;
        console.log(e);

    }
}
</script>

<template>
    <div>
        <span v-if="error">{{ error }}</span>
        <input type="text" v-model.lazy="nameRick" placeholder="Nom du personnage">
        <button>Valider</button>
    </div>
    <div class="detailRick" v-if="infoRicksList.length > 0">
        <div class="containerButtonDetail">
            <button @click="getNewPage(prev)" :disabled="!prev">{{ '<' }}</button>
        </div>
        <div class="containerRick">
            <div class="card" v-for="infoRick in infoRicksList" :key="infoRick.id">
                <img :src="infoRick.pict" :alt="infoRick.name" height="70px">
                <div>
                    <h1>Nom: {{ infoRick.name }}</h1>
                    <h4>Genre: {{ infoRick.gender }}</h4>
                    <h4>Espèce: {{ infoRick.species }}</h4>
                    <h4>Localisation: {{ infoRick.location }}</h4>
                </div>
            </div>
        </div>
        <div class="containerButtonDetail">
            <button @click="getNewPage(next)" :disabled="!next">></button>
        </div>
    </div>
</template>

<style scoped>
.detailRick {
    display: flex;
    justify-content: space-evenly;
    align-items: center;

}

.containerRick {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    width: 2000px;
}

.card {
    display: flex;
    justify-content: space-evenly;
    background-color: paleturquoise;
    height: 150px;
    width: 300px;
    margin: 20px;
    border-radius: 20px;

    & div{
        width: 230px;
    }
    & img {
        border-radius: 50%;
    }

    & h1 {
        margin-top: 3px;
        margin-left: 20px;
        text-align: left;
        font-size: 0.7em;
        font-weight: 700;
    }

    & h4 {
        margin-top: 5px;
        margin-bottom: 0;
        text-align: left;
        font-size: 0.7em;
        font-weight: 600;
    }
}.containerButtonDetail {
        margin-right: 10px;
    }
</style>
