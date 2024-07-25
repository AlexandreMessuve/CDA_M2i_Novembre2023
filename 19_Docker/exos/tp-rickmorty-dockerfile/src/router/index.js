import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import ConnectionView from '../views/ConnectionView.vue';
import RegisterView from '../views/RegisterView.vue';
import RickMortyCharacterView from '../views/RickMortyCharacterView.vue';
import RickMortyEpisodeView from '../views/RickMortyEpisodeView.vue';
import RickMortyLocationView from '../views/RickMortyLocationView.vue';
import RickMortyFavoriteView from '../views/RickMortyFavoriteView.vue';
import { useAuthStore } from '@/stores/authentication';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView

    },
    {
      path: '/:pathMatch(.*)', 
      redirect  : '/' 
    },
    {
      path:'/connection',
      component: ConnectionView,
    },
    {
      path:'/register',
      component: RegisterView,
    },
    {
      path: '/rick-morty/character',
      component: RickMortyCharacterView
    },
    {
      path: '/rick-morty/episode',
      component: RickMortyEpisodeView
    },
    {
      path: '/rick-morty/location',
      component: RickMortyLocationView
    },
    {
      path: '/rick-morty/favorites',
      component: RickMortyFavoriteView
    }

  ]
})

router.beforeEach((to, from) => {
  if(to.path.startsWith('/rick-morty')){
    
    if(!useAuthStore().isLogging){
      return '/connection'
    }else{
      return true;
    }
  }else{
    return true;
  }
})
export default router
