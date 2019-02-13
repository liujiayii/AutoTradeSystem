<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">订车管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      id
      <el-input v-model="ruleForm.id"></el-input>
      cid
      <el-input v-model="ruleForm.c_id"></el-input>
      vid
      <el-input v-model="ruleForm.v_id"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.c_id)">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search" @click="search"></el-button>
            </el-input>
            <!--<el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>-->
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="ruleForm.address" readonly></el-input>
      </el-form-item>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="车型代码" prop="vehicleCode">
            <el-input v-model="ruleForm.vehicleCode" placeholder="点我" @focus="dialogTableVisible = true"></el-input>
          </el-form-item>
          <el-dialog title="车型代码" :visible.sync="dialogTableVisible">
            <el-table v-loading="loading2"
                      element-loading-text="拼命加载中"
                      stripe
                      size="small"
                      element-loading-spinner="el-icon-loading"
                      :data="tableData.data"
                      style="width: 100%">
              <el-table-column label="车型代码" prop="vehicleCode" show-overflow-tooltip></el-table-column>
              <el-table-column label="车型" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="厂牌型号" prop="brand" show-overflow-tooltip></el-table-column>
              <el-table-column label="地址" prop="place"></el-table-column>
              <el-table-column align="right">
                <template slot="header" slot-scope="scope">
                  <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
                </template>
                <template slot-scope="scope">
                  <el-button size="mini" @click="handlebooking(scope.$index, scope.row)">预定</el-button>
                </template>
              </el-table-column>
            </el-table>
            <el-container class="page-box">
              <div class="block">
                <el-pagination
                        @current-change="handleCurrentChange"
                        layout="total,prev, pager, next, jumper"
                        :total="tableData.count">
                </el-pagination>
              </div>
            </el-container>
          </el-dialog>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车型类型" prop="type">
            <el-input v-model="ruleForm.type" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="addressOne">
            <el-input v-model="ruleForm.addressOne" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="厂牌型号" prop="typeNumber">

            <el-input v-model="ruleForm.typeNumber" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车辆单价" prop="money">
            <el-input v-model="ruleForm.money" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="购买信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="预定数量" prop="number" :rules="[ { required: true, message: '预定数量', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.number21·"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="订金" prop="deposit" :rules="[ { required: true, message: '请输入订金', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.deposit"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="交车时间" prop="time" :rules="[ { required: true, message: '交车时间', trigger: 'blur' } ]">
            <el-date-picker v-model="ruleForm.time" type="date" placeholder="选择日期"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="singlePerson"
                        :rules="[ { required: true, message: '请输入制单人', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.singlePerson" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务员" prop="business"
                        :rules="[ { required: true, message: '请输入业务员', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.business" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注" prop="remark" :rules="[ { required: true, message: '请输入详细信息', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.remark" type="textarea" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</el-card>
</el-main>
<el-footer>©2018 智莱云 All rights resered 石家庄智莱云信息技术有限公司</el-footer>
</el-container>
</el-container>
</el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    data: function () {
      return {
        navActive: '3-1',
        isCollapse: false,
        dialogTableVisible: false,
        ruleForm: {
          name: '',
          address: '',
          id: '',
          phone: '',
          type: '',
          money: '',
          first_payment: '',
          monthly_number: '',
          monthly_supply: '',
          insurance: '',
          s_money: '',
          business: '',
          single_person: '${user.name}'
        },
        carForm: {
          vehile_number: '',
          vehicle_type: '',
          brand: '',
          engine_number: '',
          qualified_number: '',
          chassis_number: '',
          imported_number: '',
          inspection_number: '',
          carry_number: '',
          self_number: '',
          key_number: '',
          mileage: '',
          selling_price: ''
        },
        rules: {},
        loading2: true,
        tableData: {
          data: [],
          count: 0
        },
        searchVal: ''
      }
    },
    methods: {
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.ruleForm.v_id = this.carForm.id
            this.ruleForm.vehile_number = this.carForm.vehile_number
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.c_id ? '/sellCar/updateSellCar.action' : '/sellCar/addSellCar.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "carSales.jsp"
                    }
                  });
                } else {
                  this.$alert(res.msg, '提示', {
                    type: 'error',
                    confirmButtonText: '确定'
                  });
                }
              },
              error: (res) => {
                console.log(res)
                this.$alert(res.msg, '提示', {
                  type: 'error',
                  confirmButtonText: '确定'
                });
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      // 获取地址栏参数，name:参数名称
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
      search() {
        $.ajax({
          type: 'post',
          url: '/sellCar/findClientByPhone.action',
          data: {phone: this.ruleForm.phone},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm.name = res.data.name
              this.ruleForm.address = res.data.address
              this.ruleForm.id = res.data.id
            } else {
              this.$confirm(res.msg, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '前往添加客户信息',
                type: 'warning'
              }).then(() => {
                for (let key in this.ruleForm) {
                  this.ruleForm[key] = ''
                }
              }).catch(() => {
                window.location.href = '/pages/customerInfo/buyingCarConsult.jsp'
              });
            }
          }
        })


      },
      searchbook() {
        $.ajax({
          type: 'post',
          url: '/sellCar/findCarByNumber.action',
          data: {
            vehile_number: this.carForm.vehile_number
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.carForm = res.data
            } else {
              for (let key in this.carForm) {
                this.carForm[key] = ''
              }
              this.$notify.error({
                title: '警告',
                message: res.msg,
                position: 'bottom-right',
                offset: 300
              })
            }
          },
          error: (res) => {
            this.$notify.error({
              title: '警告',
              message: res.msg,
              position: 'bottom-right',
              offset: 300
            })
          }
        })


      },
      getTable(page) {
        this.loading2 = true
        $.ajax({
          type: 'post',
          url: this.searchVal.length == 0 ? '/VehichileDetailed/selectAll.action' : '/VehichileDetailed/hybridSelect.action',
          data: {
            limit: 10,
            page: page,
            s: this.searchVal
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              if (res.data != 'null') {
                Object.assign(this.tableData.data, res.data)
              } else {
                this.tableData.data = []
                this.$notify.error({
                  title: '警告',
                  message: res.msg,
                  position: 'bottom-right',
                  offset: 300
                })
              }
              this.tableData.count = res.count
              this.loading2 = false
            } else {
              console.log('aa')
              this.$notify.error({
                title: '警告',
                message: res.msg,
                position: 'bottom-right',
                offset: 300
              })
            }
          },
          error: (res) => {
            this.$notify.error({
              title: '警告',
              message: res.msg,
              position: 'bottom-right',
              offset: 300
            })
          }
        })
      },
      handlebooking(index, row) {
        console.log(row);
        Object.assign(this.ruleForm, row);
        this.dialogTableVisible = !this.dialogTableVisible
      },
    },
    created() {
      this.getTable(1)
      if (this.getHrefParam('id')) {
        $.ajax({
          type: 'post',
          url: '/sellCar/findById.action',
          data: {
            c_id: this.getHrefParam('id')
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm = res.data
              this.carForm = res.data
            }
          },
          error: (res) => {
            console.log(res)
          }
        })
      }
    }
  })
</script>
</html>
