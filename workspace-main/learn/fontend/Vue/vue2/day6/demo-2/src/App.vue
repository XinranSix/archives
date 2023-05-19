<template>
  <div class="app-container">
    <h1 v-color="color">App 根组件</h1>
    <button @click="color='green'">改变 color 颜色</button>
    <hr/>
    <Article>
      <template #title>
        <h3>一首诗</h3>
      </template>

      <template #content="{msg, user}">
        <div>
          <p>啊，大海，全是水。</p>
          <p>啊，蜈蚣，全是腿</p>
          <p>啊，辣椒，净辣嘴</p>
          <p>{{ msg }}</p>
          <p>{{ user }}</p>
        </div>
      </template>

      <template #author>
        <div>作者：xxx</div>
      </template>
    </Article>
    <hr/>
    <div class="box" style="display: none">
      <!-- 渲染 Left 组件和 Right 组件 -->
      <Left>
        <template #default>
          <p>这是在 Left 的内容区域，声明的 p 标签</p>
        </template>
      </Left>
    </div>
  </div>
</template>

<script>
import Left from "@/components/Left.vue"
import Article from "@/components/Article.vue";

export default {
  data() {
    return {
      userinfo: {
        name: 'zs',
        age: 20
      },
      color: 'blue'
    }
  },
  components: {
    Left,
    Article
  },
  directives: {
    color(el, binding) {
      el.style.color = binding.value
    }
  }
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
