<template>
  <div>
    <ul style="clear: both;float: right">
      <li class="li">
        <a href="javascript:void(0);">{{model.currentPage}}/{{model.totalPages}}</a>
      </li>
      <li class="li">
        <a href="javascript:void(0);" @click="toFirstPage()" v-show="model.currentPage>1">首页</a>
        <a href="javascript:void(0);" v-show="model.currentPage<=1">首页</a>
        <a href="javascript:void(0);" @click="toPrePage()" v-show="model.currentPage>1">上一页</a>
        <a href="javascript:void(0);" v-show="model.currentPage<=1">上一页</a>
        <input type="text" class="input" v-model="model.currentPage">
        <a href="javascript:void(0);" @click="toNextPage()" v-show="model.currentPage<model.totalPages">下一页</a>
        <a href="javascript:void(0);" v-show="model.currentPage>=model.totalPages">下一页</a>
        <a href="javascript:void(0);" @click="toLastPage()" v-show="model.currentPage<model.totalPages">末页</a>
        <a href="javascript:void(0);" v-show="model.currentPage>=model.totalPages">末页</a>
      </li>
      <li class="li">
        <input type="text" v-model="page" style="width: 20px;">
        <a href="javascript:void(0);" @click="toPage()">
          <span>GO</span>
        </a>
      </li>
      <li>
        <selection :model="model.selection"></selection>
      </li>
    </ul>
  </div>
</template>

<script>
  import * as util from '../service/util'
  import selection from '../components/Selection'

  export default {
    data() {
      return {
        page: undefined
      }
    },
    props: ['model'],
    methods: {
      initPage() {
        this.model.itemsPerPage = this.model.selection.selected;
        this.model.currentPage = 1;
        this.model.totalItems = 0;
        this.model.totalPages = this.model.totalItems / this.model.itemsPerPage;
        this.model.error = false;
        util.call(this.model);
      },
      toFirstPage() {
        this.model.currentPage = 1;
        this.model.itemsPerPage = this.model.selection.selected;
        util.call(this.model);
      },
      toPrePage() {
        this.model.currentPage = this.model.currentPage - 1;
        this.model.itemsPerPage = this.model.selection.selected;
        util.call(this.model);
      },
      toNextPage() {
        this.model.currentPage = this.model.currentPage + 1;
        this.model.itemsPerPage = this.model.selection.selected;
        util.call(this.model);
      },
      toLastPage() {
        this.model.currentPage = this.model.totalPages;
        this.model.itemsPerPage = this.model.selection.selected;
        util.call(this.model);
      },
      toPage() {
        this.page = this.model.currentPage;
        this.model.itemsPerPage = this.model.selection.selected;
        util.call(this.model);
      },
      initPageAndQuery() {
        this.initPage();
        util.call(this.model);
      }
    },
    components: {
      selection: selection
    }
  }
</script>

<style>
  li {
    float: left;
    list-style: none
  }

  li a {
    text-decoration: none
  }

  input {
    width: 20px;
  }
</style>
