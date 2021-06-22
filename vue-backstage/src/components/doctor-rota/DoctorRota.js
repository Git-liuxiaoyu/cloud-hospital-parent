export default {
  name: "doctorRota",
  /* 属性 */
  /* 接收属性 */
  props: ['departmentId'],
  data() {
    return {
      /* 参数 */
      /* 显现对话框 */
      flagAddAndUpdateDoctorRotaDialog: false,
      /* 主键数组 */
      idArr: [],
      /* 添加时加载方法 */
      addDoctorRotaLoading: false,
      /* 医生最大接纳人数 */
      maxPatient: [],
      /* 医生列表 */
      departmentDoctorList: "",
      /* 选择医生数组 */
      selectDoctor: [],
      /* 科室房间数组 */
      departmentOutRoomArr: "",
      /* 是否出现添加DoctorRota */
      flagAddDoctorRotaDialog: false,
      /*  */
      addDoctorRotaDate: "",
      addDoctorRotaType: "",
      /* 日期范围 */
      get calendarDateRange() {
        /* 直接返回 calendarDateStartRange */
        return this.calendarDateStartRange
      },
      set calendarDateRange(val) {
        /* 不允许为null */
        if (val === null) {
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
  /* 声明周期钩子函数 */
  mounted() {

  },
  methods: {
    /* 撤销目标排班方法 */
    cancelTargetDoctorRotaFunc(index) {
      /* 全部通过则调用添加方法 */
      /* 发送请求 */
      this.$axios
        .get("worker-service/rota/doctor/cancel/" + this.idArr[index])
        .then((res) => {
          if (res.data.code === 200) {
            this.$notify({
              title: "成功",
              message: "撤销排班成功",
              type: "success",
            });
            /* 清空数据 */
            this.idArr = [];
            this.maxPatient = [];
            this.selectDoctor = [];
            this.getTargetRotaInfo();
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
          /* Unloading */
          this.addDoctorRotaLoading = false;
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 修改排班信息方法 */
    updateDoctorRotaFunc(index, roomId) {
      /* 先判断有无选择排班医生 */
      if (this.selectDoctor[index] === undefined) {
        /** 提醒 */
        this.$notify({
          title: "警告",
          message: "请选择值班医生",
          type: "warning",
        });
        return;
      }

      /* 判断有无最大接诊数 */
      if (this.maxPatient[index] === undefined) {
        /** 提醒 */
        this.$notify({
          title: "警告",
          message: "请输入最大接诊数",
          type: "warning",
        });
        return;
      }

      /* Loading */
      this.addDoctorRotaLoading = true;

      /* 全部通过则调用添加方法 */
      /* 发送请求 */
      this.$axios
        .post("worker-service/rota/doctor/update", {
          id: this.idArr[index],
          departmentId: this.departmentId,
          date: this.addDoctorRotaDate,
          rotaType: "1",
          shiftType: this.addDoctorRotaType,
          doctorId: this.selectDoctor[index],
          maxPatient: this.maxPatient[index],
          'roomId': roomId
        })
        .then((res) => {
          if (res.data.code === 200) {
            this.$notify({
              title: "成功",
              message: "修改排班成功",
              type: "success",
            });
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
          /* Unloading */
          this.addDoctorRotaLoading = false;
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 获得当前对话框的排班信息 */
    getTargetRotaInfo() {
      /* 发送请求 */
      this.$axios
        .post("worker-service/rota/doctor/view/set/rota", {
          departmentId: this.departmentId,
          date: this.addDoctorRotaDate,
          shiftType: this.addDoctorRotaType
        })
        .then((res) => {
          if (res.data.code === 200) {
            /* 循环排班信息 */
            res.data.data.forEach(e => {
              this.departmentOutRoomArr.forEach((d, index) => {
                if (e.roomid === d.id) {
                  this.idArr[index] = e.id;
                  this.maxPatient[index] = e.maxpatient;
                  this.selectDoctor[index] = e.doctorid;
                }
              });
            });
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
          /* unLoading */
          setTimeout(() => {
            this.flagAddAndUpdateDoctorRotaDialog = false;
          }, 800);
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 添加排班方法 */
    addDoctorRotaFunc(index, roomId) {
      /* 先判断有无选择排班医生 */
      if (this.selectDoctor[index] === undefined) {
        /** 提醒 */
        this.$notify({
          title: "警告",
          message: "请选择值班医生",
          type: "warning",
        });
        return;
      }

      /* 判断有无最大接诊数 */
      if (this.maxPatient[index] === undefined) {
        /** 提醒 */
        this.$notify({
          title: "警告",
          message: "请输入最大接诊数",
          type: "warning",
        });
        return;
      }

      /* Loading */
      this.addDoctorRotaLoading = true;

      /* 全部通过则调用添加方法 */
      /* 发送请求 */
      this.$axios
        .post("worker-service/rota/doctor/add", {
          departmentId: this.departmentId,
          date: this.addDoctorRotaDate,
          rotaType: "1",
          shiftType: this.addDoctorRotaType,
          doctorId: this.selectDoctor[index],
          maxPatient: this.maxPatient[index],
          'roomId': roomId
        })
        .then((res) => {
          if (res.data.code === 200) {
            this.$notify({
              title: "成功",
              message: "添加排班成功",
              type: "success",
            });
            /* 赋值 */
            this.idArr[index] = res.data.data;
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
            /* 清空数据 */
            this.selectDoctor[index] = undefined;
            this.maxPatient[index] = undefined;
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
          /* Unloading */
          this.addDoctorRotaLoading = false;
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 获取该科室所有医生 */
    getAllDepartmentDoctors() {
      /* 发送请求 */
      this.$axios
        .get("worker-service/worker/view/all/department/" + this.departmentId)
        .then((res) => {
          if (res.data.code === 200) {
            /* 赋值 */
            this.departmentDoctorList = res.data.data;
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 获取该科室的全部诊室房间 */
    getAllRoomByDepartmentId() {
      /* 发送请求 */
      this.$axios
        .get("worker-service/room/out/view/all/" + this.departmentId)
        .then((res) => {
          if (res.data.code === 200) {
            /* 赋值 */
            this.departmentOutRoomArr = res.data.data;
          } else if (res.data.code === 444) {
            /** 提醒 */
            this.$notify({
              title: "警告",
              message: res.data.msg,
              type: "warning",
            });
          } else {
            /** 提醒 */
            this.$notify({
              title: "错误",
              message: res.data.msg,
              type: "error",
            });
          }
        })
        .catch(() => {
          /** 提醒 */
          this.$notify({
            title: "错误",
            message: "网络错误",
            type: "error",
          });
        });
    },
    /* 展示添加医生排班对话框 */
    showAddDoctorRotaDialogFunc(flag, date, type) {
      /* Loading */
      this.flagAddAndUpdateDoctorRotaDialog = true;
      /* 得到选择的日期 */
      this.addDoctorRotaDate = date;
      /* 得到选择的类型 */
      this.addDoctorRotaType = type;
      /* 获得所有该科室的的Room */
      this.getAllRoomByDepartmentId();
      /* 获得所有该科室的医生 */
      this.getAllDepartmentDoctors();
      /* 清空数据 */
      this.idArr = [];
      this.maxPatient = [];
      this.selectDoctor = [];
      this.getTargetRotaInfo();
      /* 显现对话框 */
      this.flagAddDoctorRotaDialog = flag;
    }
  }


}
