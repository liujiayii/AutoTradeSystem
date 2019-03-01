<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/pages/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round
             onclick="window.location.href='formEdit.jsp'">添加工单
  </el-button>
</el-container>

<el-tabs v-model="activeName">
  <el-tab-pane label="工单查询" name="first">
    <el-card shadow="hover">
      <el-container class="main">
        <el-form :model="ruleForm" ref="ruleForm" inline label-width="100px">
          <el-form-item label="登记经手人" prop="entryPerson">
            <el-input v-model="ruleForm.entryPerson"></el-input>
          </el-form-item>
          <el-form-item label="车辆号码" prop="vehicleNumber">
            <el-input v-model="ruleForm.vehicleNumber"></el-input>
          </el-form-item>
          <el-form-item label="车型" prop="vehicleType">
            <el-input v-model="ruleForm.vehicleType"></el-input>
          </el-form-item>
          <el-form-item label="客户电话" prop="phoneNumber">
            <el-input v-model="ruleForm.phoneNumber"></el-input>
          </el-form-item>
          <el-form-item label="客户姓名" prop="customerName">
            <el-input v-model="ruleForm.customerName"></el-input>
          </el-form-item>
          <el-form-item label="车辆颜色" prop="color">
            <el-input v-model="ruleForm.color"></el-input>
          </el-form-item>
          <el-form-item label="VIN号" prop="vin">
            <el-input v-model="ruleForm.vin"></el-input>
          </el-form-item>
          <el-form-item label="预约进厂时间" prop="appointmentTime">
            <el-date-picker style="width: 202px" v-model="ruleForm.appointmentTime" type="date" placeholder="选择日期"
                            format="yyyy 年 MM 月 dd 日" value-format="timestamp"></el-date-picker>
          </el-form-item>
         <!--  <el-form-item label="进厂时间" prop="enterTime">
            <el-date-picker style="width: 202px" v-model="ruleForm.enterTime" type="date" placeholder="选择日期"
                            format="yyyy 年 MM 月 dd 日" value-format="timestamp"></el-date-picker>

          </el-form-item> -->
          <el-form-item label="目前情况">
            <el-select v-model="ruleForm.state" placeholder="车辆目前维修进度">
              <el-option label="预约" :value="0"></el-option>
              <el-option label="在修" :value="1"></el-option>
              <el-option label="完工" :value="2"></el-option>
              <el-option label="结算" :value="3"></el-option>
              <el-option label="结账" :value="4"></el-option>
            </el-select>
          </el-form-item>

          <!-- <el-form-item label="预约完工时间" prop="makespanTime">
            <el-date-picker style="width: 202px" v-model="ruleForm.makespanTime" type="date" placeholder="选择日期"
                            format="yyyy 年 MM 月 dd 日" value-format="timestamp"></el-date-picker>
          </el-form-item> -->
          <el-row>
            <el-col :span="24">
              <el-form-item>
                <el-button type="info" @click="submitForm()">搜索</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-container>
    </el-card>
  </el-tab-pane>
  <el-tab-pane label="显示工单" name="second">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="车牌号" prop="vehicleNumber" show-overflow-tooltip></el-table-column>
          <el-table-column label="车主名称" prop="customerName" show-overflow-tooltip></el-table-column>
          <el-table-column label="车型" prop="vehicleType" show-overflow-tooltip></el-table-column>
          <!-- <el-table-column label="进厂时间" prop="enterTime" :formatter="dateFormat"
                           show-overflow-tooltip></el-table-column> -->
          <el-table-column label="客户电话" prop="phone_number" show-overflow-tooltip></el-table-column>
          <el-table-column label="居住地址" prop="address" show-overflow-tooltip></el-table-column>
          <el-table-column label="状态" prop="state" :formatter="stateFormat" show-overflow-tooltip></el-table-column>
          <el-table-column align="right">
            <template slot="header" slot-scope="scope">
              <el-input placeholder="输入关键词进行搜索" @focus="activeName='first'"/>
            </template>
            <template slot-scope="scope">
              <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-container>
    </el-card>
    <el-container class="page-box">
      <div class="block">
        <el-pagination
                @current-change="handleCurrentChange"
                layout="total,prev, pager, next, jumper"
                :total="tableData.count">
        </el-pagination>
      </div>
    </el-container>
  </el-tab-pane>
</el-tabs>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '8-1',
        activeName: 'second',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {limit: 10}
      }
    },
    methods: {
      resetForm(formName) {
        this.ruleForm = {page: 1, limit: 10};
      },
      stateFormat(row, column, cellValue, index) {
        console.log(cellValue)
        return cellValue == 0 ? '预约' : cellValue == 1 ? '在修' : cellValue == 3 ? '结算' : cellValue == 4 ? '结账' : cellValue == 2 ? '完工' : '系统异常'
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'formEdit.jsp?id=' + row.vehicleId + '&repair_id=' + row.repair_id
      },
      handleCurrentChange(page) {
        console.log(page)
        this.ruleForm.page = page
        for (let i in this.ruleForm) {
          if (this.ruleForm[i] == '') {
            delete this.ruleForm[i]
          }
        }
        this.getTable(this.ruleForm, '/Repair/hybridSelect.action', '/Repair/hybridSelect.action')
      },
      submitForm() {
        this.handleCurrentChange(1)
        this.activeName = 'second'
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
