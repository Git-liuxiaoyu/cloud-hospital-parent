export default {
  name: "register",
  data() {
    return {
      switchShow: true,//医生个人信息和医生list切换
      doctor: [],//页面的医生对象
      item: '',
      subject: [],//科目集合
      subjectType: [],//科目类型集合
      rotaId: [],//医生类型集合
      Register: {

      },//添加患者挂号记录对象
      //图片对象
      url: 'https://git-liuxiaoyu.oss-cn-beijing.aliyuncs.com/frontstage/QQ%E5%9B%BE%E7%89%8720210616165827.png',
      patient: {//患者对象

      },
      patientBox: false,//添加患者模态框
      form: {//下拉框表单对象
        itemValue: '',
        subjectValue: '',
        subjectTypeValue: '',
        regTypeValue: '',
        rotaIdValue: ''
      },
      rules: {//表单验证
        name: [{required: true, message: '请输入姓名', trigger: 'blur'},
          {
            pattern: /^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\.\s]{1,20})$/,
            message: "请输入合法的姓名",
          }],
        age: [{required: true, message: '请输入年龄', trigger: 'blur'},
          {
            pattern: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
            message: "请输入合法的姓名",
          }],
        gender: [{required: true, message: '请选择性别', trigger: 'change'}],
        identityId: [{required: true, message: '请输入身份证号', trigger: 'blur'},
          {
            pattern: /^\d{15}|\d{18}$/,
            message: "请输入合法的身份证号码",
          }],
        phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
          {
            pattern: /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
            message: "请输入合法的手机号",
          }],
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
    addPatient(formName) {
      this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios.post("Patient/add", this.patient).then(r => {
              if (r.data.code == 200) {
                this.Register.patientId = r.data.data;//添加患者后拿到患者在数据库的Id
                //添加患者挂号记录请求
                this.$axios.post("Register/add", this.Register).then(r => {
                  console.log(r)
                })
                this.$notify({
                  title: '成功',
                  message: '挂号成功,请付款',
                  type: 'success'
                });
                this.patientBox = false;
              }
            })
          }
        }
      )
    },
//科目下拉框获取焦点是触发
    getSubject(id) {

      const that = this;

      const command = {
        'date': that.form.itemValue,
        departmentId: id
      }

      //查询时间段和departmentId查询医生
      this.$axios.post("http://localhost:9100/rota/doctor/reg", command).then(r => {
        this.doctor = r.data.data
      })
    }
    ,

//查询
    querySubject() {
      this.$axios.post("http://localhost:9100/division/all").then(r => {
        this.subject = r.data.data
      })
    }
    ,

//挂号时间失去焦点是触发
    checkItem() {
      let yesterday = new Date((new Date() / 1000 - 86400) * 1000);//昨天时间
      if (new Date(this.form.itemValue) < yesterday) {//如果选中的时间小于当前时间，是不允许选择的
        this.$notify({
          title: '警告',
          message: '预约时间只能是未来的时间',
          type: 'warning'
        });
        this.form.itemValue = '';
      }
    }
    ,
//点击医生对象
    getDoctorInfo(item) {
      this.switchShow = false;
      //添加患者挂号记录对象赋值
      this.Register.regType = item.doctorLevel;//挂号类型
      this.Register.rotaId = item.id;//排班Id
      this.Register.departmentId = item.departmentid;//外键-科室ID
      this.Register.visitTime = item.date;//挂号的就诊时间
      this.Register.visitSection = item.shifttype;//就诊时间段（1、上午，2、下午）
      this.Register.type = '1';//挂号类型（1、线上，2、线下）
      console.log('Register',this.Register)
    }
    ,
//选择医生
    choiceDoctor() {
      this.switchShow = true;
    }
  },
  created() {
    this.querySubject();
  }
}
