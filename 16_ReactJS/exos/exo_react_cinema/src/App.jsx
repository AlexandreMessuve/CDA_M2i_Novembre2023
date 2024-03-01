import {Link, Outlet} from "react-router-dom";
import {MovieProvider} from "./context/MovieContext.jsx";

function App() {

  return (
    <MovieProvider>
        <header>
            <nav className={'navbar'}>
                <ul className={'navbar nav'}>
                    <li className={'nav-item mx-2'}><Link className={'nav-link'} to={'/'}>Accueil</Link></li>
                    <li className={'nav-item mx-2'}><Link className={'nav-link'} to={'/add'}>Ajouter un film</Link></li>
                </ul>
            </nav>
        </header>
        <main>
            <Outlet/>
        </main>
    </MovieProvider>
  )
}

export default App
