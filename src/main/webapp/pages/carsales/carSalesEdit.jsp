<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">订车管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id" type="hidden"></el-input>
      <el-input v-model="ruleForm.c_id" type="hidden"></el-input>
      <el-input v-model="ruleForm.v_id" type="hidden"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.c_id)">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search" @click="search"></el-button>
            </el-input>
            <!--<el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>-->
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="ruleForm.address" readonly></el-input>
      </el-form-item>
      <el-form-item label="购买信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="付款方式" :rules="[ { required: true, message: '请输入付款方式', trigger: 'blur' } ]">
            <el-select v-model="ruleForm.type" placeholder="请选择付款方式">
              <el-option label="全款" :value="1"></el-option>
              <el-option label="分期" :value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="成交价" prop="money" :rules="[ { required: true, message: '请输入成交价', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.money"></el-input>
          </el-form-item>
        </el-col>
        <template v-if="this.ruleForm.type==2">
          <el-col :span="12">
            <el-form-item label="首付款" prop="first_payment"
                          :rules="[ { required: true, message: '请输入首付款', trigger: 'blur' } ]">
              <el-input v-model="ruleForm.first_payment"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="分期月数" prop="monthly_number"
                          :rules="[ { required: true, message: '请输入分期月数', trigger: 'blur' } ]">
              <el-input v-model="ruleForm.monthly_number"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月供" prop="monthly_supply"
                          :rules="[ { required: true, message: '请输入月供', trigger: 'blur' } ]">
              <el-input v-model="ruleForm.monthly_supply"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="保险地址" :rules="[ { required: true, message: '请选择保险地址', trigger: 'blur' } ]">
            <el-select v-model="ruleForm.insurance" placeholder="请选择保险地址">
              <el-option label="本店" :value="1"></el-option>
              <el-option label="外部" :value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="single_person"
                        :rules="[ { required: true, message: '请输入制单人', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.single_person" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务员" prop="person" :rules="[ { required: true, message: '请输入业务员', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.person" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="售价" prop="s_money" :rules="[ { required: true, message: '请输入售价', trigger: 'blur' } ]">
            <el-input v-model="ruleForm.s_money"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-form-item label="车辆信息"></el-form-item>
        <el-col :span="12">
          <el-form-item label="入库编号" prop="vehile_number">
            <el-input v-model="carForm.vehile_number" :readonly="Boolean(ruleForm.c_id)">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search"
                         @click="search2"></el-button>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车辆类型" prop="vehicle_type">
            <el-input v-model="carForm.vehicle_type" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车牌" prop="brand">
            <el-input v-model="carForm.brand" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车型代码" prop="vehicle_code">
            <el-input v-model="carForm.vehicle_code" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="place">
            <el-input v-model="carForm.place" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发动机号" prop="engine_number">
            <el-input v-model="carForm.engine_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="合格证号" prop="qualified_number">
            <el-input v-model="carForm.qualified_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="底盘号" prop="chassis_number">
            <el-input v-model="carForm.chassis_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="进口证号" prop="imported_number">
            <el-input v-model="carForm.imported_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="商检号" prop="inspection_number">
            <el-input v-model="carForm.inspection_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="提单号" prop="carry_number">
            <el-input v-model="carForm.carry_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="自编号" prop="self_number">
            <el-input v-model="carForm.self_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="钥匙号" prop="key_number">
            <el-input v-model="carForm.key_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行驶里程" prop="mileage">
            <el-input v-model="carForm.mileage" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出厂时间" prop="monthly_number">
            <el-input v-model="carForm.monthly_number" readonly></el-input>
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
        navActive: '3-1',
        isCollapse: false,
        ruleForm: {
          name: '',
          address: '',
          id: '',
          phone: '',
          type: '',
          money: '',
          first_payment: '',
          monthly_number: '',
          monthly_supply: '',
          insurance: '',
          s_money: '',
          business: '',
          single_person:'${user.name}'
        },
        carForm: {
          vehile_number: '',
          vehicle_type: '',
          brand: '',
          engine_number: '',
          qualified_number: '',
          chassis_number: '',
          imported_number: '',
          inspection_number: '',
          carry_number: '',
          self_number: '',
          key_number: '',
          mileage: '',
          selling_price: ''
        },
        rules: {}
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.ruleForm.v_id = this.carForm.id
            this.ruleForm.vehile_number = this.carForm.vehile_number
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.c_id ? '/sellCar/updateSellCar.action' : '/insertbooking.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.$alert(res.msg, '提示', {
                    confirmButtonText: '确定',
                    type: 'success',
                    callback: action => {
                      window.location.href = "carSales.jsp"
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
      },
      search() {
        $.ajax({
          type: 'post',
          url: '/sellCar/findClientByPhone.action',
          data: {phone: this.ruleForm.phone},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm.name = res.data.name
              this.ruleForm.address = res.data.address
              this.ruleForm.id = res.data.id
            } else {
              this.$confirm(res.msg, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '前往添加客户信息',
                type: 'warning'
              }).then(() => {
                for (let key in this.ruleForm) {
                  this.ruleForm[key] = ''
                }
              }).catch(() => {
                window.location.href = '/pages/customerInfo/buyingCarConsult.jsp'
              });
            }
          }
        })


      },
      search2() {
        $.ajax({
          type: 'post',
          url: '/sellCar/findCarByNumber.action',
          data: {
            vehile_number: this.carForm.vehile_number
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.carForm = res.data
            } else {
              for (let key in this.carForm) {
                this.carForm[key] = ''
              }
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


      }
    },
    created() {
      if (this.getHrefParam('id')) {
        $.ajax({
          type: 'post',
          url: '/sellCar/findById.action',
          data: {
            c_id: this.getHrefParam('id')
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm = res.data
              this.carForm = res.data
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
