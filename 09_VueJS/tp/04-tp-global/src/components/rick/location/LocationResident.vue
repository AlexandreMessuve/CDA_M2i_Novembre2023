<script setup>
// Importation des dépendances nécessaires
import { ref } from 'vue';
import ModalCharacter from '../characters/ModalCharacter.vue';

// Définition des propriétés attendues en tant que props
const props = defineProps({
    character: {
        type: Object,
        required: true,
    }
});

// Déclaration d'une référence réactive pour afficher ou masquer le modal
const showModal = ref(false);

// Fonction pour mettre à jour l'état du modal
const updateModal = (value) => {
    showModal.value = value;
}
</script>

<template v-if="character">
<ModalCharacter :key="character.id" :id-rick="character.id" :name="character.name" :species="character.species" :image="character.image"
        :status="character.status" :type-rick="character.type" :origin="character.origin.name" :location="character.location.name"
        :created="character.created" :gender="character.gender" :show-modal="showModal" @update-modal="updateModal" />
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