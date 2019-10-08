import Vue from 'vue'
import Router from 'vue-router';
import PostPatient from '../components/PostPatient';
import Login from '../components/Login.vue';
import home from '../components/home.vue';
import Appointment from '../components/Appointment.vue';
import Discharge from '../components/Discharge.vue';
import DischargesData from '../components/DischargesData.vue';
import Examination from "../components/ExaminationSystem.vue";
import Reservation from "../components/HelloWorld.vue";
import PostPayment from "../components/PostPayment.vue";
import Bill from "../components/Bill.vue";
import Bills from "../components/Bills.vue";

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
            },
            {
                path: '/appointment',
                component: Appointment
                },
        {
            path: '/discharge',
            component: Discharge
        },
        {
            path: '/dischargeData',
            component: DischargesData
        },
        {
            path: '/examination',
            component: Examination
        },
        {
            path: '/reservation',
            component: Reservation
        },
        {
            path: '/postPayment',
            component: PostPayment
        },
        {
            path: '/bill/:id',
            component: Bill
        },
        {
            path: '/bills/:id',
            component: Bills
        }
    ]
    
});