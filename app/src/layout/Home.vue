<template>
  <div>
    <h1>{{title}}</h1>
    <div>
      <my-menu></my-menu>
    </div>
  </div>
</template>

<script>
  import myMenu from '../components/Menu'
  export default {
    name: 'home',
    data() {
      return {
        title: '首页'
      }
    },
    components: {myMenu: myMenu}
  }
</script>

<style></style>
