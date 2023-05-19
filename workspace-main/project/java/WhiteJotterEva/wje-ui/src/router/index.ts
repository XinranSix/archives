import {createRouter, createWebHashHistory, RouteRecordRaw, Router} from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/Login.vue'),
    },
    {
        path: '/index',
        name: 'Index',
        component: () => import('@/views/Index.vue'),
    },
]

const router: Router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
