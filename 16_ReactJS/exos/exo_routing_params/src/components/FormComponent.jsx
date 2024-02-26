import {Link, useNavigate, useParams, useSearchParams} from "react-router-dom";
import {useContext, useRef} from "react";
import {ContactContext} from "../context/ContactContext.jsx";
import {v4 as uuidv4} from 'uuid';

export function FormComponent() {
    const {contacts, addContact, editContact, deleteContact} = useContext(ContactContext);
    const navigate = useNavigate();
    const {contactId} = useParams();
    const [searchParams, setSearchParams] = useSearchParams();
    const mode = searchParams.get('mode') ?? "default";
    const contact = contacts?.find((contact) => contact.id === contactId);
    const firstname = useRef(mode !== 'default' ? contact.firstname : '');
    const lastname = useRef(mode !== 'default' ? contact.lastname : '');
    const email = useRef(mode !== 'default' ? contact.email : '');
    const phone = useRef(mode !== 'default' ? contact.phone : '');

    const formHandler = (e) => {
        e.preventDefault();
        const newContact = {
            id: mode === 'default' ? uuidv4() : contactId,
            firstname: firstname.current.value,
            lastname: lastname.current.value,
            email: email.current.value,
            phone: phone.current.value
        }
        console.log(newContact)
        if (mode === 'default') {
            addContact(newContact);
            navigate('/');
        } else {
            editContact(contactId, newContact);
            navigate('/');
        }
    }

    const deleteHandler = () => {
        deleteContact(contactId);
        navigate('/');
    }
    return (
        <>
            {
                mode !== 'del' ?
                    <>
                        <h1 className={'text-center my-5'}>{mode === 'default' ? 'Formulaire d\'ajout de contact' : `Formulaire d'edition de ${contact.firstname} ${contact.lastname}`}</h1>
                        <div className={'container'}>
                            <form className={'w-50 m-auto'} onSubmit={formHandler}>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Prénom</label>
                                    <input className={'form-control'} ref={firstname} defaultValue={mode === 'edit' ? contact.firstname : ''}
                                           id={'firstname'} name={'fistname'} type={'text'} placeholder={'Jean'}
                                           required={true}/>
                                </div>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Nom</label>
                                    <input className={'form-control'} ref={lastname} defaultValue={mode === 'edit' ? contact.lastname : ''}
                                           id={'lastname'} name={'lastname'} type={'text'} placeholder={'Moulin'}
                                           required={true}/>
                                </div>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Email</label>
                                    <input className={'form-control'} ref={email} id={'email'} defaultValue={mode === 'edit' ? contact.email : ''}
                                           name={'email'} type={'text'} placeholder={'jean.moulin@email.fr'}
                                           required={true}/>
                                </div>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Numéro de téléphone</label>
                                    <input className={'form-control'} ref={phone} id={'phone'} defaultValue={mode === 'edit' ? contact.phone : ''}
                                           name={'phone'} type={'tel'} placeholder={'0502321242'}
                                           required={true}/>
                                </div>
                                <div className={'my-5 d-flex justify-content-center'}>
                                    <button className={'btn btn-primary'}>{
                                        mode === 'default' ? 'Ajouter' : 'Modifier'
                                    }</button>
                                </div>
                            </form>
                        </div>
                    </> :
                    <>
                        <h3 className={'text-center my-5'}>Voulez vous vraiment
                            supprimer {contact.firstname} {contact.lastname} ?</h3>
                        <div className={'d-flex justify-content-center'}>
                            <button className={'btn btn-danger'} onClick={deleteHandler}>Oui</button>
                            <Link className={'btn btn-outline-primary'} to={'/'}>Non</Link>
                        </div>
                    </>
            }

        </>
    )
}