<template>
    <div align = "center">

        <button @click="gocall()" style="width:70px">添加</button>
        <table border="1" cellspacing="0" cellpadding="15px" style="text-align:center">
            <tr >
                <td>编号</td>
                <td>姓名</td>
                <td>生日</td>
                <td>性别</td>
                <td>职业</td>
                <td>住所</td>
                <td>电话</td>
                <td>操作</td>
            </tr>
            <tr v-for="user in users" :key="user.id">
                <!--        <tr>-->
                <td>{{user.id}}</td>
                <td>{{user.name}}</td>
                <td>{{user.birthday}}</td>
                <td>{{ user.gender == '0' ? '男' : '女' }}</td>
                <td>{{user.career}}</td>
                <td>{{user.address}}</td>
                <td>{{user.mobile}}</td>
                <td>
                    <el-button type="button" @click="goupdate(user.id)">修改</el-button>
                    <button @click="findbyid(user.id)" >详细</button>
                </td>
            </tr>
            <!-- 分页 开始 -->
        </table>  

  </div>  
  
</template>

<script>
import axios from 'axios';
export default { 
        data(){
            return{
                users:[

                ],
            }
            

        },
        methods:{
           userlist(){

                axios.get("http://localhost:8888/user/list").then(r => {  

                    this.users = r.data;  
                    
                       
                });
            },


            goupdate(id) {              
                this.$router.push({path:'goupdate',query:{id:id}})
            },
            //进入详情页面
            findbyid(id){
                this.$router.push({path:'gofindbyid',query:{id:id}})
            },

            gocall(){     
                this.$router.push("/gocall");
            },

        },
        created:function(){
            this.userlist()
        }
}

</script>

<style scoped>

</style>

