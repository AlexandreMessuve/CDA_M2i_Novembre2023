import {createContext, useEffect, useState} from "react";

export const ContactContext = createContext('contact');
export function ContactProvider(props) {
    const [contacts, setContacts] = useState([]);

    const addContact = (contact) => {
        setContacts([...contacts, contact]);
    }

    const editContact = (contactId, updateContact) =>{
            const updatedContacts = contacts.map((contact) => {
                if(contact.id === contactId){
                    return updateContact
                }
                return contact
            });
            setContacts(updatedContacts);
    }
    const deleteContact = (contactId) => {
        const updatedContacts = contacts.filter((contact) => contact.id !== contactId);
        setContacts(updatedContacts);
    }

    useEffect(() => {
        console.log(contacts);
    }, [contacts]);
    return (
        <>
            <ContactContext.Provider value={{
                contacts: contacts,
                addContact:addContact,
                editContact:editContact,
                deleteContact:deleteContact
            }}>
                {props.children}
            </ContactContext.Provider>
        </>
    )
}