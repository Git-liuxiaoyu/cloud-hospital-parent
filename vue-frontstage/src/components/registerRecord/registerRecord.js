export default {
  name: "registerRecord",
  data() {
    return {
      detailsBox: false,//详情盒子对象
      registerOrder:[],//挂号订单
    }
  },
  methods: {
    showDetails() {
      this.detailsBox = true;
    },
    findAllOrder(){//查询所有的挂号订单
      this.$axios.get("Register/query/phone/"+window.localStorage.getItem("phone")).then(r => {
        this.registerOrder = r.data.data
        console.log(this.registerOrder)
      })
    },
  },
  created() {
    this.findAllOrder();
  }
}
