import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import {jwtDecode} from "jwt-decode";

export const sign = createAsyncThunk("auth/sign", async (payload) => {
    try {

        const resp = await axios.post(`${payload.URL}`,payload.credentials);
        return resp.data
    }catch (e) {
        return e;
    }
});

export const verifToken = createAsyncThunk('auth/logout', async (token) => {
    try {
        const decoded = jwtDecode(token);
        const date = new Date();
        if(decoded.exp * 1000 > date.getTime()){
            return {
                idToken: token,
                ... decoded
            }
        }
    }catch{
        return false;
    }
})
const authSlice = createSlice({
    name: "auth",
    initialState: {
        user: null,
        authMode: "Sign In",
    },
    reducers: {
        removeUser: (state) => {
            localStorage.removeItem("token");
            state.user = null;
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
        builder.addCase(verifToken.fulfilled, (state, action) => {
            if(!state.user){
                state.user = action.payload;
            }
        });
        builder.addCase(verifToken.rejected, (state) => {
            removeUser();
        })
    }
});

export const {  removeUser, setAuthMode } = authSlice.actions;
export default authSlice.reducer;
