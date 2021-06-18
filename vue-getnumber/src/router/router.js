import VueRouter from "vue-router";
import Vue from "vue";


import registration from "../components/registration/registration.vue"
import index from "../components/index/index.vue"
import pharmacy from "../components/pharmacy/pharmacy.vue"
import examine from "../components/examine/examine.vue"

Vue.use(VueRouter)

const router = new VueRouter({

    routes:[
        {path:"/",redirect:"/index"},

        {path:"/goregistration",component:registration},
        {path:"/index",component:index},
        {path:"/gopharmacy",component:pharmacy},
        {path:"/goexamine",component:examine},
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