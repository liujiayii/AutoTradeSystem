<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>喔驰后台管理系统</title>
  <link href="https://cdn.bootcss.com/element-ui/2.5.4/theme-chalk/index.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/vue/2.6.4/vue.js"></script>
  <script src="https://cdn.bootcss.com/element-ui/2.5.4/index.js"></script>
  <link rel="stylesheet" href="./login/login.css">
</head>
<body>
<div id="app">
  <el-container class="main">
    <p class="title">喔驰后台管理系统</p>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="60px" class="demo-ruleForm">
      <el-form-item label="账号" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="info" @click="submitForm('ruleForm')" class="submit" round :loading="loading">登录
        </el-button>
      </el-form-item>
    </el-form>
  </el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    data() {
      let validUser = (rule, value, callback) => {
        const valid = /^[a-zA-Z0-9_-]{3,12}$/
        if (!valid.test(value)) {
          callback(new Error('请输入正确的用户名'));
        } else {
          callback();
        }
      }
      let validPass = (rule, value, callback) => {
        const valid = /^[a-zA-Z0-9_-]{6,12}$/
        if (value && value.length != 0) {
          if (!valid.test(value)) {
            callback(new Error('请输入正确的密码'));
          } else if (value.length < 6 || value.length > 12) {
            callback(new Error('长度在 6 到 12 个字符'));
          } else {
            callback();
          }
        } else {
          callback();
        }

      }
      return {
        ruleForm: {
          username: 'admin',
          password: '12345678'
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'},
            {min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur'},
            {validator: validUser, trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur'},
            {validator: validPass, trigger: 'blur'}]
        },
        loading: false
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.loading = true
            $.ajax({
              type: 'post',
              url: '/login_handle.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  window.location.href = '/pages/customerInfo/buyingCarConsult.jsp'
                } else if (res.code == -1) {
                  this.loading = false
                  this.$notify.error({
                    title: '提示',
                    message: res.msg,
                    position: 'bottom-right',
                    offset: 300
                  })
                }
              },
              error(res) {
                this.loading = false
                this.$notify.error({
                  title: '提示',
                  message: res.msg,
                  position: 'bottom-right',
                  offset: 300
                })
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  })
</script>
</html>
