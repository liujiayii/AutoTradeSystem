<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">{{title}}</div>
</el-container>

<el-card shadow="hover">
  <el-container class="main">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-dynamic">
      <el-form-item prop="id" label="部门" :rules="[ { required: true, message: '请选择部门', trigger: 'blur' } ]">
        <el-select v-model="ruleForm.id" placeholder="请选择部门">
          <el-option v-for="item in branchData" :label="item.department" :value="item.id" :key="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="name" label="姓名" :rules="[ { required: true, message: '请输入姓名', trigger: 'blur' } ]">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item prop="name" label="项目名称" :rules="[ { required: true, message: '请输入姓名', trigger: 'blur' } ]">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item prop="name" label="金额"
                    :rules="[ { required: true, message: '请输入金额', trigger: 'blur' } ]">
        <el-input v-model="ruleForm.money"></el-input>
      </el-form-item>
      <el-form-item prop="name" label="摘要"
                    :rules="[ { required: true, message: '请输入摘要', trigger: 'blur' } ]">
        <el-input type="textarea" v-model="ruleForm.remark"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
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
        navActive: this.getHrefParam('type') == 'income' ? '5-1' : '5-2',
        isCollapse: false,
        ruleForm: {
          id: '',
          remark: '',
          money: '',
          name: ''
        },
        branchData: [],
        title: this.getHrefParam('type') == 'income' ? '收入管理' : '支出管理'
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
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
    },
    mounted() {
      this.getBranch()
    }
  })
</script>
</html>
