import Vue from 'vue'
import App from './App'
import router from './router'

//element-ui组件导入
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

import axios from "axios";
axios.defaults.baseURL = window.global_url.Base_url;
Vue.prototype.$axios = axios

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
