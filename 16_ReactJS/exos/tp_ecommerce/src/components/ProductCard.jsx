import {useContext} from "react";
import {CartContext} from "../context/CartContext.jsx";

export const ProductCard = (props) => {
    const product = props.product
    const { addToCart } = useContext(CartContext);
    return (
        <>
            <div className={'card w-25'} >
                <div className={"card-body"}>
                    <h5 className={"card-title"}>{product.name}</h5>
                    <p className={"card-text"}>{product.description}</p>
                    <p className={'card-text text-center'}>{product.price}€</p>
                    <button onClick={() => addToCart(product)} className={'btn btn-outline-primary'}>Ajouter au panier</button>
                </div>
            </div>
        </>
    )
}