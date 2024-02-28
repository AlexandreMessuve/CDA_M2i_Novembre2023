import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {Loader} from "./Loader.jsx";

export const BookPage = () => {
    const {bookId} = useParams();
    const [book, setBook] = useState(null);
    const [author, setAuthor] = useState('');
    const [load, setLoad] = useState(false);
    const [failLoad, setFailLoad] = useState(false);
    useEffect(() => {
        (async() => {
            try {
                const resp = await axios.get(`http://openlibrary.org/works/${bookId}.json`);
                await getAuthor(resp.data.authors);
                console.log(resp.data);
                setBook(resp.data);
                setLoad(true);
            }catch (e) {
                setLoad(true);
                setFailLoad(true);
            }
        })()
    }, []);
    const getAuthor = async (authors) => {
        try {
            const authorLink = authors[0].author.key;
            const resp = await axios.get(`http://openlibrary.org${authorLink}.json`);
            setAuthor(resp.data.name);
        }catch (e) {
            setAuthor('Non défini');
        }
    }
    return (
        <div className={'text-white'}>
            {
                load && !failLoad && book &&
                <div className={'container my-5'}>
                    <h1 className={'text-center m-3'}>Detail du livre</h1>
                    <hr />
                    <div className={'d-flex justify-content-center m-3'}>
                        <img className={'m-3'} src={`https://covers.openlibrary.org/b/id/${book.covers[0]}-L.jpg`}
                             alt={book.title + ' image'}
                        />
                        <div>
                            <h1 className={'m-3'}>Titre: {book.title}</h1>
                            <h2 className={'m-3'}>Auteur: <span className={'fs-5'}>{author}</span></h2>
                            <h2 className={'m-3'}>Année: <span className={'fs-5'}>{book.first_publish_date}</span></h2>
                            <h2 className={'m-3'}>Description :</h2>
                            <p className={'m-3'}>{book.description.value ? book.description.value : book.description}</p>
                        </div>
                    </div>
                    <hr />
                    <div className={'d-flex justify-content-center my-3'}>
                        <Link className={'nav-link link-light'} to={'/'}>Retour</Link>
                    </div>
                </div>
            }
            {
                !load && !failLoad &&
                <Loader />
            }
        </div>
    )
}