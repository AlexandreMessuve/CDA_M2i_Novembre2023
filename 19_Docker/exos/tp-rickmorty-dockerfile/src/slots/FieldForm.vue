<script setup>
import { onMounted, reactive, ref } from 'vue';

const props = defineProps({
    idInput: {
        type: String,
        required: true,
    },
    typeInput:{
        type: String,
        required: true,
    },
    inputValue: {
        required: true,
    },
    inputClass: {
        type: String,
        required: true,
    }
});
const emit = defineEmits(['update-value']);

const valueInput = ref(props.inputValue);
const formClass = reactive({
    input: '',
    label: ''
})
onMounted(() =>{
    if(props.typeInput === 'checkbox'){
        formClass.input = 'form-check-input ';
        formClass.label = 'form-check-label mx-1 '
        
    }else{
        formClass.input = 'form-control ';
        formClass.label = 'form-label '
    }

});

const beforeEmitValue = () => {
    if(typeof(valueInput.value) === 'boolean'){
        valueInput.value = !valueInput.value;
        emit('update-value', valueInput.value);
    }else{
        emit('update-value', valueInput.value)
    }
}
</script>

<template>
    <label :class="formClass.label" :for="idInput"><slot name="label"></slot></label>
    <input class="focus-ring" :class="formClass.input, inputClass" @keyup="beforeEmitValue" @click="beforeEmitValue"  :id="idInput" :name="idInput" :type="typeInput" v-model="valueInput">
</template>