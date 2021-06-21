export default {
  name: "doctorRota",
  /* 属性 */
  data() {
    return {
      /* 参数 */
      flagAddDoctorRota: false,
      /* 日期范围 */
      get calendarDateRange() {
        /* 直接返回 calendarDateStartRange */
        return this.calendarDateStartRange
      },
      set calendarDateRange(val) {
        /* 不允许为null */
        if (val===null){
          return;
        }
        /* 获得开始和结束对象 */
        let start = new Date((val / 1000 - 86400) * 1000)
        let end = new Date((val / 1000 + 86400 * 5) * 1000)
        /* 获得年月日 */
        let sy = start.getFullYear()
        let sm = (start.getMonth() + 1).toString().padStart(2, '0')
        let sd = start.getDate().toString().padStart(2, '0')
        /* 设置日期范围开始 */
        this.calendarDateStartRange = `${sy}-${sm}-${sd}`
        /* 获得年月日 */
        sy = end.getFullYear()
        sm = (end.getMonth() + 1).toString().padStart(2, '0')
        sd = end.getDate().toString().padStart(2, '0')
        /* 设置日期范围结束 */
        this.calendarDateEndRange = `${sy}-${sm}-${sd}`
        /* 组成最终日期范围数组 */
        this.calendarDateFinalRange = [this.calendarDateStartRange, this.calendarDateEndRange]
      },
      calendarDateStartRange: "",
      calendarDateEndRange: "",
      calendarDateFinalRange: ""
    }
  },
  methods: {
    /* 展示添加医生排班对话框 */
    showAddDoctorRotaDialogFunc(flag) {
      this.flagAddDoctorRota = flag;
    }
  }


}
