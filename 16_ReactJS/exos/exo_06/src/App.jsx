import './App.css'
import {useState} from "react";
import {FormComponent} from "./components/FormComponent.jsx";
import {TableComponent} from "./components/TableComponent.jsx";

function App() {
  const [contacts, setContacts] = useState([])

  const addContact = (contact) => {
    setContacts(prevContacts => [...prevContacts, contact]);
  }
  return (
    <>
      <h1>Ajout de contact</h1>
      <FormComponent addContact={addContact} />
      <h1>Liste des contacts :</h1>
      {contacts.length > 0 ? <TableComponent contacts={contacts} /> : <p>Aucun contact</p>}
    </>
  )
}

export default App
