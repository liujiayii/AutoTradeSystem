<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">评估审核</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="车型" prop="intention">
            <el-input v-model="ruleForm.intention"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品牌" prop="brand">
            <el-input v-model="ruleForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="评估金额" prop="assessmentMoney">
            <el-input v-model="ruleForm.assessmentMoney"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="评估人" prop="assessmentName">
            <el-input v-model="ruleForm.assessmentName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
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
        navActive: '2-1',
        isCollapse: false,
        ruleForm: {
          assessmentMoney: '',
          assessmentName: '',
          brand: '',
          intention: ''
        },
        rules: {
          assessment_money: [
            {required: true, message: '请输入评估金额', trigger: 'blur'}
          ],
          assessment_name: [
            {required: true, message: '请输入评估人', trigger: 'blur'}
          ],
          brand: [
            {required: true, message: '请输入品牌', trigger: 'blur'}
          ],
          intention: [
            {required: true, message: '请输入车型', trigger: 'blur'}
          ]
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
              url: this.ruleForm.id ? '/Assessment/updateByPrimaryKey.action' : '/Assessment/insertAssessment.action',
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
                      window.location.href = "evaluation.jsp"
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
    created() {
      if (this.getHrefParam('id')) {
        $.ajax({
          type: 'post',
          url: '/Assessment/selectAssessmentById.action',
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
        })
      }
    }
  })
</script>
</html>
