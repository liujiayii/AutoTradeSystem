<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">维修明细</div>
  <div>
    <el-button v-show="activeName != 'first'" class="btn" type="primary" icon="el-icon-plus" round
               @click="activeName == 'second' ? dialogTableVisible=true : dialogTableVisibles=true">添加{{activeName ==
      'second' ? '项目' : '材料'}}
    </el-button>
    <template v-if="this.ruleForm.state <5">
      <el-button @click="next" class="btn" type="info">下一步</el-button>
    </template>
  </div>
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
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">选择</el-button>
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
    <el-form :model="ruleForms" ref="ruleForms" inline label-width="100px">
      <el-form-item label="品牌" prop="brand">
        <el-input v-model="ruleForms.brand"></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="number">
        <el-input v-model="ruleForms.number" @input="money"></el-input>
      </el-form-item>
      <el-form-item label="单价" prop="price">
        <el-input v-model="ruleForms.price" @input="money"></el-input>
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
            <el-button type="primary" @click="submitFormss('ruleForms')">确定</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </el-dialog>
</el-container>
<el-tabs v-model="activeName" :before-leave="tabsClick">
  <el-tab-pane label="工单明细" name="first">
    <el-card shadow="hover">

      <el-steps :active="parseInt(ruleForm.state)" finish-status="success">
        <el-step title="预约"></el-step>
        <el-step title="在修"></el-step>
        <el-step title="完工"></el-step>
        <el-step title="结算"></el-step>
        <el-step title="结账"></el-step>
      </el-steps>
      <el-container class="main">
        <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="客户基本信息"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="内部工号" prop="internal_number">
            <el-input v-model="ruleForm.internal_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车型分类" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="车辆号码" prop="vehicle_number">
            <el-input style="width: 202px" v-model="ruleForm.vehicle_number">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search"
                         @click="searchCar"></el-button>
            </el-input>
          </el-form-item>
          <el-form-item label="使用性质" prop="nature">
            <el-input v-model="ruleForm.nature" readonly></el-input>
          </el-form-item>
          <el-form-item label="VIN号" prop="vin">
            <el-input v-model="ruleForm.vin" readonly></el-input>
          </el-form-item>
          <el-form-item label="内部编号" prop="internal_number">
            <el-input v-model="ruleForm.internal_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车型" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="车名" prop="range_rover">
            <el-input v-model="ruleForm.range_rover" readonly></el-input>
          </el-form-item>
          <el-form-item label="机型" prop="aircraft_type">
            <el-input v-model="ruleForm.aircraft_type" readonly></el-input>
          </el-form-item>
          <el-form-item label="厂牌" prop="brand">
            <el-input v-model="ruleForm.brand" readonly></el-input>
          </el-form-item>
          <el-form-item label="发动机号" prop="engine_number">
            <el-input v-model="ruleForm.engine_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="底盘号" prop="chassis_number">
            <el-input v-model="ruleForm.chassis_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="变速箱号" prop="gearbox_number">
            <el-input v-model="ruleForm.gearbox_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="车身颜色" prop="color">
            <el-input v-model="ruleForm.color" readonly></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="产品属性："></el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="运营单位" prop="company">
                <el-input v-model="ruleForm.company" readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="联系人" prop="customer_name">
            <el-input v-model="ruleForm.customer_name" readonly></el-input>
          </el-form-item>
          <el-form-item label="联系电话" prop="phone_number">
            <el-input v-model="ruleForm.phone_number" readonly></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="送检人员："></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="送检人" prop="driver_name">
            <el-input v-model="ruleForm.driver_name" readonly></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="office_telephone">
            <el-input v-model="ruleForm.office_telephone" readonly></el-input>
          </el-form-item>
          <el-form-item label="手机" prop="move_number">
            <el-input v-model="ruleForm.move_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="驾驶证号" prop="driver_license_number">
            <el-input v-model="ruleForm.driver_license_number" readonly></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="id_number">
            <el-input v-model="ruleForm.id_number" readonly></el-input>
          </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="车辆信息："></el-form-item>
            </el-col>
            <el-form-item label="车辆备注" prop="remark">
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
          <el-form-item label="进厂时间" prop="enter_time">
            <el-date-picker style="width: 202px" v-model="ruleForm.enter_time" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="预约进厂日期" prop="appointment_time">
            <el-date-picker style="width: 202px" v-model="ruleForm.appointment_time" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="结算日期" prop="settlement">
            <el-date-picker style="width: 202px" v-model="ruleForm.settlement" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
          <el-form-item label="维修类别" prop="category">
            <el-input v-model="ruleForm.category"></el-input>
          </el-form-item>
          <el-form-item label="结账金额" prop="money">
            <el-input v-model="ruleForm.money"></el-input>
          </el-form-item>
          <el-form-item label="结账方式" prop="type">
            <el-input v-model="ruleForm.type"></el-input>
          </el-form-item>
          <el-row v-if="!Boolean(this.getHrefParam('id'))">
            <el-col :span="24">
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
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
          <el-table-column label="派工">
            <template slot-scope="scope">
              <i class="fa fa-user-md fa-lg" @click="handleWork(scope.$index, scope.row)"></i>
            </template>
          </el-table-column>
          <el-table-column>
            <template slot-scope="scope">
              <el-button size="mini" @click="handleEdit5(scope.$index, scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-dialog title="工单编辑" :visible.sync="dialogTableVisible5" @close="closeDialog">
          <el-form :model="ruleForm5" ref="ruleForm5" inline label-width="100px">
            <el-form-item label="工时" prop="working_hours">
              <el-input v-model="ruleForm5.working_hours"></el-input>
            </el-form-item>
            <el-form-item label="工时单价" prop="price">
              <el-input v-model="ruleForm5.price" @input="money"></el-input>
            </el-form-item>
            <el-row>
              <el-col :span="24">
                <el-form-item>
                  <el-button type="primary" @click="submitForm5('ruleForm5')">确定</el-button>
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
              <el-button type="primary" @click="submitForms('form')">确定</el-button>
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
          <el-table-column align="right">
            <template slot-scope="scope">
              <el-button size="mini" @click="handleEdit3(scope.$index, scope.row)">编辑</el-button>
              <el-button size="mini" @click="handleEdit4(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
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
          state: 0,
          three_guarantees: '',
          type: '',
          vehicle_id: '',
          vehicle_note: '',
          vehicle_number: '',
          vehicle_type: '',
          vin: ''
        },
        dialogFormVisible: false,
        dialogTableVisible5: false,
        form: {
          data: []
        },
        repair_id: this.getHrefParam('repair_id') ? this.getHrefParam('repair_id') : '',
        ruleForms: {repair_id: this.getHrefParam('repair_id') ? this.getHrefParam('repair_id') : ''},
        ruleForm5: {working_hours: '', price: ''}
      }
    },
    methods: {
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
              console.log(res)
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
            message: '已取消删除'
          });
        });
      },
      closeDia() {
        this.form.name = ''
      },
      closeDialog() {
        this.ruleForms = {}
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
                console.log(res)
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
            console.log('error submit!!');
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
              console.log(res)
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
            console.log(res)
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
      searchCar() {
        if (this.ruleForm.vehicle_number) {
          this.onLoad('/Repair/detailsSelectByVehicleNumber.action', {VehicleNumber: this.ruleForm.vehicle_number})
        }
      },
      handleWork(index, row) {
        console.log(index, row);
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
        console.log(newTab)
        console.log(olbTab)
        if (this.repair_id == '') {
          this.notifyError('请先填写表单')
        } else {
          this.handleCurrentChange(1, newTab)
        }
        return this.repair_id == '' ? false : ''
      },
      search(value) {
        console.log(this.searchVal)
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
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          repair_id: this.repair_id
        }, tabs == 'second' ? '/repairProject/showRepairProject.action' : '/Parts/selectPartsShow.action', '')
      },
      submitFormss(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForms.id ? '/Parts/update.action ' : '/Parts/insert.action',
              data: JSON.stringify(this.ruleForms),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                console.log(res)
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
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            this.ruleForm.vehicleId = this.ruleForm.vehicle_id
            $.ajax({
              type: 'post',
              url: '/Repair/insert.action',
              data: JSON.stringify(this.ruleForm),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.repair_id = res.data.repair_id
                  this.ruleForms.repair_id = res.data.repair_id
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
            console.log('error submit!!');
            return false;
          }
        })
      },
      submitForms(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            this.dialogFormVisible = false
            // 派工
            $.ajax({
              type: 'post',
              url: '/repairProject/updateRepairProject.action',
              data: JSON.stringify({id: this.form.id, repairman: this.form.name}),
              contentType: "application/json",
              dataType: 'json',
              success: (res) => {
                console.log(res)
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
            console.log('error submit!!');
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
