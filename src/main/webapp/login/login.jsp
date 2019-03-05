<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>喔驰后台管理系统</title>
  <link href="//lib.baomitu.com/element-ui/2.6.1/theme-chalk/index.css" rel="stylesheet">
  <script src="//lib.baomitu.com/jquery/3.3.1/jquery.min.js"></script>
  <script src="//lib.baomitu.com/vue/2.6.8/vue.min.js"></script>
  <script src="//lib.baomitu.com/element-ui/2.6.1/index.js"></script>
  <link rel="stylesheet" href="./login/login.css">
</head>
<body>
<div id="app">
  <el-container class="main">
    <el-card shadow="hover">
      <p class="title">喔驰后台管理系统</p>
      <el-form label-position="left" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px">
        <el-form-item label="账号" prop="username">
          <el-input v-model="ruleForm.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password" type="password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="code">
          <input type="hidden" value="${results}">
          <el-input placeholder="请输入验证码" v-model="ruleForm.code">
            <img id="code" src="showAuthCode.action" slot="append" @click="codeUpdate">
          </el-input>
        </el-form-item>
        <el-button type="info" @click="submitForm('ruleForm')" class="submit" round :loading="loading">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
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
          username: '',
          password: '',
          code: ''
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'},
            {min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur'},
            {validator: validUser, trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur'},
            {validator: validPass, trigger: 'blur'}],
          code: [{required: true, message: '请输入验证码', trigger: 'blur'}]
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
              type: "post",
              url: "loginTwo.action",
              data: {"auth_code": this.ruleForm.code,},
              success: (r) => {
                if (r.code == 1) {
                  $.ajax({
                    type: 'post',
                    url: '/login_handle.action',
                    data: this.ruleForm,
                    dataType: 'json',
                    success: (res) => {
                      if (res.code == 1) {
                        window.location.href = '/views/index/index.jsp'
                      } else if (res.code == -1) {
                        this.loading = false
                        this.notifyError(res.msg)
                      }
                    },
                    error(res) {
                      this.loading = false
                      this.notifyError(res.msg)
                    }
                  })
                } else {
                  this.codeUpdate()
                  this.ruleForm.code = ''
                  this.loading = false
                  this.notifyError(r.msg)
                }
              },
              error: (r) => {
                this.codeUpdate()
                this.ruleForm.code = ''
                this.loading = false
                this.notifyError(r.msg)
              }
            })
          } else {
            return false;
          }
        });
      },
      notifyError(message) {
        this.$notify.error({
          title: '提示',
          message,
          position: 'bottom-right',
          offset: 300
        })
      },
      codeUpdate() {
        document.getElementById('code').src = "showAuthCode.action?t=" + new Date().getTime()
      }
    }
  })
</script>
</html>
