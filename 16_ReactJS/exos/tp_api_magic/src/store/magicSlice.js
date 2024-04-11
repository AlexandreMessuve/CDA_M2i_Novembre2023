import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import {URL_API} from "../constant/URL_API.js";

export const initialState = {
    pageCards: 1,
    cards: [],
    sets: [],
    deck: [],
    deckCardsCount: 0,
    isLoading: false,
    error: null
}
export const fetchCards = createAsyncThunk('magic/fetchCards', async (page) => {
   try {
       const resp = await axios.get(`${URL_API}cards?page=${page}`,{
           params:{
               contains: "imageUrl",
               pageSize: 20
           }
       });
       return resp.data.cards;
   } catch (e) {
       return e;
   }
});
export const fetchSets = createAsyncThunk('magic/fetchSets', async () => {
    try {
        const resp = await axios.get(`${URL_API}sets`);
        return resp.data.sets;
    } catch (e) {
        return e;
    }
});
const magicSlice = createSlice({
    name: "magic",
    initialState,
    reducers: {
        setDeck: (state, action) => {
            if(state.deckCardsCount >= 30){
                return;
            }
            const existCard = state.deck.find((card) => card.id === action.payload.id);
            if(existCard){
                existCard.quantity++;
                state.deck = state.deck.map((card) => {
                    if(card.id === existCard.id){
                        if(existCard.quantity <= 3){
                            return existCard;
                        }
                    }
                    return card
                });
                state.deckCardsCount++
            }else{
                state.deck.push({quantity: 1, ...action.payload})
                state.deckCardsCount++
            }
        },
        removeCardDeck: (state, action) => {
            action.payload.quantity--;
            state.deck = state.deck.map((card) => {
                if(card.id === action.payload.id){
                    if(action.payload.quantity <= 0){
                        return
                    }
                    return action.payload;
                }
                return  card;
            })
        },
        removeDeck: (state) => {
            state.deck = [];
        }
    },
    extraReducers: (builder) => {
        builder.addCase(fetchCards.fulfilled, (state, action) => {
            console.log(action);
            state.isLoading = false;
            state.cards = action.payload;
        });
        builder.addCase(fetchCards.pending, (state) =>{
            state.error = null;
            state.cards = [];
            state.isLoading = true;
        });
        builder.addCase(fetchCards.rejected, (state, action) => {
            state.error = action.payload;
            state.cards = [];
        });

        builder.addCase(fetchSets.fulfilled, (state, action) => {
            state.sets = action.payload;
        });
        builder.addCase(fetchSets.pending, (state) =>{
            state.error = null;
        });
        builder.addCase(fetchSets.rejected, (state, action) => {
            state.error = action.payload;
        });
}
});
export const {setDeck, removeCardDeck, removeDeck} = magicSlice.actions;
export default magicSlice.reducer;