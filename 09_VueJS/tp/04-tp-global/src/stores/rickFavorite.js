// Importation des modules nécessaires
import { ref } from 'vue'; // Pour rendre l'état réactif
import { v4 as uuid} from 'uuid'; // Pour générer des identifiants uniques
import { defineStore } from 'pinia'; // Pour définir un magasin d'état

// Définition du magasin d'état
export const useFavoriteStore = defineStore('favorite', () => {
    // Initialisation de l'état avec les favoris stockés dans le localStorage
    // Si aucun favori n'est trouvé, une liste vide est utilisée
    const favorite = ref(!!JSON.parse(localStorage.getItem('favorite')) ? JSON.parse(localStorage.getItem('favorite')) : []);

    // Méthode pour ajouter un favori
    const addFavorite = (type, data) => {
        let flag = false;
        // Vérification si le favori existe déjà
        favorite.value.forEach(element => {
            if(element.type === type && element.data === data){
                flag = true;
            }
        });
        console.log(flag);
        // Si le favori existe déjà, ne rien faire et retourner false
        if(flag){
            return false;
        }else{
            // Sinon, créer un nouvel objet favori avec un identifiant unique, le type, les données et la date d'ajout
            const date = new Date()
            const newFavorite = {
                id: uuid(),
                type: type,
                data: data,
                addDate: new Date(date),
            }
            // Ajouter le nouvel objet à la liste des favoris et mettre à jour le localStorage
            favorite.value.push(newFavorite);
            localStorage.setItem('favorite', JSON.stringify(favorite.value));
        }
    }

    // Méthode pour obtenir un favori en fonction de son type et de ses données
    // Cette méthode n'est pas encore implémentée
    const getFavorite = (type , data)=>{
        let foundData = null;
        favorite.value.forEach((value) => {
            if(value.type === type && value.data === data){
                foundData = value;
            }
        });
        return foundData;
    }
    const deleteFavorite = (id) =>{
        favorite.value = favorite.value.filter((value) => value.id !== id);
        localStorage.setItem('favorite', JSON.stringify(favorite.value));
    }
    return  {favorite,getFavorite, addFavorite, deleteFavorite}


})
