<script setup>
import { useAuthStore } from '@/stores/authentication';
const authStore = useAuthStore();
</script>

<template>
  <main>
    <div id="home-img" class="d-flex align-items-center justify-content-center">
      <h1>Accueil rick et morty</h1>

      <div id="home-container" >
        
      </div>
    </div>
    <div class="container mt-5">
      <h2>Vous retrouverez sur cette application</h2>
      <p>Bienvenue sur notre projet dédié à l'univers déjanté de Rick et Morty. Explorez les différentes dimensions,
        découvrez les personnages loufoques, et plongez-vous dans l'aventure interdimensionnelle.</p>
      <p>Rejoignez Rick Sanchez et Morty Smith dans leurs folles escapades à travers l'univers. Que vous soyez un fan de
        science-fiction, d'humour absurde, ou simplement curieux, vous êtes au bon endroit!</p>
      <p v-if="!authStore.isLogging">Commencez votre voyage maintenant en vous connectant <router-link to="/connection">ici</router-link> ou si vous
        n'avez pas de compte: <router-link to="/register">ici</router-link></p>

        <h2 class="text-end pt-5">Qu'est ce que Rick et Morty ?</h2>
        <p class="text-end">Rick et Morty est une série animée américaine créée par Justin Roiland et Dan Harmon. La série suit les aventures de Rick Sanchez, un scientifique excentrique et alcoolique, et de son petit-fils Morty Smith, un adolescent timide. Ensemble, ils voyagent à travers l'univers et traversent des dimensions parallèles, vivant des aventures aussi absurdes que dangereuses.</p>
        <p>La série est connue pour son humour noir, son intelligence satirique, et sa capacité à mélanger des éléments de science-fiction avec des commentaires sociaux et philosophiques. Elle aborde des thèmes tels que l'existence, la moralité, la réalité, et remet en question les conventions narratives traditionnelles. "Rick et Morty" est également saluée pour son écriture complexe, son inventivité visuelle, et sa capacité à susciter la réflexion tout en divertissant le public.</p>
    </div>
  </main>
</template>

<style scoped>
#home-container {
  height: 400px;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.3);
  position: absolute;
}

#home-img {
  background-image: url(../assets/img/background-home.jpg);
  background-repeat: space;
  background-size: contain;
  height: 400px;
  width: 100%;
  background-color: #1D194C;
}

@media screen and (max-width: 1500px) {
  #home-container, #home-img{
    height: 300px;
  }
}
@media screen and (max-width: 1100px) {
  #home-container, #home-img{
    height: 200px;
  }
}
@media screen and (max-width: 412px) {
  #home-container, #home-img{
    height: 80px;
  }
  h1{
    font-size: 0.9em;
  }
}
</style>
