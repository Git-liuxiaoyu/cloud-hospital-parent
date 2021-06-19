// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

import router from './router'

/* 引入ElementUI - START */
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

/* 引入滑动验证 - START */
import SlideVerify from 'vue-monoplasty-slide-verify';
Vue.use(SlideVerify);

/** 引入 axios - START */
import axios from 'axios'
/* axios的第二个问题：每个组件内部都要引入axios  ，每个组件其实也是一个vue实例 */
Vue.prototype.$axios = axios

/* axios的第一个问题： 每次请求都要添加基准路径 */
axios.defaults.baseURL = 'http://localhost:9999/'


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
