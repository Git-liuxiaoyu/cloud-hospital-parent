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
                            this.$notify({
                                title: '成功',
                                message: '挂号成功,请付款',
                                type: 'success'
                            });
                            this.patientBox = false;
                        }
                    })
                }
            })
        },
        //科目下拉框获取焦点是触发
        getSubject(id) {
            this.form.subjectTypeValue = '';
            this.$axios.get("http://localhost:9100/depart/all/" + id).then(r => {
                this.subjectType = r.data.data
            })
        },
        //查询
        querySubject() {
            this.$axios.post("http://localhost:9100/division/all").then(r => {
                this.subject = r.data.data
            })
        }
    },
    created() {
        this.querySubject();
    }
}
