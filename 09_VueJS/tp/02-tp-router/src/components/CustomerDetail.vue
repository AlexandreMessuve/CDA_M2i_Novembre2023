<script setup>
import { inject, onUnmounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
const { customersDetailList } = inject('customersDetailList');
const { changeName } = inject('customerName');
const route = useRoute();
const router = useRouter();
const { customerId } = route.params;
const customer = customersDetailList.value.find(c => c.id === +customerId);

if(!customer){
    router.push('/');
}
onUnmounted(() => {
    changeName('');
});
</script>

<template>
    <div class="card m-auto text-center" style="width: 80%;">
        <div class="card-body">
            <h5 class="card-title">{{ customer?.name }}</h5>
            <p class="card-text">Name: {{ customer?.name }}</p>
            <p class="card-text"> Email: {{ customer?.email }}</p>
            <p class="card-text"> Phone: {{ customer?.phone }}</p>
            <p class="card-text"> City: {{ customer?.city }}</p>
            <p class="card-text"> State: {{ customer?.state }}</p>
            <p class="card-text"> Country: {{ customer?.country }}</p>
            <p class="card-text"> Organization: {{ customer?.organization }}</p>
            <p class="card-text"> Job Profile: {{ customer?.jobProfile }}</p>
            <p class="card-text"> Additionnal Info: {{ customer?.additionalInfo }}</p>
        </div>
        <div class="card-footer">
            <router-link :to="`/customers`" class="btn btn-primary">Go Back</router-link>
        </div>
    </div>
</template>