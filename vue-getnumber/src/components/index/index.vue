<template>
    <div align = "center" id = "div1">
        <el-container>
            <!-- <el-header><font class="font1">某某医院取票机欢迎您&nbsp;&nbsp;<i class="el-icon-s-ticket"></i></font></el-header> -->
            <el-main>
               
                <table style="height:100%;width: 100%;">
                    <tr id = "tr1">            
                        <td class="td1"><el-button @click="goregistration()">挂号取票</el-button></td>
                        <td class="td1"><el-button  @click="gopharmacy()">药房取票</el-button></td>
                        <td class="td1"><el-button @click="goexamine() ">检查取票</el-button></td>
                    </tr>
                </table>      
            </el-main>
            <!-- <el-footer><font class="font1">尾部</font></el-footer> -->
        </el-container>

  </div>  
  
</template>

<script>
import axios from 'axios';
export default { 
        data(){
            return{

            }
            

        },
        methods:{
            goregistration(){
               this.$router.push("/goregistration"); 
            },
            gopharmacy(){
                this.$router.push("/gopharmacy"); 
            },
            goexamine(){
                this.$router.push("/goexamine");
            }

        },
        created:function(){
            
        }
}

</script>

<style scoped>

#div1{
    height: 100%;
}
  /* .el-header {
    background-color:black;
    color:azure;
    text-align: center;
    font-size: 35px;
    font-family: "微软雅黑";
    line-height: 15%;
    padding-top: 15px;

  }
  
.el-footer {
    background-color: #B3C0D1;
    color: cyan;
    text-align: center;
    font-size: 35px;
    font-family: "楷体";
    line-height: 15%;
    padding-top: 28px;

  } */

  .el-main {
       background-image: url('../image/001.jpg');
      background-size:cover;

    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 75%;
  }
  .el-container{ 
    height: 753px;
  }

  .el-button{
    background-color:lavender;
    color:deepskyblue;
    font-family: "楷体";
    font-size: 25px;
    opacity:0.8;
    height: 150px;
    width: 200px;
  }
  #tr1{
    margin-top:13%;
    width: 100%;

  }

  .td{
      width: 30%;
  }
</style>

