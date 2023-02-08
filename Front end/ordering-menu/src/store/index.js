import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    items : [],
  },
  mutations: {
    SET_ITEMS(state, itemList) {
      state.items = itemList;
    }
  },
  actions: {
  },
  modules: {
  }
})
