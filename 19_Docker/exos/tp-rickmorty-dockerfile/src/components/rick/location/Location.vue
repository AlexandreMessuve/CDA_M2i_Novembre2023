<script setup>
// Import des dépendances nécessaires
import { useLocationStore } from '@/stores/rickLocation';
import { onBeforeMount, ref } from 'vue';
import LocationItem from './LocationItem.vue';
// Utilisation du store "locationStore"
const locationStore = useLocationStore();

// Exécution au moment du montage du composant
onBeforeMount(async () => {
    // Récupération des données depuis le store
    await locationStore.fetchData();
});

// Fonction pour changer de page
const changePage = async (page) => {
    // Appel de la méthode du store pour changer de page avec la recherche actuelle
    await locationStore.changePage(page);
};

</script>

<template>
    <div v-if="locationStore.location.results.length > 0">
        <div class="text-center">
            <button class="btn btn-outline-secondary mx-5" :disabled="locationStore.location.currentPage === 1"
                @click="changePage(1)">
                Première page
            </button>
            <button class="btn btn-outline-secondary mx-3" :disabled="locationStore.location.currentPage === 1"
                @click="changePage(locationStore.location.currentPage - 1)">
                {{
                    locationStore.location.currentPage === 1 ? '-' :
                    locationStore.location.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ locationStore.location.currentPage }}
            </span>
            <button  :disabled="locationStore.location.currentPage === locationStore.location.maxPage" class="btn btn-outline-secondary mx-3" @click="changePage(locationStore.location.currentPage + 1)">
                {{
                    locationStore.location.currentPage === locationStore.location.maxPage ? '-' : locationStore.location.currentPage +
                1
                }}
            </button>
            <button class="btn btn-outline-secondary mx-5"
                :disabled="locationStore.location.currentPage === locationStore.location.maxPage"
                @click="changePage(locationStore.location.maxPage)">
                Derniere page
            </button>
        </div>



        <div class="d-flex flex-wrap justify-content-center">
            <LocationItem v-for="location in locationStore.location.results" :location="location"/>
        </div>



        <div class="text-center">
            <button class="btn btn-outline-secondary mx-5" :disabled="locationStore.location.currentPage === 1"
                @click="changePage(1)">
                Première page
            </button>
            <button class="btn btn-outline-secondary mx-3" :disabled="locationStore.location.currentPage === 1"
                @click="changePage(locationStore.location.currentPage - 1)">
                {{
                    locationStore.location.currentPage === 1 ? '-' :
                    locationStore.location.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ locationStore.location.currentPage }}
            </span>
            <button class="btn btn-outline-secondary mx-3" @click="changePage(locationStore.location.currentPage + 1)">
                {{
                    locationStore.location.currentPage === locationStore.location.maxPage ? '-' : locationStore.location.currentPage +
                1
                }}
            </button>
            <button class="btn btn-outline-secondary mx-5"
                :disabled="locationStore.location.currentPage === locationStore.location.maxPage"
                @click="changePage(locationStore.location.maxPage)">
                Derniere page
            </button>
        </div>
    </div>
    <div v-else>
        <h4 class="text-center mt-5">Aucune données</h4>
    </div>
</template>