export default {
  name: "register",
  data() {
    return {
      //表单
      time: [{
        value: '上午',
        label: '9:00~12:00'
      }, {
        value: '下午',
        label: '14:00~18:00'
      }],
      value: '',
      //图片对象
      url: 'https://git-liuxiaoyu.oss-cn-beijing.aliyuncs.com/frontstage/QQ%E5%9B%BE%E7%89%8720210616165827.png',
      patient: {//患者对象

      },
      patientBox:false,//添加患者模态框
    }
  },
  methods:{
    //显示挂号模态框
    doPatient(){
      this.patientBox=true;
    },
    //挂号模态框取消
    cancel(){
      this.patientBox=false;
    },
    //挂号模态框确定
    addPatient(){

    },
  }
}
