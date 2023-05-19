<template>
  <div>
    <Child>
      <template #link>
        <a href="#">a 标签11</a>
      </template>
      <template #btn="scope">
        <button>按钮22 {{scope.myNum}}</button>
      </template>
    </Child>
  </div>
</template>

<script setup lang="ts">
import {} from 'vue'
import Child from './14-AppChild.vue'

</script>

<style scoped>

</style>
