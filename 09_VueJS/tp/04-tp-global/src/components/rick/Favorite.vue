<script setup>
import { useFavoriteStore } from '@/stores/rickFavorite';
const favoriteStore = useFavoriteStore();
</script>

<template>
    <table class="table table-bordered align-middle text-center">
        <thead>
            <th>Type</th>
            <th>Nom</th>
            <th>Date d'ajout</th>
            <th>Action</th>
        </thead>
        <tbody align="center">
            <template v-if="favoriteStore.favorite.length <= 0">
                <tr>
                    <td colspan="4">Aucun favoris</td>
                </tr>
            </template>
            <template v-else>
                <tr v-for="favorite in favoriteStore.favorite">
                    <td>{{ favorite?.type }}</td>
                    <td>{{ favorite?.data.name }}</td>
                    <td>{{ new Date(favorite?.addDate).toLocaleString() }}</td>
                    <td>
                        <button class="btn btn-danger" @click="favoriteStore.deleteFavorite(favorite?.id)">
                            Delete
                        </button>
                    </td>
                </tr>
            </template>
        </tbody>
    </table>
</template>