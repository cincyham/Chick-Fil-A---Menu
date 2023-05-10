import { createSlice } from "@reduxjs/toolkit";

const transactionSlice = createSlice({
  name: "transaction",
  initialState: {
    order: [],
  },
  reducers: {
    addToOrder(state, action) {
      state.order.push(action.payload);
    },
    removeFromOrder(state, action) {
      state.order.splice(action.payload, 1);
    },
    clearOrder(state, action) {
      state.order = [];
    },
  },
});

export const {
  addToOrder,
  removeFromOrder,
  clearOrder,
} = transactionSlice.actions;

export const transactionReducer = transactionSlice.reducer;
