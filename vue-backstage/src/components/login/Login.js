import SlideVerify from '../slide-verify/SlideVerify.vue'

export default {
  /* 组件 */
  components: {
    SlideVerify
  },
  data() {
    /* 校验是否 rePassword==password */
    var checkRepasswordValid = (rule, value, callback) => {
      if (value !== this.pwdUpdate.password) {
        /* 返回错误提示 */
        return callback(new Error('两次输入的密码不一致'));
      } else {
        /* 成功的回调 */
        callback()
      }
    }
    /* 校验是否 rePassword==password */
    var checkLoginVerifyValid = (rule, value, callback) => {
      if (!value) {
        /* 返回错误提示 */
        return callback(new Error('请滑动模块进行人机验证'));
      } else {
        /* 成功的回调 */
        callback()
      }
    }

    /* 声明属性 */
    return {
      /* flag - 显示展示滑块验证 */
      flagShowSlideVerify: false,
      /* 获得验证码Loading */
      getCodeBtnLoading: false,
      /* 定时器 */
      getVerifyCodeTimer: "",
      /* 获取验证码后的倒计时 */
      leftTime: 60,
      /* 判断是否出现验证码按钮 */
      flagShowGetCodeBtn: true,
      /* 修改密码加载 */
      pwdUpdateLoading: false,
      /* 用户登录加载 */
      LoginLoading: false,
      /* 用于【用户忘记密码】 - START */
      /* 更新密码对象 */
      pwdUpdate: {
        workerNo: "",
        verifyCode: "",
        password: "",
        rePassword: "",
        flagLoginVerify: false
      },
      pwdUpdateRules: {
        workerNo: [
          {required: true, message: "请输入您的工号", trigger: "blur"},
          /* 校验长度 */
          {min: 20, max: 30, message: "长度在 20 到 30 个字符", trigger: "blur"},
        ],
        verifyCode: [
          {required: true, message: "请输入您收到的验证码", trigger: "blur"},
          /* 校验长度 */
          {min: 4, max: 6, message: "长度在 4 到 6 个字符", trigger: "blur"},
        ],
        password: [
          {required: true, message: "请输入新的密码", trigger: "blur"},
          /* 校验长度 */
          {min: 3, max: 18, message: "长度在 3 到 18 个字符", trigger: "blur"},
        ],
        rePassword: [
          {required: true, message: "请输入重复密码", trigger: "blur"},
          /* 校验长度 */
          {min: 3, max: 18, message: "长度在 3 到 18 个字符", trigger: "blur"},
          /* 判断是否和 password 属性的值一致 */
          {required: true, validator: checkRepasswordValid, trigger: "blur"}
        ],
        flagLoginVerify: [
          /* 判断该值是否为 true */
          {required: true, validator: checkLoginVerifyValid, trigger: "hover"}
        ]
      },
      /* 用于【用户忘记密码】 - END */
      /* 用于改变【用户登录】和【找回密码】两块div，即旋转div */
      flag: false,
      /* 用户登录data */
      userLogin: {
        account: "",
        password: "",
        loginToken: "",
        flagLoginVerify: false
      },
      checked: false,
      loginRules: {
        account: [
          {required: true, message: "请输入您的账号", trigger: "blur"},
          /* 校验长度 */
          {min: 3, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur"},
        ],
        password: [
          {required: true, message: "请输入您的密码", trigger: "blur"},
          /* 校验长度 */
          {min: 3, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur"},
        ],
        flagLoginVerify: [
          /* 判断该值是否为 true */
          {required: true, validator: checkLoginVerifyValid, trigger: "hover"}
        ]
      },
      isIn: true, // 鼠标进去的门，默认打开
      isOut: false,
      span: "",
      con: document.querySelector(".container"),
    };
  },
  /* created 生命钩子函数 */
  created() {
    /** 调用 获得 loginToken 方法 */
    this.getLoginToken();
  },
  methods: {
    /* 切换是否显示 */
    showSlideVerify(flag) {
      this.flagShowSlideVerify = flag;
    },
    /* 请求修改密码功能 */
    reqUpdatePwdFunc(refName) {
      /** 验证表单 */
      this.$refs[refName].validate((valid) => {
        /* 验证表单通过 */
        if (valid) {
          /* 修改 pwdUpdateLoading 为 true */
          this.pwdUpdateLoading = true;
          /* 发送请求 */
          this.$axios
            .post("worker-service/user/update/pwd", this.pwdUpdate)
            .then((res) => {
              if (res.data.code === 200) {
                /** 提醒 */
                this.$notify({
                  title: "成功",
                  message: "修改密码成功",
                  type: "success",
                });
              } else if (res.data.code === 444) {
                /** 提醒 */
                this.$notify({
                  title: "警告",
                  message: res.data.msg,
                  type: "warning",
                });
              } else {
                /** 提醒 */
                this.$notify({
                  title: "错误",
                  message: res.data.msg,
                  type: "error",
                });
              }
            })
            .catch(() => {
              /** 提醒 */
              this.$notify({
                title: "错误",
                message: "网络错误",
                type: "error",
              });
            });
          /* 修改 pwdUpdateLoading 为 false */
          this.pwdUpdateLoading = false;
        }
      });
    },
    /* 发送验证码功能 */
    sendVerifyCode() {
      /* 判断是否输入工号 */
      if (this.pwdUpdate.workerNo === null || this.pwdUpdate.workerNo === "") {
        /** 提醒 */
        this.$notify({
          title: "警告",
          message: "请输入工号",
          type: "warning",
        });
        /* 不继续执行下去 */
        return;
      }
      /* getCodeBtnLoading 切换为 true */
      this.getCodeBtnLoading = true;
      /* 发送请求 */
      this.$axios
        .post("worker-service/user/send/verify/code", this.pwdUpdate)
        .then((res) => {
          console.log(res)
          if (res.data.code === 200) {
            /* 设置 60 秒后才能再发送短信 */
            this.flagShowGetCodeBtn = false;
            /* 设置定时器 */
            this.getVerifyCodeTimer = setInterval(() => {
              this.leftTime--
              if (this.leftTime === 0) {
                /* 改为 true */
                this.flagShowGetCodeBtn = true;
                /* 剩余时间重置 */
                this.leftTime = 60;
                clearInterval(this.getVerifyCodeTimer);
              }
            }, 1000)
            /** 提醒 */
            this.$notify({
              title: "成功",
              message: "发送验证码成功",
              type: "success",
            });
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
      /* getCodeBtnLoading 切换为 false */
      this.getCodeBtnLoading = false;
    },
    /** 获取 loginToken */
    getLoginToken() {
      /** 发送请求 */
      this.$axios
        .get("worker-service/user/login/token")
        .then((res) => {
          if (res.data.code === 200) {
            /** 赋值 localStorage */
            this.userLogin.loginToken = res.data.data
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /** 用户登录方法 */
    login(refName) {
      console.log(this.userLogin.loginToken);
      /** 验证表单 */
      this.$refs[refName].validate((valid) => {
        /** 判断表单是否满足条件 */
        if (valid) {
          /** 满足 */
          /* LoginLoading 改为true */
          this.LoginLoading = true;
          /* 发送请求 */
          this.$axios
            .post("worker-service/user/doLogin", this.userLogin)
            .then((res) => {
              if (res.data.code === 200) {
                /** 存入 localStorage */
                localStorage.setItem("BackLoginedToken", res.data.data);
                /** 提醒 */
                this.$notify({
                  title: "成功",
                  message: "登录成功，欢迎您！",
                  type: "success",
                });
                /** 转发到主页 */
                this.$router.push("/home");
              } else if (res.data.code === 444) {
                /** 提醒 */
                this.$notify({
                  title: "警告",
                  message: res.data.msg,
                  type: "warning",
                });
              } else {
                /** 提醒 */
                this.$notify({
                  title: "错误",
                  message: res.data.msg,
                  type: "error",
                });
              }
            })
            .catch(() => {
              /** 提醒 */
              this.$notify({
                title: "错误",
                message: "网络错误",
                type: "error",
              });
            });
          /* LoginLoading 改为false */
          this.LoginLoading = false;
        }
      });
    },
    mouseIn(e) {
      console.log(e);
      if (this.isIn) {
        // 如果进去的门时打开的，就可以执行这个函数
        // 获取进入的鼠标位置
        // 生成元素的位置=进入点距离窗口的距离-父盒子距离窗口的距离
        let inx = e.clientX - e.target.offsetLeft;
        let iny = e.clientY - e.target.offsetTop;

        // 创建一个span元素，并且给它对应的出生坐标
        let el = document.createElement("span");
        el.style.left = inx + "px";
        el.style.top = iny + "px";
        this.con.appendChild(el); // 添加到con对应的父元素，即container

        $(".container span").removeClass("out"); // 除去出去的动画 不知道这样写是不是不太好
        $(".container span").addClass("in"); // 添加进入的动画
        this.span = document.querySelector(".container span");
        this.isIn = false; // 关闭进来的门（不能使用进入的方法）
        this.isOut = true; // 打开出去的门（可以使用出去的方法）
      }
    },
    mouseOut: function (e) {
      console.log(e);

      if (this.isOut) {
        // 获取出去的鼠标位置
        // 生成元素的位置=进入点距离窗口的距离-父盒子距离窗口的距离
        let inx = e.clientX - e.target.offsetLeft;
        let iny = e.clientY - e.target.offsetTop;

        //
        $(".container span").removeClass("in"); // 移除进入的动画
        $(".container span").addClass("out"); // 添加出去的动画
        $(".out").css("left", inx + "px"); // 添加出去的坐标
        $(".out").css("top", iny + "px");

        this.isOut = false; // 关闭出去的大门

        // 当动画结束后再删除元素
        setTimeout(() => {
          con.removeChild(span); // 删除元素
          this.isIn = true; // 打开进来的大门
        }, 500);
      }
    },
  },
};
