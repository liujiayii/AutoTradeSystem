<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">保险凭证</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="insuranceForm" ref="insuranceForm" label-width="100px" class="demo-ruleForm">
      <el-input v-model="insuranceForm.id"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="buyingCustomerForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="buyingCustomerForm.phone"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="buyingCustomerForm.address"></el-input>
      </el-form-item>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="车型" prop="intention">
            <el-input v-model="buyingCustomerForm.intention"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品牌" prop="brand">
            <el-input v-model="buyingCustomerForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="强险金额" prop="strongDanger">
            <el-input v-model="insuranceForm.strongDanger"></el-input>
          </el-form-item>
        </el-col>
        <!-- <el-col :span="12">
          <el-form-item label="保险类型" prop="kilometres">
            <el-input v-model="insuranceForm.kilometres"></el-input>
          </el-form-item>
        </el-col> -->
        <el-col :span="12">
          <el-form-item label="保险金额" prop="commercialInsurance">
            <el-input v-model="insuranceForm.commercialInsurance"></el-input>
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
        <el-button type="primary" @click="submitForm('insuranceForm')">确定</el-button>
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
        navActive: '2-2',
        isCollapse: false,
        buyingCustomerForm: {
          name: '',
          phone: '',
          address: '',
          brand: '',
          intention: ''
        },
        insuranceForm: {
          strongDanger: '',
          commercialInsurance: ''
        },
        rules: {
          name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
          phone: [{required: true, message: '请输入电话', trigger: 'blur'}],
          address: [{required: true, message: '请输入地址', trigger: 'blur'}],
          vehicle_type: [{required: true, message: '请输入车型', trigger: 'blur'}],
          brand: [{required: true, message: '请输入品牌', trigger: 'blur'}],
          service_life: [{required: true, message: '请输入使用年限', trigger: 'blur'}],
          kilometres: [{required: true, message: '请输入公里数', trigger: 'blur'}],
          offer: [{required: true, message: '请填写粗略报价', trigger: 'blur'}]
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
              url: this.insuranceForm.id ? '/insurance/updateInsurance.action' : '/insurance/insertInsurance.action',
              data: this.insuranceForm.id ? JSON.stringify(this.insuranceForm) : JSON.stringify({"insurance": this.insuranceForm, "buyingCustomer": this.buyingCustomerForm}),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "insurance.jsp"
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
        $.ajax({
          type: 'post',
          url: '/insurance/showBuyingCustomer.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            console.log("保险客户：" + JSON.stringify(res))
            if (res.code == 1) {
              this.buyingCustomerForm = res.data
            }
          },
          error: (res) => {
            console.log(res)
          }
        });
        // 显示保险表信息
        $.ajax({
          type: 'post',
          url: '/insurance/showDetailsInsurance.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            console.log("保险：" + JSON.stringify(res))
            if (res.code == 1) {
              this.insuranceForm = res.data
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