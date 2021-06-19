<template>
  <div class="login">
    <section>
      <div class="wave">
        <span></span>
        <span></span>
        <span></span>
      </div>
      <div class="Before" :style="flag ? 'transform: rotateY(180deg)' : ''">
        <div class="content">
          <el-container>
            <div
              class="login-page"
              @mouseenter="mouseIn"
              @mouseleave="mouseOut"
            >
              <el-form
                :model="userLogin"
                :rules="loginRules"
                status-icon
                ref="userLogin"
                label-position="left"
                label-width="0px"
                class="demo-ruleForm"
              >
                <img src="./images/wyq-blue.png" style="width: 300px" />
                <br />
                <br />
                <h3
                  class="title"
                  style="
                    maragn-left: -50px;
                    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC',
                      'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial,
                      sans-serif;
                    color: #409eff;
                  "
                >
                  用户登录
                </h3>
                <br />
                <el-form-item prop="account">
                  <el-input
                    type="text"
                    v-model.trim="userLogin.account"
                    auto-complete="off"
                    placeholder="请输入账号"
                    clearable
                  ></el-input>
                </el-form-item>
                <el-form-item prop="password">
                  <el-input
                    type="password"
                    v-model.trim="userLogin.password"
                    auto-complete="off"
                    placeholder="请输入密码"
                    clearable
                    @keyup.native="
                      $event.target.value = $event.target.value.replace(
                        /^\s+|\s+$/gm,
                        ''
                      )
                    "
                  ></el-input>
                </el-form-item>
                <el-checkbox v-model="checked" class="rememberme"
                  >记住密码</el-checkbox
                >
                <el-form-item style="width: 100%">
                  <el-button
                    type="primary"
                    round
                    style="width: 60%; font-weight: bold; font-size: 15px"
                    @click="login('userLogin')"
                    @mouseenter="mouseIn(index)"
                    >登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</el-button
                  >
                </el-form-item>
                <el-form-item style="width: 100%">
                  <a class="register" @click="flag = !flag">忘记密码</a><br />
                </el-form-item>
              </el-form>
            </div>
          </el-container>
        </div>
      </div>

      <div class="After" :style="flag ? 'transform: rotateY(0deg)' : ''">
        <div class="content">
          <el-container>
            <div
              class="login-page"
              @mouseenter="mouseIn"
              @mouseleave="mouseOut"
            >
              <el-form
                :model="userLogin"
                :rules="rules"
                status-icon
                ref="userLogin"
                label-position="left"
                label-width="0px"
                class="demo-ruleForm"
              >
                <img src="./images/wyq-blue.png" style="width: 300px" />
                <br />
                <br />
                <h3
                  class="title"
                  style="
                    maragn-left: -50px;
                    font-family: 'Helvetica Neue', Helvetica, 'PingFang SC',
                      'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial,
                      sans-serif;
                    color: #409eff;
                  "
                >
                  忘记密码
                </h3>
                <br />
                <el-form-item prop="info">
                  <el-input
                    type="text"
                    v-model.trim="userLogin.info"
                    auto-complete="off"
                    placeholder="请输入账号"
                    clearable
                  ></el-input>
                </el-form-item>
                <el-form-item prop="password">
                  <el-input
                    type="password"
                    v-model.trim="userLogin.password"
                    auto-complete="off"
                    placeholder="请输入密码"
                    clearable
                    @keyup.native="
                      $event.target.value = $event.target.value.replace(
                        /^\s+|\s+$/gm,
                        ''
                      )
                    "
                  ></el-input>
                </el-form-item>
                <el-checkbox v-model="checked" class="rememberme"
                  >记住密码</el-checkbox
                >
                <el-form-item style="width: 100%">
                  <el-button
                    type="primary"
                    round
                    style="width: 60%; font-weight: bold; font-size: 15px"
                    @click="login('userLogin')"
                    @mouseenter="mouseIn(index)"
                    >登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</el-button
                  >
                </el-form-item>
                <el-form-item style="width: 100%">
                  <a class="register" @click="flag = !flag">回到登录</a><br />
                </el-form-item>
              </el-form>
            </div>
          </el-container>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      /* 用于改变【用户登录】和【找回密码】两块div，即旋转div */
      flag: false,
      /* 用户登录data */
      userLogin: {
        account: "",
        password: "",
        loginToken: ""
      },
      checked: false,
      loginRules: {
        account: [
          { required: true, message: "请输入您的账号", trigger: "blur" },
          /* 校验长度 */
          { min: 3, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入您的密码", trigger: "blur" },
          /* 校验长度 */
          { min: 3, max: 10, message: "长度在 3 到 5 个字符", trigger: "blur" },
        ],
      },
      isIn: true, // 鼠标进去的门，默认打开
      isOut: false,
      span: "",
      con: document.querySelector(".container"),
    };
  },
  created(){
    /** 调用 获得 loginToken 方法 */
    this.getLoginToken();
  },
  methods: {
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
            message: res.data.msg,
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
                this.$router.push("/index");
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
                message: res.data.msg,
                type: "error",
              });
            });
        }
      });
    },
    plogin() {
      this.$router.push("/login");
    },
    goindex() {
      this.$router.push("/home");
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
</script>

<style scoped>
.login-page {
  -webkit-border-radius: 5px;
  text-align: center;
  border-radius: 15px;
  /* margin: 100px 0 0 350px; */
  width: 330px;
  padding: 35px 35px 15px;
  background: #fff;
  border: 2px solid #eaeaea;
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}
.register {
  color: indigo;
}
.register:hover {
  color: chocolate;
  cursor: pointer;
}
.bjimg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -10;
  object-fit: cover;
}

section {
  position: relative;
  height: 100vh;
  width: 100%;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}
section .wave {
  position: absolute;
  left: 0;
  width: 100%;
  height: 100%;
  background: #4973ff;
}

section .wave span {
  position: absolute;
  width: 325vh;
  height: 325vh;
  top: 0;
  left: 50%;
  transform: translate(-50%, -75%);
  background: white;
}
section .wave span:nth-child(1) {
  animation: animate 5s linear infinite;
  border-radius: 45%;
  background: rgba(20, 20, 20, 0.8);
}
section .wave span:nth-child(2) {
  animation: animate 10s linear infinite;
  border-radius: 40%;
  background: rgba(20, 20, 20, 0.5);
}
section .wave span:nth-child(3) {
  animation: animate 15s linear infinite;
  border-radius: 42.5%;
  background: rgba(20 20, 20, 0.5);
}

@keyframes animate {
  0% {
    transform: translate(-50%, -75%) rotate(0deg);
  }
  100% {
    transform: translate(-50%, -75%) rotate(360deg);
  }
}

section .content {
  position: relative;
  z-index: 1;
}

/* 卡片翻转特效 */
.Before {
  position: absolute;
  backface-visibility: hidden;
  transition: 3s;
}
.After {
  position: absolute;
  transform: rotateY(-180deg);
  backface-visibility: hidden;
  transition: 3s;
}
</style>
