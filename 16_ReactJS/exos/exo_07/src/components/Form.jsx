import {useRef} from "react";

export const Form = (props) => {
    let username = useRef('');
    let password = useRef('');
    const sendForm = props.sendForm;
    const formHandler = (e) =>  {
        e.preventDefault();
        const user = {
            "username" : username.current.value,
            "password" : password.current.value
        }

        sendForm(user);
        e.target.reset();
    }
    return (
        <>
            <h1>Login</h1>
            <form onSubmit={formHandler}>
                <div>
                    <label>Username</label>
                    <input type={'text'} ref={username}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type={'password'} ref={password}/>
                </div>
                <button type={'submit'}>Login</button>
            </form>
        </>
    )
}