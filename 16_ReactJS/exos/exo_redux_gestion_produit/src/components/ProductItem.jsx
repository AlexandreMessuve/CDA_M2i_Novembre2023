import {useRef, useState} from "react";
import {useDispatch} from "react-redux";
import {updateProduct, deleteProduct} from "../store/productsSlice.js";

export const ProductItem = (props) => {
    const product = props.product;
    const name = useRef();
    const price = useRef();
    const [showInput, setShowInput] = useState(false);
    const dispatch = useDispatch();
    const handleUpdate = () =>{
        const updatedProduct = {
            id: product.id,
            name: name.current.value,
            price: Number(price.current.value)
        }
        dispatch(updateProduct(updatedProduct));
        setShowInput(false);
    }
    return (
        <>
            <tr>
                {
                    !showInput ?
                        <>
                            <td className={'w-25'}>{product.name}</td>
                            <td className={'w-25'}>{product.price} €</td>
                            <td className={'w-25'}>
                                <button onClick={() => setShowInput(true)} className={'btn btn-outline-info mx-2'}>Modifier</button>
                                <button onClick={() => dispatch(deleteProduct(product.id))} className={'btn btn-outline-danger'}>Supprimer</button>
                            </td>
                        </>
                        :
                        <>
                            <td className={'w-25'}><input ref={name} type={'text'} className={'form-control text-center'} name={'name'} defaultValue={product.name}/></td>
                            <td className={'w-25'}><input ref={price} type={'number'} className={'form-control text-center'} name={'price'} defaultValue={product.price}/></td>
                            <td className={'w-25'}>
                                <button onClick={() =>handleUpdate()} className={'btn btn-outline-primary mx-2'}>Valider</button>
                                <button onClick={() => setShowInput(false)}  className={'btn btn-outline-danger'}>Annuler</button>
                            </td>
                        </>
                }

            </tr>
        </>
    )
}