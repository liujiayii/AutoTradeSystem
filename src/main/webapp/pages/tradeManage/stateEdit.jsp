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
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.id)" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地址" prop="address">
            <el-input v-model="ruleForm.address" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="贷款金额" prop="loanAmount">
            <el-input v-model="ruleForm.loanAmount" @input="count" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="贷款期限（月）" prop="totalPeriod">
            <el-input v-model="ruleForm.totalPeriod" @input="count" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="还款日" prop="repaymentDate">
            <el-date-picker type="date" v-model="ruleForm.repaymentDate" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="每期还款" prop="monthlySupply">
            <el-input v-model="ruleForm.monthlySupply" type="number"></el-input>
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
        navActive: '2-3',
        ruleForm: {
          name: '',
          phone: '',
          address: '',
          totalPeriod: '',
          loanAmount: '',
          monthlySupply: '',
          repaymentDate: ''
        }
      }
    },
    methods: {
      count() {
        let t = this.ruleForm.totalPeriod == '' ? 1 : parseInt(this.ruleForm.totalPeriod)
        let l = this.ruleForm.loanAmount == '' ? 0 : parseInt(this.ruleForm.loanAmount)
        this.ruleForm.monthlySupply = l / t
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/byStages/updateByStages.action' : '/byStages/insertByStages.action',
              data: this.ruleForm.id ? JSON.stringify({
                id: this.ruleForm.id,
                repaymentDate: this.ruleForm.repaymentDate,
                byStages: {
                  totalPeriod: this.ruleForm.totalPeriod,
                  loanAmount: this.ruleForm.loanAmount,
                  monthlySupply: this.ruleForm.monthly_supply
                }
              }) : JSON.stringify({
                "buyingCustomer": {
                  name: this.ruleForm.name,
                  phone: this.ruleForm.phone,
                  address: this.ruleForm.address
                },
                "carForm": {
                  id: this.ruleForm.id,
                  byStages: {
                    totalPeriod: this.ruleForm.totalPeriod,
                    loanAmount: this.ruleForm.loanAmount,
                    monthlySupply: this.ruleForm.monthly_supply
                  },
                  repaymentDate: this.ruleForm.repaymentDate
                }
              }),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'stateManage.jsp')
                } else {
                  this.notifyError(res.msg,)
                }
              },
              error: (res) => {
                console.log(res)
                this.notifyError(res.msg,)
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
        //获取客户信息
        this.onLoad('/byStages/showBuyingCustomer.action', {id: this.getHrefParam('id')})
        //获取分期详情
        $.ajax({
          type: 'post',
          url: '/byStages/showDetailsByStages.action',
          data: {id: this.getHrefParam('id'), page: 1, limit: 1},
          dataType: 'json',
          success: (res) => {
            console.log("分期：" + JSON.stringify(res))
            if (res.code == 1) {
              console.log(res)
              Object.assign(this.ruleForm, res.data[0])
              Object.assign(this.ruleForm, res.data[0].byStages)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            console.log(res)
            this.notifyError(res.msg)
          }
        })
      }
    }
  })
</script>
</html>
