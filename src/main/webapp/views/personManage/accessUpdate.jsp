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
  <el-container class="main access">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="客户信息：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1001">车辆资源</el-checkbox>
          <el-checkbox :label="1002">买车咨询</el-checkbox>
          <el-checkbox :label="1003">置换车辆</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="交易管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1004">评估审核</el-checkbox>
          <el-checkbox :label="1005">保险凭证</el-checkbox>
          <el-checkbox :label="1006">分期管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="售车管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1007">订车管理</el-checkbox>
          <el-checkbox :label="1008">售车管理</el-checkbox>
          <!--<el-checkbox :label="1009">退车管理</el-checkbox>-->
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="车辆管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1010">车辆管理</el-checkbox>
          <el-checkbox :label="1011">车辆信息</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="财务管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1012">部门管理</el-checkbox>
          <el-checkbox :label="1013">收入管理</el-checkbox>
          <el-checkbox :label="1014">支出管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="库存管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1015">库存详情</el-checkbox>
          <el-checkbox :label="1016">采购记录</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="公司管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1017">员工管理</el-checkbox>
          <el-checkbox :label="1018">权限管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1019">维修工单</el-checkbox>
          <el-checkbox :label="1020">维修项目</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修档案：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1022">客户档案</el-checkbox>
          <el-checkbox :label="1021">车辆档案</el-checkbox>
          <el-checkbox :label="1025">客户类型</el-checkbox>
          <el-checkbox :label="1023">驾驶员信息档案</el-checkbox>
          <el-checkbox :label="1024">车型设置</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <!--<el-form-item label="报表管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1026">维修报表</el-checkbox>
          <el-checkbox :label="1027">售车报表</el-checkbox>
          <el-checkbox :label="1028">进车报表</el-checkbox>
        </el-checkbox-group>
      </el-form-item>-->
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
        navActive: '7-2',
        ruleForm: {
          id: this.getHrefParam('id'),
          popedoms: []
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              traditional: true,
              type: 'post',
              url: '/popedom/updatePopedom.action',
              data: this.ruleForm,
              traditional: true,
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'accessManage.jsp')
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
        $.ajax({
          type: 'post',
          url: '/popedom/findPopedomByUserId.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              for (let i = 0; i < res.data.length; i++) {
                this.ruleForm.popedoms.push(res.data[i].pId)
              }
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      }
    }
  })
</script>
</html>
