<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm">
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
                  <el-button size="mini" type="info" @click="handlebooking(scope.$index, scope.row)">预定</el-button>
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
            <el-input v-model="ruleForm.selling_price" type="number"></el-input>
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
            <el-input v-model="ruleForm.mileage" type="number"></el-input>
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
        <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
        <el-button @click="goBack">返回</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</el-card>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin, rules],
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
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/Vehichle/updateByPrimaryKey.action' : '/Vehichle/insert.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'carManage.jsp')
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
      search(value) {
        this.handleCurrentChange(1)
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/VehichileDetailed/selectAll.action', '/VehichileDetailed/hybridSelect.action')
      },
      handlebooking(index, row) {
        delete row['id']
        Object.assign(this.ruleForm, row);
        this.dialogTableVisible = !this.dialogTableVisible
      },
    },
    created() {
      this.handleCurrentChange(1)
      if (this.getHrefParam('id')) {
        this.onLoad('/Vehichle/selectByPrimaryKey.action', {id: this.getHrefParam('id')})
      }
    }
  })
</script>
</html>
