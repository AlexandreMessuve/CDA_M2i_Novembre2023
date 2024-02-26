import {Link} from "react-router-dom";

export const NavBar = () => {
    return (
        <>
            <header>
                <nav className={'text-center'}>
                    <Link className={'mx-2'} to={'/'} >Home</Link>
                    <Link className={'mx-2'} to={'/products'} >Products</Link>
                    <Link className={'mx-2'} to={'/login'} >Log in</Link>
                </nav>
            </header>

        </>
    )
}