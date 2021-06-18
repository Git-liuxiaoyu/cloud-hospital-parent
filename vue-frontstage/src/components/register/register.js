export default {
  name: "register",
  data() {
    return {
      time: [{//表单时间集合
        value: '上午',
        label: '9:00~12:00'
      }, {
        value: '下午',
        label: '14:00~18:00'
      }],
      subject: [],//科目集合
      subjectType: [],//科目类型集合
      //图片对象
      url: 'https://git-liuxiaoyu.oss-cn-beijing.aliyuncs.com/frontstage/QQ%E5%9B%BE%E7%89%8720210616165827.png',
      patient: {//患者对象

      },
      patientBox: false,//添加患者模态框
      form: {//下拉框表单对象
        timeValue: '上午',
        subjectValue: '',
        subjectTypeValue: ''
      },
    }
  },
  methods: {
    //显示挂号模态框
    doPatient() {
      this.patientBox = true;
    },
    //挂号模态框取消
    cancel() {
      this.patientBox = false;
    },
    //挂号模态框确定
    addPatient() {

    },
    //科目下拉框获取焦点是触发
    getSubject(id) {
      this.form.subjectTypeValue='';
      this.$axios.get("http://localhost:9100/depart/all/"+id).then(r => {
        this.subjectType = r.data.data
      })
    },
    //查询
    querySubject(){
      this.$axios.post("http://localhost:9100/division/all").then(r => {
        this.subject = r.data.data
      })
    }
  },
  created() {
    this.querySubject();
  }
}
