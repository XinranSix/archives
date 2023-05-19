import {createApp} from 'vue'
// import './style.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import {store, key} from "./store"

const app = createApp(App)
app.use(ElementPlus)
app.use(router)
app.use(store, key)
app.mount('#app')
