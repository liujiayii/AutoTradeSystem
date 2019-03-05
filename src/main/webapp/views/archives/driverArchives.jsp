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
      <el-table-column label="姓名" prop="driver_name" show-overflow-tooltip></el-table-column>
      <el-table-column label="职务" prop="duty" show-overflow-tooltip></el-table-column>
      <el-table-column label="手机号码" prop="move_number" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="info" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="驾驶员档案" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form :model="ruleForm" ref="ruleForm" inline label-width="100px" :rules="rules">
        <el-form-item label="驾驶员姓名" prop="driver_name">
          <el-input v-model="ruleForm.driver_name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select style="width: 202px" v-model="ruleForm.gender" placeholder="请选择性别">
            <el-option label="男" :value="1"></el-option>
            <el-option label="女" :value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职务" prop="duty">
          <el-input v-model="ruleForm.duty"></el-input>
        </el-form-item>
        <el-form-item label="出生日期" prop="brithday">
          <el-date-picker style="width: 202px" v-model="ruleForm.brithday" type="date" placeholder="选择出生日期"
                          value-format="timestamp"></el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号" prop="id_number">
          <el-input v-model="ruleForm.id_number"></el-input>
        </el-form-item>
        <el-form-item label="手机" prop="move_number">
          <el-input v-model="ruleForm.move_number" type="number"></el-input>
        </el-form-item>
        <el-form-item label="住宅电话号码" prop="phone_number">
          <el-input v-model="ruleForm.phone_number" type="number"></el-input>
        </el-form-item>
        <el-form-item label="驾驶证号" prop="driver_license_number">
          <el-input v-model="ruleForm.driver_license_number"></el-input>
        </el-form-item>
        <el-form-item label="准驾车型" prop="quasi_driving_type">
          <el-input v-model="ruleForm.quasi_driving_type"></el-input>
        </el-form-item>
        <el-form-item label="发证日期" prop="opening_date">
          <el-date-picker style="width: 202px" v-model="ruleForm.opening_date" type="date" placeholder="选择发证日期"
                          value-format="timestamp"></el-date-picker>
        </el-form-item>
        <el-form-item label="失效日期" prop="expiry_date">
          <el-date-picker style="width: 202px" v-model="ruleForm.expiry_date" type="date" placeholder="选择失效日期"
                          value-format="timestamp"></el-date-picker>
        </el-form-item>
        <el-form-item label="电子邮箱" prop="e_mail">
          <el-input v-model="ruleForm.e_mail"></el-input>
        </el-form-item>
        <el-form-item label="办公室电话" prop="office_telephone">
          <el-input v-model="ruleForm.office_telephone" type="number"></el-input>
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
        navActive: '9-3',
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
      search(value) {
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        this.ruleForm = row
        this.dialogFormVisible = true
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          keyWord: this.searchVal
        }, '/carRecord/findDriverByLimit.action', '/carRecord/findDriverByLimit.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/carRecord/updateDriver.action' : '/carRecord/insertDriver.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
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
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
