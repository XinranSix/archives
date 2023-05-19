<template>
  <div>
    <p>{{ objRet.num }}</p>
    <button @click="hdClick">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs} from 'vue'

let obj = {
  num: 30
}
let objRet = reactive<typeof obj>(obj)

let {num} = toRefs<typeof obj>(objRet)

const hdClick = () => {
  num.value++
}
</script>

<style scoped>

</style>
