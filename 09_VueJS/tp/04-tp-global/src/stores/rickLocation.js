import { reactive} from 'vue';
import * as rickApi from '@/api/rickApi';
import { defineStore } from 'pinia';

export const useLocationStore = defineStore('location', () => {
    const location = reactive({
        results: [],
        currentPage: 1,
        firstPage: 1,
        maxPage: 0,
        count: 0,
    });

    const fetchData = async() => {
        try{
           const response =  await rickApi.locations.get(`?page=${location.currentPage}`);
           const data = await response.data;
           location.results = data.results;
           location.maxPage = data.info.pages;
           location.count = data.info.count;
           location.results.forEach(async (loc) => {
            const promisesResidents = loc.residents.map((loc) => rickApi.getChar(loc))
            loc.residents = await Promise.all(promisesResidents);
           });

        }catch (e){
            location.results = [];
        }
    }

    const changePage = async(page) =>{
        location.currentPage = page;
        await fetchData();
    }
    return  {location, fetchData, changePage}


})
