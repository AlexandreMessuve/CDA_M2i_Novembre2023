import {useState} from "react";

export const FirstComponent = () => {
    const [lastname, setLastname] = useState('');
    const [firstname, setFirstname] = useState('');

    const onInputChange = (e) => {
        if(e.target.name === 'lastname'){
            setLastname(e.target.value.toUpperCase().trim());
        }
        if(e.target.name === 'firstname'){
            setFirstname(e.target.value.trim());
        }
    }
    return (
        <>
            <div>
                <label>Prenom : </label>
                <input id={'firstname'} name={'firstname'} value={firstname} onChange={onInputChange}/>
            </div>
            <div>
                <label>Nom : </label>
                <input name={'lastname'} value={lastname} onChange={onInputChange}/>
            </div>

            <p>Bonjour {firstname} <strong>{lastname}</strong>, bienvenue sur l'application !</p>
        </>
    )
}