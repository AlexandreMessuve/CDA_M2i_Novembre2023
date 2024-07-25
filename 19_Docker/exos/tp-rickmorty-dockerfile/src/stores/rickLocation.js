// Importation des modules nécessaires
import { reactive } from 'vue'; // Pour rendre l'état réactif
import * as rickApi from '@/api/rickApi'; // API pour récupérer les données
import { defineStore } from 'pinia'; // Pour définir un magasin d'état

// Définition du magasin d'état
export const useLocationStore = defineStore('location', () => {
    
    // Définition de l'état initial
    const location = reactive({
        results: [], // Résultats de l'API
        currentPage: 1, // Page actuelle
        firstPage: 1, // Première page
        maxPage: 0, // Page maximale
        count: 0, // Nombre total de résultats
    });

    // Méthode pour récupérer les données de l'API
    const fetchData = async() => {
        try{
           // Faire une requête à l'API avec le numéro de page actuel
           const response =  await rickApi.locations.get(`?page=${location.currentPage}`);
           const data = await response.data;
           
           // Stocker les données de réponse dans l'état
           location.results = data.results;
           location.maxPage = data.info.pages;
           location.count = data.info.count;
           
           // Pour chaque résultat, récupérer les résidents
           location.results.forEach(async (loc) => {
            const promisesResidents = loc.residents.map((loc) => rickApi.getChar(loc))
            loc.residents = await Promise.all(promisesResidents);
           });

        }catch (e){
            // En cas d'erreur, réinitialiser les résultats
            location.results = [];
        }
    }

    // Méthode pour changer la page actuelle et récupérer les nouvelles données
    const changePage = async(page) =>{
        location.currentPage = page;
        await fetchData();
    }
    
    // Retourner l'état et les méthodes pour interagir avec lui
    return  {location, fetchData, changePage}
})