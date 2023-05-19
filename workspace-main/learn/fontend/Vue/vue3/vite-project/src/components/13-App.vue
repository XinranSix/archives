<template>
  <div>
    <Child v-model:num="num"></Child>
  </div>
</template>

<script setup lang="ts">
import {reactive, toRefs} from 'vue'
import Child from '@/components/13-AppChild.vue'

let {num} = toRefs(reactive({
  num: 20
}))
</script>

<style scoped>

</style>
