export default {
  name: "login",
  data() {
    return {
      //预约挂号模态框显示和隐藏的对象
      login: false,
      //手机号和验证码的参数对象
      parameter: {
        phone: '',//手机号
        code: ''//验证码
      },
      disabled: false,//是否禁用获取验证码的按钮状态
      msg: "获取验证码",
      rules: {//表单验证
        phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
          {
            pattern: /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
            message: "请输入合法的手机号",
          }],
      },
    }
  },
  methods: {
    //显示预约挂号模态框方法
    showLogin() {
      this.login = true;
    },
    //获取验证码的方法
    getCode(phone,formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //向后台发送手机号
          this.$axios.post("Register/getCode/"+phone).then(r => {
            //返回值为200开始计时
            if(r.data.code==200){
              this.$message.success("已发送,注意查收");
              let time = 60;
              let timer = setInterval(() => {
                if (time == 0) {
                  this.msg = "获取验证码";
                  this.disabled = false;
                  //停止计时器
                  clearInterval(timer)
                } else {
                  this.msg = time + "秒后重试";
                  this.disabled = true;
                  time--;
                }
              }, 1000)
            }else {
              //不是200
              this.$message.error(r.data.msg);
            }
          })
        }
      })
    },
    //模态框取消方法
    cancel(formName) {
      this.$refs[formName].resetFields();
      this.login = false;
    },
    //模态框失去焦点方法
    handleClose() {
      this.$refs['rules'].resetFields();
      this.login = false;
    },
    //模态框登入方法
    doLogin(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("Register/doLogin/",this.parameter).then(r => {
            if(r.data.code==200){
              window.localStorage.setItem("phone",this.parameter.phone)//存入手机号
              this.$message.success("登入成功");
              this.$router.push("/index");
            }else {
              this.$message.error(r.data.msg);
            }
          })
        }
      })
    },
  }
}
