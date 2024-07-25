<script setup>
// Importation des fonctions nécessaires de Vue.js
import { ref, watchEffect, onBeforeMount } from 'vue';

// Importation du composant EpisodeCharacter
import EpisodeCharacter from './EpisodeCharacter.vue';

// Importation du magasin d'état pour les favoris
import { useFavoriteStore } from '@/stores/rickFavorite';

// Initialisation du magasin d'état pour les favoris
const favoriteStore = useFavoriteStore();

// Définition des propriétés du composant avec la fonction defineProps
const props = defineProps({
    // La propriété episode est de type Object et est requise
    episode: {
        type: Object,
        required: true,
    }
});

// Création d'une propriété réactive favorite initialisée à null
const favorite = ref(null);

// Création d'une propriété réactive loading initialisée à false
const loading = ref(false);

// Définition d'une fonction loader pour activer le chargement
const loader = () => {
    loading.value = true;
}

// Définition d'une fonction loadCharacter pour charger un personnage
const loadCharacter = (character) => {
    // Si le personnage est un objet, activer le chargement et retourner true
    if(typeof character === 'object'){
        loader();
        return true;
    }else{
        // Sinon, retourner false
        return false;
    }
}

// Utilisation de watchEffect pour réagir aux changements de la propriété episode
watchEffect(() => {
    // Mise à jour de la valeur de favorite avec le favori correspondant à l'épisode
    favorite.value = favoriteStore.getFavorite('episode', props.episode);
});

// Utilisation de onBeforeMount pour initialiser la valeur de favorite avant le montage du composant
onBeforeMount(() => {
    // Recherche du favori correspondant à l'épisode dans le magasin d'état pour les favoris
    favorite.value = favoriteStore.favorite.find((value) =>value.type === 'episode' && value.data.id === props.episode.id);
})
</script>

<template>
    <div class="card m-3" style="width: 57rem; height: auto;">
        <div class="card-body">
            <div class="d-flex flex-wrap justify-content-around">
                <h6>Nom de l'épisode : <span>{{ episode.name }}</span></h6>
                <h6>Diffusions: <span>{{ new Date(episode.air_date).toLocaleDateString() }}</span></h6>
                <a href="#" v-if="!!favorite" @click.prevent="favoriteStore.deleteFavorite(favorite?.id)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-heart-fill text-danger" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                            d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314" />
                    </svg>
                </a>
                <a href="#" v-else @click.prevent="favoriteStore.addFavorite('episode', episode)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart text-danger"
                        viewBox="0 0 16 16">
                        <path
                            d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15" />
                    </svg>
                </a>
            </div>
            <hr />
            <h6>Personnage dans l'épisode : <span>{{ episode.episode }}</span></h6>
            <div class="d-flex justify-content-center" v-if="!loading">
                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                    class="bi bi-arrow-clockwise rotating" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2z" />
                    <path
                        d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466" />
                </svg>
            </div>
            <div class="character"  v-if="!!episode.characters">
                <div class="d-flex flex-wrap">
                    <div class="m-1" v-for="character in episode.characters" v-show="loading === true">
                        <EpisodeCharacter v-if="loadCharacter(character)" :character="character" />
                    </div>
                </div>
            </div>
            <p></p>
        </div>
    </div>
</template>

<style scoped >
.character{
    overflow: auto;
    height: 11rem;
}

@keyframes rotating {
    from {
        -ms-transform: rotate(0deg);
        -moz-transform: rotate(0deg);
        -webkit-transform: rotate(0deg);
        -o-transform: rotate(0deg);
        transform: rotate(0deg);
    }

    to {
        -ms-transform: rotate(360deg);
        -moz-transform: rotate(360deg);
        -webkit-transform: rotate(360deg);
        -o-transform: rotate(360deg);
        transform: rotate(360deg);
    }
}

.rotating {
    -webkit-animation: rotating 1s linear infinite;
    -moz-animation: rotating 1s linear infinite;
    -ms-animation: rotating 1s linear infinite;
    -o-animation: rotating 1s linear infinite;
    animation: rotating 1s linear infinite;
}
</style>