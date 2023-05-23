import { configureStore } from "@reduxjs/toolkit";
import { setupListeners } from "@reduxjs/toolkit/dist/query";
import { cfaMenuApi } from "./apis/cfaMenuApi";

export const store = configureStore({
  reducer: {
    [cfaMenuApi.reducerPath]: cfaMenuApi.reducer,
  },
  middleware: (getDefaultMiddleware) => {
    return getDefaultMiddleware().concat(cfaMenuApi.middleware);
  },
});

setupListeners(store.dispatch);

export { useGetMenuQuery, useGetTransactionsQuery, useCreateTransactionMutation } from "./apis/cfaMenuApi";
