<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">车辆信息</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-row>
        <el-col :span="12">
          <el-form-item label="车型代码" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型" prop="brand">
            <el-input v-model="ruleForm.brand"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="厂牌型号" prop="color">
            <el-input v-model="ruleForm.color"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="create_time">
            <el-input v-model="ruleForm.create_time" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价格" prop="chassis_number">
            <el-input v-model="ruleForm.chassis_number"></el-input>
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
        navActive: '4-2',
        isCollapse: false,
        ruleForm: {
          vehicle_type: '',
          brand: '',
          type: '',
          create_time: '',
          color: '',
          chassis_number: '',
          engine_number: '',
          qualified_number: '',
          imported_number: '',
          inspection_number: '',
          carry_number: '',
          self_number: '',
          key_number: '',
          mileage: '',
          business: '',
          single_person: '',
          selling_price: '',
          remark: '',
          seling_id: '',
          vehile_number: '',
          place: '',
          vehicle_code: '',
          vehicle_types: ''
        },
        rules: {
          vehicle_type: [
            {required: true, message: '请输入车型', trigger: 'blur'}
          ],
          brand: [
            {required: true, message: '请输入车牌', trigger: 'blur'}
          ],
          type: [
            {required: true, message: '请输入车类', trigger: 'blur'}
          ],
          /* create_time: [
            {required: true, message: '请输入创建时间', trigger: 'blur'}
          ], */
          color: [
            {required: true, message: '请输入车辆颜色', trigger: 'blur'}
          ],
          chassis_number: [
            {required: true, message: '请输入底盘号', trigger: 'blur'}
          ],
          engine_number: [
            {required: true, message: '请输入发动机号', trigger: 'blur'}
          ],
          qualified_number: [
            {required: true, message: '请填写合格证号', trigger: 'blur'}
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
              url: this.ruleForm.id ? '/updateSellingCustomerById.action' : '/Vehichle/insert.action',
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
                      window.location.href = "carManage.jsp"
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
          url: '/selectSellingCustomerById.action',
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
