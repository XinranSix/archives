import VueRouter from 'vue-router'

import Vue from 'vue'
import Home from '@/components/Home.vue'
import Movie from "@/components/Movie.vue";
import About from "@/components/About.vue";
import Tab1 from "@/components/tabs/Tab1.vue"
import Tab2 from "@/components/tabs/Tab2.vue"
import Login from "@/components/Login.vue";
import Main from "@/components/Main.vue";

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [
        {path: '/', redirect: '/home'},
        {path: '/home', component: Home},
        {path: '/movie/:id', component: Movie, props: true},
        {
            path: '/about', component: About, children: [
                {path: '', component: Tab1},
                // {path: 'tab1', component: Tab1},
                {path: 'tab2', component: Tab2}
            ]
        },
        {path: '/login', component: Login},
        {path: '/main', component: Main}
    ]
})

router.beforeEach((to, from, next) => {
    if (to.path === '/main') {
        const token = localStorage.getItem('token')
        if (token) {
            next()
        } else {
            next('/login')
        }
    } else {
        next()
    }
})

export default router
