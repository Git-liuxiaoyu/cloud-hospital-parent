export default {
  name: "registerRecord",
  data() {
    return {
      detailsBox: false,//详情盒子对象
      registerOrder: [],//挂号订单
      registerOrderItem: {},//挂号订单详情
      leftTimeData:"",
      /* 剩余时间 */
      get leftTime(){
        return this.leftTimeData;
      },
      set leftTime(val){
        var date = new Date(val);
        var finalDate = new Date((date/1000 + 15 * 60)*1000);
        let timer=setInterval(()=>{
          if(new Date()<finalDate){
            var time = finalDate - new Date();
            this.leftTimeData = time;
          }else {
            clearInterval(timer);//关闭计时器
          }
        },1000);
      }
    }
  },
  methods: {
    showDetails(item) {
      this.detailsBox = true;
      this.registerOrderItem = item
      this.leftTime = this.registerOrderItem.regTime;
    },
    findAllOrder() {//查询所有的挂号订单
      this.$axios.get("Register/query/phone/" + window.localStorage.getItem("phone")).then(r => {
        this.registerOrder = r.data.data
      })
    },
  },
  created() {
    this.findAllOrder();
  }
}
