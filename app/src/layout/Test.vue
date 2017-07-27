<template>
  <div>
    <div style="float: right;">
      <grid :model="gridModel"></grid>
    </div>
    <div>
      <pagination :model="paginationModel"></pagination>
    </div>
  </div>
</template>

<script>
  import pagination from '../components/Pagination'
  import grid from '../components/Grid'

  export default {
    data() {
      return {
        gridModel: undefined,
        paginationModel: undefined
      }
    },
    created() {
      this.init();
    },
    methods: {
      init: function () {
        this.gridModel = {
          headList: [
            {key: 'id', name: '编号', type: 'Long'},
            {key: 'name', name: '姓名', type: 'String'},
            {key: 'age', name: '年龄', type: 'Integer'},
            {name: '操作', type: 'Operation'}
          ],
          bodyList: [
            {id: 1, name: 'jack', age: 18},
            {id: 2, name: 'mike', age: 19}
          ],
          operationList: [
            {
              name: '新增',
              fn(item) {
                alert(JSON.stringify(item));
              }
            },
            {
              name: '删除',
              fn(item) {
                alert(JSON.stringify(item));
              }
            },
            {
              name: '修改',
              fn(item) {
                alert(JSON.stringify(item));
              }
            }
          ],
          checkFlag: true,
          allChecked: false
        };
        this.paginationModel = {
          currentPage: 1,
          totalItems: 80,
          totalPages: 8,
          itemsPerPage: 10,
          error: false,
          selection: {
            selected: 10,
            options: [
              {text: '10', value: 10},
              {text: '20', value: 20},
              {text: '50', value: 50}
            ]
          }
        };
      }
    },
    components: {
      pagination: pagination,
      grid: grid
    }
  }
</script>

<style></style>
