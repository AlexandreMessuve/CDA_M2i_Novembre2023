<script setup>
import { inject } from 'vue';

const { customersList} = inject('customersList');
const { changeName } = inject('customerName');

console.log(customersList);
</script>

<template>
    <div v-if="customersList.length > 0" class="text-center d-flex flex-column align-items-center mt-3">
        <div v-for="customer in customersList" @click="changeName(customer.name)" class="card m-3" style="width: 18rem;" > 
            <div class="card-body">
                <h5 class="card-title">{{ customer.name }}</h5>
                <p class="card-text">{{ customer.email }}<br />
                    {{ customer.phone }}
                </p>
                <router-link :to="`/customers/${customer.id}`" class="btn btn-primary">Plus de detail</router-link>
            </div>
        </div>
    </div>
</template>