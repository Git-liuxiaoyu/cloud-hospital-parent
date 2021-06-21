export default {
  name: "home",
  data() {
    return {
      /* 读取信息 */
      fullscreenLoading: true,
      loginUserInfo: "",
    }
  },
  created() {
    /** 初始化获得登录用户信息 */
    this.getLoginUserInfo();
  },
  methods: {
    /* 【退出登录】功能 */
    logoutFuc() {
      /* 删除 localStorage 中存储的 Token */
      localStorage.removeItem("BackLoginedToken");
      /* 跳转到登录路由 */
      this.$router.push("/");
    },
    /** 获得登录用户信息 */
    getLoginUserInfo() {
      /** 发送请求 */
      this.$axios
        .get("worker-service/worker/view")
        .then((res) => {
          if (res.data.code === 200) {
            console.log("登录用户信息", res.data);
            /* 赋值 */
            this.loginUserInfo = res.data.data;
            /* 0.5s 后再解除 loading */
            setTimeout(() => {
              this.fullscreenLoading = false;
            }, 500);
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
        }).catch(() => {
        /** 提醒 */
        this.$notify({
          title: "错误",
          message: "网络错误",
          type: "error",
        });
      });
    }
  }
}

