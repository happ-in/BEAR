import { createStore } from "vuex";

export default createStore({
  state: {
    accessToken: null,
    userId: '',
  },
  getters: {
    getAccessToken: state => {
      if (sessionStorage.getItem('accessToken') != null) {
        this.state.accessToken = sessionStorage.getItem('accessToken');
        this.state.userId = sessionStorage.getItem('userId');
        this.state.userName = sessionStorage.getItem('userName');
        this.state.gender = sessionStorage.getItem('gender');
      }
      return state.accessToken;
    }
  },
  mutations: {},
  actions: {},
  modules: {},
  
});
