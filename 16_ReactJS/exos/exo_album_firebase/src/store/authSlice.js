import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";

export const sign = createAsyncThunk("auth/sign", async (payload) => {
    try {

        const resp = await axios.post(`${payload.URL}`,payload.credentials);
        return resp.data
    }catch (e) {
        return e;
    }
});
const authSlice = createSlice({
    name: "auth",
    initialState: {
        user: null,
        authMode: "Sign In",
    },
    reducers: {
        setUser: (state, action) => {
            state.user = action.payload;
        },
        removeUser: (state) => {
            state.user = null;
            localStorage.removeItem("token");
        },
        setAuthMode: (state, action) => {
            state.authMode = action.payload;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(sign.fulfilled, (state, action) => {
            state.user = action.payload;
            localStorage.setItem('token', action.payload.idToken);
        });
        builder.addCase(sign.rejected, (state, action) => {
            console.log(action.payload);
        });
    }
});

export const { setUser, removeUser, setAuthMode } = authSlice.actions;
export default authSlice.reducer;
