<template>
  <div>
    <p>{{ arr[0] }}</p>
    <p>{{ arr }}</p>
    <button @click="hdClick">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {reactive} from 'vue'

let arr = reactive([10, 20, 30])

const hdClick = () => {
  arr[0] = 100
}
</script>

<style scoped lang="less">

</style>
