// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

import router from './router'

/* 引入ElementUI - START */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

/* 引入滑动模块验证 - START */
import SlideVerify from 'vue-monoplasty-slide-verify';
Vue.use(SlideVerify);

/* 引入滑动验证 */
import VueSimpleVerify from 'vue-simple-verify'
import '../node_modules/vue-simple-verify/dist/vue-simple-verify.css'

Vue.component('vue-simple-verify', VueSimpleVerify)

/** 引入 axios - START */
import axios from 'axios'
/* axios的第二个问题：每个组件内部都要引入axios  ，每个组件其实也是一个vue实例 */
Vue.prototype.$axios = axios

/* axios的第一个问题： 每次请求都要添加基准路径 */
axios.defaults.baseURL = 'http://localhost:9999/'

/* 每次都要添加 token */
axios.interceptors.request.use(
  function (config) {
    config.headers.BackLOginedToken = localStorage.getItem('BackLoginedToken')
    return config
  },
  function (error) {
    // Do something with request error
    return Promise.reject(error)
  }
)

Vue.config.productionTip = false

/* 定义全局过滤器 */
Vue.filter('dateConverter', function (input, pattern = '') { /* 'dateConverter'为过滤器名 */
  if (input === '-') {
    return '-'
  }

  /* 【input】是使用管道符|左边的值，自动传入；【pattern = ""】表示pattern未传值则默认值为"" */
  /* 转换为日期对象 */
  var dt = new Date(input)

  /* 获得年月日 */
  var y = dt.getFullYear()
  var m = (dt.getMonth() + 1).toString().padStart(2, '0')
  var d = dt.getDate().toString().padStart(2, '0')

  /* 如果传递进来的字符串类型，转为小写之后，等于 yyyy-mm-dd，那么就返回 年-月-日 */
  /* 否则，就返回  年-月-日 时：分：秒 */
  if (pattern.toLowerCase() === 'yyyy-mm-dd') {
    return `${y}-${m}-${d}`
  } else {
    /* 获得时分秒 */
    var hh = dt.getHours().toString().padStart(2, '0')
    var mm = dt.getMinutes().toString().padStart(2, '0')
    var ss = dt.getSeconds().toString().padStart(2, '0')

    return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
