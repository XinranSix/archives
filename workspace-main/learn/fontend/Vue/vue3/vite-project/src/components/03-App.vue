<template>
  <div>
    <p>{{ objRef.num }}</p>
    <button @click="objRef.num++">按钮1</button>
    <button @click="hdClick">按钮2</button>
  </div>
</template>

<script lang="ts">
import {defineComponent, ref, Ref} from 'vue'

export default defineComponent({
  setup() {
    let obj = {
      num: 30
    }
    type ObjType = {
      num: number
    }
    const hdClick = () => {
      objRef.value.num += 5
    }
    let objRef: Ref<ObjType> = ref(obj)
    // console.log(objRef)
    return {
      objRef,
      hdClick
    }
  }
})
</script>

<style scoped>

</style>
