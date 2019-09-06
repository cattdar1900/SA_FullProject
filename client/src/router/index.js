import Vue from 'vue'
import Router from 'vue-router';
import PostPatient from '../components/PostPatient';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: PostPatient
        }
        
    ]
});