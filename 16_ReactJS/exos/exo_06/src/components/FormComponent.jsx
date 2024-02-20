import {useState} from "react";

export const FormComponent = (props) => {
    const [lastname, setLastname] = useState('');
    const [firstname, setFirstname] = useState('');
    const [email, setEmail] = useState('');
    const lastnameHandler = (e) => {
        setLastname(e.target.value);
    }
    const firstnameHandler = (e) => {
        setFirstname(e.target.value);
    }
    const emailHandler = (e) => {
        setEmail(e.target.value);
    }

    const formHandler = (e) => {
        e.preventDefault();
        const contact =
            {
                "firstname" : firstname,
                "lastname" : lastname,
                "email" : email
            };
        // eslint-disable-next-line react/prop-types
        props.addContact(contact);
        setLastname('');
        setFirstname('');
        setEmail('');
    }
    return (
        <>
            <form onSubmit={formHandler}>
                <div>
                    <label>Nom</label>
                    <input type={'text'} id={'lastname'} value={lastname} onChange={lastnameHandler} required={true}/>
                </div>
                <div>
                    <label>Prénom</label>
                    <input type={'text'} id={'firstname'} value={firstname} onChange={firstnameHandler} required={true}/>
                </div>
                <div>
                    <label>Email</label>
                    <input type={'email'} value={email} onChange={emailHandler} required={true}/>
                </div>
                <button type={'submit'}>Ajouter</button>
            </form>
        </>
    )
}