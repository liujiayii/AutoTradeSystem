<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">分期管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-input v-model="ruleForm.id"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地址" prop="address">
            <el-input v-model="ruleForm.address"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="贷款金额">
            <el-input v-model="carForm.byStages.loanAmount" @input="count"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="贷款期限">
            <el-input v-model="carForm.byStages.totalPeriod" @input="count" ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="还款日">
            <el-date-picker type="date" v-model="carForm.repaymentDate" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="每期还款">
            <el-input v-model="carForm.byStages.monthlySupply"></el-input>
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
        navActive: '2-3',
        ruleForm: {
          name: '',
          phone: '',
          address: ''
        },
        carForm: {
          byStages: {
            totalPeriod: '',
            loanAmount: '',
            monthlySupply: ''
          },
          repaymentDate: ''
        }
      }
    },
    methods: {
      count() {
        let t = this.carForm.byStages.totalPeriod == '' ? 1 : parseInt(this.carForm.byStages.totalPeriod)
        let l = this.carForm.byStages.loanAmount == '' ? 0 : parseInt(this.carForm.byStages.loanAmount)
        this.carForm.byStages.monthlySupply = l / t
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/byStages/updateByStages.action' : '/byStages/insertByStages.action',
              data: this.ruleForm.id ? JSON.stringify(this.carForm) : JSON.stringify({
                "buyingCustomer": this.ruleForm,
                "carForm": this.carForm
              }),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "stateManage.jsp"
                    }
                  })
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
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        //获取客户信息
        $.ajax({
          type: 'post',
          url: '/byStages/showBuyingCustomer.action',
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
        });
        //获取分期详情
        $.ajax({
          type: 'post',
          url: '/byStages/showDetailsByStages.action',
          data: {id: this.getHrefParam('id'), page: 1, limit: 1},

          dataType: 'json',
          success: (res) => {
            console.log("分期：" + JSON.stringify(res))
            if (res.code == 1) {
              this.carForm = res.data[0]
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
