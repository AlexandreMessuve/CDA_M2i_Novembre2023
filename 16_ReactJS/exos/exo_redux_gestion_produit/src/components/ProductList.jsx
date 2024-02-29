import {useSelector} from "react-redux";
import {ProductItem} from "./ProductItem.jsx";

export const ProductList = () => {
    const products = useSelector(state => state.product.products);
    const countProducts = useSelector(state => state.product.countProducts);
    return (
        <>
            <h1 className={'text-center'}>Liste des produits</h1>
            <table className={'table table-bordered text-center'}>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                {
                    countProducts === 0 &&
                     <tr>
                         <td colSpan={3}>Rien</td>
                     </tr>
                }
                {
                    products.map((product) => (
                        <ProductItem key={product.id} product={product} />
                    ))
                }
                </tbody>
            </table>
        </>
    )
}