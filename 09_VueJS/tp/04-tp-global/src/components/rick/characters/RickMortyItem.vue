<script setup>
// Importation des fonctions nécessaires de Vue.js
import { onBeforeMount, ref, watchEffect } from 'vue';

// Importation du composant ModalCharacter
import ModalCharacter from './ModalCharacter.vue';

// Importation du magasin d'état pour les favoris
import { useFavoriteStore } from '@/stores/rickFavorite';

// Initialisation du magasin d'état pour les favoris
const favoriteStore = useFavoriteStore();

// Définition des propriétés du composant avec la fonction defineProps
const props = defineProps({
    // La propriété rick est de type Object et est requise
    rick: {
        type: Object,
        required: true,
    }
});

// Création d'une propriété réactive showModal initialisée à false
const showModal = ref(false);

// Définition d'une fonction updateModal pour mettre à jour la valeur de showModal
const updateModal = (value) => {
    showModal.value = value;
}

// Création d'une propriété réactive favorite initialisée à null
const favorite = ref(null);

// Définition d'une fonction loadImg pour charger une image
const loadImg = (e) => {
    // Mise à jour de la source de l'image avec l'image de la propriété rick
    e.target.src = props.rick.image;
}

// Utilisation de watchEffect pour réagir aux changements de la propriété rick
watchEffect(() => {
    // Mise à jour de la valeur de favorite avec le favori correspondant au personnage rick
    favorite.value = favoriteStore.getFavorite('character', props.rick);
});

// Utilisation de onBeforeMount pour initialiser la valeur de favorite avant le montage du composant
onBeforeMount(() => {
    // Recherche du favori correspondant au personnage rick dans le magasin d'état pour les favoris
    favorite.value = favoriteStore.favorite.find((value) =>value.type === 'character' && value.data.id === props.rick.id);
})
</script>

<template>
    <ModalCharacter :key="rick.id" :id-rick="rick.id" :name="rick.name" :species="rick.species" :image="rick.image"
        :status="rick.status" :type-rick="rick.type" :origin="rick.origin.name" :location="rick.location.name"
        :created="Date(rick.created)" :gender="rick.gender" :show-modal="showModal" @update-modal="updateModal" />

    <div class="card m-3" style="width: 18rem;">
        <a href="#" @click.prevent="showModal = !showModal">
            <img :id="rick.id" class="card-img-top" @load="loadImg" src="@/assets/img/avatar_placeholder.webp"
                :alt="rick.name">
            <div class="card-body">
                <div class="d-flex">
                    <h6 class="card-title">{{ rick.name }}</h6>

                </div>
                <p><span class="text-success">Species:</span> {{ rick.species }} </p>
            </div>
        </a>
        <div class="card-footer">
            <div class="d-flex justify-content-between">
                <p>Ajouter aux favoris</p>
                <a href="#" v-if="!!favorite" @click.prevent="favoriteStore.deleteFavorite(favorite?.id)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-heart-fill text-danger" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                            d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314" />
                    </svg>
                </a>
                <a href="#" v-else @click.prevent="favoriteStore.addFavorite('character', rick)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart text-danger"
                        viewBox="0 0 16 16">
                        <path
                            d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15" />
                    </svg>
                </a>
            </div>
        </div>
    </div>
</template>

