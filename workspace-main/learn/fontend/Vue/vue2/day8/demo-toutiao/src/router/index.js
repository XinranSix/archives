import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home/MyHome.vue'
import User from '@/views/MyUser/User.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    components: Home
  },
  {
    path: '/user',
    components: User
  }
]

const router = new VueRouter({
  routes
})

export default router
