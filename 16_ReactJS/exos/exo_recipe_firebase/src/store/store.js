import { configureStore } from "@reduxjs/toolkit";
import authSlice from "./authSlice.js";
import recipeSlice from "./recipeSlice.js";


export default configureStore({
    reducer: {
        auth: authSlice,
        recipe: recipeSlice,
    },
});
