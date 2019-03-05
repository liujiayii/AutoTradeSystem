<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px">
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.id)" type="number"></el-input>
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
            <el-input v-model="ruleForm.intention" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品牌" prop="brand">
            <el-input v-model="ruleForm.brand" :readonly="Boolean(ruleForm.id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="强险金额" prop="strongDanger">
            <el-input v-model="ruleForm.strongDanger" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保险金额" prop="commercialInsurance">
            <el-input v-model="ruleForm.commercialInsurance" type="number"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    <!--  <el-upload
              ref="upload"
              :file-list="fileList"
              action=""
              list-type="picture"
              :auto-upload="false"
              :on-change="updateFile"
              :on-remove="updateFile">
        <el-button slot="trigger" size="small" type="primary">选择文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>-->
      <el-form-item>
        <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
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
        fileList: [],
        formDate: ""
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/insurance/updateInsurance.action' : '/insurance/insertInsurance.action',
              data: this.ruleForm.id ? JSON.stringify({
                id: this.ruleForm.id,
                strongDanger: this.ruleForm.strongDanger,
                commercialInsurance: this.ruleForm.commercialInsurance
              }) : JSON.stringify({
                "buyingCustomer": {
                  name: this.ruleForm.name,
                  phone: this.ruleForm.phone,
                  address: this.ruleForm.address,
                  brand: this.ruleForm.brand,
                  intention: this.ruleForm.intention
                }, "insurance": {
                  strongDanger: this.ruleForm.strongDanger,
                  commercialInsurance: this.ruleForm.commercialInsurance
                }
              }),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'insurance.jsp')
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      },
      submitUpload() {
        // 手动上传
        this.formDate = new FormData();
          for (var i = 0; i < this.fileList.length; i++) {
            this.formDate.append('file', this.fileList[i].raw);
          }
          $.ajax({
            url: "/insurance/uploadFile.action",
            type: 'post',
            contentType: false,
            data: this.formDate,
            async: false,
            processData: false,  //使用ajax上传图片要设置的
            success: function (res) {
              if (res.success) {
                //上传成功
              } else {
                //上传失败
                return;
              }
            },
            error: function (res) {
              alert("请求错误");
            }
          });
        //this.$refs.upload.submit();
      },
      updateFile(file, fileList) {
        this.fileList = fileList;
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
