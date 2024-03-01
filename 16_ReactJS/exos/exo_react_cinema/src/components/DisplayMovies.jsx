import {useContext, useEffect} from "react";
import {ItemMovie} from "./ItemMovie.jsx";
import {MovieContext} from "../context/MovieContext.jsx";

export const DisplayMovies = () => {
    const {movies, fetchMovies} = useContext(MovieContext);
    useEffect(() => {
        (async()=> {
            await fetchMovies();
        })()
    }, [movies]);
    return (
        <div className={'container'}>
            <h1 className={'text-center'}>Application de gestion de films</h1>
            <div className={'d-flex flex-wrap justify-content-center'}>
                {
                    movies.map((movie) => (
                        <ItemMovie key={movie._id} movie={movie} />
                    ))
                }
                {
                    movies.length <= 0 && (
                        <h3 className={'text-center'}>Aucun film</h3>
                    )
                }
            </div>
        </div>
    )
}