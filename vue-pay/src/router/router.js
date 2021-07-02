import VueRouter from "vue-router";
import Vue from "vue";


import index from "../components/pay/pay.vue"

Vue.use(VueRouter)

const router = new VueRouter({

    routes:[
        {path:"/",redirect:"/index"},
        {path:"/index",component:index},
    ]

})


//导出路由对象
export default router

// //路由守卫 
// router.beforeEach((to,from,next)=>{
//     //to   参数  目的地
//     //from  从哪里来
//     //next 放行，去哪里
//     if(to.path === '/login'){
//         next()
//     }else{
//         var token = localStorage.getItem("token");
//         token?next:next('/login')
//     }

// })