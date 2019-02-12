<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">权限管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main access">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-form-item label="客户信息：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1001">车辆资源</el-checkbox>
          <el-checkbox :label="1002">买车咨询</el-checkbox>
          <el-checkbox :label="1003">置换车辆</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="交易管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1004">评估审核</el-checkbox>
          <el-checkbox :label="1005">保险凭证</el-checkbox>
          <el-checkbox :label="1006">分歧管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="售车管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1007">订车管理</el-checkbox>
          <el-checkbox :label="1008">售车管理</el-checkbox>
          <el-checkbox :label="1009">退车管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="车辆管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1010">车辆管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="财务管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1011">收入管理</el-checkbox>
          <el-checkbox :label="1012">支出管理</el-checkbox>
          <el-checkbox :label="1013">部门管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="库存管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1014">汽车配件</el-checkbox>
          <el-checkbox :label="1015">其他</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="公司管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1016">员工管理</el-checkbox>
          <el-checkbox :label="1017">权限管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1018">维修工单</el-checkbox>
          <el-checkbox :label="1019">维修车型分类</el-checkbox>
          <el-checkbox :label="1020">维修工时计算</el-checkbox>
          <el-checkbox :label="1021">维修项目定义</el-checkbox>
          <el-checkbox :label="1022">维修项目用料</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修档案：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1023">客户档案</el-checkbox>
          <el-checkbox :label="1024">车辆档案</el-checkbox>
          <el-checkbox :label="1025">员工档案</el-checkbox>
          <el-checkbox :label="1026">驾驶员信息档案</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="报表管理：">
        <el-checkbox-group v-model="ruleForm.arr" class="checkbox-group">
          <el-checkbox :label="1027">维修报表</el-checkbox>
          <el-checkbox :label="1028">售车报表</el-checkbox>
          <el-checkbox :label="1029">进车报表</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</el-card>
</el-main>
<el-footer>©2018 智莱云 All rights resered 石家庄智莱云信息技术有限公司</el-footer>
</el-container>
</el-container>
</el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    data: function () {
      return {
        navActive: '7-2',
        isCollapse: false,
        ruleForm: {
          id: '',
          arr: []
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: '',
              data: this.ruleForm,
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
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
      // 获取地址栏参数，name:参数名称
      getHrefParam(key) {
        var s = window.location.href;
        var reg = new RegExp(key + "=\\w+");
        var rs = reg.exec(s);
        if (rs === null || rs === undefined) {
          return "";
        } else {
          return rs[0].split("=")[1];
        }
      }
    }
  })
</script>
</html>
