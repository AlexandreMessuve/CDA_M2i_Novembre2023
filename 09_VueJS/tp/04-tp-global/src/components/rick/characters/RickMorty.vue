<script setup>

// Import des dépendances nécessaires
import { useRickStore } from '@/stores/rickCharacter';
import { onMounted, ref } from 'vue';
import RickSearch from './RickSearch.vue';
import RickItem from './RickMortyItem.vue';

// Utilisation du store "rickCharacter"
const rickStore = useRickStore();

// Référence pour la recherche
const search = ref({});

// Exécution au moment du montage du composant
onMounted(async () => {
    // Récupération des données depuis le store
    await rickStore.fetchData();
});

// Variable réactive pour afficher ou masquer le filtre
const showFilter = ref(false);

// Fonction pour changer de page
const changePage = async (page) => {
    // Appel de la méthode du store pour changer de page avec la recherche actuelle
    await rickStore.changePage(page, search.value);
};

// Fonction pour mettre à jour la recherche
const updateSearch = async (value) => {
    // Mise à jour de la valeur de recherche
    search.value = value;
    // Appel de la méthode du store pour changer de page avec la nouvelle recherche
    await rickStore.changePage(1, search.value);
}



</script>

<template>
    <div class="d-flex justify-content-center">
        <a @click.prevent="showFilter = !showFilter" href="#" class="mt-3">
            <svg v-if="showFilter" xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                class="bi bi-funnel-fill text-success text-center" viewBox="0 0 16 16">
                <path
                    d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5z" />
            </svg>
            <svg v-else xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                class="bi bi-funnel text-success text-center" viewBox="0 0 16 16">
                <path
                    d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2z" />
            </svg>
        </a>
    </div>
    <div v-if="showFilter" class="text-center">
        <RickSearch @search="updateSearch" />
    </div>
    <div v-if="rickStore.rick.results.length > 0">
        <div class="text-center">
            <button 
            class="btn btn-outline-secondary mx-5"
            :disabled="rickStore.rick.currentPage === 1" 
            @click="changePage(1)">
            Première page
        </button>
            <button 
            class="btn btn-outline-secondary mx-3"
            :disabled="rickStore.rick.currentPage === 1" 
            @click="changePage(rickStore.rick.currentPage - 1)">
                {{
                    rickStore.rick.currentPage === 1 ? '-' :
                    rickStore.rick.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ rickStore.rick.currentPage }}
            </span>
            <button 
            class="btn btn-outline-secondary mx-3"
            @click="changePage(rickStore.rick.currentPage + 1)">
            {{ 
            rickStore.rick.currentPage === rickStore.rick.maxPage ? '-' : rickStore.rick.currentPage + 1 
            }}
            </button>
            <button 
            class="btn btn-outline-secondary mx-5"
            :disabled="rickStore.rick.currentPage === rickStore.rick.maxPage"
            @click="changePage(rickStore.rick.maxPage)">
            Derniere page
        </button>
        </div>


        <div class="d-flex flex-wrap justify-content-center">
            <RickItem v-for="rick in rickStore.rick.results" :rick="rick"/>
        </div>


        <div class="text-center">
            <button 
            class="btn btn-outline-secondary mx-5"
            :disabled="rickStore.rick.currentPage === 1" 
            @click="changePage(1)">
            Première page
        </button>
            <button 
            class="btn btn-outline-secondary mx-3"
            :disabled="rickStore.rick.currentPage === 1" 
            @click="changePage(rickStore.rick.currentPage - 1)">
                {{
                    rickStore.rick.currentPage === 1 ? '-' :
                    rickStore.rick.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ rickStore.rick.currentPage }}
            </span>
            <button 
            class="btn btn-outline-secondary mx-3"
            @click="changePage(rickStore.rick.currentPage + 1)">
            {{ 
            rickStore.rick.currentPage === rickStore.rick.maxPage ? '-' : rickStore.rick.currentPage + 1 
            }}
            </button>
            <button 
            class="btn btn-outline-secondary mx-5"
            :disabled="rickStore.rick.currentPage === rickStore.rick.maxPage"
            @click="changePage(rickStore.rick.maxPage)">
            Derniere page
        </button>
        </div>
    </div>
    <div v-else>
        <h4 class="text-center mt-5">Aucune données</h4>
    </div>
</template>