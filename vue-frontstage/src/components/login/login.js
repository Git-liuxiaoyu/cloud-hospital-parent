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
        code: {required: true, message: '请输入验证码', trigger: 'change'}
      }
    }
  },
  methods: {
    //显示预约挂号模态框方法
    showLogin() {
      this.login = true;
    },
    //获取验证码的方法
    getCode() {
      let time = 60;
      let timer = setInterval(() => {
        if (time == 0) {
          this.msg = "获取验证码";
          this.disabled = false;
          clearInterval(timer)
        } else {
          this.msg = time + "秒后重试";
          this.disabled = true;
          time--;
        }
      }, 1000)
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
          this.$router.push("/index");
        }
      })
    },
  }
}
