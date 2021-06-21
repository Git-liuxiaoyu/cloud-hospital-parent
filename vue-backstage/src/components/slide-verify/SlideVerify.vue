<template>
  <div>
    <slide-verify
      v-if="flag"
      ref="slideblock"
      @again="onAgain"
      @fulfilled="onFulfilled"
      @success="onSuccess"
      @fail="onFail"
      @refresh="onRefresh"
      :accuracy="accuracy"
      :slider-text="text"
    ></slide-verify>
  </div>
</template>

<script>
export default {
  mounted() {
    this.handleClick();
  },
  data() {
    return {
      flag: true,
      text: "向右滑",
      // 精确度小，可允许的误差范围小；为1时，则表示滑块要与凹槽完全重叠，才能验证成功。默认值为5
      accuracy: 1,
    };
  },
  methods: {
    onSuccess() {
      this.$emit('verifyFunc', false);
      console.log("验证通过");
    },
    onFail() {
      console.log("验证不通过");
    },
    onRefresh() {
      console.log("点击了刷新小图标");
    },
    onFulfilled() {
      console.log("刷新成功啦！");
    },
    onAgain() {
      console.log("检测到非人为操作的哦！");
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
