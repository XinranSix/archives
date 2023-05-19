<template>
  <div>
    <Child :num="num" @fn="chanNum"></Child>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import Child from './11-AppChild.vue'

let num = ref(20)

const chanNum = () => {
  num.value++
}
</script>

<style scoped>

</style>
