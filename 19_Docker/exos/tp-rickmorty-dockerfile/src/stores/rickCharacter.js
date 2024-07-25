import { reactive} from 'vue';
import * as rickApi from '@/api/rickApi';
import { defineStore } from 'pinia';

export const useRickStore = defineStore('rick', () => {
    const rick = reactive({
        results: [],
        currentPage: 1,
        firstPage: 1,
        maxPage: 0,
        count: 0,
    });

    const fetchData = async(search = null) => {
        try{
           const response =  await rickApi.characters.get(`?page=${rick.currentPage}&name=${!!search?.name ? search.name : ''}&species=${!!search?.species ? search.species : ''}&gender=${!!search?.gender ? search.gender : ''}&status=${!!search?.status ? search.status : ''}&type=${!!search?.type ? search.type : ''}`);
           const data = await response.data;
           rick.results = data.results;
           rick.maxPage = data.info.pages;
           rick.count = data.info.count;

        }catch (e){
            rick.results = [];
        }
    }

    const changePage = async(page, search) =>{
        rick.currentPage = page;
        await fetchData(search);
    }

    // Retourner l'état et les méthodes pour interagir avec lui
    return  {rick, fetchData, changePage}


})
