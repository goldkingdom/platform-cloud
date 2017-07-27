<template>
  <div>
    <h3>{{title}}</h3>
    <div>count: {{count}}</div>
    <button @click="add(1)">Increment +1</button>
    <div>
      <ul>
        <li v-for="item in menuList">
          <a href="javascript:void(0);" @click="clickMenu(item)">{{item.name}}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import * as util from '../service/util'

  export default {
    name: 'menu',
    created() {
      this.loadMenu();
    },
    data() {
      return {
        title: '菜单',
        count: 1,
        menuList: []
      }
    },
    methods: {
      loadMenu: function () {
        let vm = this;
        axios.get(util.clientUrl + '/menu/loadMenu')
          .then(function (res) {
            vm.menuList = res.data;
          })
          .catch(function (err) {
            console.log(err);
          });
      },
      clickMenu: function (item) {
        let vm = this;
        axios.post(util.clientUrl + '/menu/clickMenu', {val: 1})
          .then(function (res) {
            vm.val = res.data;
          })
          .catch(function (err) {
            console.log(err);
          });
      },
      add: function (num) {
        let vm = this;
        vm.count = util.add(vm.count, num);
      }
    }
  }
</script>

<style></style>
