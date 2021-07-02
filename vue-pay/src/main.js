import Vue from 'vue'
import App from './App'

// 在main.js 中引入
// 引入 element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/commons.css'

Vue.use(ElementUI)

//引入路由对象
import router from './router/router.js'


Vue.config.productionTip=false
/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { 
    App:App,   
  },
  router,
  template: '<App/>'
})
