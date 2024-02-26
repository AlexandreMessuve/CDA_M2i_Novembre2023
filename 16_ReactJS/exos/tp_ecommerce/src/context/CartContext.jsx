import { createContext, useState, useEffect} from "react";

export const CartContext = createContext('cart');

export const CartProvider = ({children}) => {
    const [cartItems, setCartItems] = useState([]);
    const [showCart, setShowCart] = useState(false);
    const [totalPriceCart, setTotalPriceCart] = useState(0);
    const [totalPriceHT, setTotalPriceHT] = useState(0);
    const [tva, setTva] = useState(0);
    //Permet d'ajouter un produit dans le panier
    const addToCart = (item) => {

        const isItemInCart = cartItems.find((cartItem) => cartItem.id === item.id)
        if(isItemInCart){
            setCartItems(
                cartItems.map((cartItem) =>
                    cartItem.id === item.id ? {
                            ...cartItem, quantity: cartItem.quantity + 1,allPrice: (cartItem.price * (cartItem.quantity +1)).toFixed(2)
                        }
                        : cartItem
                )
            )
        }else {
            setCartItems([...cartItems, { ...item, quantity: 1, allPrice: item.price}])
        }
    }

    const removeFromCart = (item) => {
        const isItemInCart = cartItems.find((cartItem)=> cartItem.id === item.id)
        if (isItemInCart.quantity === 1){
            setCartItems(cartItems.filter((cartItem) => cartItem.id !== item.id))
        }else {
            setCartItems(
                cartItems.map((cartItem) =>
                    cartItem.id === item.id ? {
                        ...cartItem, quantity: cartItem.quantity - 1, allPrice: (cartItem.price * (cartItem.quantity -1)).toFixed(2)
                    }: cartItem
                )
            )
        }
    }
    const clearCart = () => {
        setCartItems([])
    }

    const getCartTotalHT = () => {
        return cartItems.reduce((total, item) => total + item.price * item.quantity,0).toFixed(2)
    }
    const getCartTVA = () => {
        return (parseFloat(getCartTotalHT())* 20/100).toFixed(2)
    }
    const getCartTotalTTC = () =>{
        return (parseFloat(getCartTotalHT())+parseFloat(getCartTVA())).toFixed(2)
    }

    useEffect(() => {
        getCartTVA();
        getCartTotalTTC();
        setTotalPriceCart(getCartTotalTTC());
        console.log(cartItems);
    }, [cartItems])

    return(
        <CartContext.Provider value={{
            cartItems,
            totalPriceCart,
            showCart,
            setShowCart,
            getCartTVA,
            getCartTotalHT,
            addToCart,
            removeFromCart,
            clearCart
        }}>
            {children}
        </CartContext.Provider>
    )
}