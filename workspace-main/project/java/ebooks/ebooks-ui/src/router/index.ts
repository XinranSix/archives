import {
    createRouter,
    createWebHashHistory,
    RouteRecordRaw,
    Router,
    createWebHistory
} from "vue-router";

const routes: Array<RouteRecordRaw> = [
    {
        path: "/login",
        name: "Login",
        component: () =>
            import(/* webpackChunkName: "About" */ "../views/login/Login.vue"),
    },
];

const router: Router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
