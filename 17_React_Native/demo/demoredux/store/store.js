import {configureStore} from '@reduxjs/toolkit';
import dataSlice from './dataSlice';

export default store = configureStore({
  reducer: {
    data: dataSlice,
  },
});
