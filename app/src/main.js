// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './service/vuex/store'

/* eslint-disable no-new */
Vue.directive('enabled', {
  update: function (el, binding) {
    el.disabled = binding.value;
  }
});
var app = new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {App}
});
