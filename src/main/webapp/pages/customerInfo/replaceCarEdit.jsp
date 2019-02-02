<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">车辆置换</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id" type="hidden"></el-input>
      <el-form-item label="客户信息"></el-form-item>
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
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item label="车辆信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="意向车型" prop="intention">
            <el-input v-model="ruleForm.intention"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="意向品牌" prop="brands">
            <el-input v-model="ruleForm.brands"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="客户预算" prop="budget">
            <el-input v-model="ruleForm.budget"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车型" prop="vehicleType">
            <el-input v-model="ruleForm.vehicleType"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品牌" prop="brand">
            <el-input v-model="ruleForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="使用年限" prop="service_life">
            <el-input v-model="ruleForm.service_life"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公里数" prop="kilometres">
            <el-input v-model="ruleForm.kilometres"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无重大事故" prop="major_accidents">
            <el-radio-group v-model="ruleForm.major_accidents">
              <el-radio border :label="1">有</el-radio>
              <el-radio border :label="0">无</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="粗略报价" prop="offer">
            <el-input v-model="ruleForm.offer"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="维修记录" prop="maintenance_record">
            <el-input type="textarea" :rows="2" v-model="ruleForm.maintenance_record"></el-input>
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
        navActive: '1-3',
        isCollapse: false,
        ruleForm: {
          name: '',
          phone: '',
          address: '',
          intention: '',
          brands: '',
          budget: '',
          vehicleType: '',
          brand: '',
          major_accidents: 0,
          maintenance_record: '',
          offer: ''
        },
        rules: {
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'}
          ],
          phone: [
            {required: true, message: '请输入电话', trigger: 'blur'}
          ],
          address: [
            {required: true, message: '请输入地址', trigger: 'blur'}
          ],
          intention: [
            {required: true, message: '请输入意向车型', trigger: 'blur'}
          ],
          brands: [
            {required: true, message: '请输入意向车牌', trigger: 'blur'}
          ],
          budget: [
            {required: true, message: '请输入预算', trigger: 'blur'}
          ],
          vehicleType: [
            {required: true, message: '请输入车型', trigger: 'blur'}
          ],
          brand: [
            {required: true, message: '请输入品牌', trigger: 'blur'}
          ],
          service_life: [
            {required: true, message: '请输入使用年限', trigger: 'blur'}
          ],
          kilometres: [
            {required: true, message: '请输入公里数', trigger: 'blur'}
          ],
          offer: [
            {required: true, message: '请填写粗略报价', trigger: 'blur'}
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
              url: this.ruleForm.id ? '/updateSubCustomerById.action' : '/insertAllSubCustomer.action',
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
                      window.location.href = "carResources.jsp"
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
          url: '/selectSubCustomerById.action',
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
