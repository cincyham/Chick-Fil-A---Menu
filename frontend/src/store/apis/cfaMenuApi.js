import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const cfaMenuApi = createApi({
  reducerPath: "cfaMenu",
  baseQuery: fetchBaseQuery({
    baseUrl: "http://localhost:8080/api",
    fetchFn: (...args) => {
      return fetch(...args);
    },
  }),
  endpoints(builder) {
    return {
      getMenu: builder.query({
        query: () => {
          return {
            url: `/items`,
            method: "GET",
          };
        },
      }),
    };
  },
});

export const { useGetMenuQuery } = cfaMenuApi;
export { cfaMenuApi };
