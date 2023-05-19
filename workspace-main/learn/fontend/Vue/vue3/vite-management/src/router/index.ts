import {createRouter, createWebHashHistory, Router, RouteRecordRaw} from 'vue-router'
import {App} from 'vue'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/login/login.vue')
    }
]

const router: Router = createRouter({
    history: createWebHashHistory(),
    routes
})

export const initRouter = (app: App<Element>) => {
    app.use(router)
}
