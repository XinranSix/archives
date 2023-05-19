<template>
  <div>
    <p ref="op">这是一个 p 标签</p>
  </div>
</template>

<script>
import {defineComponent, ref, onMounted, nextTick} from 'vue'

export default defineComponent({
  setup() {
    let op = ref()

    // onMounted(() => {
    //   console.log(op)
    // })
    nextTick(() => {
      console.log(op)
    })
    return {
      op
    }
  }
})
</script>

<style scoped>

</style>
