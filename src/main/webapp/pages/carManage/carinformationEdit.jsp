<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">车辆信息</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-row>
        <el-col :span="12">
          <el-form-item label="车型代码" prop="vehicleCode">
            <el-input v-model="ruleForm.vehicleCode"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="厂牌型号" prop="brand">
            <el-input v-model="ruleForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="place">
            <el-input v-model="ruleForm.place"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价格" prop="selling_price">
            <el-input v-model="ruleForm.selling_price"></el-input>
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
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '4-2',
        ruleForm: {
          vehicleCode: '',
          vehicle_type: '',
          brand: '',
          place: '',
          selling_price: ''
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/VehichileDetailed/update.action' : '/VehichileDetailed/insert.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.notifySuc(res.msg,'carinformation.jsp')
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                console.log(res)
                this.notifyError(res.msg)
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
        this.onLoad('/VehichileDetailed/selectById.action', {id: this.getHrefParam('id')})
      }
    }
  })
</script>
</html>
