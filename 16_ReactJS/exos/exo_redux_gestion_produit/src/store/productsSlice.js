import { createSlice } from "@reduxjs/toolkit";

const productsSlice = createSlice({
   name:'product',
   initialState: {
       products: [],
       countProducts: 0,
   },
    reducers: {
       addProduct: (state, action) => {
            const newProduct = {
                id: Date.now(),
                name: action.payload.name,
                price: action.payload.price,
            };
            state.products.push(newProduct);
            state.countProducts++;
       },
       updateProduct: (state, action) => {
            state.products = state.products.map((product) => {
                if (product.id === action.payload.id){
                    product.name = action.payload.name;
                    product.price = action.payload.price;
                }
                return product;
            })
       },
       deleteProduct: (state, action) => {
            state.products = state.products.filter((product) => product.id !== action.payload);
            state.countProducts--;
       }
    }
});

export const { addProduct, updateProduct, deleteProduct} = productsSlice.actions;
export default productsSlice.reducer;