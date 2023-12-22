import axios from "axios";

export const characters = axios.create({
    baseURL: 'https://rickandmortyapi.com/api/character/'
});

export const episodes = axios.create({
    baseURL: 'https://rickandmortyapi.com/api/episode/'
});

export const locations = axios.create({
    baseURL: 'https://rickandmortyapi.com/api/location/'
});

export const getChar = async(url) => {
    const character = axios.create(
        {
            baseURL: url,
        }
    )
    try{
        const response = await character.get(url);
        return await response.data;
    }catch(e){
        console.error(e)
    }
}
