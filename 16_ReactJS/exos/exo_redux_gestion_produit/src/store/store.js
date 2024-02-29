import {configureStore} from "@reduxjs/toolkit";
import productsSlice from "./productsSlice.js";


export default configureStore({
    reducer: {
        product: productsSlice,
    },
});