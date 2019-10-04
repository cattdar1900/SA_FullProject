import Vue from 'vue'
import Router from 'vue-router';
import PostPatient from '../components/PostPatient';
import Login from '../components/Login.vue';
import home from '../components/home.vue';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/patient',
            component: PostPatient
        },{
        path: '/',
        component: Login
        },
        {
            path: '/home',
            component: home
            }
    ]
});