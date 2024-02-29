import {useRef} from "react";
import {useDispatch} from "react-redux";
import {addProduct} from "../store/productsSlice.js";

export const AddProduct = () => {
    const name = useRef('');
    const price = useRef(0);
    const dispatch = useDispatch();
    const handleSubmit = (e) => {
        e.preventDefault();
        const newProduct = {
                name: name.current.value,
                price: Number(price.current.value)
            };
        dispatch(addProduct(newProduct));
        price.current.value = 0;
        name.current.value = '';


    }
    return (
        <>
            <h1 className={'text-center m-5'}>Ajouter un produit</h1>
            <form onSubmit={handleSubmit}  className={'w-50 m-auto'} >
                <div className={'m-3'}>
                    <label htmlFor={'name'} className={'form-label'}>Nom du produit</label>
                    <input type={'text'} className={'form-control text-center'} placeholder={'Pomme'} id={'name'} ref={name} required={true} />
                </div>
                <div className={'m-3'}>
                    <label htmlFor={'price'} className={'form-label'}>Prix du produit</label>
                    <input type={'number'} className={'form-control text-center'} id={'price'} ref={price} defaultValue={0} step={'any'} required={true}/>
                </div>
                <div className={'m-3'}>
                    <button className={'btn btn-outline-primary'} type={'submit'}>Ajouter</button>
                </div>
            </form>
        </>
    )
}