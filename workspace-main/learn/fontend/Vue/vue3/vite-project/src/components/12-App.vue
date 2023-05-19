<template>
  <div>
    <input type="checkbox" v-model="checkAll"> 全选/全不选
    <ul>
      <li v-for="(item, index) in states.length" :key="item">
        <input type="checkbox" v-model="states[index]"/>
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import {ref, toRefs, reactive, computed} from 'vue'

let {states} = toRefs(reactive({
  states: [false, false, false, false, false, false, false, false]
}))

let checkAll = computed({
  get() {
    return states.value.every(item => item)
  },
  set(newValue) {
    states.value = states.value.map(() => newValue)
  }
})
</script>

<style scoped>

</style>
