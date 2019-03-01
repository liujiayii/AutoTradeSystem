<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/pages/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
</el-container>
<el-card shadow="hover">
  <el-container class="main">
    <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px" :rules="rules">
      <el-row>
        <el-col :span="24">
          <el-form-item label="车辆信息："></el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="车辆号码" prop="vehicle_number">
        <el-input v-model="ruleForm.vehicle_number" @blur="searchNum"></el-input>
      </el-form-item>
      <el-form-item label="来源" prop="source">
        <el-input v-model="ruleForm.source"></el-input>
      </el-form-item>
      <el-form-item label="性质" prop="nature">
        <el-input v-model="ruleForm.nature"></el-input>
      </el-form-item>
      <el-form-item label="车型" prop="vehicle_type">
        <el-select style="width: 202px" v-model="ruleForm.vehicle_type" placeholder="请选择车型" @change="selectCarType">
          <el-option v-for="item in carType" :key="item.id" :label="item.vehicle_classification"
                     :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="车名" prop="range_rover">
        <el-select style="width: 202px" v-model="ruleForm.range_rover" placeholder="请选择车名" @change="selectCarName">
          <el-option v-for="item in carName" :key="item.model_definition_id" :label="item.range_rover"
                     :value="item.range_rover">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="厂牌" prop="brand">
        <el-input v-model="ruleForm.brand" readonly></el-input>
      </el-form-item>
      <el-form-item label="发动机号" prop="engine_number">
        <el-input v-model="ruleForm.engine_number"></el-input>
      </el-form-item>
      <el-form-item label="底盘号" prop="chassis_number">
        <el-input v-model="ruleForm.chassis_number"></el-input>
      </el-form-item>
      <el-form-item label="变速箱号" prop="gearbox_number">
        <el-input v-model="ruleForm.gearbox_number"></el-input>
      </el-form-item>
      <el-form-item label="类别" prop="category">
        <el-input v-model="ruleForm.category"></el-input>
      </el-form-item>
      <el-form-item label="机型" prop="aircraft_type">
        <el-input v-model="ruleForm.aircraft_type"></el-input>
      </el-form-item>
      <el-form-item label="VIN号" prop="vin">
        <el-input v-model="ruleForm.vin"></el-input>
      </el-form-item>
      <el-form-item label="内部编号" prop="internal_number">
        <el-input v-model="ruleForm.internal_number"></el-input>
      </el-form-item>
      <el-form-item label="车身颜色" prop="color">
        <el-input v-model="ruleForm.color"></el-input>
      </el-form-item>
      <el-row>
        <el-col :span="24">
          <el-form-item label="车主信息："></el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="联系电话" prop="phone_code">
        <el-input style="width: 202px" v-model="ruleForm.phone_code" type="number">
          <el-button slot="append" icon="el-icon-search" @click="search1"></el-button>
        </el-input>
      </el-form-item>
      <el-form-item label="车主名称" prop="customer_name">
        <el-input v-model="ruleForm.customer_name" readonly></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="ruleForm.address" readonly></el-input>
      </el-form-item>
      <el-form-item label="邮编" prop="postcode">
        <el-input v-model="ruleForm.postcode" readonly></el-input>
      </el-form-item>
      <el-row>
        <el-col :span="24">
          <el-form-item label="驾驶人员："></el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="手机" prop="move_number">
        <el-input style="width: 202px" v-model="ruleForm.move_number" type="number">
          <el-button slot="append" icon="el-icon-search" @click="search2"></el-button>
        </el-input>
      </el-form-item>
      <el-form-item label="驾驶员" prop="driver_name">
        <el-input v-model="ruleForm.driver_name" readonly></el-input>
      </el-form-item>
      <el-form-item label="驾驶证号" prop="driver_license_number">
        <el-input v-model="ruleForm.driver_license_number" readonly></el-input>
      </el-form-item>
      <el-form-item label="身份证号" prop="id_number">
        <el-input v-model="ruleForm.id_number" readonly></el-input>
      </el-form-item>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="保险归属："></el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="三包单位" prop="three_guarantees">
            <el-input v-model="ruleForm.three_guarantees"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="经销商" prop="dealer">
            <el-input v-model="ruleForm.dealer"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="车辆备注" prop="vehicle_note">
            <el-input v-model="ruleForm.vehicle_note"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item>
            <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
            <el-button @click="goBack">取消</el-button>
          </el-form-item>
        </el-col>
      </el-row>
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
        navActive: '9-1',
        searchVal: '',
        ruleForm: {
          address: '',
          aircraft_type: '',
          area: '',
          brand: '',
          brithday: '',
          c_id: '',
          category: '',
          chassis_number: '',
          color: '',
          company: '',
          customer_archives_id: '',
          customer_id: '',
          customer_name: '',
          customer_type: '',
          d_id: '',
          dealer: '',
          driver_id: '',
          driver_license_number: '',
          driver_name: '',
          duty: '',
          e_mail: '',
          engine_number: '',
          expiry_date: '',
          fax: '',
          gearbox_number: '',
          gender: '',
          id_number: '',
          internal_number: '',
          m_id: '',
          model_definition_id: '',
          move_number: '',
          nature: '',
          office_telephone: '',
          opening_date: '',
          phone_code: '',
          phone_number: '',
          postcode: '',
          province: '',
          quasi_driving_type: '',
          range_rover: '',
          region: '',
          source: '',
          three_guarantees: '',
          vehicle_classification_id: '',
          vehicle_note: '',
          vehicle_number: '',
          vehicle_type: '',
          vin: ''
        },
        carType: [],
        carName: []
      }
    },
    methods: {
      searchNum(){
        console.log('------')
        $.ajax({
          type: 'post',
          url: '/carRecord/findVehicleArchivesByVehicleNumber.action',
          data: {vehicle_number: this.ruleForm.vehicle_number},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {

            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            console.log(res)
            this.notifyError(res.msg)
          }
        })
      },
      selectCarName(val) {
        let obj = {}
        obj = this.carName.find((item) => {
          return item.range_rover === val
        })
        this.ruleForm.brand = obj.brand
        this.ruleForm.model_definition_id = obj.model_definition_id
      },
      selectCarType(val) {
        console.log(val)
        this.ruleForm.range_rover = ''
        this.ruleForm.brand = ''

        $.ajax({
          type: 'post',
          url: '/carRecord/findCarNameByid.action',
          data: {id: val},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.carName = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            console.log(res)
            this.notifyError(res.msg)
          }
        })
      },
      search1() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findClientByPhone.action',
          data: {phone: this.ruleForm.phone_code},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
              res.data.customer_archives_id = res.data.id
              delete res.data.id
              Object.assign(this.ruleForm, res.data)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
            console.log(res)
          }
        })
      },
      search2() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findDriverByPhone.action',
          data: {phone: this.ruleForm.move_number},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
              res.data.driver_id = res.data.id
              delete res.data.id
              Object.assign(this.ruleForm, res.data)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
            console.log(res)
          }
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.getHrefParam('id') ? '/carRecord/updateCarArchives.action' : '/carRecord/insertCarArchives.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.notifySuc(res.msg, 'carArchives.jsp')
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
                console.log(res)
              }
            })
            console.log(this.ruleForm)
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      getCarType() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findCarType.action',
          data: this.ruleForm,
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.carType = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            console.log(res)
            this.notifyError(res.msg)
          }
        })
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        this.onLoad('/carRecord/findCarArchivesById.action', {id: this.getHrefParam('id')})
      }
      this.getCarType()
    }
  })
</script>
</html>
