<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round @click="dialogFormVisible=true">添加</el-button>
</el-container>
<el-card shadow="hover">
  <el-container class="main">
    <el-table v-loading="loading2"
              element-loading-text="拼命加载中"
              stripe
              size="small"
              element-loading-spinner="el-icon-loading"
              :data="tableData.data"
              style="width: 100%">
      <el-table-column label="编号" prop="id" show-overflow-tooltip></el-table-column>
      <el-table-column label="类型" prop="vehicle_classification" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot-scope="scope">
          <el-button size="mini" type="info" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="车辆类型" :visible.sync="dialogFormVisible" @close="clearForm" width="500px">
      <el-form :model="ruleForm" ref="ruleForm" inline label-width="100px" :rules="rules">
        <el-form-item label="类型" prop="vehicle_classification">
          <el-input v-model="ruleForm.vehicle_classification"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
          <el-button @click="dialogFormVisible=false">取消</el-button>
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
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin, rules],
    data: function () {
      return {
        navActive: '9-5',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        dialogFormVisible: false
      }
    },
    methods: {
      clearForm() {
        this.ruleForm = {}
      },
      handleEdit(index, row) {
        this.ruleForm = row
        this.dialogFormVisible = true
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page
        }, '/VehicleClassification/selectAll.action', '/VehicleClassification/selectAll.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            delete this.ruleForm.create_time
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/VehicleClassification/update.action' : '/VehicleClassification/insert.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.dialogFormVisible = false
                  this.$refs[formName].resetFields();
                  this.notifyNoPath(res.msg)
                  this.handleCurrentChange(this.page)
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
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
