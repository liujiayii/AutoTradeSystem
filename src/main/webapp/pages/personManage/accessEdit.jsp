<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">权限管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-form-item label="用户信息"></el-form-item>
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
        <el-col :span="12">
          <el-form-item label="职位" prop="pId">
            <el-select v-model="ruleForm.pId" placeholder="请选择职位">
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
          <el-form-item label="账号" prop="userName">
            <el-input v-model="ruleForm.userName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="密码" prop="passWord">
            <el-input v-model="ruleForm.passWord"></el-input>
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
      let validUser = (rule, value, callback) => {
        const valid = /^[a-zA-Z0-9_-]{3,12}$/
        if (valid.test(value)) {
          callback(new Error('请输入正确的用户名'));
        } else {
          callback();
        }
      }
      let validPass = (rule, value, callback) => {
        const valid = /^[a-zA-Z0-9_-]{6,12}$/
        if (value.length != 0) {
          if (valid.test(value)) {
            callback(new Error('请输入正确的密码'));
          } else if (value.length < 6 || value.length > 12) {
            callback(new Error('长度在 6 到 12 个字符'));
          } else {
            callback();
          }
        }
      }
      return {
        navActive: '7-2',
        ruleForm: {
          name: ''
        },
        rules: {
          userName: [{required: true, message: '请输入用户名', trigger: 'blur'},
            {validator: validUser, trigger: 'blur'},
            {min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur'}],
          passWord: [{validator: validPass, trigger: 'blur'}],
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
                url: this.ruleForm.id ? '/user/updateUser.action' : '/user/insertUser.action',
                data: this.ruleForm,
                dataType: 'json',
                success: (res) => {
                  console.log(res)
                  if (res.code == 1) {
                    this.$alert(res.msg, '提示', {
                      confirmButtonText: '确定',
                      type: 'success',
                      callback: action => {
                        window.location.href = "accessManage.jsp"
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
              }
            )
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
          url: '/user/findById.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              delete res.data['post']
              delete res.data['KeyWord']
              delete res.data['createTime']
              delete res.data['passWord']
              this.ruleForm = res.data
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
