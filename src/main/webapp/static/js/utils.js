let Menu = [
  {
    name: '首页',
    path: '/views/index/index.jsp',
    icon: 'fa fa-home fa-fw'
  }, {
    name: '客户信息',
    icon: 'fa fa-address-book fa-fw',
    child: [{
      name: '车辆资源',
      path: '/views/customerInfo/carResources.jsp'
    }, {
      name: '买车咨询',
      path: '/views/customerInfo/buyingCarConsult.jsp'
    }, {
      name: '置换车辆',
      path: '/views/customerInfo/replaceCar.jsp'
    }]
  }, {
    name: '交易管理',
    icon: 'fa fa-suitcase fa-fw',
    child: [{
      name: '评估审核',
      path: '/views/tradeManage/evaluation.jsp'
    }, {
      name: '保险凭证',
      path: '/views/tradeManage/insurance.jsp'
    }, {
      name: '分期管理',
      path: '/views/tradeManage/stateManage.jsp'
    }]
  }, {
    name: '售车管理',
    icon: 'fa fa-car fa-fw',
    child: [{
      name: '订车管理',
      path: '/views/carSales/booking.jsp'
    }, {
      name: '售车管理',
      path: '/views/carSales/carSales.jsp'
    }/*, {
      name: '退车管理',
      path: '/views/carSales/carSales.jsp'
    }*/]
  }, {
    name: '车辆管理',
    icon: 'fa fa-cab fa-fw',
    child: [{
      name: '车辆管理',
      path: '/views/carManage/carManage.jsp'
    }, {
      name: '车辆信息',
      path: '/views/carManage/carinformation.jsp'
    }]
  }, {
    name: '财务管理',
    icon: 'fa fa-book fa-fw',
    child: [{
      name: '部门管理',
      path: '/views/financialManage/branch.jsp'
    }, {
      name: '收入管理',
      path: '/views/financialManage/income.jsp'
    }, {
      name: '支出管理',
      path: '/views/financialManage/expend.jsp'
    }]
  }, {
    name: '库存管理',
    icon: 'fa fa-truck fa-fw',
    child: [{
      name: '库存详情',
      path: '/views/inventoryManage/stock.jsp'
    }, {
      name: '采购记录',
      path: '/views/inventoryManage/inventoryManage.jsp'
    },
      {
        name: '库存预警',
        path: '/views/inventoryManage/inventoryAlert.jsp'
      }]
  }, {
    name: '公司管理',
    icon: 'fa fa-group fa-fw',
    child: [{
      name: '员工管理',
      path: '/views/personManage/staffManage.jsp'
    }, {
      name: '权限管理',
      path: '/views/personManage/accessManage.jsp'
    }]
  }, {
    name: '维修管理',
    icon: 'fa fa-wrench fa-fw',
    child: [{
      name: '维修工单',
      path: '/views/repair/form.jsp'
    }, {
      name: '维修项目',
      path: '/views/repair/repairItem.jsp'
    }]
  }, {
    name: '维修档案',
    icon: 'fa fa-archive fa-fw',
    child: [{
      name: '车辆档案',
      path: '/views/archives/carArchives.jsp'
    }, {
      name: '客户档案',
      path: '/views/archives/custArchives.jsp'
    }, {
      name: '驾驶员档案',
      path: '/views/archives/driverArchives.jsp'
    }, {
      name: '车型设置',
      path: '/views/archives/carType.jsp'
    }, {
      name: '车辆类型',
      path: '/views/archives/carClass.jsp'
    }, {
      name: '客户类型',
      path: '/views/archives/custClass.jsp'
    }]
  }]

