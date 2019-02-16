<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">车辆管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
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
          <el-form-item label="车型" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="购车价格(元)" prop="selling_price">
            <el-input v-model="ruleForm.selling_price"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车牌号" prop="brand">
            <el-input v-model="ruleForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车类">
            <el-select v-model="ruleForm.type" placeholder="请选择车辆类型 ">
              <el-option label="新车" :value="1"></el-option>
              <el-option label="旧车" :value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车牌颜色" prop="color">
            <el-input v-model="ruleForm.color"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="底盘号" prop="chassis_number">
            <el-input v-model="ruleForm.chassis_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发动机号" prop="engine_number">
            <el-input v-model="ruleForm.engine_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="合格证号" prop="qualified_number">
            <el-input v-model="ruleForm.qualified_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="进口证号" prop="imported_number">
            <el-input v-model="ruleForm.imported_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="商检号" prop="inspection_number">
            <el-input v-model="ruleForm.inspection_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="提单号" prop="carry_number">
            <el-input v-model="ruleForm.carry_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="自编号" prop="self_number">
            <el-input v-model="ruleForm.self_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="钥匙号" prop="key_number">
            <el-input v-model="ruleForm.key_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行驶里程" prop="mileage">
            <el-input v-model="ruleForm.mileage"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务员" prop="business">
            <el-input v-model="ruleForm.business"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="single_person">
            <el-input v-model="ruleForm.single_person"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="ruleForm.remark"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入库编号" prop="vehile_number">
            <el-input v-model="ruleForm.vehile_number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="place">
            <el-input v-model="ruleForm.place"></el-input>
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
        navActive: '4-1',
        dialogTableVisible: false,
        ruleForm: {
          vehicle_type: '',
          brand: '',
          type: '',
          create_time: '',
          color: '',
          chassis_number: '',
          engine_number: '',
          qualified_number: '',
          imported_number: '',
          inspection_number: '',
          carry_number: '',
          self_number: '',
          key_number: '',
          mileage: '',
          business: '',
          single_person: '${user.name}',
          selling_price: '',
          remark: '',
          seling_id: '',
          vehile_number: '',
          place: '',
          vehicle_code: '',
          vehicle_types: ''
        },
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert(this.ruleForm.type)
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/Vehichle/updateByPrimaryKey.action': '/Vehichle/insert.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "carManage.jsp"
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
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
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
                this.tableData.data = res.data
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
          url: '/Vehichle/selectByPrimaryKey.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm = res.data
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
