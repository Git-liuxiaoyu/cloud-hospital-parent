import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/', redirect: '/login'
    },
    {
      path: '/login',
      component: () => import('@/components/login/login.vue'),
    },
    {
      path: '/index',
      component: () => import('@/components/index/index.vue'),
      children: [
        {
          path: '/register',
          component: () => import('@/components/register/register.vue'),
        },
        {
          path: '/registerRecord',
          component: () => import('@/components/registerRecord/registerRecord.vue'),
        }
      ]
    },
  ]
})
