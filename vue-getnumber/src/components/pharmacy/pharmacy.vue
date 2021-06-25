
<template>

    <div align="center" id="div1">
     
         <el-container>

        <el-header>
            <div id="div2">
                 <a href="#" @click="returnindex()">
                <i class="el-icon-d-arrow-left" style="margin-left:5px"></i>
                </a>
            </div>
           
            <font class="font1">XXX医院药房取票&nbsp;&nbsp;
                <i class="el-icon-s-ticket"></i>
            </font>
        </el-header>
            <el-main>
                <el-input
                    type="text"
                    placeholder="请输入4位取票码"
                    v-model="num"
                    @input="num=num.replace(/[^\d]/g,'')"
                    maxlength="4"
                    show-word-limit style="width:50%" >
                 <template slot="prepend">YF</template>
                </el-input>

                <br/>
                <br/>
                <el-button type="success" plain @click="getnumber()" id="button1">取&nbsp;&nbsp;票</el-button>
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
            getnumber(){//取票
                var no = "YF"+this.num;

               axios.get("http://localhost:6001/YFproof/findbyno/"+no).then(r => {  
                    var msg = r.data.msg;
                   console.log(r)
                   var num1 = this.num;
                   if(num1 == null){
                       num1 = "null";
                   }
                   

                   if(r.data.code != 200){//取票失败
                      this.$alert('<font>'+msg+'</font><br/><font>取票号：'+this.num+'，请认真核对号码，或寻求工作人员帮助</font>', '取票失败', {
                        dangerouslyUseHTMLString: true
                        });
                   }else if(r.data.code == 200){//取票成功
                    this.takeNumber.no = r.data.data.no;//取号码
                    this.takeNumber.roomName = "药房";
                    this.takeNumber.orderNum = r.data.data.orderNum;//排队序号
                    this.takeNumber.createTime = r.data.data.createTime;//取票时间
                    this.takeNumber.status = "就诊结束";


                       this.$notify({
                            title: '取票成功',
                            dangerouslyUseHTMLString: true,
                            duration:20000,
                            message: '<font>房间名称：'+this.takeNumber.roomName+'</font><br/><br/><font>排队序号：'+this.takeNumber.orderNum+'</font><br/><br/><font>取票号码：'+this.takeNumber.no+'</font><br/><br/><font>取票时间：'+this.takeNumber.createTime+'</font><br/><br/><font>就诊状态：'+this.takeNumber.status+'</font><br/>'
                            });
                   }
                    
                       
                });
            },

            returnindex(){//返回
                this.$router.push("/");
            }
            
        }

}

</script>
<style>

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
