<template>
  <div>
    <p>{{ doubleNum }}</p>
    <button @click="num++">按钮</button>
    <p>{{ dbNum2 }}</p>
    <button @click="objRet.num++">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs, computed} from 'vue'

let num = ref(20)

let doubleNum = computed(() => {
  return num.value * 2
})

let obj = {
  num: 30
}

let objRet = reactive(obj)

let dbNum2 = computed(() => {
  return objRet.num * 2
})

computed({
  get() {
  },
  set() {
  }
})
</script>

<style scoped>

</style>
