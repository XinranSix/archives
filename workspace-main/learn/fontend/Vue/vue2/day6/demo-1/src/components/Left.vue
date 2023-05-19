<template>
  <div class="left-container">
    <h3>Left 组件 --- {{ count }}</h3>
    <button @click="count++">+1</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      count: 0
    }
  },
  deactivated() {
    console.log('组件被缓存了')
  },
  activated() {
    console.log('组件被激活了')
  }
}
</script>

<style lang="less">
.left-container {
  padding: 0 20px 20px;
  background-color: orange;
  min-height: 250px;
  flex: 1;
}
</style>
