import Vue from 'vue'
import App from './App'
import router from './router'

//element-ui组件导入
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";


Vue.use(ElementUI);

axios.defaults.baseURL = window.global_url.Base_url;
Vue.prototype.$axios = axios

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})

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

/* 定义全局过滤器 */
Vue.filter('timeConverter', function (input) { /* 'dateConverter'为过滤器名 */
  /* 【input】是使用管道符|左边的值，自动传入；【pattern = ""】表示pattern未传值则默认值为"" */
  /* 转换为日期对象 */
  var dt = new Date(input)

  /* 获得时分秒 */
  var mm = dt.getMinutes().toString().padStart(2, '0')
  var ss = dt.getSeconds().toString().padStart(2, '0')

  return `${mm}:${ss}`

})
