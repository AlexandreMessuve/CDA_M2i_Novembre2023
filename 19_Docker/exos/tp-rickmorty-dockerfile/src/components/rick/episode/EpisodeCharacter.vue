<script setup>
// Importation de la fonction ref de Vue.js pour créer des propriétés réactives
import {ref} from 'vue';

// Importation du composant ModalCharacter
import ModalCharacter from '../characters/ModalCharacter.vue';

// Définition des propriétés du composant avec la fonction defineProps
const props = defineProps({
    // La propriété character est de type Object et est requise
    character: {
        type: Object,
        required: true,
    }
});

// Création d'une propriété réactive showModal initialisée à false
const showModal = ref(false);

// Définition d'une fonction updateModal pour mettre à jour la valeur de showModal
const updateModal = (value) => {
    // Mise à jour de la valeur de showModal
    showModal.value = value;
}
</script>

<template v-if="character">
<ModalCharacter :key="character.id" :id-rick="character.id" :name="character.name" :species="character.species" :image="character.image"
        :status="character.status" :type-rick="character.type" :origin="character.origin.name" :location="character.location.name"
        :created="new Date(character.created)" :gender="character.gender" :show-modal="showModal" @update-modal="updateModal" />
<a href="" @click.prevent="showModal = !showModal">
    <div :id="character?.id">
        <img  :src="!!character.image ? character.image : '../../../assets/img/avatar_placeholder.jpeg'" :alt="character?.name" height="50"/>
        <p>{{character?.name?.length > 15 ? character?.name?.slice(0,15) + '...' : character?.name}}</p>
    </div>
</a>
</template>

<style scoped>
p{
    font-size: 0.7rem;
}
</style>