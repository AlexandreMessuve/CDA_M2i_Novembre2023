import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import {useContext, useEffect, useRef, useState} from "react";
import {MovieContext} from "../context/MovieContext.jsx";

export const FormMovies = () => {
    const {movies, addMovie, updateMovie} = useContext(MovieContext);
    const { movieId } = useParams();
    const navigate = useNavigate();
    const [movie, setMovie] = useState(null);
    const [searchParams] = useSearchParams();
    const mode = searchParams.get('mode') ?? "default";

    const title = useRef('');
    const description = useRef('');
    const director = useRef('');
    const releaseDate = useRef('');

    useEffect(() => {
        const movieFind = movies.find((movie) => movie._id === movieId);
        setMovie(movieFind)
    }, []);

    const handleSubmit = async (e) =>{
            e.preventDefault();
            const movie = {
                title: title.current.value,
                description: description.current.value,
                director: director.current.value,
                releaseDate: new Date(releaseDate.current.value)
            }
            if(mode === 'default'){
                if(await addMovie(movie)){
                    navigate('/')
                }else{
                    console.log('error');
                }
            }else{
                if(await updateMovie(movie)){
                    navigate('/');
                }else{
                    console.log('error');
                }
            }
    }
    return (
        <>
            <h1 className={'text-center'}>{mode === 'default' ? 'Ajout' : 'Modification'} de film</h1>
            <form onSubmit={handleSubmit} className={'w-50 m-auto text-center'}>
                <div className={'m-5'}>
                    <label htmlFor={'title'} className={'form-label'}>Titre</label>
                    <input className={'form-control'} ref={title} id={'title'} type={'text'}
                           defaultValue={movie?.title}/>
                </div>
                <div className={'m-5'}>
                    <label htmlFor={'description'} className={'form-label'}>Description</label>
                    <textarea className={'form-control'} ref={description} defaultValue={movie?.description} id={'description'} rows={8}>

                    </textarea>
                </div>
                <div className={'m-5'}>
                    <label htmlFor={'director'} className={'form-label'}>Realisateur</label>
                    <input className={'form-control'} ref={director} id={'director'} type={'text'} defaultValue={movie?.director} />
                </div>
                <div className={'m-5'}>
                    <label htmlFor={'date'} className={'form-label'}>Realisateur</label>
                    <input className={'form-control'} ref={releaseDate} id={'date'} type={'date'} defaultValue={movie?.releaseDate} />
                </div>
                <div className={'m-5'}>
                    <button className={'btn btn-outline-primary'}>{mode === 'default' ? 'Ajouter' : 'Modifier'}</button>
                </div>
            </form>
        </>
    )
}