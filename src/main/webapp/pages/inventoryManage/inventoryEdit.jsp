<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">库存管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-input v-model="ruleForm.id"></el-input>
      <el-row>
        <el-col :span="12">
          <el-form-item label="采购人" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="采购项目" prop="purchase">
            <el-input v-model="ruleForm.purchase"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型" prop="type">
            <el-input v-model="ruleForm.type"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="采购金额" prop="purchaseMoney">
            <el-input v-model="ruleForm.purchaseMoney"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="采购时间" prop="createTime">
            <el-date-picker v-model="ruleForm.createTime" type="date" placeholder="选择日期"
                            value-format="timestamp"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="singName">
            <el-input v-model="ruleForm.singName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remark">
            <el-input v-model="ruleForm.remark"></el-input>
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
        navActive: '6-1',
        ruleForm: {
          name: '',
          type: '',
          purchase: '',
          singName: '',
          purchaseMoney: '',
          createTime: '',
          remark: ''
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
              url: this.ruleForm.id ? '/purchase/updatePurchaseById.action' : '/purchase/insertPurchase.action',
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
                      window.location.href = "inventoryManage.jsp"
                    }
                  });
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
      created() {
        if (this.getHrefParam('id')) {
          $.ajax({
            type: 'post',
            url: '/purchase/selectPurchaseById.action',
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
    }
  })
</script>
</html>
