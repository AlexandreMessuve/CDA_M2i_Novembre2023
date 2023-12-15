import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', () => {
  const users = ref([]);

  const user = ref(null);

  const isLogging = computed(() => {
    return !!user.value;
  })

  const auth = (email, password) => {
    if(users.value > 0){
      users.value.forEach((user) => {
        if(email === user.email && password === user.password){
          user.value = {
            username: user.username,
            email: user.email
          }
          return true;
        }
      });
      return 'email ou mot de passe incorrect';
    }else{
      return 'vous n\'exister pas dans notre base de données';
    }
  }
})
