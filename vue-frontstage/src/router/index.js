import Vue from 'vue'
import Router from 'vue-router'

// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

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
