<template>
  <div>
    <p>{{ num }}</p>
    <button @click="hdClick">{{ num }}</button>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref, Ref} from 'vue'

export default defineComponent({
  setup() {
    let num: Ref<number> = ref(20)
    console.log(num.value)
    let hdClick = () => {
      num.value++
      console.log(num)
    }
    return {
      num, hdClick
    }
  }
})
</script>

<style scoped>

</style>
