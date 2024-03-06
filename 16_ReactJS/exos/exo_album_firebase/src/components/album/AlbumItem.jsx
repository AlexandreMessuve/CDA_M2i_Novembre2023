import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {deleteAlbum, setFormMode, setSelectedAlbum} from "../../store/albumSlice.js";
import {Rating} from "react-simple-star-rating";
import {useState} from "react";
import {Button, Modal} from "react-bootstrap";

export const AlbumItem = (props) => {
    const album = props.album;
    const [showModal, setShowModal] = useState(false);
    const user = useSelector(state => state.auth.user);
    const dispatch = useDispatch();
    const handleDelete = () => {
        const payload = {
            index: album.index,
            idToken: user.idToken
        }
        dispatch(deleteAlbum(payload));
        setShowModal(false);
    }
    const handleClose = () => setShowModal(false);
    return (
        <>
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton={true}>
                    <Modal.Title>Suppression</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    Voulez vous vraiment supprimer l'album {album.name} ?
                </Modal.Body>
                <Modal.Footer>
                    <button onClick={handleClose} className={'btn btn-outline-secondary'}>Non</button>
                    <button onClick={() => handleDelete()} className={'btn btn-outline-danger'}>Oui</button>
                </Modal.Footer>
            </Modal>
            <div className={'card my-3 mx-3'}>
                <h5 className={'card-title'}>{album.name}</h5>
                <img src={album.coverUrl} height={250} width={100} className="card-img-top" alt={album.name}/>
                <div className={'card-body text-start'}>
                    <div className={'d-flex justify-content-between m-3'}>
                        <span className={'fw-bold'}>Artist:</span>
                        <span>{album.artist}</span>
                    </div>
                    <div className={'d-flex justify-content-between m-3'}>
                        <span className={'fw-bold'}>Release date: </span>
                        <span>{new Date(album.releaseDate).toLocaleDateString()}</span>
                    </div>
                    <div className={'d-flex justify-content-between m-3'}>
                        <span className={'fw-bold'}>Score:</span>
                        <Rating size={25} readonly={true} initialValue={album.score}/>
                    </div>


                </div>
                {
                    user && (
                        <div className={'d-flex justify-content-end w-100 card-footer'}>
                            <Link onClick={() => {
                                dispatch(setFormMode('Modifier un album'));
                                dispatch(setSelectedAlbum(album));
                            }} to={'/album-form'} className={'btn btn-outline-info m-3'}>Modifier</Link>
                            <button onClick={() => setShowModal(true)}
                                    className={'btn btn-outline-danger m-3'}>Supprimer
                            </button>
                        </div>
                    )
                }
            </div>
        </>
    )
}