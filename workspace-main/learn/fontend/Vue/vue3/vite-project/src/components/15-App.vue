<template>
  <div>
    <Table :arr="state.arr">
      <template #btns="{index}">
        <button @click="hdClick(index)">编辑</button>
      </template>
    </Table>
    <Table :arr="state.arr">
      <template #btns>
        <button>编辑</button>
        <button>删除</button>
      </template>
    </Table>
  </div>
</template>

<script setup lang="ts">
import {reactive} from 'vue'
import Table from './15-AppChild.vue'

let state = reactive({
  arr: [{
    name: '小明',
    age: 28
  }, {
    name: '小红',
    age: 20
  }]
})

const hdClick = (index: number) => {
  console.log(state.arr[index])
}
</script>

<style scoped>

</style>
