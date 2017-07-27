<template>
  <table border="1px;">
    <thead>
    <tr>
      <th v-show="model.checkFlag">
        <input type="checkbox" v-model="model.allChecked" @click="checkAll()">
      </th>
      <th v-for="head in model.headList">{{head.name}}</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in model.bodyList">
      <td v-show="model.checkFlag">
        <input type="checkbox" v-model="item.checked" @click="checkOne()">
      </td>
      <td v-for="head in model.headList">
        <div v-show="head.type=='Operation'">
          <ul>
            <li class="li" v-for="operation in model.operationList">
              <button @click="operation.fn(item)">{{operation.name}}</button>
              &nbsp;&nbsp;
            </li>
          </ul>
        </div>
        <div v-show="head.type!='Operation'">{{item[head.key]}}</div>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
  export default {
    created() {
      this.checkAll();
    },
    props: ['model'],
    methods: {
      checkAll: function () {
        for (var item of this.model.bodyList) {
          item.checked = this.model.allChecked;
        }
      },
      checkOne: function () {
        this.model.allChecked = true;
        for (var item of this.model.bodyList) {
          if (!item.checked) {
            this.model.allChecked = false;
          }
        }
      }
    }
  }
</script>

<style>
  li {
    float: left;
    list-style: none;
    margin-bottom: 15px;
  }
</style>
