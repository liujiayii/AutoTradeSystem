<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/pages/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地址" prop="address">
            <el-input v-model="ruleForm.address"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="职位" prop="p_id">
            <el-select v-model="ruleForm.p_id" placeholder="请选择职位">
              <el-option label="总经理" :value="2000"></el-option>
              <el-option label="销售主管" :value="2001"></el-option>
              <el-option label="财务主管" :value="2002"></el-option>
              <el-option label="维修主管" :value="2003"></el-option>
              <el-option label="采购" :value="2004"></el-option>
              <el-option label="金融主管" :value="2005"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item prop="departmentId" label="部门">
            <el-select v-model="ruleForm.departmentId" placeholder="请选择部门">
              <el-option v-for="item in branchData" :label="item.department" :value="item.id"
                         :key="item.id"></el-option>
            </el-select>
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
        navActive: '7-1',
        ruleForm: {
          name: '',
          phone: '',
          address: '',
          postId: '',
          departmentId: '',
        },
        branchData: [],
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/staff/update.action' : '/staff/insert.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'staffManage.jsp')
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                console.log(res)
                this.notifyError(res.msg)
              }
            })
            console.log(this.ruleForm)
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      getBranch() {
        $.ajax({
          type: 'post',
          url: '/department/selectAll.action',
          data: {
            limit: 100,
            page: 1
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.branchData = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
    },
    created() {
      this.getBranch()
      if (this.getHrefParam('id')) {
        this.onLoad('/staff/selectById.action', {id: this.getHrefParam('id')})
      }
    }
  })
</script>
</html>
