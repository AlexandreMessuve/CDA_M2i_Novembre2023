import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
    name: "auth",
    initialState: {
        user: null,
        isAuth: false,
        authMode: "Sign In",
    },
    reducers: {
        setUser: (state, action) => {
            state.user = action.payload;
            state.isAuth = true;
        },
        removeUser: (state) => {
            state.user = null;
            state.isAuth = false;
            localStorage.removeItem("token");
        },
        setAuthMode: (state, action) => {
            state.authMode = action.payload;
        },
    },
});

export const { setUser, removeUser, setAuthMode } = authSlice.actions;
export default authSlice.reducer;
