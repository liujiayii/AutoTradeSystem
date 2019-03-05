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
      <el-table-column label="车型" prop="vehicle_type" show-overflow-tooltip></el-table-column>
      <el-table-column label="品牌" prop="brand" show-overflow-tooltip></el-table-column>
      <el-table-column label="型号" prop="range_rover" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="info" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="车型编辑" :visible.sync="dialogFormVisible" width="500px" @close="clearForm">
      <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
        <el-form-item label="车型" prop="vehicle_classification_id">
          <el-select v-model="ruleForm.vehicle_classification_id" placeholder="请选择车型" @change="select">
            <el-option v-for="item in carType" :key="item.id" :label="item.vehicle_classification"
                       :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车名" prop="range_rover">
          <el-input style="width: 217px" v-model="ruleForm.range_rover"></el-input>
        </el-form-item>
        <el-form-item label="厂家" prop="brand">
          <el-input style="width: 217px" v-model="ruleForm.brand"></el-input>
        </el-form-item>
        <el-form-item>
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
        navActive: '9-4',
        activeName: 'second',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        dialogFormVisible: false,
        carType: []
      }
    },
    methods: {
      clearForm() {
        this.ruleForm = {}
      },
      select(val) {
        let obj = {}
        obj = this.carType.find((item) => {
          return item.id === val
        })
        this.ruleForm.vehicle_classification = obj.vehicle_classification
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        this.select(row.vehicle_classification_id)
        this.ruleForm = row
        this.dialogFormVisible = true
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          keyWord: this.searchVal
        }, '/carRecord/CarTypeLimit.action', '/carRecord/CarTypeLimit.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            delete this.ruleForm.vehicle_type
            $.ajax({
              type: 'post',
              url: this.ruleForm.model_definition_id ? '/carRecord/updateCarType.action' : '/carRecord/insertCarType.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.dialogFormVisible = false
                  this.$refs[formName].resetFields();
                  this.notifyNoPath(res.msg)
                  this.handleCurrentChange(1)
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
      getCarType() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findCarType.action',
          data: this.ruleForm,
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.carType = res.data
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
      this.handleCurrentChange(1)
      this.getCarType()
    }
  })
</script>
</html>
