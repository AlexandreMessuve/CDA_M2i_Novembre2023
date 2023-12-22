import { ref } from 'vue';
import { v4 as uuid} from 'uuid';
import { defineStore } from 'pinia';

export const useFavoriteStore = defineStore('favorite', () => {
    const favorite = ref(!!JSON.parse(localStorage.getItem('favorite')) ? JSON.parse(localStorage.getItem('favorite')) : []);

    const addFavorite = (type, data) => {
        let flag = false;
        favorite.value.forEach(element => {
            if(element.type === type && element.data === data){
                flag = true;
            }
        });
        console.log(flag);
        if(flag){
            return false;
        }else{
            const date = new Date()
            const newFavorite = {
                id: uuid(),
                type: type,
                data: data,
                addDate: new Date(date),
            }
            favorite.value.push(newFavorite);
            localStorage.setItem('favorite', JSON.stringify(favorite.value));
        }
    }

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
