<script setup>
import { useTodosStore } from '../stores/todosStore';
const { changeFavoriteStatus, removeTodo } = useTodosStore();
const props = defineProps({
    todo: {
        type: Object,
        required:true,
    },
    index: {
        type: Number,
        required: true,
    }
})
const colorFavorite = (favorite) => {
    if(favorite){
        return 'text-danger';
    }
    return '';
}

</script>
<template>
    <div class="card mt-3" style="width: 50rem;">
        <div class="d-flex justify-content-between align-items-center">
            <h3>{{ todo.text }}</h3>
            <div>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" @click="removeTodo(todo)"
                    viewBox="0 0 16 16">
                    <path
                        d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5M8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5m3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0" />
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-heart-fill"
                    @click="changeFavoriteStatus(todo.id)" :class="colorFavorite(todo.favorite)"  viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314" />
                </svg>
            </div>
        </div>
    </div>
</template>

<style scoped>
svg {
    cursor: pointer;
}
</style>
