import {useContext, useEffect, useRef, useState} from "react";
import {BookContext} from "../context/BookContext.jsx";

export const FormBook = () => {
    const title = useRef();
    const author = useRef();
    const publicationDate = useRef();
    const [isValid, setIsValid] = useState(true);
    const value = useContext(BookContext);
    const onSubmit = (e) => {
        e.preventDefault();
        const newBook =
            {
                'id': Date.now(),
                'title': title.current.value,
                'author': author.current.value,
                'publicationDate': new Date(publicationDate.current.value)
            };
        value.setBooksList(prevBookList => [...prevBookList, newBook]);
    }
    useEffect(() => {
        if(title.current.value.length > 0 && author.current.value.length > 0 ){
            setIsValid(false)
        }else{
            setIsValid(true)
        }
    }, [title, author]);
    return (
        <>
            <form onSubmit={onSubmit}>
                <div>
                    <label>Titre</label>
                    <input type={'text'} ref={title}/>
                </div>
                <div>
                    <label>Auteur</label>
                    <input type={'text'} ref={author}/>
                </div>
                <div>
                    <label>Date de publication</label>
                    <input type={'date'} ref={publicationDate}/>
                </div>
                <div>
                    <button type={'submit'}>Ajouter</button>
                </div>
            </form>
        </>
    )
}