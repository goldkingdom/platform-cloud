<template xmlns:v-bind="http://www.w3.org/1999/xhtml">
  <div>
    <select v-model="model.selected">
      <option v-for="option in model.options" v-bind:value="option.value">
        {{option.text}}
      </option>
      <span>Selected:{{model.selected}}</span>
    </select>
  </div>
</template>

<script>
  export default {
    props: ['model'],
    methods: {}
  }
</script>

<style></style>
