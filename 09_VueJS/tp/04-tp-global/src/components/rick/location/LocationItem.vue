<script setup>
import { ref, watchEffect, onBeforeMount } from 'vue';
import LocationResident from './LocationResident.vue';
import { useFavoriteStore } from '@/stores/rickFavorite';
const favoriteStore = useFavoriteStore();

const props = defineProps({
    location: {
        type: Object,
        required: true,
    }
});
const favorite = ref(null);

// Cette fonction vérifie si le personnage est un objet
const loadCharacter = (character) => {
    if (typeof character === 'object') {
        return true;
    } else {
        return false;
    }
}

// Cette fonction est appelée à chaque fois que la liste des favoris est mise à jour
watchEffect(() => {
    favorite.value = favoriteStore.getFavorite('location', props.location);
});

// Cette fonction est appelée avant que le composant soit monté
onBeforeMount(() => {
    favorite.value = favoriteStore.favorite.find((value) => value.type === 'location' && value.data.id === props.location.id);
})
</script>

<template>
    <div class="card m-3" style="width: 57rem; height: auto;">
        <div class="card-body">
            <div class="d-flex flex-wrap justify-content-around">
                <h6>Nom : <span>{{ location.name }}</span></h6>
                <h6>Type: <span>{{ location.type }}</span></h6>
                <h6>Dimension: <span>{{ location.dimension }}</span></h6>
                <a href="#" v-if="!!favorite" @click.prevent="favoriteStore.deleteFavorite(favorite?.id)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-heart-fill text-danger" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                            d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314" />
                    </svg>
                </a>
                <a href="#" v-else @click.prevent="favoriteStore.addFavorite('location', location)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart text-danger"
                        viewBox="0 0 16 16">
                        <path
                            d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15" />
                    </svg>
                </a>
            </div>
            <hr />
            <div class="character"  v-if="location.residents.length > 0">
                <h6>Residents:</h6>
                <div class="d-flex flex-wrap">
                    <div class="m-1" v-for="resident in location.residents">
                        <LocationResident v-if="loadCharacter(resident)" :character="resident" />
                    </div>
                </div>
            </div>
            <div v-else>
                <h6>Aucun résident dans cette planète</h6>
            </div>
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