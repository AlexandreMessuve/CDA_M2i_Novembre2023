import * as rickApi from '@/api/rickApi';
import { ref, computed, reactive} from 'vue';
import { defineStore } from 'pinia';

export const useEpisodeStore = defineStore('episode', () => {
    const episode = reactive({
        results: [],
        currentPage: 1,
        firstPage: 1,
        maxPage: 0,
        count: 0,
    });

    const fetchData = async() => {
        try{
           const response =  await rickApi.episodes.get(`?page=${episode.currentPage}`);
           const data = await response.data;
           episode.results = data.results;
           episode.maxPage = data.info.pages;
           episode.count = data.info.count;
           episode.results.forEach(async (ep) => {
            const promisesCharacter = ep.characters.map((ep) => rickApi.getChar(ep))
            ep.characters = await Promise.all(promisesCharacter);
           });
        }catch (e){
            episode.results = [];
        }
    }

    const changePage = async(page) =>{
        episode.currentPage = page;
        await fetchData();
    }
    return  {episode, fetchData, changePage}
})
