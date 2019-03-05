<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <template v-if=" this.ruleForm.state < 2">
    <el-button-group>
      <el-button v-show="activeName != 'first'" class="btn" type="info" icon="el-icon-plus" round
                 @click="activeName == 'second' ? dialogTableVisible=true : dialogTableVisibles=true">添加{{activeName ==
        'second' ? '项目' : '材料'}}
      </el-button>
      <template v-if="activeName == 'third' && tableData.count!=0">
        <el-button class="btn" type="info" @click="goPrint('data')">打印材料单</el-button>
      </template>
    </el-button-group>
  </template>
  <template v-if="activeName == 'first'">
    <el-button v-if="this.ruleForm.state ==0 || this.ruleForm.state ==1" @click="next"
               class="btn" type="info">{{this.ruleForm.state == 0 ? '转在修' : '完工'}}
    </el-button>
    <template v-if="this.ruleForm.state ==2||this.ruleForm.state ==3">
      <el-button @click="balance" class="btn" type="info">结算/结账</el-button>
      <el-dialog title="结算/结账" :visible.sync="dialogTableVisible6">
        <el-form :model="BalanceRuleForm" ref="BalanceRuleForm" inline label-width="100px">
          <el-form-item label="结账日期" prop="closingDate">
            <el-date-picker style="width: 202px"
                            v-model="BalanceRuleForm.closingDate"
                            type="date"
                            placeholder="选择日期"
                            value-format="timestamp">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="支付方式" prop="type">
            <el-select style="width: 202px" v-model="BalanceRuleForm.type" placeholder="请选择支付方式">
              <el-option label="支付宝" value="支付宝"></el-option>
              <el-option label="微信" value="微信"></el-option>
              <el-option label="现金" value="现金"></el-option>
              <el-option label="信用卡" value="信用卡"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="应收金额" prop="t_money">
            <el-input v-model="BalanceRuleForm.t_money" readonly></el-input>
          </el-form-item>
          <el-form-item label="实收金额" prop="money">
            <el-input v-model="BalanceRuleForm.money"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer">
          <el-button type="info" @click="sub('3')">结算</el-button>
          <el-button type="info" @click="sub('4')">结账</el-button>
        </div>
      </el-dialog>
    </template>
    <template v-if="this.ruleForm.state ==4">
      <el-button class="btn" type="info" @click="goPrint('balance')">打印结算单</el-button>
    </template>
  </template>
  <el-dialog title="添加项目" :visible.sync="dialogTableVisible">
    <el-table v-loading="loading2"
              element-loading-text="拼命加载中"
              stripe
              size="small"
              element-loading-spinner="el-icon-loading"
              :data="diaTableData.data"
              style="width: 100%">
      <el-table-column label="项目编号" prop="id" show-overflow-tooltip></el-table-column>
      <el-table-column label="项目分类" prop="names" show-overflow-tooltip></el-table-column>
      <el-table-column label="项目名称" prop="name" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)">选择</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-container class="page-box">
      <div class="block">
        <el-pagination
                @current-change="handleCurrentChanges"
                layout="total,prev, pager, next, jumper"
                :total="diaTableData.count">
        </el-pagination>
      </div>
    </el-container>
  </el-dialog>
  <el-dialog title="添加材料" :visible.sync="dialogTableVisibles" @close="closeDialog">
    <el-form :model="ruleForms" ref="ruleForms" inline label-width="100px" :rules="rules">
      <el-form-item label="品牌" prop="brand">
        <el-input v-model="ruleForms.brand"></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="number">
        <el-input v-model="ruleForms.number" @input="money" type="number"></el-input>
      </el-form-item>
      <el-form-item label="单价" prop="price">
        <el-input v-model="ruleForms.price" @input="money" type="number"></el-input>
      </el-form-item>
      <el-form-item label="总价钱" prop="money">
        <el-input v-model="ruleForms.money" readonly></el-input>
      </el-form-item>
      <el-form-item label="维修工单id" prop="repair_id">
        <el-input v-model="ruleForms.repair_id" readonly></el-input>
      </el-form-item>
      <el-form-item label="型号" prop="model">
        <el-input v-model="ruleForms.model"></el-input>
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input v-model="ruleForms.name"></el-input>
      </el-form-item>
      <el-row>
        <el-col :span="24">
          <el-form-item>
            <el-button type="info" @click="submitFormss('ruleForms')">确定</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </el-dialog>
