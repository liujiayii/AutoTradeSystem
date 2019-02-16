<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">{{title}}</div>
</el-container>

<el-card shadow="hover">
  <el-container class="main">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-form-item prop="departmentId" label="部门">
        <el-select v-model="ruleForm.departmentId" placeholder="请选择部门">
          <el-option v-for="item in branchData" :label="item.department" :value="item.department"
                     :key="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="name" label="姓名">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="项目名称">
        <el-input v-model="ruleForm[type == 'income' ? 'income' : 'expenditure']"></el-input>
      </el-form-item>
      <el-form-item label="金额">
        <el-input v-model="ruleForm[type == 'income' ? 'incomeMoney' : 'expenditureMoney']"></el-input>
      </el-form-item>
      <el-form-item label="摘要">
        <el-input type="textarea"
                  v-model="ruleForm[type == 'income' ? 'incomeDetailed' : 'detailedExpenditure']"></el-input>
      </el-form-item>
      <el-form-item label="日期">
        <el-date-picker
                v-model="ruleForm.data"
                type="date"
                value-format="timestamp"
                placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
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
        type: this.getHrefParam('type'),
        navActive: this.getHrefParam('type') == 'income' ? '5-1' : '5-2',
        ruleForm: {
          departmentId: '',
          income: '',
          expenditure: '',
          incomeMoney: '',
          expenditureMoney: '',
          name: '',
          incomeDetailed: '',
          detailedExpenditure: '',
          data: ''
        },
        branchData: [],
        title: this.getHrefParam('type') == 'income' ? '收入管理' : '支出管理'
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.getHrefParam('type') == 'income' ? '/Incom/insertIncom.action' : '/Expenditure/insertExpenditure.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = this.getHrefParam('type') == 'income' ? "income.jsp" : 'expend.jsp'
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
              this.$notify.error({
                title: '警告',
                message: res.msg,
                position: 'bottom-right',
                offset: 300
              })
            }
          },
          error: (res) => {
            this.$notify.error({
              title: '警告',
              message: res.msg,
              position: 'bottom-right',
              offset: 300
            })
          }
        })
      }
    },
    mounted() {
      this.getBranch()
    }
  })
</script>
</html>
