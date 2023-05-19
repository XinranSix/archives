<template>
  <div>
    <p>{{ num }}</p>
    <button @click="num++">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs, Ref, watch} from 'vue'

// let num: Ref<number> = ref(20)

// watch(num, (newVal, oldValue) => {
//   console.log(newVal, oldValue)
// })

let obj = {
  num: 30
}

let objRet = reactive(obj)
let {num} = toRefs(objRet)

watch(num, (newValue, oldValue) => {
  console.log(newValue, oldValue)
})
</script>

<style lang="less" scoped>

</style>