const rules = {
  data() {
    let validUser = (rule, value, callback) => {
      const valid = /^[a-zA-Z0-9_-]{3,12}$/
      if (!valid.test(value)) {
        callback(new Error('请输入正确的用户名'));
      } else {
        callback();
      }
    }
    let validPass = (rule, value, callback) => {
      const valid = /^[a-zA-Z0-9_-]{6,12}$/
      if (value && value.length != 0) {
        if (!valid.test(value)) {
          callback(new Error('请输入正确的密码'));
        } else if (value.length < 6 || value.length > 12) {
          callback(new Error('长度在 6 到 12 个字符'));
        } else {
          callback();
        }
      } else {
        callback();
      }
    }
    return {
      rules: {
        address: [{required: true, message: '请输入地址', trigger: 'blur'}],
        aircraft_type: [{required: true, message: '请输入机型', trigger: 'blur'}],
        assessmentMoney: [{required: true, message: '请输入评估金额', trigger: 'blur'}],
        assessmentName: [{required: true, message: '请输入评估人', trigger: 'blur'}],
        appointment_time: [{required: true, message: '请选择日期', trigger: 'blur'}],
        area: [{required: true, message: '请输入区域', trigger: 'blur'}],
        budget: [{required: true, message: '请输入客户预算', trigger: 'blur'}],
        brand: [{required: true, message: '请输入品牌', trigger: 'blur'}],
        brands: [{required: true, message: '请输入意向品牌', trigger: 'blur'}],
        business: [{required: true, message: '请输入业务员', trigger: 'blur'}],
        brithday: [{required: true, message: '请选择日期', trigger: 'blur'}],
        company: [{required: true, message: '请输入省份', trigger: 'blur'}],
        commercialInsurance: [{required: true, message: '请输入保险金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的保险金额', trigger: 'blur'}],
        chassis_number: [{required: true, message: '请输入底盘号', trigger: 'blur'}],
        carry_number: [{required: true, message: '请输入提单号', trigger: 'blur'}],
        category: [{required: true, message: '请输入类别', trigger: 'blur'}],
        color: {required: true, message: '请输入车身颜色', trigger: 'blur'},
        createTime: [{required: true, message: '请选择时间', trigger: 'blur'}],
        closingDate: [{required: true, message: '请选择时间', trigger: 'blur'}],
        customer_type: {required: true, message: '请选择客户类型', trigger: 'blur'},
        customer_name: {required: true, message: '请选择客户姓名', trigger: 'blur'},
        driver_name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
        deposit: [{required: true, message: '请输入订金', trigger: 'blur'}],
        dealer: [{required: true, message: '请输入经销商', trigger: 'blur'}],
        departmentId: [{required: true, message: '请选择部门', trigger: 'blur'}],
        detailedExpenditure: [{required: true, message: '请输入摘要', trigger: 'blur'}],
        duty: [{required: true, message: '请输入职务', trigger: 'blur'}],
        driver_license_number: [{required: true, message: '请输入驾驶证号', trigger: 'blur'}],
        e_mail: [{required: true, message: '请输入电子邮箱', trigger: 'blur'}],
        engine_number: [{required: true, message: '请输入发动机号', trigger: 'blur'}],
        expenditure: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
        expiry_date: [{required: true, message: '请选择日期', trigger: 'blur'}],
        expenditureMoney: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        first_payment: [{required: true, message: '请输入首付款', trigger: 'blur'},
          {required: 'number', message: '请输入正确的首付款', trigger: 'blur'}],
        fax: [{required: true, message: '请输入传真', trigger: 'blur'}],
        gender: [{required: true, message: '请选择性别', trigger: 'blur'}],
        gearbox_number: [{required: true, message: '请输入变速箱号', trigger: 'blur'}],
        id_number: [{required: true, message: '请输入身份证号', trigger: 'blur'},
          {required: 'number', message: '请输入正确的身份证号', trigger: 'blur'}],
        intention: [{required: true, message: '请输入意向车型', trigger: 'blur'}],
        insurance: [{required: true, message: '请选择保险地址', trigger: 'blur'}],
        internal_number: [{required: true, message: '请输入内部编号', trigger: 'blur'}],
        imported_number: [{required: true, message: '请输入进口证号', trigger: 'blur'}],
        inspection_number: [{required: true, message: '请输入商检号', trigger: 'blur'}],
        income: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
        incomeMoney: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        incomeDetailed: [{required: true, message: '请输入摘要', trigger: 'blur'}],
        kilometres: [{required: true, message: '请输入公里数', trigger: 'blur'},
          {required: 'number', message: '请输入正确的公里数', trigger: 'blur'}],
        key_number: [{required: true, message: '请输入钥匙号', trigger: 'blur'}],
        loanAmount: [{required: true, message: '请输入贷款金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的贷款金额', trigger: 'blur'}],
        library: [{required: true, message: '请选择', trigger: 'blur'}],
        major_accidents: [{required: true, message: '请选择有无重大事故', trigger: 'blur'}],
        maintenance_record: [{required: true, message: '请输入维修记录', trigger: 'blur'}],
        money: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        monthly_number: [{required: true, message: '请输入分期月数', trigger: 'blur'},
          {required: 'number', message: '请输入正确的分期月数', trigger: 'blur'}],
        monthly_supply: [{required: true, message: '请输入月供', trigger: 'blur'},
          {required: 'number', message: '请输入正确的月供', trigger: 'blur'}],
        move_number: [{required: true, message: '请输入手机号', trigger: 'blur'},
          {required: 'number', message: '请输入正确的手机号', trigger: 'blur'}],
        monthlySupply: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        mileage: [{required: true, message: '请输入行驶里程', trigger: 'blur'}],
        model: [{required: true, message: '请输入型号', trigger: 'blur'}],
        name: [{required: true, message: '请输入内容', trigger: 'blur'}],
        names: [{required: true, message: '请输入内容', trigger: 'blur'}],
        number: [{required: true, message: '请输入数量', trigger: 'blur'}],
        nature: [{required: true, message: '请输入性质', trigger: 'blur'}],
        offer: [{required: true, message: '请输入粗略报价', trigger: 'blur'},
          {required: 'number', message: '请输入正确的粗略报价', trigger: 'blur'}],
        office_telephone: [{required: true, message: '请输入办公室电话', trigger: 'blur'},
          {required: 'number', message: '请输入正确的办公室电话', trigger: 'blur'}],
        opening_date: [{required: true, message: '请选择日期', trigger: 'blur'}],
        phone_code: [{required: true, message: '请输入电话', trigger: 'blur'},
          {required: 'number', min: 5, max: 11, message: '请输入正确的电话', trigger: 'blur'}],
        phone: [{required: true, message: '请输入电话', trigger: 'blur'},
          {required: 'number', min: 5, max: 11, message: '请输入正确的电话', trigger: 'blur'}],
        place: [{required: true, message: '请输入产地', trigger: 'blur'}],
        passWord: [{validator: validPass, trigger: 'blur'},
          /*{required: true, message: '请输入密码', trigger: 'blur'}*/],
        person: [{required: true, message: '请输入业务员', trigger: 'blur'}],
        purchase: [{required: true, message: '请输入采购项目', trigger: 'blur'}],
        purchaseMoney: [{required: true, message: '请输入采购金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的采购金额', trigger: 'blur'}],
        p_id: [{required: true, message: '请选择职位', trigger: 'blur'}],
        pId: [{required: true, message: '请选择职位', trigger: 'blur'}],
        price: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        postcode: [{required: true, message: '请输入邮编', trigger: 'blur'},
          {required: 'number', message: '请输入正确的邮编', trigger: 'blur'}],
        province: [{required: true, message: '请输入省份', trigger: 'blur'}],
        phone_number: [{required: true, message: '请输入住宅电话号码', trigger: 'blur'},
          {required: 'number', message: '请输入正确的住宅电话号码', trigger: 'blur'}],
        qualified_number: [{required: true, message: '请输入合格证号', trigger: 'blur'}],
        quasi_driving_type: [{required: true, message: '请输入准驾车型', trigger: 'blur'}],
        region: [{required: true, message: '请输入地区', trigger: 'blur'}],
        range_rover: [{required: true, message: '请输入车名', trigger: 'blur'}],
        remark: [{required: true, message: '请输入详细信息', trigger: 'blur'}],
        repaymentDate: [{required: true, message: '请选择日期', trigger: 'blur'}],
        road_haul: {required: true, message: '请输入行驶里程', trigger: 'blur'},
        source: [{required: true, message: '请输入来源', trigger: 'blur'}],
        service_life: [{required: true, message: '请输入使用年限', trigger: 'blur'},
          {required: 'number', message: '请输入正确的使用年限', trigger: 'blur'}],
        strongDanger: [{required: true, message: '请输入强险金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的强险金额', trigger: 'blur'}],
        selling_price: [{required: true, message: '请输入车辆单价', trigger: 'blur'},
          {required: 'number', message: '请输入正确的车辆单价', trigger: 'blur'}],
        singlePerson: [{required: true, message: '请输入制单人', trigger: 'blur'}],
        single_person: [{required: true, message: '请输入制单人', trigger: 'blur'}],
        singName: [{required: true, message: '请输入制单人', trigger: 'blur'}],
        s_money: [{required: true, message: '请输入售价', trigger: 'blur'},
          {required: 'number', message: '请输入正确的贷款期限', trigger: 'blur'}],
        self_number: [{required: true, message: '请输入自编号', trigger: 'blur'}],
        totalPeriod: [{required: true, message: '请输入贷款期限', trigger: 'blur'},
          {required: 'number', message: '请输入正确的贷款期限', trigger: 'blur'}],
        time: [{required: true, message: '请选择时间', trigger: 'blur'}],
        type: [{required: true, message: '请输入内容', trigger: 'blur'}],
        three_guarantees: [{required: true, message: '请输入三包单位', trigger: 'blur'}],
        userName: [{required: true, message: '请输入用户名', trigger: 'blur'},
          {validator: validUser, trigger: 'blur'},
          {min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur'}],
        vin: [{required: true, message: '请输入VIN号', trigger: 'blur'}],
        vehicle_type: [{required: true, message: '请输入车型', trigger: 'blur'}],
        vehile_number: [{required: true, message: '请输入入库编号', trigger: 'blur'},
          {required: 'number', message: '请输入正确的入库编号', trigger: 'blur'}],
        vehicle_number: [{required: true, message: '请输入车牌号', trigger: 'blur'}],
        vehicleType: [{required: true, message: '请输入车型', trigger: 'blur'}],
        vehicleCode: {required: true, message: '请选择车型', trigger: 'blur'},
        vehicle_code: {required: true, message: '请选择车型', trigger: 'blur'},
        vehicle_classification: {required: true, message: '请输入类型', trigger: 'blur'},
        vehicle_classification_id: {required: true, message: '请选择车型', trigger: 'blur'},
        working_hours: [{required: true, message: '请输入工时', trigger: 'blur'},
          {required: 'number', message: '请输入正确的工时', trigger: 'blur'}]
      }
    }
  }
}

const mixin = {
  data() {
    return {
      isCollapse: false,
      menu: Menu,
      footer: '©2019 智莱云 All rights resered 石家庄智莱云信息技术公司提供技术支持',
      breadcrumb: {first: '', second: ''},
      page: 1
    }
  },
  computed: {
    logo() {
      return this.isCollapse ? '喔' : '喔驰管理系统'
    }
  },
  methods: {
    getBreadcrumb() {
      if (this.navActive !== '0') {
        let t = this.navActive.split('-')
        this.breadcrumb = {
          first: this.menu[parseInt(t[0])].name,
          second: this.menu[parseInt(t[0])].child[parseInt(t[1]) - 1].name
        }
      }
    },
    handleCommand(command) {
    },
    getHrefParam(key) {
      var s = window.location.href;
      var reg = new RegExp(key + "=\\w+");
      var rs = reg.exec(s);
      if (rs === null || rs === undefined) {
        return "";
      } else {
        return rs[0].split("=")[1];
      }
    },
    goBack() {
      window.history.back();
      return false;
    },
    dateFormat(row, column, cellValue, index) {
      let date = new Date(cellValue);
      let y = date.getFullYear();
      let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      return y + "-" + m + "-" + d;
    },
    notifyError(msg) {
      this.$alert(msg, '提示', {
        type: 'error',
        confirmButtonText: '确定'
      });
    },
    notifySuc(msg, path) {
      this.$alert(msg, '提示', {
        confirmButtonText: '确定',
        type: 'success',
        callback: action => {
          window.location.href = path
        }
      });
    },
    notifyNoPath(message) {
      this.$notify({
        title: '成功',
        message,
        type: 'success'
      });
    },
    onLoad(url, data) {
      $.ajax({
        type: 'post',
        url,
        data,
        dataType: 'json',
        success: (res) => {
          if (res.code === 1) {
            Object.assign(this.ruleForm, res.data)
          } else {
            this.$notify({
              title: '警告',
              message: res.msg,
              type: 'warning'
            });
          }
        },
        error: (res) => {
          this.$notify({
            title: '警告',
            message: res.msg,
            type: 'warning'
          });
        }
      })
    },
    getTable(data, url_a, url_b, arr) {
      this.loading2 = true
      this.page = data.page
      $.ajax({
        type: 'post',
        url: this.searchVal.length === 0 ? url_a : url_b,
        data,
        dataType: 'json',
        success: (res) => {
          this.loading2 = false
          if (res.code === 1) {
            if (res.data !== 'null') {
              arr ? arr.data = res.data : this.tableData.data = res.data
            } else {
              this.tableData.data = []
            }
            arr ? arr.count = res.count : this.tableData.count = res.count
          } else {
            this.notifyError(res.msg)
          }
        },
        error: (res) => {
          this.notifyError(res.msg)
        }
      })
    }
  },
  created() {
    this.getBreadcrumb()
  }
}
