import {useContext, useState} from 'react';
import './App.css';
import {NavBar} from "./components/NavBar.jsx";
import {CartContext, CartProvider} from "./context/CartContext.jsx";
import {ProductCard} from "./components/ProductCard.jsx";
import {CartModal} from "./components/Modal/CartModal.jsx";
import Modal from './components/Modal/Modal.jsx';

function App() {
    const [products, setProducts] = useState([
        {
            'id' : 1,
            'name': 'PC Gamer 01',
            'description' : 'PC Gamer i7 13600K, RTX 4070, 32gb RAM DDR5',
            'price': 1200,

        },
        {
            'id' : 2,
            'name': 'PC Gamer 02',
            'description' : 'PC Gamer i7 13700K, RTX 4080, 32gb RAM DDR5',
            'price': 1600,

        },
        {
            'id' : 3,
            'name': 'PC Gamer 03',
            'description' : 'PC Gamer i9 13600K, RTX 4090, 32gb RAM DDR5',
            'price': 1800,

        },
    ]);
    const [showModal, setShowModal] = useState(false);
  return (
    <CartProvider>
        {
            showModal  && <Modal closeModal={() => setShowModal(false)}><CartModal /></Modal>
        }
        <header>
            <NavBar  openModal={() => setShowModal(true)} />
        </header>
        <main className={'container'}>
            <h1 className={'text-center'}>Produits :</h1>
            <div className={'d-flex justify-content-center flex-wrap'}>
            {
                products.length > 0 ? products.map((product) => (
                    <ProductCard key={product.id} product={product} />
                )) : <h3 className={'text-center'}>Aucun produit</h3>
            }
            </div>
        </main>
    </CartProvider>
  )
}

export default App
