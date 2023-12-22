<script setup>
import { reactive, watchEffect, ref } from 'vue';
import { RouterLink, RouterView, useRoute } from 'vue-router'
import { useAuthStore } from './stores/authentication';
import router from './router';
const authStore = useAuthStore();
const route = useRoute();

const linkClass = reactive({
  home: '',
  connection: '',
  register: '',
  rickCharacter: '',
  rickEpisode: '',
  rickLocation: '',
  rickFavorites: '',
  footer: '',
});

watchEffect(() => {
  const active = 'active';
  if (route.path === '/') {
    linkClass.home = active;
  } else {
    linkClass.home = '';
  }
  if (route.path === '/connection') {
    linkClass.connection = active;
  } else {
    linkClass.connection = '';
  }
  if (route.path === '/register') {
    linkClass.register = active;
  } else {
    linkClass.register = '';
  }
  if (route.path === '/rick-morty/character') {
    linkClass.rickCharacter = active;
  } else {
    linkClass.rickCharacter = '';
  }
  if (route.path === '/rick-morty/episode') {
    linkClass.rickEpisode = active;
  } else {
    linkClass.rickEpisode = '';
  }
  if (route.path === '/rick-morty/location') {
    linkClass.rickLocation = active;
  } else {
    linkClass.rickLocation = '';
  }
  if (route.path === '/rick-morty/favorites') {
    linkClass.rickFavorites = active;
  } else {
    linkClass.rickFavorites = '';
  }
  if (route.path === '/connection' || route.path === '/register') {
    linkClass.footer = 'fixed-bottom';
  } else {
    linkClass.footer = '';
  }
});
const isShowModal = ref(false);

const showModal = (e) => {
  if (e.target.id === 'modalLogout') {
    isShowModal.value = !isShowModal.value;
  }
};
const logout = () => {
  isShowModal.value = !isShowModal.value;
  authStore.logout();
  router.push('/');
}
</script>

<template>
  <template v-if="authStore.isLogging">
    <div v-show="isShowModal" class="modal fade show" id="modalLogout"
      style="display: block; background-color: rgba(255, 255, 255, 0.6);" @click.event="showModal">
      <div class="modal-dialog z-3" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title text-center" id="modalContent">Voulez vous vraiment vous déconnecter ?</h5>
            <button type="button" class="btn btn-close" @click="isShowModal = !isShowModal" aria-label="Close">
            </button>
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" @click="isShowModal = !isShowModal">Non</button>
            <button @click="logout" type="button" class="btn btn-primary">Oui</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  <header>
    <nav
      class="navbar  navbar-dark navbar-expand-lg navbar-expand-md bg-primary justify-content-lg-between justify-content-md-between">
      <div class="nav-item align-items-center mx-5">
        <RouterLink to="/"><img src="./assets/img/Rick_et_Morty_Logo_FR.png" alt="logo rick et morty" height="60">
        </RouterLink>
      </div>
      <div class="align-items-end mx-5">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar"
          aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse justify-content-lg-end justify-content-md-end justify-content-center mx-5"
        id="navbar">


        <ul class="navbar-nav justify-items-center">
          <li class="nav-item">
            <RouterLink  :class="linkClass.home" to="/">Accueil</RouterLink>
          </li>
          <template v-if="authStore.isLogging">
            <li class="nav-item"><router-link class="nav-link" :class="linkClass.rickCharacter"  to="/rick-morty/character">Personnage</router-link></li>
            <li class="nav-item"><router-link class="nav-link" :class="linkClass.rickEpisode" to="/rick-morty/episode">Episode</router-link></li>
            <li class="nav-item"><router-link class="nav-link" :class="linkClass.rickLocation" to="/rick-morty/location">Location</router-link></li>
            <li class="nav-item"><router-link class="nav-link" :class="linkClass.rickFavorites" to="/rick-morty/favorites">Favoris</router-link></li>
          </template>
          <template v-if="!authStore.isLogging">
            <li class="nav-item" active-class="active">
              <RouterLink class="nav-link" :class="linkClass.connection" to="/connection">Se connecter</RouterLink>
            </li>
            <li class="nav-item" active-class="active">
              <RouterLink class="nav-link" :class="linkClass.register" to="/register">S'inscrire</RouterLink>
            </li>
          </template>
          <template v-else>
            <li class="nav-item">
              <button class="btn btn-outline-dark" @click="isShowModal = !isShowModal">Se
                déconnecter</button>
            </li>
          </template>
        </ul>
      </div>
    </nav>
  </header>
  <main>
    <RouterView />
  </main>
  <footer :class="linkClass.footer">
    <div class="d-flex justify-content-between">
      <img src="./assets/img/logo.png" alt="logo utopios" height="100px" />

      <div class="align-self-center">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-github"
          viewBox="0 0 16 16">
          <path
            d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8" />
        </svg>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-linkedin mx-3"
          viewBox="0 0 16 16">
          <path
            d="M0 1.146C0 .513.526 0 1.175 0h13.65C15.474 0 16 .513 16 1.146v13.708c0 .633-.526 1.146-1.175 1.146H1.175C.526 16 0 15.487 0 14.854V1.146zm4.943 12.248V6.169H2.542v7.225h2.401m-1.2-8.212c.837 0 1.358-.554 1.358-1.248-.015-.709-.52-1.248-1.342-1.248-.822 0-1.359.54-1.359 1.248 0 .694.521 1.248 1.327 1.248h.016zm4.908 8.212V9.359c0-.216.016-.432.08-.586.173-.431.568-.878 1.232-.878.869 0 1.216.662 1.216 1.634v3.865h2.401V9.25c0-2.22-1.184-3.252-2.764-3.252-1.274 0-1.845.7-2.165 1.193v.025h-.016a5.54 5.54 0 0 1 .016-.025V6.169h-2.4c.03.678 0 7.225 0 7.225h2.4" />
        </svg>
      </div>
    </div>
  </footer>
</template>

