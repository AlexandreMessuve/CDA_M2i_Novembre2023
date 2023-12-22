<script setup>
// Import des dépendances nécessaires
import { useEpisodeStore } from '@/stores/rickEpisode';
import { onMounted, ref } from 'vue';
import EpisodeItem from './EpisodeItem.vue';
// Utilisation du store "rickCharacter"
const episodeStore = useEpisodeStore();

// Exécution au moment du montage du composant
onMounted(async () => {
    // Récupération des données depuis le store
    await episodeStore.fetchData();
});

// Fonction pour changer de page
const changePage = async (page) => {
    // Appel de la méthode du store pour changer de page avec la recherche actuelle
    await episodeStore.changePage(page);
};

</script>

<template>
    <div v-if="episodeStore.episode.results.length > 0">
        <div class="text-center">
            <button class="btn btn-outline-secondary mx-5" :disabled="episodeStore.episode.currentPage === 1"
                @click="changePage(1)">
                Première page
            </button>
            <button class="btn btn-outline-secondary mx-3" :disabled="episodeStore.episode.currentPage === 1"
                @click="changePage(episodeStore.episode.currentPage - 1)">
                {{
                    episodeStore.episode.currentPage === 1 ? '-' :
                    episodeStore.episode.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ episodeStore.episode.currentPage }}
            </span>
            <button  :disabled="episodeStore.episode.currentPage === episodeStore.episode.maxPage" class="btn btn-outline-secondary mx-3" @click="changePage(episodeStore.episode.currentPage + 1)">
                {{
                    episodeStore.episode.currentPage === episodeStore.episode.maxPage ? '-' : episodeStore.episode.currentPage +
                1
                }}
            </button>
            <button class="btn btn-outline-secondary mx-5"
                :disabled="episodeStore.episode.currentPage === episodeStore.episode.maxPage"
                @click="changePage(episodeStore.episode.maxPage)">
                Derniere page
            </button>
        </div>



        <div class="d-flex flex-wrap justify-content-center">
            <EpisodeItem v-for="episode in episodeStore.episode.results" :episode="episode"/>
        </div>



        <div class="text-center">
            <button class="btn btn-outline-secondary mx-5" :disabled="episodeStore.episode.currentPage === 1"
                @click="changePage(1)">
                Première page
            </button>
            <button class="btn btn-outline-secondary mx-3" :disabled="episodeStore.episode.currentPage === 1"
                @click="changePage(episodeStore.episode.currentPage - 1)">
                {{
                    episodeStore.episode.currentPage === 1 ? '-' :
                    episodeStore.episode.currentPage - 1
                }}
            </button>
            <span class="mx-1">
                {{ episodeStore.episode.currentPage }}
            </span>
            <button class="btn btn-outline-secondary mx-3" @click="changePage(episodeStore.episode.currentPage + 1)">
                {{
                    episodeStore.episode.currentPage === episodeStore.episode.maxPage ? '-' : episodeStore.episode.currentPage +
                1
                }}
            </button>
            <button class="btn btn-outline-secondary mx-5"
                :disabled="episodeStore.episode.currentPage === episodeStore.episode.maxPage"
                @click="changePage(episodeStore.episode.maxPage)">
                Derniere page
            </button>
        </div>
    </div>
    <div v-else>
        <h4 class="text-center mt-5">Aucune données</h4>
    </div>
</template>