<template>
  <div>
    <p>{{ num }}</p>
    <button @click="num++">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs, Ref} from 'vue'

let obj = {
  num: 20
}
let objRet = reactive(obj)
let {num} = toRefs(objRet)
</script>

<style scoped>

</style>
