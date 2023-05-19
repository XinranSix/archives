<template>
  <div>
    <p>这是子组件 {{ num }}</p>
    <button @click="hdClick">按钮</button>
  </div>
</template>

<script setup lang="ts">
import {defineProps, defineEmits} from 'vue'

defineProps({
  num: {
    type: Number,
    default: 30
  }
})

const emit = defineEmits<{
  (event: 'fn'): void
}>()

const hdClick = () => {
  emit('fn')
}
</script>

<style scoped>

</style>
