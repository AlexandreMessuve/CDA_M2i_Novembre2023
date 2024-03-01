import {createContext, useState} from "react";
import axios from "axios";
export const MovieContext = createContext('movie');

export const MovieProvider = (props) => {
    const [movies, setMovies] = useState([]);
    const URLBack = 'http://localhost:3000/api/movies';

    const fetchMovies = async () => {
        try{
            const resp = await axios.get(URLBack);
            setMovies(resp.data);
            return true;
        }catch (e){
            console.log(e);
            return false;
        }
    }
    const addMovie = async(movie) => {
        try {
            await axios.post(URLBack, movie);
            setMovies([...movies, movie]);
            return true;
        } catch (e) {
            console.log(e);
            return false;
        }
    }

    const updateMovie = async(movieId, updatedMovie) => {

        try {
            await axios.put(URLBack+`/${movieId}`, updatedMovie)
            const updatedMovies = movies.map((movie) => {
                if(movie.id === movieId){
                    return updatedMovie;
                }
                return movie;
            });
            setMovies(updatedMovies);
            return true;
        }catch (e){
            console.log(e);
            return false;
        }
    }

    const deleteMovie = async(movieId) => {
        try {
            await axios.delete(URLBack+`/${movieId}`)
            const updatedMovies = movies.filter((movie) => movie.id !== movieId);
            setMovies(updatedMovies);
            return true;
        } catch (e) {
            console.log(e);
            return false
        }
    }
    return(
        <MovieContext.Provider value={
            {
                movies: movies,
                fetchMovies: fetchMovies,
                addMovie: addMovie,
                updateMovie: updateMovie,
                deleteMovie: deleteMovie
            }
        }>
            {props.children}
        </MovieContext.Provider>
    );
}