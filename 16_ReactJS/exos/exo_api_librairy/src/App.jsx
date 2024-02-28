import {useEffect, useState} from 'react';
import axios from "axios";
import {Link} from "react-router-dom";
import {Loader} from "./components/Loader.jsx";

function App() {
  const [books, setBooks] = useState([]);
  const [load, setLoad] = useState(false);
  const [failLoad, setFailLoad] = useState(false);

    useEffect(() => {
        (async () =>{
           try {
               const resp = await axios.get('https://openlibrary.org/subjects/fantasy.json?limit=100');
               const bookList = await resp.data.works;
               setBooks(bookList);
               setLoad(true);
           }
           catch (e) {
               setLoad(true);
               setFailLoad(true);
           }
        })()
    });
  return (
    <div className={'container text-white'}>
        {
            load && failLoad &&
            <div className="alert alert-danger" role="alert">
                Erreur lors du chargement des livres
            </div>
        }
        {
            !load && !failLoad &&
                <Loader />
        }
        {
            books.length > 0 &&
            <>
                <h1 className={'m-5 text-center'}>Liste des livres :</h1>
                <div className={'d-flex justify-content-center flex-wrap'}>
                    {
                        books.map((book) => (
                            <div className={'m-3'} key={book.cover_edition_key}>
                                <h6 className={'text-center'}>{book.title.length > 40 ? book.title.slice(0, 40) + '...' : book.title} </h6>
                                <Link to={`/${book.key.slice(7, book.key.length)}`}>
                                    <img height={'500'} width={'300'}  src={`https://covers.openlibrary.org/b/id/${book.cover_id}-L.jpg`} alt={book.title}/>
                                </Link>
                            </div>
                        ))
                    }
                </div>
            </>
        }
    </div>
  )
}

export default App
