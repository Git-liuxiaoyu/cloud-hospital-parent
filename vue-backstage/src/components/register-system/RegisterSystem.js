export default {
  name: "RegisterSystem",
  data() {
    return {
      form: {
        redisterTimeValue: '',//挂号时间
        subjectValue: '',//科目类型
        doctorTypeValue: '',//医生类型
        doctorValue: '',//医生名字
      },//表单对象
      redisterTime: [{value: '上午', id: 1}, {value: '下午', id: 2}, {value: '晚上', id: 3}],//挂号时间的下拉框
      patient: {},//患者表单信息
      doctor: {},/*查询医生的对象参数*/
      identityId: {
        identityId: '',//身份证Id
      },

      patientId: '',//患者id
      doctorType: [
        {value: "普通", id: 1},
        {value: "专家", id: 2}
      ],
      showPatient: false,//显示患者信息

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

        phone: [{required: true, message: '请输入手机号', trigger: 'blur'},
          {
            pattern: /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
            message: "请输入合法的手机号",
          }],
      },
      identity: {//身份证表单的对象
        identityId: [{required: true, message: '请输入身份证号', trigger: 'blur'},
          {
            pattern: /^\d{15}|\d{18}$/,
            message: "请输入合法的身份证号码",
          }],
      }
    }
  },
  methods: {
    querySubject() {
      this.$axios.post("worker-service/division/all").then(r => {
        this.subject = r.data.data
      })
    },
    /*添加患者信息*/
    doPatient(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let addPatient = {
            name: this.patient.name,
            age: this.patient.age,
            gender: this.patient.gender,
            phone: this.patient.phone,
            identityId: this.identityId.identityId
          }
          console.log(addPatient)
          this.$axios.post("register-service/Patient/add", addPatient).then(r => {
            if (r.data.code == 200) {
              this.patientId = r.data.data;//添加患者后拿到患者在数据库的Id
              console.log("id为" + this.patientId)
            } else if (r.data.code == 444) {
              this.$notify({
                title: '提示',
                message: '存在该患者,无法添加',
                type: 'warning'
              });
            }
          })
        }
      })
    },
    /*查询患者信息*/
    getPatientItem(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.get("register-service/Patient/query/byIdentityId/" + this.identityId.identityId).then(r => {
            if (r.data.code == 200) {
              this.patient = r.data.data;
              this.showPatient = true;//显示患者信息
              this.patientId = r.data.data.id;//获取患者信息
              this.patient.identityId = r.data.data.identityid;
            } else {
              this.$notify({
                title: '提示',
                message: '没有患者信息,请先添加',
                type: 'warning'
              });
              this.patient.name = '';
              this.patient.age = '';
              this.patient.gender = '0';
              this.patient.phone = null;
              this.showPatient = true;
            }
          })
        }
      })
    },
    /*修改患者信息*/
    updatePatient(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.patient)
          this.$axios.post("register-service/Patient/update", this.patient).then(r => {
            if (r.data.code == 200) {
              this.$notify({
                title: '成功',
                message: '修改患者信息成功',
                type: 'success'
              });
            }
          })
        }
      })
    },
    /*查询今天的时间*/
    queryDoctor() {
      /*获取今天的信息*/
      var date = new Date();
      date.setTime(date.getTime());
      var s2 = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
      this.doctor.date = s2;/*查询医生的时间*/
    },
    /*查询医生信息*/
    getDoctor() {
      console.log(this.form)
      if (this.form.doctorTypeValue != "" && this.form.redisterTimeValue != "" && this.form.subjectValue != "") {
        this.$axios.post("worker-service/rota/doctor/reg/back", this.form).then(r => {
          console.log(r)
        })
      }
    },
    /*添加挂号信息*/
    doRegister() {
      if (this.patientId != "") {

      } else {
        alert(1)
      }
    }
  },
  created() {
    this.querySubject();
    this.queryDoctor();
  }
}

