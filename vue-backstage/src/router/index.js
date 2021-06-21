import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    /** 组件 - 登录  - 张方松 */
    {
      path: '/',
      name: 'login',
      component: () => import('@/components/login/Login.vue')
    },
    /** 组件 - 首页 */
    {
      path: '/home',
      component: () => import('@/components/home/home.vue'),
      children: [
        {
          path: '/doctor/rota',
          name: 'doctor-rota',
          component: () => import('@/components/doctor-rota/DoctorRota.vue')
        }
      ]
    }
  ]
})
