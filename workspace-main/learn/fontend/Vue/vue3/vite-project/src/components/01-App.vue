<template>
  <div>
    <p>这是第一个组件</p>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, onBeforeMount, onBeforeUpdate, onUpdated} from 'vue'

export default defineComponent({
  setup() {
    console.log('执行了 setup')

    onBeforeMount(() => {
      console.log('执行了 onBeforeMount')
    })

    onMounted(() => {
      console.log('执行了 onMounted')
    })
  }
})
</script>

<style scoped>

</style>
