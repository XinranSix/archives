<template>
  <div class="app-container">
    <Header title="购物车案例"></Header>
    <!--    <p>{{ amt }}</p>-->
    <Goods
        v-for="item in list"
        :key="item.id"
        :id="item.id"
        :title="item.goods_name"
        :pic="item.goods_img"
        :price="item.goods_price"
        :state="item.goods_state"
        :count="item.goods_count"
        @state-change="getNewState"
    ></Goods>
    <Footer :isFull="fullState" :amount="amt" :all="total" @full-change="getFullState"></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header/Header.vue";
import Footer from "@/components/Footer/Footer.vue";
import Goods from "@/components/Goods/Goods.vue";
import axios from "axios";
import bus from "@/components/eventBus"

export default {
  data() {
    return {
      list: []
    }
  },
  methods: {
    // 请求列表数据的方法
    async initCartList() {
      const {data: res} = await axios.get('https://www.escook.cn/api/cart')
      if (res.status === 200) {
        this.list = res.list
      }
    },
    getNewState(e) {
      this.list.some(item => {
        if (item.id === e.id) {
          item.goods_state = e.value
          return true
        }
      })
    },
    getFullState(e) {
      this.list.forEach(item => {
        item.goods_state = e
      })
    }
  },
  computed: {
    fullState() {
      return this.list.every(item => item.goods_state)
    },
    amt() {
      return this.list.filter(item => item.goods_state).reduce((total, item) => {
        return total += item.goods_price * item.goods_count
      }, 0)
    },
    total() {
      return this.list.filter(item => item.goods_state).reduce((t, item) => {
        return t += item.goods_count
      }, 0)
    }
  },
  components: {
    Header, Footer, Goods
  },
  created() {
    this.initCartList()
    bus.$on('share', (val) => {
      this.list.some(item => {
        if (item.id === val.id) {
          item.goods_count = val.value
          return true
        }
      })
    })
  }
}
</script>

<style lang="less" scoped>
.app-container {
  padding-top: 45px;
  padding-bottom: 50px;
}
</style>
