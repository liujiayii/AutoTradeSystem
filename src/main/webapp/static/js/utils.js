let javas = 'javascript:;'
let Menu = [
  {
    name: '首页',
    path: '/pages/test/test.jsp',
    icon: 'fa fa-home fa-fw'
  }, {
    name: '客户信息',
    icon: 'fa fa-address-book fa-fw',
    child: [{
      name: '车辆资源',
      path: '/pages/customerInfo/carResources.jsp'
    }, {
      name: '买车咨询',
      path: '/pages/customerInfo/buyingCarConsult.jsp'
    }, {
      name: '置换车辆',
      path: '/pages/customerInfo/replaceCar.jsp'
    }]
  }, {
    name: '交易管理',
    icon: 'fa fa-suitcase fa-fw',
    child: [{
      name: '评估审核',
      path: '/pages/tradeManage/evaluation.jsp'
    }, {
      name: '保险凭证',
      path: '/pages/tradeManage/insurance.jsp'
    }, {
      name: '分期管理',
      path: '/pages/tradeManage/stateManage.jsp'
    }]
  }, {
    name: '售车管理',
    icon: 'fa fa-car fa-fw',
    child: [{
      name: '订车管理',
      path: '/pages/carSales/booking.jsp'
    }, {
      name: '售车管理',
      path: '/pages/carSales/carSales.jsp'
    }, {
      name: '退车管理',
      path: '/pages/carSales/carSales.jsp'
    }]
  }, {
    name: '车辆管理',
    icon: 'fa fa-cab fa-fw',
    child: [{
      name: '车辆管理',
      path: '/pages/carManage/carManage.jsp'
    }, {
      name: '车辆信息',
      path: '/pages/carManage/carinformation.jsp'
    }]
  }, {
    name: '财务管理',
    icon: 'fa fa-book fa-fw',
    child: [{
      name: '部门管理',
      path: '/pages/financialManage/branch.jsp'
    }, {
      name: '收入管理',
      path: '/pages/financialManage/income.jsp'
    }, {
      name: '支出管理',
      path: '/pages/financialManage/expend.jsp'
    }]
  }, {
    name: '库存管理',
    icon: 'fa fa-truck fa-fw',
    child: [{
      name: '汽车配件',
      path: '/pages/inventoryManage/inventoryManage.jsp'
    }, {
      name: '其他',
      path: '/pages/inventoryManage/inventoryManage.jsp'
    }]
  }, {
    name: '公司管理',
    icon: 'fa fa-group fa-fw',
    child: [{
      name: '员工管理',
      path: '/pages/personManage/staffManage.jsp'
    }, {
      name: '权限管理',
      path: '/pages/personManage/accessManage.jsp'
    }]
  }, {
    name: '维修管理',
    icon: 'fa fa-wrench fa-fw',
    child: [{
      name: '维修工单',
      path: '/pages/repair/form.jsp'
    }, {
      name: '车辆档案',
      path: '/pages/repair/carArchives.jsp'
    }, {
      name: '维修工时',
      path: '/pages/repair/repairTime.jsp'
    }, {
      name: '维修项目',
      path: '/pages/repair/repairItem.jsp'
    }, {
      name: '项目用料',
      path: '/pages/repair/itemUsed.jsp'
    }]
  }, {
    name: '维修档案',
    icon: 'fa fa-archive fa-fw',
    child: [{
      name: '客户档案',
      path: javas
    }, {
      name: '车辆档案',
      path: javas
    }, {
      name: '员工档案',
      path: javas
    }, {
      name: '驾驶员信息档案',
      path: javas
    }]
  }, {
    name: '报表管理',
    icon: 'fa fa-wpforms fa-fw',
    child: [{
      name: '维修报表',
      path: javas
    }, {
      name: '售车报表',
      path: javas
    }, {
      name: '进车报表',
      path: javas
    }]
  }]

