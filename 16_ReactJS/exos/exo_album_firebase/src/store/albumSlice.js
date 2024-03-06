import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import {DB_URL} from "../firebaseConfig.js";

export const fetchAlbum = createAsyncThunk("album/fetch", async() => {
    try {
        const resp = await axios.get(`${DB_URL}albumsList.json`);
        const albums = [];
        if(resp.data){
            for (const key in resp.data){
                albums.push({index: key, ...resp.data[key]})
            }
        }
        return albums;
    }catch (e) {
        return e;
    }
});
export const addAlbum = createAsyncThunk("album/add", async(payload) => {
    try {
        const newAlbum = payload.newAlbum;
        const resp = await axios.post(`${DB_URL}albumsList.json?auth=${payload.idToken}`,newAlbum)
        return {
            index: resp.data.name,
            ...payload.newAlbum
        }
    }catch (e) {
        return e;
    }
});

export const editAlbum = createAsyncThunk("album/edit", async(payload) => {
    try {
        const resp = await axios.put(`${DB_URL}albumsList/${payload.index}.json?auth=${payload.idToken}`,payload.editAlbum);
        return payload.editAlbum
    }catch (e) {
        return e;
    }
});

export const deleteAlbum = createAsyncThunk('album/delete', async (payload) => {
    try {
        const resp = await axios.delete(`${DB_URL}albumsList/${payload.index}.json?auth=${payload.idToken}`);
        return payload.index;
    }catch (e) {
        return e;
    }
})
const albumSlice = createSlice({
    name: "album",
    initialState: {
        formMode: "Ajouter un album",
        albums: [],
        selectedAlbum: null,
        isLoading: false,
        error: null
    },
    reducers: {
        setFormMode: (state, action) => {
            state.formMode = action.payload;
        },
        setSelectedAlbum: (state, action) => {
            state.selectedAlbum = action.payload;
        },
        setError: (state, action) => {
            state.error = action.payload;
        },
        sortByScore: (state, action) => {
            if(action.payload){
                state.albums = state.albums.sort((a,b) => b.score - a.score);
            }else{
                state.albums = state.albums.sort((a,b) => a.score - b.score);
            }
        },
        sortByName: (state, action) => {
            if (action.payload){
                state.albums = state.albums.sort((a,b) => a.name.localeCompare(b.name));
            }else{
                state.albums = state.albums.sort((a,b) => b.name.localeCompare(a.name));
            }
        }
     },
    extraReducers: (builder) => {
        //Fetch album
        builder.addCase(fetchAlbum.fulfilled, (state, action) => {
            state.albums = action.payload;
            state.isLoading = false;
        });
        builder.addCase(fetchAlbum.pending, (state) => {
            state.isLoading = true;
        });
        builder.addCase(fetchAlbum.rejected, (state, action) => {
            state.error = action.payload;
        });

        //Add Album
        builder.addCase(addAlbum.fulfilled, (state, action) => {
            state.albums.push(action.payload);
        });
        builder.addCase(addAlbum.rejected, (state, action) => {
            state.error = action.payload;
        });

        //Edit album
        builder.addCase(editAlbum.fulfilled, (state, action) => {
            state.albums = state.albums.map((album) => {
                if(album.index === action.payload.index){
                    return action.payload
                }
                return album
            });
        });
        builder.addCase(editAlbum.rejected, (state, action) => {
            state.error = action.payload;
        });

        //Delete Album
        builder.addCase(deleteAlbum.fulfilled, (state, action) => {
            state.albums = state.albums.filter((album) => album.index !== action.payload);
        });
        builder.addCase(deleteAlbum.rejected, (state, action) => {
            state.error = action.payload;
        });
    }
});
export const {setFormMode, setSelectedAlbum, setError, sortByName, sortByScore} = albumSlice.actions;
export default albumSlice.reducer;
