<script setup>
import {ref, watch} from 'vue';
const toggleInput = ref(false);
const newTodo = ref('');
const emit = defineEmits('update-todo')
const props = defineProps({
    todo:  {
        type: String,
        required: true,
    },
    checked: {
        type: Boolean,
        required: true,
    },
    index: {
        type: Number,
        required: true,
    }
});
const emitUpdateTodo = (index) => {
    emit('update-todo', newTodo.value, index);
    newTodo.value = '';
    toggleInput.value = false;
}

watch(toggleInput => {
    if (toggleInput) {
        newTodo.value = props.todo;
    }else{
        newTodo.value = '';
    }
})

</script>

<template>
    <div class="container-todo">
        <li>
            <div v-if="!toggleInput">
                <div class="todo-text">
                    <input type="checkbox" :checked="checked" @click="$emit('check-todo',checked? false : true, index)">
                    {{ todo }}
                </div>
            </div>
            <div v-if="toggleInput">
                <input v-model="newTodo" required @keyup.enter="emitUpdateTodo(index)">
                <button class="validate-btn" @click="emitUpdateTodo(index)">Valider</button>
            </div>
            <div>
                <button class="edit-btn" @click="toggleInput = !toggleInput">Edit</button>
                <button @click="$emit('del-todo', index)">Del</button>
            </div>
        </li>
    </div>
</template>

<style scoped>
.container-todo{
    display:flex;
    justify-content:center;
}
li{
    list-style-type: none;
    display:flex;
}
.todo-text{
    width:200px;
    text-align:left;
}
button{
    color: red;
    border-color: red;
}
button:hover{
    color: rgb(255, 68, 0);
    border-color: rgb(255, 68, 0);
}
.edit-btn{
    color: green;
    border-color: green;
}
.edit-btn:hover{
    color: rgb(0, 254, 0);
    border-color: rgb(0, 254, 0);
}
.validate-btn{
    color: blue;
    border-color: blue;
}
.validate-btn:hover{
    color: rgb(24, 56, 198);
    border-color: rgb(24, 56, 198);
}

</style>