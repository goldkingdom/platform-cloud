import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    model: {}
  },
  mutations: {
    SET_MODEL(state, model) {
      state.model = model;
    }
  },
  actions: {
    setModel({commit}, model) {
      commit('SET_MODEL', model);
    }
  },
  getters: {
    getModel: (state) => state.model
  }
});
