import {useDispatch} from "react-redux";
import {fetchAlbum, sortByName, sortByScore} from "../../store/albumSlice.js";
import {useState} from "react";

export const FilterAlbum = () => {
    const [sortName, setSortName] = useState(true)
    const [sortScore, setSortScore] = useState(true)
    const dispatch = useDispatch();
    const handleSortName = () => {
        dispatch(sortByName(sortName));
        setSortName(!sortName);
    }
    const handleSortScore = () => {
        dispatch(sortByScore(sortScore));
        setSortScore(!sortScore);
    }
    const handleReset = () => {
        dispatch(fetchAlbum());
        setSortScore(true);
        setSortName(true);
    }
    return (
        <div className={'d-flex justify-content-end h-25 align-items-center'}>
            <button onClick={() => handleSortName()} className={'btn btn-outline-primary mx-2'}>Trier par nom</button>
            <button onClick={() => handleSortScore()} className={'btn btn-outline-primary mx-2'}>Trier par score</button>
            <button onClick={() => handleReset()} className={'btn btn-warning mx-2'}>reset</button>
        </div>
    )
}