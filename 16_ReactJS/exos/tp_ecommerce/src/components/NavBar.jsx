import {useContext} from "react";
import {CartContext} from "../context/CartContext.jsx";

export const NavBar = (props) => {
    const {cartItems} = useContext(CartContext);
    const openModal = props.openModal;
    return (
        <>
            <nav className="navbar navbar-light bg-light justify-content-between">
                <a className="navbar-brand mx-5">E commerce</a>
                <button onClick={openModal} className="btn btn-outline-success my-2 my-sm-0 mx-5" type="submit">
                    Panier
                    {
                        cartItems.length > 0 ?
                            <span className={'badge rounded-circle bg-danger position-absolute z-3'}>
                                {cartItems.length}
                            </span> : null
                    }
                </button>

            </nav>
        </>
    )
}