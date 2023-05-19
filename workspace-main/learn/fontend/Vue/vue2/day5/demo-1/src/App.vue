<template>
  <div class="app-container">
    <h1 ref="myh1">App 根组件</h1>
    <button @click="showThis">打印 this</button>
    <button @click="onReset">重置 Left 组件的 count 值为 0</button>
    <hr/>

    <input type="text" v-if="inputVisible" @blur="showButton" ref="iptRef">
    <button v-else @click="showInput">展示输入框</button>

    <hr/>
    <div class="box">
      <!-- 渲染 Left 组件和 Right 组件 -->
      <Left ref="comLeft"></Left>
    </div>
  </div>
</template>

<script>
import Left from '@/components/Left.vue'

export default {
  components: {
    Left
  },
  data() {
    return {
      inputVisible: false
    }
  },
  methods: {
    showThis() {
      console.log(this)
      this.$refs.myh1.style.color = 'red'
    },
    onReset() {
      this.$refs.comLeft.resetCount()
    },
    showInput() {
      this.inputVisible = true
      this.$nextTick(() => {
        this.$refs.iptRef.focus()
      })
    },
    showButton() {
      this.inputVisible = false
    }
  },
  // updated() {
  //   this.$refs.iptRef.focus()
  // }
}
</script>

<style lang="less">
.app-container {
  padding: 1px 20px 20px;
  background-color: #efefef;
}

.box {
  display: flex;
}
</style>