</el-container>
<el-tabs v-model="activeName" :before-leave="tabsClick">
  <el-tab-pane label="工单明细" name="first">
    <el-card shadow="hover">
      <el-steps :active="parseInt(ruleForm.state)+1" finish-status="success">
        <el-step title="预约"></el-step>
        <el-step title="在修"></el-step>
        <el-step title="完工"></el-step>
        <el-step title="结算"></el-step>
        <el-step title="结账"></el-step>
      </el-steps>
      <el-container class="main">
        <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px" :rules="rules">
          <el-row>
            <el-col :span="24">
              <el-form-item label="客户基本信息"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="内部工号">
            <el-input v-model="ruleForm.internal_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车型分类">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="车辆号码" prop="vehicle_number">
            <el-input style="width: 202px" v-model="ruleForm.vehicle_number">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search"
                         @click="searchCar"></el-button>
            </el-input>
          </el-form-item>
          <el-form-item label="使用性质">
            <el-input v-model="ruleForm.nature" readonly></el-input>
          </el-form-item>
          <el-form-item label="VIN号">
            <el-input v-model="ruleForm.vin" readonly></el-input>
          </el-form-item>
          <el-form-item label="内部编号">
            <el-input v-model="ruleForm.internal_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车型">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="车名">
            <el-input v-model="ruleForm.range_rover" readonly></el-input>
          </el-form-item>
          <el-form-item label="机型">
            <el-input v-model="ruleForm.aircraft_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="厂牌">
            <el-input v-model="ruleForm.brand" readonly></el-input>
          </el-form-item>
          <el-form-item label="发动机号">
            <el-input v-model="ruleForm.engine_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="底盘号">
            <el-input v-model="ruleForm.chassis_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="变速箱号">
            <el-input v-model="ruleForm.gearbox_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车身颜色">
            <el-input v-model="ruleForm.color" readonly></el-input>
          </el-form-item>
          <el-form-item label="行驶里程数" prop="road_haul">
            <el-input v-model="ruleForm.road_haul"></el-input>
          </el-form-item>

          <el-row>
            <el-col :span="24">
              <el-form-item label="产品属性："></el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="运营单位">
                <el-input v-model="ruleForm.company" readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="联系人">
            <el-input v-model="ruleForm.customer_name" readonly></el-input>
          </el-form-item>
          <el-form-item label="联系电话">
            <el-input v-model="ruleForm.phone_number" readonly></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="送检人员："></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="送检人">
            <el-input v-model="ruleForm.driver_name" readonly></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="ruleForm.office_telephone" readonly></el-input>
          </el-form-item>
          <el-form-item label="手机">
            <el-input v-model="ruleForm.move_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="驾驶证号">
            <el-input v-model="ruleForm.driver_license_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="身份证号">
            <el-input v-model="ruleForm.id_number" readonly></el-input>
          </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="车辆信息："></el-form-item>
            </el-col>
            <el-form-item label="车辆备注">
              <el-input type="textarea" :rows="2" placeholder="请输入车辆备注" v-model="ruleForm.remark"></el-input>
            </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="维修信息："></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="业务员" prop="entry_person">
            <el-input v-model="ruleForm.entry_person" readonly></el-input>
          </el-form-item>
          <el-form-item label="预约进厂日期" prop="appointment_time">
            <el-date-picker style="width: 202px" v-model="ruleForm.appointment_time" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="结算日期" prop="settlement">
            <el-date-picker style="width: 202px" v-model="ruleForm.settlement" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="结帐日期" prop="closing_date">
            <el-date-picker style="width: 202px" v-model="ruleForm.closing_date" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="结账金额">
            <el-input v-model="ruleForm.money"></el-input>
          </el-form-item>
          <el-form-item label="结账方式">
            <el-input v-model="ruleForm.type"></el-input>
          </el-form-item>
          <el-row v-if="!Boolean(this.getHrefParam('id'))">
            <el-col :span="24">
              <el-form-item>
                <el-button type="info" @click="submitForm('ruleForm')">保存</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-container>
    </el-card>
  </el-tab-pane>
  <el-tab-pane label="修理工单" name="second">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="项目名称" prop="name" show-overflow-tooltip></el-table-column>
          <el-table-column label="工时" prop="working_hours" show-overflow-tooltip></el-table-column>
          <el-table-column label="工时单价" prop="price" show-overflow-tooltip></el-table-column>
          <el-table-column label="工时费" prop="money" show-overflow-tooltip></el-table-column>
          <el-table-column label="维修人员" prop="repairman" show-overflow-tooltip></el-table-column>
          <template v-if=" this.ruleForm.state <2">
            <el-table-column label="派工">
              <template slot-scope="scope">
                <i class="fa fa-user-md fa-lg" @click="handleWork(scope.$index, scope.row)"></i>
              </template>
            </el-table-column>
            <el-table-column>
              <template slot-scope="scope">
                <el-button type="info" size="mini" @click="handleEdit5(scope.$index, scope.row)">编辑</el-button>
              </template>
            </el-table-column>
          </template>
        </el-table>
        <el-dialog title="工单编辑" :visible.sync="dialogTableVisible5" @close="closeDialog">
          <el-form :model="ruleForm5" ref="ruleForm5" inline label-width="100px" :rules="rules">
            <el-form-item label="工时" prop="working_hours">
              <el-input v-model="ruleForm5.working_hours" @input="count" type="number"></el-input>
            </el-form-item>
            <el-form-item label="工时单价" prop="price">
              <el-input v-model="ruleForm5.price" @input="count" type="number"></el-input>
            </el-form-item>
            <el-form-item label="工时费" prop="money">
              <el-input v-model="ruleForm5.money" readonly></el-input>
            </el-form-item>
            <el-row>
              <el-col :span="24">
                <el-form-item>
                  <el-button type="info" @click="submitForm5('ruleForm5')">确定</el-button>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-dialog>
        <el-dialog title="派工师傅" :visible.sync="dialogFormVisible" width="500px" @close="closeDia">
          <el-form :model="form" ref="form" :rules="rules" label-width="120px">
            <el-form-item label="项目师傅">
              <el-select v-model="form.name" placeholder="请选择项目师傅">
                <el-option :label="item.name" v-for="(item, index) in form.data" :key="index"
                           :value="item.name"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="info" @click="submitForms('form')">确定</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
      </el-container>
    </el-card>
    <el-container class="page-box">
      <div class="block">
        <el-pagination
                @current-change="handleCurrentChange"
                layout="total,prev, pager, next, jumper"
                :total="tableData.count">
        </el-pagination>
      </div>
    </el-container>
  </el-tab-pane>
  <el-tab-pane label="材料明细" name="third">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="商品名称" prop="name" show-overflow-tooltip></el-table-column>
          <el-table-column label="商品型号" prop="model" show-overflow-tooltip></el-table-column>
          <el-table-column label="品牌" prop="brand" show-overflow-tooltip></el-table-column>
          <el-table-column label="数量" prop="number" show-overflow-tooltip></el-table-column>
          <el-table-column label="单价" prop="price" show-overflow-tooltip></el-table-column>
          <el-table-column label="总额" prop="money" show-overflow-tooltip></el-table-column>
          <template v-if=" this.ruleForm.state <2">
            <el-table-column align="right">
              <template slot-scope="scope">
                <el-button type="info" size="mini" @click="handleEdit3(scope.$index, scope.row)">编辑</el-button>
                <el-button type="danger" size="mini" @click="handleEdit4(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </template>
        </el-table>
      </el-container>
    </el-card>
    <el-container class="page-box">
      <div class="block">
        <el-pagination
                @current-change="handleCurrentChange"
                layout="total,prev, pager, next, jumper"
                :total="tableData.count">
        </el-pagination>
      </div>
    </el-container>
  </el-tab-pane>
