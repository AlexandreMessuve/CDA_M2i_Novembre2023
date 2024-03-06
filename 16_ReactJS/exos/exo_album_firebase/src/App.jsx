import {Link, Outlet} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {removeUser} from "./store/authSlice.js";
import {setFormMode} from "./store/albumSlice.js";

function App() {

    const dispatch = useDispatch();
    const user = useSelector(state => state.auth.user);
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
