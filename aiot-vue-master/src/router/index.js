import Vue from 'vue'
import VueRouter from 'vue-router'
import home from '../views/home.vue'
import statistics from "../views/statistics";
import equipments from "../views/equipments";
import users from "../views/users";
import tableView from "../components/tables/data-table"
import chartView from "../components/tables/chart-table"

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/home'
    }, {
        path: '/home',
        name: 'home',
        component: home
    }, {
        path: '/statistics',
        redirect: '/statistics/table-view'
    }, {
        path: '/statistics',
        name: 'statistics',
        component: statistics,
        children: [
            {
                path: 'chart-view',
                name: 'chartView',
                component: chartView
            }, {
                path: 'table-view',
                name: 'tableView',
                component: tableView
            }
        ]
    }, {
        path: '/equipments',
        name: 'equipments',
        component: equipments
    }, {
        path: '/users',
        name: 'users',
        component: users
    }
]

const router = new VueRouter({
    mode: "history",
    routes
})

export default router
