<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">权限管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main access">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
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
          <el-checkbox :label="1009">退车管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="车辆管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1010">车辆管理</el-checkbox>
          <el-checkbox :label="1010">车辆信息</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="财务管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1011">收入管理</el-checkbox>
          <el-checkbox :label="1012">支出管理</el-checkbox>
          <el-checkbox :label="1013">部门管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="库存管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1014">汽车配件</el-checkbox>
          <el-checkbox :label="1015">其他</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="公司管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1016">员工管理</el-checkbox>
          <el-checkbox :label="1017">权限管理</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1018">维修工单</el-checkbox>
          <el-checkbox :label="1019">维修车型分类</el-checkbox>
          <el-checkbox :label="1020">维修工时计算</el-checkbox>
          <el-checkbox :label="1021">维修项目定义</el-checkbox>
          <el-checkbox :label="1022">维修项目用料</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="维修档案：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
          <el-checkbox :label="1023">客户档案</el-checkbox>
          <el-checkbox :label="1024">车辆档案</el-checkbox>
          <el-checkbox :label="1025">员工档案</el-checkbox>
          <el-checkbox :label="1026">驾驶员信息档案</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="报表管理：">
        <el-checkbox-group v-model="ruleForm.popedoms" class="checkbox-group">
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
            console.log(this.ruleForm)
            $.ajax({
              traditional: true,
              type: 'post',
              url: '/popedom/updatePopedom.action',
              data: this.ruleForm,
              traditional: true,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                this.$alert(res.msg, '提示', {
                  type: 'success',
                  confirmButtonText: '确定',
                  callback: action => {
                    window.location.href = "accessManage.jsp"
                  }
                });
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
            console.log(res)
            if (res.code == 1) {
              for (let i = 0; i < res.data.length; i++) {
                this.ruleForm.popedoms.push(res.data[i].pId)
              }
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
      }
    }
  })
</script>
</html>
