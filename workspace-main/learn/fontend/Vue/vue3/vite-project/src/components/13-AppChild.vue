<template>
  <div>
    {{ num }}
    <button @click="hdClick">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {defineProps, defineEmits} from 'vue'

let props = defineProps({
  num: {
    type: Number,
    default: 100
  }
})

let n = props.num

const emit = defineEmits<{
  (event: 'update:num', n: number): void
}>()

const hdClick = () => {
  n++
  emit('update:num', n++)
}
</script>

<style scoped>

</style>
