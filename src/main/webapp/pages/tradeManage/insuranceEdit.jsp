<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">保险凭证</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px">
      <el-input v-model="ruleForm.id"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="ruleForm.address" :readonly="Boolean(ruleForm.id)"></el-input>
      </el-form-item>
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
          <el-form-item label="强险金额" prop="strongDanger">
            <el-input v-model="ruleForm.strongDanger"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保险金额" prop="commercialInsurance">
            <el-input v-model="ruleForm.commercialInsurance"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-upload
              class="upload-demo"
              action="https://jsonplaceholder.typicode.com/posts/"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :file-list="fileList2"
              list-type="picture">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
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
    mixins: [mixin, rules],
    data: function () {
      return {
        navActive: '2-2',
        ruleForm: {
          name: '',
          phone: '',
          address: '',
          brand: '',
          intention: '',
          strongDanger: '',
          commercialInsurance: ''
        },
        fileList2: [{
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }, {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }]

      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/insurance/updateInsurance.action' : '/insurance/insertInsurance.action',
              data: this.ruleForm.id ? JSON.stringify({
                name: this.ruleForm.name,
                phone: this.ruleForm.phone,
                address: this.ruleForm.address,
                brand: this.ruleForm.brand,
                intention: this.ruleForm.intention
              }) : JSON.stringify({
                "insurance": {
                  name: this.ruleForm.name,
                  phone: this.ruleForm.phone,
                  address: this.ruleForm.address,
                  brand: this.ruleForm.brand,
                  intention: this.ruleForm.intention
                }, "buyingCustomer": {
                  strongDanger: this.ruleForm.strongDanger,
                  commercialInsurance: this.ruleForm.commercialInsurance
                }
              }),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'insurance.jsp')
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
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        //获取保险表关联客户信息
        this.onLoad('/insurance/showBuyingCustomer.action', {id: this.getHrefParam('id')})
        // 显示保险表信息
        this.onLoad('/insurance/showDetailsInsurance.action', {id: this.getHrefParam('id')})
      }
    }
  })
</script>
</html>
