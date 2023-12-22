<script setup>
// Importation des fonctions nécessaires de Vue.js
import { ref, reactive, watchEffect, onMounted } from 'vue';

// Importation du magasin d'état pour l'authentification
import { useAuthStore } from '../../stores/authentication.js';

// Importation de la fonction useRouter de Vue Router pour la navigation
import { useRouter } from 'vue-router';

// Importation des expressions régulières pour la validation
import * as REGEX from '../../constants/regex.js';

// Importation du schéma de validation pour l'inscription
import registerValidation from '../../yup/registerValidation.js';

// Initialisation du routeur et du magasin d'état pour l'authentification
const router = useRouter();
const authStore = useAuthStore();

// Création d'un objet réactif pour le formulaire d'inscription
const form = reactive({
    email: '',
    username: '',
    password: '',
    confirmPass: ''
});

// Création d'un objet réactif pour les erreurs de validation du formulaire
const errors = reactive({
    email: '',
    username: '',
    password: '',
    confirmPass: ''
})

// Création d'un objet réactif pour la réponse du serveur
let resp = reactive({});

// Création d'une propriété réactive pour le statut de la réponse
const respStatus = ref(false);

// Création d'une propriété réactive pour la classe d'alerte
const alertClass = ref('');

// Création d'un objet réactif pour les classes du formulaire
const classForm = reactive({
    email: '',
    username: '',
    password: '',
    confirmPass: '',
})

// Utilisation de watchEffect pour réagir aux changements de la propriété respStatus
watchEffect(() => {
    // Définition des classes pour les champs du formulaire en fonction du statut de la réponse
    const classDanger = 'border-danger focus-ring-danger';
    const classSuccess = 'border-success focus-ring-success';
    if (form.email !== '') {
        if (REGEX.EMAIL.test(form.email)) {
            classForm.email = classSuccess;
            errors.email = '';
        } else {
            classForm.email = classDanger;
        }
    } else {
        classForm.email = '';
    }

    if (form.username !== '') {
        if (REGEX.USERNAME.test(form.username)) {
            classForm.username = classSuccess;
            errors.username = '';
        } else {
            classForm.username = classDanger;
        }
    } else {
        classForm.username = '';
    }

    if (form.password !== '') {
        if (REGEX.PASSWORD.test(form.password)) {
            classForm.password = classSuccess;
            errors.password = '';
        } else {
            classForm.password = classDanger;
        }
    } else {
        classForm.password = '';
    }

    if (form.confirmPass !== '') {
        if (form.password === form.confirmPass) {
            classForm.confirmPass = classSuccess;
            errors.confirmPass = '';
        } else {
            classForm.confirmPass = classDanger;
        }
    } else {
        classForm.confirmPass = '';
    }


});

/**
 * Fonction exécutée avant la soumission du formulaire d'inscription.
 * Réinitialise les erreurs de validation.
 * Effectue la validation du formulaire.
 * Enregistre l'utilisateur si la validation réussit.
 * Gère les réponses de succès ou d'échec de l'enregistrement.
 * Gère les erreurs de validation.
 */
const beforeSubmit = async () => {
    errors.email = '';
    errors.username = '';
    errors.password = '';
    errors.confirmPass = '';
    try {
        await registerValidation.validate(form, { abortEarly: false });

        resp = authStore.register(form.email, form.username, form.password);
        if (resp.code) {
            alertClass.value = 'alert-success';
            form.email = '';
            form.username = '';
            form.password = '';
            form.confirmPass = '';
            setTimeout(() => {
                router.push('/')
            }, 1000);
        } else {
            alertClass.value = 'alert-danger';
            form.password = '';
            form.confirmPass = '';
        }
        respStatus.value = true;
    } catch (error) {
        error.inner.forEach((e) => errors[e.path] = e.message);
        form.password = '';
        form.confirmPass = '';
    }
}

/**
 * Fonction exécutée lorsque le composant est monté.
 * Redirige l'utilisateur vers la page d'accueil si une session est déjà active.
 */
onMounted(() => {
    if (authStore.isLogging) {
        router.push('/');
    }
});

</script>

<template>
    <div class="d-flex flex-column align-items-center mt-3">
        <div v-show="respStatus" class="alert" :class="alertClass">
            {{ resp.message }}
            <button class="btn btn-close" @click="respStatus = !respStatus"></button>
        </div>
        <form @submit.prevent="beforeSubmit" class="w-50 text-start">
            <div class="row mt-3">
                <div class="col">
                    <label for="email" class="form-label">Votre mail</label>
                    <input class="form-control focus-ring" :class="classForm.email" type="email" name="email" id="email"
                        v-model="form.email" placeholder="exemple@exemple.fr">
                    <p class="form-text text-danger" v-if="errors.email">{{ errors.email }}</p>
                </div>
                <div class="col">
                    <label class="form-label" for="username">Votre username</label>
                    <input minlength="4" class="form-control focus-ring" :class="classForm.username" type="username"
                        name="username" id="username" v-model="form.username" placeholder="mon super username">
                    <p class="form-text text-danger" v-if="errors.username">{{ errors.username }}</p>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col">
                    <label class="form-label" for="password">Votre mot de passe</label>
                    <input class="form-control focus-ring" :class="classForm.password" type="password" name="password"
                        id="password" v-model="form.password">
                    <p class="form-text text-danger" v-if="errors.password">{{ errors.password }}</p>
                </div>
                <div class="col">
                    <label class="form-label" for="password-reapeat">Repeter votre mot de passe</label>
                    <input class="form-control focus-ring" :class="classForm.confirmPass" type="password"
                        name="password-repeat" id="password-repeat" v-model="form.confirmPass">
                    <p class="form-text text-danger" v-if="errors.confirmPass">{{ errors.confirmPass }}</p>
                </div>
                <span class="form-text">Votre mot de passe doit avoir au minimum 8 caractère dont une majuscule, une
                    minuscule et un numérique</span>
            </div>
            <div class="d-flex justify-content-center">
                <button class="btn btn-outline-primary m-3 text-center">S'inscrire</button>
            </div>
        </form>
    </div>
</template>