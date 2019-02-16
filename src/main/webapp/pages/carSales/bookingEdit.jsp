<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">订车管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-input v-model="ruleForm.id"></el-input>
      <el-input v-model="ruleForm.c_id"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.c_id)" placeholder="请输入电话进行搜索">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search" @click="search"></el-button>
            </el-input>
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
          <el-form-item label="车型类型" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="place">
            <el-input v-model="ruleForm.place" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="厂牌型号" prop="brand">
            <el-input v-model="ruleForm.brand" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车辆单价" prop="selling_price">
            <el-input v-model="ruleForm.selling_price" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="购买信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="预定数量" prop="number">
            <el-input v-model="ruleForm.number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="订金" prop="deposit">
            <el-input v-model="ruleForm.deposit"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="交车时间" prop="time">
            <el-date-picker v-model="ruleForm.time" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="singlePerson">
            <el-input v-model="ruleForm.singlePerson" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务员" prop="business">
            <el-input v-model="ruleForm.business" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="ruleForm.remark" type="textarea" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
        <el-button @click="goBack">返回</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</el-card>
</el-main>
<el-footer>{{footer}}</el-footer>
</el-container>
</el-container>
</el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '3-1',
        dialogTableVisible: false,
        ruleForm: {
          buyingId: '',
          name: '',
          address: '',
          phone: '',
          vehicleCode: '',
          vehicle_type: '',
          brand: '',
          place: '',
          selling_price: '',
          number: '',
          deposit: '',
          time: '',
          business: '',
          remark: '',
          singlePerson: '${user.name}'
        },
        /*  carForm: {
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
         }, */
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true
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
            delete this.ruleForm['name']
            delete this.ruleForm['address']
            delete this.ruleForm['phone']
            delete this.ruleForm['createTime']
            delete this.ruleForm['vehicle_type']
            delete this.ruleForm['brand']
            delete this.ruleForm['place']
            delete this.ruleForm['selling_price']
            this.ruleForm['time'] = new Date(this.ruleForm['time']);
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/booking/updatebooking.action' : '/booking/insertbooking.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "booking.jsp"
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
              this.ruleForm.buyingId = res.data.id
            } else {
              this.$confirm(res.msg, '提示', {
                distinguishCancelAndClose: true,
                confirmButtonText: '确定',
                cancelButtonText: '前往添加客户信息',
                type: 'warning'
              }).then(() => {
                for (let key in this.ruleForm) {
                  this.ruleForm[key] = ''
                }
              }).catch(action => {
                if (action == 'cancel') {
                  window.location.href = '/pages/customerInfo/buyingCarConsult.jsp'
                }
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
        delete row['id']
        Object.assign(this.ruleForm, row);
        this.dialogTableVisible = !this.dialogTableVisible
      },
    },
    created() {
      this.getTable(1)
      if (this.getHrefParam('id')) {

        $.ajax({
          type: 'post',
          url: '/booking/findById.action',
          data: {
            id: this.getHrefParam('id')
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