const mixin = {
  data() {
    return {
      isCollapse: false,
      menu: Menu,
      rules: {
        address: [{required: true, message: '请输入地址', trigger: 'blur'}],
        assessmentMoney: [{required: true, message: '请输入评估金额', trigger: 'blur'}],
        assessmentName: [{required: true, message: '请输入评估人', trigger: 'blur'}],
        budget: [{required: true, message: '请输入客户预算', trigger: 'blur'}],
        brand: [{required: true, message: '请输入品牌', trigger: 'blur'}],
        brands: [{required: true, message: '请输入意向品牌', trigger: 'blur'}],
        business: [{required: true, message: '请输入业务员', trigger: 'blur'}],
        commercialInsurance: [{required: true, message: '请输入保险金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的保险金额', trigger: 'blur'}],
        chassis_number: [{required: true, message: '请输入底盘号', trigger: 'blur'}],
        carry_number: [{required: true, message: '请输入提单号', trigger: 'blur'}],
        color: {required: true, message: '请输入车牌颜色', trigger: 'blur'},
        createTime: [{required: true, message: '请选择时间', trigger: 'blur'}],
        deposit: [{required: true, message: '请输入订金', trigger: 'blur'}],
        departmentId: [{required: true, message: '请选择部门', trigger: 'blur'}],
        detailedExpenditure: [{required: true, message: '请输入摘要', trigger: 'blur'}],
        engine_number: [{required: true, message: '请输入发动机号', trigger: 'blur'}],
        expenditure: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
        expenditureMoney: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        first_payment: [{required: true, message: '请输入首付款', trigger: 'blur'},
          {required: 'number', message: '请输入正确的首付款', trigger: 'blur'}],
        intention: [{required: true, message: '请输入意向车型', trigger: 'blur'}],
        insurance: [{required: true, message: '请选择保险地址', trigger: 'blur'}],
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
        major_accidents: [{required: true, message: '请选择有无重大事故', trigger: 'blur'}],
        maintenance_record: [{required: true, message: '请输入维修记录', trigger: 'blur'}],
        money: [{required: true, message: '请输入成交价', trigger: 'blur'},
          {required: 'number', message: '请输入正确的成交价', trigger: 'blur'}],
        monthly_number: [{required: true, message: '请输入分期月数', trigger: 'blur'},
          {required: 'number', message: '请输入正确的分期月数', trigger: 'blur'}],
        monthly_supply: [{required: true, message: '请输入月供', trigger: 'blur'},
          {required: 'number', message: '请输入正确的月供', trigger: 'blur'}],
        monthlySupply: [{required: true, message: '请输入金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的金额', trigger: 'blur'}],
        mileage: [{required: true, message: '请输入行驶里程', trigger: 'blur'}],
        name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
        number: [{required: true, message: '请输入预定数量', trigger: 'blur'}],
        offer: [{required: true, message: '请输入粗略报价', trigger: 'blur'},
          {required: 'number', message: '请输入正确的粗略报价', trigger: 'blur'}],
        phone: [{required: true, message: '请输入电话', trigger: 'blur'},
          {required: 'number', min: 5, max: 11, message: '请输入正确的电话', trigger: 'blur'}],
        place: [{required: true, message: '请输入产地', trigger: 'blur'}],
        person: [{required: true, message: '请输入业务员', trigger: 'blur'}],
        purchase: [{required: true, message: '请输入采购项目', trigger: 'blur'}],
        purchaseMoney: [{required: true, message: '请输入采购金额', trigger: 'blur'},
          {required: 'number', message: '请输入正确的采购金额', trigger: 'blur'}],
        p_id: [{required: true, message: '请选择职位', trigger: 'blur'}],
        pId: [{required: true, message: '请选择职位', trigger: 'blur'}],
        qualified_number: [{required: true, message: '请输入合格证号', trigger: 'blur'}],
        remark: [{required: true, message: '请输入详细信息', trigger: 'blur'}],
        repaymentDate: [{required: true, message: '请选择日期', trigger: 'blur'}],
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
        type: [{required: true, message: '请选择', trigger: 'blur'}],
        vehicle_type: [{required: true, message: '请输入车型', trigger: 'blur'}],
        vehile_number: [{required: true, message: '请输入入库编号', trigger: 'blur'},
          {required: 'number', message: '请输入正确的入库编号', trigger: 'blur'}],
        vehicleType: [{required: true, message: '请输入车型', trigger: 'blur'}],
        vehicleCode: {required: true, message: '请选择车型', trigger: 'blur'},
        vehicle_code: {required: true, message: '请选择车型', trigger: 'blur'},
      },
      footer: '©2018 智莱云 All rights resered 石家庄智莱云信息技术有限公司'
    }
  },
  computed: {
    logo() {
      return this.isCollapse ? '喔' : '喔驰管理系统'
    }
  },
  methods: {
    handleCommand(command) {
      console.log(command)
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
          console.log(res)
          if (res.code == 1) {
            Object.assign(this.ruleForm, res.data)
          }
        },
        error: (res) => {
          console.log(res)
        }
      })
    },
    getTable(data, url_a, url_b,) {
      this.loading2 = true
      $.ajax({
        type: 'post',
        url: this.searchVal.length == 0 ? url_a : url_b,
        data,
        dataType: 'json',
        success: (res) => {
          console.log(res)
          if (res.code == 1) {
            if (res.data != 'null') {
              this.tableData.data = res.data
            } else {
              this.tableData.data = []
              this.notifyError(res.msg)
            }
            this.tableData.count = res.count
            this.loading2 = false
          } else {
            console.log('aa')
            this.notifyError(res.msg)
          }
        },
        error: (res) => {
          this.notifyError(res.msg)
        }
      })
    }

  }
}