</el-tabs>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin, rules],
    data: function () {
      return {
        navActive: '8-1',
        activeName: 'first',
        tableData: {
          data: [],
          count: 0
        },
        diaTableData: {
          data: [],
          count: 0
        },
        dialogTableVisible: false,
        dialogTableVisibles: false,
        dialogTableVisible6: false,
        searchVal: '',
        loading2: true,
        ruleForm: {
          address: '',
          aircraft_type: '',
          appointment_time: '',
          area: '',
          brand: '',
          brithday: '',
          category: '',
          chassis_number: '',
          closing_date: '',
          color: '',
          company: '',
          customer_archives_id: '',
          customer_id: '',
          customer_name: '',
          customer_type: '',
          dealer: '',
          driver_id: '',
          driver_license_number: '',
          driver_name: '',
          duty: '',
          e_mail: '',
          engine_number: '',
          enter_time: '',
          entry_person: '${user.name}',
          expiry_date: '',
          fax: '',
          gearbox_number: '',
          gender: '',
          id_number: '',
          internal_number: '',
          model_definition_id: '',
          money: '',
          move_number: '',
          nature: '',
          office_telephone: '',
          opening_date: '',
          phone_number: '',
          postcode: '',
          province: '',
          quasi_driving_type: '',
          range_rover: '',
          region: '',
          remark: '',
          settlement: '',
          source: '',
          state: -1,
          three_guarantees: '',
          type: '',
          vehicle_id: '',
          vehicle_note: '',
          vehicle_number: '',
          vehicle_type: '',
          vin: '',
          road_haul: ''
        },
        dialogFormVisible: false,
        dialogTableVisible5: false,
        form: {
          data: []
        },
        repair_id: this.getHrefParam('repair_id') ? this.getHrefParam('repair_id') : '',
        ruleForms: {
          repair_id: this.getHrefParam('repair_id') ? this.getHrefParam('repair_id') : '',
          brand: '',
          model: '',
          money: '',
          name: '',
          number: '',
          price: '',
        },
        ruleForm5: {working_hours: '', price: ''},
        balanceData: [],
        BalanceRuleForm: {
          id: '',
          t_money: '',
          state: ''
        }
      }
    },
    methods: {
      goPrint(type) {
        window.location.href = 'print.jsp?id=' + this.repair_id + '&type=' + type
      },
      sub(e) {
        this.BalanceRuleForm.state = e
        $.ajax({
          type: 'post',
          url: '/carRecord/windUpAnAccount.action',
          contentType: "application/json",
          data: JSON.stringify(this.BalanceRuleForm),
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
              this.notifySuc(res.msg, 'form.jsp')
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      balance() {
        this.dialogTableVisible6 = true
        $.ajax({
          type: 'post',
          url: '/carRecord/closeAnAccount.action',
          data: {id: this.repair_id},
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.BalanceRuleForm.t_money = res.data
              this.BalanceRuleForm.id = this.repair_id
              this.notifyNoPath(res.msg)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      count() {
        let t = this.ruleForm5.working_hours == '' ? 1 : parseInt(this.ruleForm5.working_hours)
        let l = this.ruleForm5.price == '' ? 1 : parseInt(this.ruleForm5.price)
        this.ruleForm5.money = l * t
      },
      next() {
        this.$confirm(' 是否继续更改订单状态?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          $.ajax({
            type: 'post',
            url: '/Repair/upadteState.action',
            data: {id: this.repair_id, state: parseInt(this.ruleForm.state) + 1},
            dataType: 'json',
            success: (res) => {
              if (res.code == 1) {
                this.ruleForm.state = parseInt(this.ruleForm.state) + 1
                this.notifyNoPath(res.msg)
              } else {
                this.notifyError(res.msg)
              }
            },
            error: (res) => {
              this.notifyError(res.msg)
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
        });
      },
      closeDia() {
        this.form.name = ''
      },
      closeDialog() {
        this.ruleForms = {
          repair_id: this.repair_id, brand: '',
          model: '',
          money: '',
          name: '',
          number: '',
          price: '',
        }
        this.ruleForm5 = {}
      },
      handleEdit3(index, row) {
        this.dialogTableVisibles = true
        Object.assign(this.ruleForms, row)
      },
      handleEdit6() {

      },
      handleEdit5(index, row) {
        this.dialogTableVisible5 = true
        Object.assign(this.ruleForm5, row)
      },
      submitForm5(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 编辑修理工单
            $.ajax({
              type: 'post',
              url: '/repairProject/updateRepairProject.action',
              data: JSON.stringify(this.ruleForm5),
              dataType: 'json',
              contentType: "application/json",
              success: (res) => {
                if (res.code == 1) {
                  this.dialogTableVisible5 = false
                  this.handleCurrentChange(1, this.activeName)
                  this.notifyNoPath(res.msg)
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      },
      handleEdit4(index, row) {
        this.$confirm('是否删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          $.ajax({
            type: 'post',
            url: '/Parts/delete.action',
            data: {id: row.id},
            dataType: 'json',
            success: (res) => {
              if (res.code == 1) {
                this.handleCurrentChange(1, this.activeName)
                this.notifyNoPath(res.msg)
              } else {
                this.notifyError(res.msg)
              }
            },
            error: (res) => {
              this.notifyError(res.msg)
            }
          })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      money() {
        this.ruleForms.number && this.ruleForms.price ? this.ruleForms.money = this.ruleForms.number * this.ruleForms.price : this.ruleForms.money = 0
      },
      handleEdit(index, row) {
        var obj = {
          "repairProject": {"name": row.name, "repair_id": this.repair_id},
          "phone": this.ruleForm.phone_number,
          "project_id": row.id,
          "vehicle_classification_id": this.ruleForm.vehicle_classification_id
        };
        $.ajax({
          type: 'post',
          url: '/repairProject/insertSelective.action',
          data: JSON.stringify(obj),
          contentType: "application/json",
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
              this.dialogTableVisible = false
              this.handleCurrentChange(1, 'second')
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      searchCar() {
        if (this.ruleForm.vehicle_number) {
          $.ajax({
            type: 'post',
            url: '/Repair/detailsSelectByVehicleNumber.action',
            data: {VehicleNumber: this.ruleForm.vehicle_number},
            dataType: 'json',
            success: (res) => {
              if (res.code == 1) {
                Object.assign(this.ruleForm, res.data)
                this.notifyNoPath(res.msg)
              } else if (res.code == 2) {
                this.$confirm('没有车辆信息, 是否添加档案?', '提示', {
                  confirmButtonText: '添加档案',
                  cancelButtonText: '取消',
                  type: 'warning'
                }).then(() => {
                  window.location.href = '/views/archives/carEdit.jsp'
                }).catch(() => {

                });
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
      handleWork(index, row) {
        this.dialogFormVisible = true;
        this.form.id = row.id
        // 派工维修员显示
        $.ajax({
          type: 'post',
          url: '/staff/selectAllStaff.action',
          data: {post: "维修员"},
          dataType: 'json',
          success: (res) => {
            this.form.data = res.data;
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      tabsClick(newTab, olbTab) {
        if (this.repair_id == '') {
          this.notifyError('请先填写表单')
        } else {
          this.handleCurrentChange(1, newTab)
        }
        return this.repair_id == '' ? false : ''
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      handleCurrentChanges(page) {
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/Project/selectAll.action', '', this.diaTableData)
      },
      handleCurrentChange(page, tabs) {
        this.getTable({
          limit: 10,
          page,
          repair_id: this.repair_id
        }, tabs == 'second' ? '/repairProject/showRepairProject.action' : '/Parts/selectPartsShow.action', '')
      },
      submitFormss(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForms.id ? '/Parts/update.action ' : '/Parts/insert.action',
              data: JSON.stringify(this.ruleForms),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.notifyNoPath(res.msg)
                  this.dialogTableVisibles = false
                  this.handleCurrentChange(1, 'third')
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.ruleForm.vehicleId = this.ruleForm.vehicle_id
            $.ajax({
              type: 'post',
              url: '/Repair/insert.action',
              data: JSON.stringify( /* this.ruleForm  */
                //{
                {
                  "vehicleId": this.ruleForm.vehicle_id,
                  "remark": this.ruleForm.remark,
                  "enterTime": this.ruleForm.enter_time,
                  "appointmentTime": this.ruleForm.appointment_time,
                  "makespanTime": this.ruleForm.makespan_time,
                  "settlement": this.ruleForm.settlement,
                  "closingDate": this.ruleForm.closing_date,
                  "money": this.ruleForm.money,
                  "entryPerson": this.ruleForm.entry_person,
                  "vehicle_number": this.ruleForm.vehicle_number,
                  "roadHaul": this.ruleForm.road_haul
                }
                // },
                // }
              ),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.repair_id = res.data.repair_id
                  this.ruleForms.repair_id = res.data.repair_id
                  this.ruleForm.state = 0
                  this.notifyNoPath(res.msg)
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      },
      submitForms(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.dialogFormVisible = false
            // 派工
            $.ajax({
              type: 'post',
              url: '/repairProject/updateRepairProject.action',
              data: JSON.stringify({id: this.form.id, repairman: this.form.name}),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.handleCurrentChange(1, this.activeName)
                  this.notifyNoPath(res.msg)
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        this.onLoad('/Repair/detailsSelect.action', {
          vehicleId: this.getHrefParam('id'),
          repair_id: this.getHrefParam('repair_id')
        })
      } else {
        this.notifyNoPath('输入车牌号查询')
      }
      this.handleCurrentChanges(1)
    }
  })
</script>
</html>
