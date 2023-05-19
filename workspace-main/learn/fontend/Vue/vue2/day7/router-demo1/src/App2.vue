<template>
  <div class="app-container">
    <h1>App2 组件</h1>
    <!--    <a href="#/home">首页</a>-->
    <!--    <a href="#/movie">电影</a>-->
    <!--    <a href="#/about">关于</a>-->
    <router-link to="/home">首页</router-link>
    <router-link to="/movie/1">洛基</router-link>
    <router-link to="/movie/2">雷神</router-link>
    <router-link to="/movie/3">复联</router-link>
    <router-link to="/about">关于</router-link>
    <hr/>

    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="less" scoped>
.app-container {
  background-color: #efefef;
  overflow: hidden;
  margin: 10px;
  padding: 15px;

  > a {
    margin-right: 10px;
  }
}
</style>
