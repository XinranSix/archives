import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "@/components/Login.vue"
import AppIndex from "@/components/home/AppIndex.vue"
import Home from "@/components/Home.vue";
import LibraryIndex from "@/components/library/LibraryIndex.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/home',
        name: 'Home',
        component: Home,
        redirect: '/index',
        children: [
            {
                path: '/index',
                name: 'AppIndex',
                component: AppIndex,
                meta: {
                    requireAuth: true
                }
            },
            {
                path: '/library',
                name: 'Library',
                component: LibraryIndex,
                meta: {
                    requireAuth: true
                }
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router
