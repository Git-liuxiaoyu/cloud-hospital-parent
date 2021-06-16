import Vue from 'vue'
import Router from 'vue-router'
/* 后台登录 Vue */
import Login from '@/components/login/Login.vue'

import xxx from '@/components/login/xxx.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/xxx',
      name: 'xxx',
      component: xxx
    }
  ]
})
