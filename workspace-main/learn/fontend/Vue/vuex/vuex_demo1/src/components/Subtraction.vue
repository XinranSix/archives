<template>
  <div>
<!--    <h3>当前最新的 count 值为：{{ count }}</h3>-->
    <h3>当前最新的 count 值为：{{ showNum }}</h3>
    <button @click="btnHandler1">-1</button>
    <button @click="btnHandler2">-n</button>
    <button @click="btnHandler3">-1 Async</button>
    <button @click="btnHandler4">-n Async</button>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'

export default {
  name: 'Subtraction',
  data () {
    return {}
  },
  methods: {
    ...mapMutations(['sub', 'subN']),
    ...mapActions(['subAsync', 'subNAsync']),
    btnHandler1 () {
      this.sub()
    },
    btnHandler2 () {
      this.subN(3)
    },
    btnHandler3 () {
      this.subAsync()
    },
    btnHandler4 () {
      this.subNAsync(3)
    }
  },
  computed: {
    ...mapState(['count']),
    ...mapGetters(['showNum'])
  }
}
</script>

<style scoped>

</style>
