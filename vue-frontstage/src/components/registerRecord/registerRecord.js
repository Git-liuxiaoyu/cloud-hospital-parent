export default {
  name: "registerRecord",
  data() {
    return {
      detailsBox: false,//详情盒子对象
      registerOrder: [],//挂号订单
      registerOrderItem: {},//挂号订单详情
      leftTimeData: "",
      //专家类型
      zhuanjia: '',//10元是专拣，5元是普通
      /* 剩余时间 */
      get leftTime() {
        return this.leftTimeData;
      },
      set leftTime(val) {
        var date = new Date(val);
        var finalDate = new Date((date / 1000 + 15 * 60) * 1000);
        let timer = setInterval(() => {
          if (new Date() < finalDate) {
            var time = finalDate - new Date();
            this.leftTimeData = time;
          } else {
            clearInterval(timer);//关闭计时器
          }
        }, 1000);
      }
    }
  },
  methods: {
    showDetails(item) {
      this.detailsBox = true;
      this.registerOrderItem = item
      //剩余时间
      this.leftTime = this.registerOrderItem.regTime;
      console.log('tag', item)
      if (item.price == 5) {
        this.registerOrderItem.regType = '2'
      } else {
        this.registerOrderItem.regType = '1'
      }
    },
    findAllOrder() {//查询所有的挂号订单
      this.$axios.get("Register/query/phone/" + window.localStorage.getItem("phone")).then(r => {
        this.registerOrder = r.data.data
      })
    },
    tuikuan(id) {
      console.log(id)
      this.$axios.post("http://localhost:6003/call/refund/" + id).then(r => {
        if (r.data.code == 200) {
          location.reload();
          this.$notify({
            title: '成功',
            message: '退款成功',
            type: 'success'
          });
        }
      })
    },
    //取消挂号订单
    quxiao() {

    },
    //支付挂号订单
    zifu(registerOrderItem) {
      location.href = "http://localhost:6003/call/pay/" + registerOrderItem.id + "/" + registerOrderItem.regType;
    }
  },
  created() {
    this.findAllOrder();
  }
}
