<template>
  <div>
    <p>{{ objRet.num }}</p>
    <button @click="objRet.num++">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs, Ref, watch, watchEffect} from 'vue'

// let num: Ref<number> = ref(20)

// watch(num, (newVal, oldValue) => {
//   console.log(newVal, oldValue)
// })

let obj = {
  num: 50
}

let objRet = reactive(obj)
// let {num} = toRefs(objRet)

// watch(() => objRet.num, (newValue, oldValue) => {
//   console.log(newValue, oldValue)
// })

// watch([() => objRet.num], (newValue, oldValue) => {
//   console.log(newValue, oldValue)
// }, {
//   immediate:true
// })

watchEffect(() => {
  console.log(objRet.num)
})
</script>

<style lang="less" scoped>

</style>
