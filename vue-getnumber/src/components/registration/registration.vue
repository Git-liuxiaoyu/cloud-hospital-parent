
<template>

    <div align="center" id="div1">
     
         <el-container>

        <el-header>
            <div id="div2">
                 <a href="#" @click="returnindex()">
                <i class="el-icon-d-arrow-left" style="margin-left:5px"></i>
                </a>
            </div>
           
            <font class="font1">XXX医院挂号取票&nbsp;&nbsp;
                <i class="el-icon-s-ticket"></i>
            </font>
        </el-header>
            <el-main>

                <el-input
                    type="text"
                    placeholder="请输入4位取票码"
                    v-model="num"
                    maxlength="4"
                    show-word-limit style="width:50%">
                 <template slot="prepend">GH</template>
                </el-input>

                <br/>
                <br/>
                <el-button type="success" plain @click="getnumber()">取&nbsp;&nbsp;票</el-button>
            </el-main>
            <el-footer><font class="font1">版权所有&copy; XXX医院</font></el-footer>
        </el-container>

        
    </div>


</template>

<script>
import axios from 'axios';
export default { 
       data(){
            return {
                num:"",
                profile:{
                  
                },
            }
        },
        methods:{
            getnumber(){//取票
                var no = "GH"+this.num;
               axios.get("http://localhost:6001/proof/findbyno/"+no).then(r => {  

                   console.log(r)
                   if(r.data.code != 200){
                       alert("取票失败");
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

  .el-button{
      font-family: "楷体";
      font-size: 25px;
      width: 200px;
      height: 60px;
  }
</style>
