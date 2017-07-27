import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
  routes: [
    {path: '/', name: 'Hello', component: resolve => require(['../layout/Hello.vue'], resolve)},
    {path: '/home', name: 'Home', component: resolve => require(['../layout/Home.vue'], resolve)},
    {path: '/test', name: 'Test', component: resolve => require(['../layout/Test.vue'], resolve)},
    {path: '/grid', name: 'Grid', component: resolve => require(['../components/Grid.vue'], resolve)}
  ]
})
