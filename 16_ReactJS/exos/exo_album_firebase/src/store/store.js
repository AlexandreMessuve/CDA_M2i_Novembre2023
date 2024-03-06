import { configureStore } from "@reduxjs/toolkit";
import authSlice from "./authSlice.js";
import albumSlice from "./albumSlice.js";


export default configureStore({
    reducer: {
        auth: authSlice,
        album: albumSlice,
    },
});
