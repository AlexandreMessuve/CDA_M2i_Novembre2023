import {createSlice} from '@reduxjs/toolkit';

const dataSlice = createSlice({
  name: 'data',
  initialState: {
    ids: ['0', '1', '2', '3'],
  },
  reducers: {
    addIds: (state, action) => {
      state.ids.push(action.payload.id);
    },
    removeIds: (state, action) => {
      state.ids.splice(state.ids.indexOf(action.payload.id), 1);
    },
  },
});

export const addIds = dataSlice.actions.addIds;
export const removeIds = dataSlice.actions.removeIds;
export default dataSlice.reducer;
