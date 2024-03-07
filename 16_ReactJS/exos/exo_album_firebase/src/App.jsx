import {Link, Outlet} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {removeUser, verifToken} from "./store/authSlice.js";
import {setFormMode} from "./store/albumSlice.js";
import {useEffect} from "react";

function App() {
    const token = localStorage.getItem('token');
    const dispatch = useDispatch();
    const user = useSelector(state => state.auth.user);
    const checkToken = () => {
        if(token){
            dispatch(verifToken(token));
        }
    }

    useEffect(() => {
        checkToken();
        const interval = setInterval(checkToken, 10000);
        return () => clearInterval(interval);
    }, [token, dispatch]);
    return (
        <>
            <header>
                <nav className={'navbar d-flex justify-content-between'}>
                    <h3>eAlbum</h3>
                    <ul className={'nav'}>
                        <li className={'nav-item'}><Link className={'nav-link'} to={'/'}>Home</Link></li>
                        {
                            user ?
                            <li className={'nav-item'}><Link onClick={() => dispatch(setFormMode('Ajouter un album'))} className={'nav-link'} to={'/album-form'}>AddAlbum</Link></li>
                                :
                            <li className={'nav-item'}><Link className={'nav-link'} to={'/sign'}>Sign IN / UP</Link></li>
                        }
                    </ul>
                    {
                        user &&
                        <button className={'btn btn-outline-danger'} onClick={() => dispatch(removeUser())}>Logout</button>
                    }
                </nav>
            </header>
            <main className={'text-center container'}>
                <Outlet />
            </main>
        </>
    )
}

export default App
