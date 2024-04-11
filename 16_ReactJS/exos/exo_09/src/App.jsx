import {useEffect, useState} from 'react'
import './App.css'
import {BookContext} from "./context/BookContext.jsx";
import {FormBook} from "./components/FormBook.jsx";

function App() {
    const [booksList, setBooksList] = useState([])
    useEffect(() => {
        console.log(booksList)
    }, []);
  return (
    <>
        <BookContext.Provider value={{booksList, setBooksList}}>
            <FormBook />
        </BookContext.Provider>
    </>
  )
}

export default App
