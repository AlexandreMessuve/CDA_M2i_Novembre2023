<script setup>
import { reactive } from 'vue';
import searchFile from '@/assets/search.json';
const select = reactive({
    status: searchFile[0],
    species: searchFile[1],
    type: searchFile[2],
    gender: searchFile[3]
})

const search = reactive({
    name: '',
    species: '',
    type: '',
    gender: '',
    status: '',
    input: ''
});

const emit = defineEmits(['search']);

const updateFilter = () => {
    emit('search', search);
}
const clearFilter = () => {
    search.name = '';
    search.species = '';
    search.type = '';
    search.gender = '';
    search.status = '';
    search.input = '';
    updateFilter();
}
</script>

<template>
    <div class="d-flex flex-column align-items-center">
    <div style="width: 30rem;" >
        <input  type="text" id="name" class="text-center form-control rounded-5" v-model="search.name" @keyup="updateFilter" placeholder="Search name ..."/>
    </div>
        <div class="d-flex justify-content-center m-2">
            <div class="d-flex flex-wrap  justify-content-center" style="width: 50rem;">
                <div class="m-2">
                    <label class="text-success text-start">{{ select.status.name }}</label>
                    <select class="mx-2 text-center" :name="select.status.name" v-model="search.status" @change="updateFilter">
                        <option selected value="">-</option>
                        <option v-for="value in select.status.subFilters" :value="value">{{ value }}</option>
                    </select>
                </div>
                <div class="m-2">
                    <label class="text-success text-start">{{ select.type.name }}</label>
                    <select class="mx-2 text-center" :name="select.type.name" v-model="search.type" @change="updateFilter">
                        <option selected value="">-</option>
                        <option v-for="value in select.type.subFilters" :value="value">{{ value }}</option>
                    </select>
                </div>

                <div class="m-2"> 
                    <label class="text-success text-start">{{ select.species.name }}</label>
                    <select class="mx-2 text-center" :name="select.species.name" v-model="search.species" @change="updateFilter">
                        <option selected value="">-</option>
                        <option v-for="value in select.species.subFilters" :value="value">{{ value }}</option>
                    </select>
                </div>

                <div class="m-2">
                    <label class="text-success text-start">{{ select.gender.name }}</label>
                    <select class="mx-2 text-center" :name="select.gender.name" v-model="search.gender" @change="updateFilter">
                        <option selected value="">-</option>
                        <option v-for="value in select.gender.subFilters" :value="value">{{ value }}</option>
                    </select>
                </div>
            </div>
        </div>
        <button @click="clearFilter" class="btn btn-outline-warning m-2">clear filter</button>
    </div>
</template>

<style scoped>
select{
    width: 20rem;
}
</style>