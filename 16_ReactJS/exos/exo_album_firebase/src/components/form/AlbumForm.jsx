import { useRef} from "react";
import { useDispatch, useSelector } from "react-redux";
import {useNavigate} from "react-router-dom";
import {addAlbum, editAlbum, setError, setSelectedAlbum} from "../../store/albumSlice.js";

const AlbumForm = () => {
    const formMode = useSelector(state => state.album.formMode);
    const error = useSelector(state => state.album.error);
    const album = useSelector(state => state.album.selectedAlbum);
    const nameRef = useRef();
    const coverRef = useRef();
    const artistRef = useRef();
    const releaseDateRef = useRef();
    const scoreRef = useRef();
    const user = useSelector(state => state.auth.user);
    const dispatch = useDispatch()
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault()
        const album = {
            id: formMode === 'Ajouter un album' ? Date.now() : album?.id,
            name: nameRef.current.value,
            artist: artistRef.current.value,
            coverUrl: coverRef.current.value,
            releaseDate: releaseDateRef.current.value,
            score: scoreRef.current.value,
        }

        if(user.idToken){
            if(formMode === 'Ajouter un album'){
                const payload = {
                    idToken: user.idToken,
                    newAlbum: album
                }
                dispatch(addAlbum(payload))
            }else{
                const payload = {
                    idToken: user.idToken,
                    editAlbum: album,
                    index: album.index,
                }
                dispatch(editAlbum(payload))
                dispatch(setSelectedAlbum(null))
            }
            if(!error){
                navigate('/');
            }
            e.target.reset();
        }

    }

    return (
        <>
            {
                error && (
                    <div className="alert alert-danger alert-dismissible" role="alert">
                        <strong>Erreur :</strong> Une erreur est survenue lors de l'envoie des données.
                        <button type="button" className="btn-close" onClick={() => dispatch(setError(null))} aria-label="Close"></button>
                    </div>
                )
            }
            <h1 className={'m-5'}>{formMode}</h1>
            <form className={'w-50 m-auto'} onSubmit={handleSubmit}>
                <div className={'m-2'}>
                    <input className={'form-control'} type={'text'} defaultValue={album?.name} placeholder={'nom album'}
                           ref={nameRef} required={true}/>
                </div>
                <div className={'m-2'}>
                    <input className={'form-control'} type={'text'} defaultValue={album?.artist} placeholder={'artist'}
                           ref={artistRef} required={true}/>
                </div>
                <div className={'m-2'}>
                    <input className={'form-control'} type={'date'} defaultValue={album?.releaseDate}
                           ref={releaseDateRef} required={true}/>
                </div>
                <div className={'m-2'}>
                    <input className={'form-control'} type={'number'} defaultValue={album?.score}
                           placeholder={'score 0 à 5'} min={0} max={5} ref={scoreRef} required={true}/>
                </div>
                <div className={'m-2'}>
                    <input className={'form-control'} type={'text'} defaultValue={album?.coverUrl}
                           placeholder={'Couverture de l\'album (URL)'} ref={coverRef} required={true}/>
                </div>
                <div className={'m-5'}>
                    <button
                        className={'btn btn-outline-primary'}>{formMode === 'Ajouter un album' ? 'Ajouter' : 'Modifier'}</button>
                </div>
            </form>
        </>
    );
}

export default AlbumForm;