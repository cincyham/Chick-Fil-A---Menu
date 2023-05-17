import { configureStore } from "@reduxjs/toolkit";
import { setupListeners } from "@reduxjs/toolkit/dist/query";
import { cfaMenuApi } from "./apis/cfaMenuApi";
import {
  pageEntrees,
  pageSides,
  pageCondiments,
  pageBeverages,
  pageTreats,
  pageReducer,
} from "./slices/pageSlice";

import {
  addToOrder,
  removeFromOrder,
  clearOrder,
  transactionReducer,
} from './slices/transactionSlice';

export const store = configureStore({
  reducer: {
    [cfaMenuApi.reducerPath]: cfaMenuApi.reducer,
    page: pageReducer,
    transaction: transactionReducer,
  },
  middleware: (getDefaultMiddleware) => {
    return getDefaultMiddleware().concat(cfaMenuApi.middleware);
  },
});

setupListeners(store.dispatch);

export { useGetMenuQuery, useGetTransactionsQuery, useCreateTransactionMutation } from "./apis/cfaMenuApi";

export { pageEntrees, pageSides, pageCondiments, pageBeverages, pageTreats, addToOrder, removeFromOrder, clearOrder };
