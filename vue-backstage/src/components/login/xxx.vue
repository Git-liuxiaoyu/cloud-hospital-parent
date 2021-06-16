<template>
  <div>
    <slide-verify
      ref="slideblock"
      @again="onAgain"
      @fulfilled="onFulfilled"
      @success="onSuccess"
      @fail="onFail"
      @refresh="onRefresh"
      :accuracy="accuracy"
      :slider-text="text"
    ></slide-verify>
    <div>{{ msg }}</div>

    <button @click="handleClick">在父组件可以点我刷新哦</button>
  </div>
</template>



<script>
export default {
  data() {
    return {
      msg: "",
      text: "向右滑",
      // 精确度小，可允许的误差范围小；为1时，则表示滑块要与凹槽完全重叠，才能验证成功。默认值为5
      accuracy: 1,
    };
  },
  methods: {
    onSuccess() {
      console.log("验证通过");
      this.msg = "login success";
    },
    onFail() {
      console.log("验证不通过");
      this.msg = "";
    },
    onRefresh() {
      console.log("点击了刷新小图标");
      this.msg = "";
    },
    onFulfilled() {
      console.log("刷新成功啦！");
    },
    onAgain() {
      console.log("检测到非人为操作的哦！");
      this.msg = "try again";
      // 刷新
      this.$refs.slideblock.reset();
    },
    handleClick() {
      // 父组件直接可以调用刷新方法
      this.$refs.slideblock.reset();
    },
  },
};
</script>

<style>
</style>