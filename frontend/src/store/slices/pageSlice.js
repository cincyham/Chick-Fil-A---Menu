import { createSlice } from "@reduxjs/toolkit";

const pageSlice = createSlice({
  name: "page",
  initialState: {
    page: "",
  },
  reducers: {
    pageEntrees(state, action) {
      state.page = "Entree";
    },
    pageSides(state, action) {
      state.page = "Side";
    },
    pageCondiments(state, action) {
      state.page = "Condiment";
    },
    pageBeverages(state, action) {
      state.page = "Beverage";
    },
    pageTreats(state, action) {
      state.page = "Treat";
    },
  },
});

export const { pageEntrees, pageSides, pageCondiments, pageBeverages, pageTreats } = pageSlice.actions;
export const pageReducer = pageSlice.reducer;
