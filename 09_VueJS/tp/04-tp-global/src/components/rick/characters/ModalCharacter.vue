<script setup>
import { ref } from 'vue';


const props = defineProps({
    idRick: {
        type: Number,
        required: true
    },
    name: {
        type: String,
        required: true,
    },
    species: {
        type: String,
        required: true
    },
    image: {
        type: String,
        required: true
    },
    status: {
        type: String,
        required: true
    },
    typeRick: {
        type: String,
    },
    origin: {
        type: String,
        required: true
    },
    location: {
        type: String,
        required: true
    },
    created: {
        type: String,
        required: true
    },
    gender: {
        type: String,
        required: true
    },
    showModal: {
        type: Boolean,
        required: true
    }
});

const emit = defineEmits(['update-modal']);
const eventModal = (e) => {
    if (e.target.id === props.image){
        emit('update-modal', false)
    } 
}

</script>

<template>
    <div v-show="showModal" :id="image" class="modal fade show"
        style="display: block; background-color: rgba(255, 255, 255, 0.6);"
        @click.event="eventModal">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content z-3">
                <div class="modal-header">
                    <h4 class="modal-title">{{ name }}</h4>
                    <button class="btn btn-close" @click="emit('update-modal', false)"></button>
                </div>
                <div class="modal-body">
                    <div class="d-flex">
                        <img class="rounded-3" :src="image" :alt="name">
                        <div class="mx-5">
                            <p><span class="text-success">Status</span> {{ status }}</p>

                            <p><span class="text-success">Species</span> {{ species }}</p>
                            <p><span class="text-success">Type</span> {{ typeRick === '' ? 'unknown' : typeRick }}</p>
                            <p><span class="text-success">Gender</span> {{ gender }}</p>

                            <p><span class="text-success">Origin</span> {{ origin }}</p>
                            <p><span class="text-success">Location</span> {{ location }}</p>
                            <p><span class="text-success">Created</span> {{ created.toLocaleString() }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>