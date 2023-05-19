<template>
  <div>
    <p>{{ objRet.num }}</p>
  </div>
</template>

<script>
import {defineComponent, reactive, ref} from 'vue'

export default defineComponent({
  setup() {
    let obj = {
      num: 20
    }
    let objRet = reactive(obj)
    console.log(objRet)
    console.log(objRet.num)
    return {
      objRet
    }
  }
})
</script>

<style scoped>

</style>
