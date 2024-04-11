import { configureStore } from "@reduxjs/toolkit";
import magicSlice from "./magicSlice.js";
export default configureStore({
    reducer: {
        magic: magicSlice
    },
});
