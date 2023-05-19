<template>
  <div>这是子组件</div>
  <slot name="btn" title="哈哈" :myNum="num"></slot>
  <slot name="link"></slot>
</template>

<script setup lang="ts">
import {ref} from 'vue'

let num = ref(30)
</script>

<style scoped>

</style>
