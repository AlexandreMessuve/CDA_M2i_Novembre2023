import {useContext} from "react";
import {ContactContext} from "../context/ContactContext.jsx";
import {Link} from "react-router-dom";

export const HomePage = () => {
    const {contacts} = useContext(ContactContext);
    return (
        <>
            <h1 className={'text-center my-5'}>Accueil</h1>
            {
                contacts?.length > 0 ?
                    <table className={'table table-striped'} align={'center'}>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>PRENOM</th>
                                <th>NOM</th>
                                <th>EMAIL</th>
                                <th>NUMERO DE TEL</th>
                                <th>ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                        {contacts.map((contact, index) => (
                            <tr key={index}>
                                <td>{contact.id.slice(0,10)} ...</td>
                                <td>{contact.firstname}</td>
                                <td>{contact.lastname}</td>
                                <td>{contact.email}</td>
                                <td>{contact.phone}</td>
                                <td>
                                    <Link className={'btn btn-outline-info'} to={`/contacts/${contact.id}?mode=edit`}>Editer</Link>
                                    <Link className={'btn btn-outline-danger'} to={`/contacts/${contact.id}?mode=del`}>Supprimer</Link>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                    : <h4 className={'text-center my-5'}>Aucun contact</h4>
            }
        </>
    )
}