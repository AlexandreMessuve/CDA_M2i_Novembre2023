<script setup>
import { ref, reactive, onMounted, watchEffect} from 'vue';
import { useAuthStore } from '../../stores/authentication.js';
import { useRouter } from 'vue-router';
import * as REGEX from '../../constants/regex.js';
import FieldForm from '../../slots/FieldForm.vue';
import connectionValidation from '../../yup/connectionValidation.js';

const router = useRouter();
const authStore = useAuthStore();

// Définition des données réactives
const form = reactive({
    email: '',
    password: '',
    checkbox: false,
});

const errors = reactive({
    email: '',
    password: ''
});

let resp = reactive({});
const respStatus = ref(false);
const alertClass = ref('');
const formClass = reactive({
    email: '',
    password: '',
    checkbox: ''
})

// Utilisation de watchEffect pour observer les changements dans les données réactives
watchEffect(() => {
    const success = 'border-success focus-ring-success text-success';
    const danger = 'border-danger focus-ring-danger text-danger';

    // Validation de l'email
    if(form.email !== ''){
        if(REGEX.EMAIL.test(form.email)){
            formClass.email = success;
            errors.email = '';
        }else{
            formClass.email = danger;
        }
    }else{
        formClass.email = '';
    }

    // Validation du mot de passe
    if(form.password !== ''){
        if(REGEX.PASSWORD.test(form.password)){
            formClass.password = success;
            errors.password = '';
        }else{
            formClass.password = danger;
        }
    }else{
        formClass.password = '';
    }

    // Validation de la case à cocher
    if (form.checkbox) {
        formClass.checkbox = success 
    }else{
        formClass.checkbox = '';
    }
})

// Fonction exécutée avant la soumission du formulaire
const beforeSubmit = async() => {
    errors.email = '';
    errors.password = '';

    try{
        // Validation des données du formulaire
        await connectionValidation.validate(form, { abortEarly: false});    
        resp = authStore.auth(form.email, form.password, form.checkbox);

        if (resp.code) {
            // Si l'authentification réussit, redirection vers la page d'accueil
            alertClass.value = 'alert-success';
            setTimeout(() => {
                router.push('/')
            }, 1000);
            email.value = '';
            form.password = '';
        } else {
            // Si l'authentification échoue, affichage d'une alerte
            alertClass.value = 'alert-danger';
            form.password = '';
        }
        respStatus.value = true;
    }catch(error) {
        // En cas d'erreur de validation, affichage des messages d'erreur
        error.inner.forEach((e) => errors[e.path] = e.message);
        form.password = '';
    }
}

// Fonction exécutée après le montage du composant
onMounted(() => {
    // Si l'utilisateur est déjà connecté, redirection vers la page d'accueil
    if(authStore.isLogging){
        router.push('/');
    }
});

// Fonctions de mise à jour des données du formulaire
const updateEmail = (value) => {
    form.email = value;
}

const updateCheck = (value) => {
    form.checkbox = value;
}
</script>

<template>
    <div class="d-flex flex-column align-items-center">
        <div v-show="respStatus" class="alert alert-dismissible" :class="alertClass">
            {{ resp.message }}
            <span class="btn btn-close" @click="respStatus = !respStatus"></span>
        </div>
        <form @submit.prevent="beforeSubmit" class="w-25">
            <div>
                <FieldForm id-input="email" type-input="email" :input-value="form.email" :input-class="formClass.email" @update-value="updateEmail">
                    <template #label>
                        Votre adresse email
                    </template>
                </FieldForm>
                <!-- <label class="form-label" for="email">Votre mail</label>
                <input class="form-control focus-ring" :class="formClass.email" type="email" name="email" id="email" v-model="form.email"> -->
                <p class="form-text text-danger" v-if="errors.email">{{ errors.email }}</p>
            </div>
            <div>
                <label class="form-label" for="password">Votre mot de passe</label>
                <input class="form-control focus-ring" :class="formClass.password" type="password" name="password" id="password" v-model="form.password">
                <p class="form-text text-danger" v-if="errors.password">{{ errors.password }}</p>

            </div>
            <div class="d-flex flex-row-reverse justify-content-end mt-2">
                <FieldForm id-input="checkbox" type-input="checkbox" :input-value="form.checkbox" :input-class="formClass.checkbox" @update-value="updateCheck">
                    <template #label>
                        Restez connecté
                    </template>
                </FieldForm>
            </div>
            <div class="mt-3">
                <p>Si vous n'avez pas de compte <router-link to="/register">inscrivez-vous</router-link></p>
            </div>
            <button class="btn btn-outline-primary mt-3">Connexion</button>
        </form>
    </div>
</template>