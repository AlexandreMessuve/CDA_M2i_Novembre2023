import { useRef } from "react"
import {useDispatch, useSelector} from "react-redux"
import { setAuthMode, setUser } from "../../store/authSlice.js"
import { URL_SIGN_IN, URL_SIGN_UP } from "../../firebaseConfig.js"
import axios from "axios"
import {useNavigate} from "react-router-dom";

const SignForm = () => {
    const authMode = useSelector(state => state.auth.authMode)
    const dispatch = useDispatch()
    const navigate = useNavigate();
    const emailRef = useRef()
    const passwordRef = useRef()

    const submitForm = (e) => {
        e.preventDefault()

        const URL = authMode === "Sign In" ? URL_SIGN_IN : URL_SIGN_UP

        const credentials = {
            email : emailRef.current.value,
            password: passwordRef.current.value,
            returnSecureToken: true
        }

        axios.post(URL, credentials).then((response) => {
            console.log(response.data);
            localStorage.setItem("token", response.data.idToken)
            dispatch(setUser(response.data))
            navigate('/');

        }).catch(e => console.log(e));
    }

    return (
        <div className={'container text-center'}>
            <h3 className={'m-5'}>{authMode}</h3>
            <form className={'w-50 m-auto'} onSubmit={submitForm}>
                <div className={'m-3'}>
                    <label className={'form-label'} htmlFor="email">Email</label>
                    <input className={'form-control'} type="email" ref={emailRef} />
                </div>
                <div className={'m-3'}>
                    <label className={'form-label'} htmlFor="password">Password</label>
                    <input className={'form-control'} type="password" ref={passwordRef} />
                </div>
                <button className={'btn btn-primary'}>{authMode}</button>
            </form>
            <button className={'btn btn-outline-primary m-5'} onClick={() => dispatch(setAuthMode(authMode === "Sign In" ? "Sign Up" : "Sign In"))}>
                {authMode === "Sign In" ? "Sign Up" : "Sign In"}
            </button>
        </div>
    );
}

export default SignForm;