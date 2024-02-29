import {ProductList} from "./components/ProductList.jsx";
import {AddProduct} from "./components/AddProduct.jsx";

function App() {

  return (
    <>
        <div className={'container'}>
            <h1 className={'text-center m-5'}>Application gestion de produits</h1>
            <div className={'text-center'}>
                <AddProduct />
            </div>
            <hr />
            <ProductList />
        </div>
    </>
  )
}

export default App
