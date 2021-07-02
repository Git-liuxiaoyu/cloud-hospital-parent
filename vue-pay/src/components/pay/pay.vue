
<template>

    <div align="center" id="div1">
     
         <el-container>

        <el-header>
            <div id="div2">
                 <a href="#" @click="returnindex()">
                <i class="el-icon-d-arrow-left" style="margin-left:5px"></i>
                </a>
            </div>
           
            <font class="font1">武汉第一人民医院取药支付窗口&nbsp;&nbsp;
                <i class="el-icon-s-ticket"></i>
            </font>
        </el-header>
            <el-main>
                <el-input
                    type="text"
                    placeholder="请输入4位药房取药码完成支付"
                    v-model="num"
                    @input="num=num.replace(/[^\d]/g,'')"
                    maxlength="4"
                    show-word-limit style="width:50%" >
                 <template slot="prepend">YF</template>
                </el-input>

                <br/>
                <br/>
                <el-button type="success" plain @click="pay()" id="button1">支付宝付款</el-button>
            </el-main>
            <el-footer><font class="font1">版权所有&copy; XXX医院</font></el-footer>
        </el-container>


        <!-- 取票成功显示票务信息 -->


        
    </div>

    


</template>

<script>
import axios from 'axios';
export default { 
       data(){
            return {
                num:"",
                getNumberOk: true,
                takeNumber:[{
                    id:"",
                    regId:"",
                    departmentId:"",
                    roomName:"",
                    orderNum:"",
                    createTime:"",
                    status:"",
                }]
            }
           
        },
        methods:{
            pay(){//取票

            var no = "YF"+this.num;
            location.href="http://localhost:6003/pharmacy/pay/"+no;

            },   
        }

}

</script>
<style>

  .el-main {
       background-image: url('../image/bg.jpeg');
      background-size:cover;

    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 75%;
  }

#div1{
    height: 100%;
}

#div2{
    width: 50px;
    height: 50px;
    float: left;
}
  .el-header {
    background-color: #B3C0D1;
    color: cyan;
    /* text-align: center; */
    font-size: 35px;
    font-family: "楷体";
    line-height: 15%;
    padding-top: 15px;

  }
  
.el-footer {
    background-color: #B3C0D1;
    color: black;
    text-align: center;
    font-size: 18px;
    font-family: "宋体";
    line-height: 15%;
    padding-top: 28px;


  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 75%;
  }
  .el-container{ 
    height: 753px;
  }
  .el-input{
      margin-top: 200px;
  }

  #button1{
      font-family: "楷体";
      font-size: 25px;
      width: 200px;
      height: 60px;
  }

  /*=============取票成功右侧弹出框开始===================*/

  
  /*内容*/
  .el-notification__content{
      text-align: left;
      color: aquamarine;
      font-size: 20px;
  }

/*标题*/
  .el-notification__title{
        text-align: center;
        font-size: 25px;
        color: aquamarine;
  }
  /*div*/
  .el-notification__group{
        width: 100%;
  }
   /*=============取票成功右侧弹出框结束===================*/

</style>
