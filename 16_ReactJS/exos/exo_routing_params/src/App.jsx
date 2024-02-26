import {Link, Outlet} from "react-router-dom";

function App() {

    return (
        <>
            <header>
                <nav className={'text-center'}>
                    <Link className={'mx-2'} to={'/'}>Contact list</Link>
                    <Link className={'mx-2'} to={'/contacts/add'}>Ajout contact</Link>
                </nav>
            </header>
            <main className={'container my-4'}>
                <Outlet/>
            </main>
            <footer>
                <h6 className={'text-center'}>Mon footer</h6>
            </footer>
        </>
    )
}

export default App
