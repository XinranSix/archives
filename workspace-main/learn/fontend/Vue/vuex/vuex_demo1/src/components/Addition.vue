<template>
  <div>
<!--    <h3>当前最新的 count 值为：{{ $store.state.count }}</h3>-->
    <h3>当前最新的 count 值为：{{ $store.getters.showNum }}</h3>
    <button @click="btnHandler1">+1</button>
    <button @click="btnHandler2">+n</button>
    <button @click="btnHandler3">+1 Async</button>
    <button @click="btnHandler4">+n Async</button>
  </div>
</template>

<script>
export default {
  name: 'Addition',
  data () {
    return {}
  },
  methods: {
    btnHandler1 () {
      this.$store.commit('add')
    },
    btnHandler2 () {
      this.$store.commit('addN', 3)
    },
    btnHandler3 () {
      this.$store.dispatch('addAsync')
    },
    btnHandler4 () {
      this.$store.dispatch('addNAsync', 3)
    }
  }
}
</script>

<style scoped>

</style>
