import {useContext} from "react";
import {CartContext} from "../../context/CartContext.jsx";

export const CartModal = () => {
    const {cartItems, totalPriceCart, removeFromCart, clearCart, getCartTVA, getCartTotalHT} = useContext(CartContext);

    return (
        <>
            <div className={'modal-content'}>
                <div className={'modal-header'}>
                    <h5 className={'modal-title text-center'}>Panier</h5>
                </div>
                <div className={'modal-body'}>
                    {
                        cartItems.length > 0 ? <table align={'center'}>
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Quantité</th>
                                <th>Total HT</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                cartItems.map((item) => (
                                    <tr key={item.id}>
                                        <td>{item.name}</td>
                                        <td>{item.quantity}</td>
                                        <td>{item.allPrice} €</td>
                                        <td className={'p-3'}>
                                            <button
                                                className={'btn btn-warning'}
                                                onClick={() => removeFromCart(item)}>
                                                Supprimer
                                            </button>
                                        </td>
                                    </tr>
                                ))
                            }
                            </tbody>
                        </table> : <p>Aucun article dans le panier</p>
                    }
                </div>
                {
                    cartItems.length > 0 ?
                        <div className={'my-2'}>
                            <div>
                                <div className={'d-flex flex-column justify-content-end'}>
                                    <p className={'text-right'}>Total HT : {getCartTotalHT()} €</p>
                                    <p className={'text-right'}>TVA : {getCartTVA()} €</p>
                                    <p className={'text-right'}>Total TTC : {totalPriceCart} €</p>
                                </div>

                                <div>
                                    <button className={'btn btn-warning'} onClick={() => clearCart()}>Vider le panier
                                    </button>
                                </div>
                            </div>

                        </div>
                        : null
                }
            </div>
        </>
    )
}