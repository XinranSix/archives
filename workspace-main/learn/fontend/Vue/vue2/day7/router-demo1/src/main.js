import Vue from 'vue'
import App from './App2.vue'

// 导入 bootstrap 样式
import 'bootstrap/dist/css/bootstrap.min.css'
// 全局样式
import '@/assets/global.css'
import router from '@/router'

Vue.config.productionTip = false

new Vue({
    render: h => h(App),
    router
}).$mount('#app')
