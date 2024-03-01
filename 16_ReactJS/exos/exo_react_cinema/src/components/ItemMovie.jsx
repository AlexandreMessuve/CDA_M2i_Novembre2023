import {Link} from "react-router-dom";
import {useContext} from "react";
import {MovieContext} from "../context/MovieContext.jsx";

export const ItemMovie = (props) => {
    const {deleteMovie} = useContext(MovieContext);
    const movie = props.movie
    return (
        <div className={'card m-3 w-25'}>
            <div className={'card-header'}>
                <h5 className={'card-title'}>{movie.title}</h5>
            </div>
            <div className={'card-body'}>
                <p className={'card-text'}>{movie.description}</p>
            </div>
            <div className={'card-footer'}>
                <Link className={'btn btn-outline-info'} to={`/edit/${movie._id}?mode=edit`}>Modifier</Link>
                <button onClick={async() => {if(!await deleteMovie(movie._id))console.log('error')}} className={'btn btn-outline-danger'}>Supprimer</button>
            </div>
        </div>
    )
}