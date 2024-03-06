import {useDispatch, useSelector} from "react-redux";
import {AlbumItem} from "../album/AlbumItem.jsx";
import {useEffect, useState} from "react";
import {fetchAlbum} from "../../store/albumSlice.js";
import {FilterAlbum} from "../album/FilterAlbum.jsx";

export const HomePage = () => {
    const [isSort, setIsSort] = useState(false)
    const albums = useSelector(state => state.album.albums);
    const isLoading = useSelector(state => state.album.isLoading);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(fetchAlbum())
    }, []);
    return (
        <>
            {
                !isLoading ? (
                    <>
                        <div className={'text-center'}>
                            <div className={'d-flex justify-content-between align-items-center'}>
                                <h1 className={'my-5 text-start'}>Album</h1>
                                {
                                    isSort && (
                                        <FilterAlbum />
                                    )
                                }
                                <button onClick={() => setIsSort(!isSort)} className={'btn btn-outline-primary'}>{isSort ? 'Fermer': 'Trier'}</button>
                            </div>


                            {
                                albums?.length <=0 && (
                                    <h3 className={'m-3'}>Aucun album</h3>
                                )
                             }
                            <div className={'d-flex flex-wrap text-center m-auto'}>
                            {
                                albums?.map((album) => (
                                    <AlbumItem album={album} key={album.id} />
                                ))
                            }

                            </div>
                        </div>
                    </>
                ) : (
                    <div className={'position-absolute top-50 start-50 translate-middle'}>
                        <div className="spinner-border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </div>
                    </div>
                )
            }
        </>

    )
}