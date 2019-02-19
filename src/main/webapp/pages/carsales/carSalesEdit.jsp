<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">订车管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px">
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
            <el-input v-model="ruleForm.phone" :readonly="Boolean(ruleForm.c_id)" placeholder="请输入电话进行搜索">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search" @click="search"></el-button>
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系地址" prop="address">
        <el-input v-model="ruleForm.address" readonly></el-input>
      </el-form-item>
      <el-form-item label="购买信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="付款方式">
            <el-select v-model="ruleForm.type" placeholder="请选择付款方式">
              <el-option label="全款" :value="1"></el-option>
              <el-option label="分期" :value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="成交价" prop="money">
            <el-input v-model="ruleForm.money"></el-input>
          </el-form-item>
        </el-col>
        <template v-if="this.ruleForm.type==2">
          <el-col :span="12">
            <el-form-item label="首付款" prop="first_payment">
              <el-input v-model="ruleForm.first_payment"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="分期月数" prop="monthly_number">
              <el-input v-model="ruleForm.monthly_number"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月供" prop="monthly_supply">
              <el-input v-model="ruleForm.monthly_supply"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="保险地址">
            <el-select v-model="ruleForm.insurance" placeholder="请选择保险地址">
              <el-option label="本店" :value="1"></el-option>
              <el-option label="外部" :value="2"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制单人" prop="single_person">
            <el-input v-model="ruleForm.single_person" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务员" prop="person">
            <el-input v-model="ruleForm.person" :readonly="Boolean(ruleForm.c_id)"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="售价" prop="s_money">
            <el-input v-model="ruleForm.s_money"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-form-item label="车辆信息"></el-form-item>
        <el-col :span="12">
          <el-form-item label="入库编号" prop="vehile_number">
            <el-input v-model="ruleForm.vehile_number" :readonly="Boolean(ruleForm.c_id)" placeholder="请输入入库编号进行搜索">
              <el-button v-if="!Boolean(ruleForm.c_id)" slot="append" icon="el-icon-search"
                         @click="search2"></el-button>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车辆类型" prop="vehicle_type">
            <el-input v-model="ruleForm.vehicle_type" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车牌" prop="brand">
            <el-input v-model="ruleForm.brand" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车型代码" prop="vehicle_code">
            <el-input v-model="ruleForm.vehicle_code" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产地" prop="place">
            <el-input v-model="ruleForm.place" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发动机号" prop="engine_number">
            <el-input v-model="ruleForm.engine_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="合格证号" prop="qualified_number">
            <el-input v-model="ruleForm.qualified_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="底盘号" prop="chassis_number">
            <el-input v-model="ruleForm.chassis_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="进口证号" prop="imported_number">
            <el-input v-model="ruleForm.imported_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="商检号" prop="inspection_number">
            <el-input v-model="ruleForm.inspection_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="提单号" prop="carry_number">
            <el-input v-model="ruleForm.carry_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="自编号" prop="self_number">
            <el-input v-model="ruleForm.self_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="钥匙号" prop="key_number">
            <el-input v-model="ruleForm.key_number" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行驶里程" prop="mileage">
            <el-input v-model="ruleForm.mileage" readonly></el-input>
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
        navActive: '3-2',
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
          single_person: '${user.name}',
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
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.ruleForm.v_id = this.ruleForm.id
            console.log(this.ruleForm)
            $.ajax({
              type: 'post',
              url: this.ruleForm.c_id ? '/sellCar/updateSellCar.action' : '/sellCar/addSellCar.action',
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
            vehile_number: this.ruleForm.vehile_number
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              delete res.data['id']
              Object.assign(this.ruleForm, res.data)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        ths.onLoad('/sellCar/findById.action',{c_id: this.getHrefParam('id')})
      }
    }
  })
</script>
</html>
