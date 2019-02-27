<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">客户档案</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round @click="dialogFormVisible=true">添加</el-button>
</el-container>
<el-card shadow="hover">
  <el-container class="main">
    <el-table v-loading="loading2"
              element-loading-text="拼命加载中"
              stripe
              size="small"
              element-loading-spinner="el-icon-loading"
              :data="tableData.data"
              style="width: 100%">
      <el-table-column label="客户姓名" prop="customer_name" show-overflow-tooltip></el-table-column>
      <el-table-column label="电话号码" prop="phone_number" show-overflow-tooltip></el-table-column>
      <el-table-column label="地址" prop="address" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="客户档案编辑" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form :model="ruleForm" ref="ruleForm" inline label-width="100px">
        <el-form-item label="客户类型" prop="customer_type">
          <el-select style="width: 202px" v-model="ruleForm.customer_type" placeholder="请选择客户类型">
            <el-option v-for="item in custClass" :key="item.id" :label="item.type"
                       :value="item.type">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="区域" prop="area">
          <el-input v-model="ruleForm.area"></el-input>
        </el-form-item>
        <el-form-item label="客户姓名" prop="customer_name">
          <el-input v-model="ruleForm.customer_name"></el-input>
        </el-form-item>
        <el-form-item label="邮编" prop="postcode">
          <el-input v-model="ruleForm.postcode"></el-input>
        </el-form-item>
        <el-form-item label="电话号码" prop="phone_number">
          <el-input v-model="ruleForm.phone_number"></el-input>
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="ruleForm.province"></el-input>
        </el-form-item>
        <el-form-item label="地区" prop="region">
          <el-input v-model="ruleForm.region"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="传真" prop="fax">
          <el-input v-model="ruleForm.fax"></el-input>
        </el-form-item>
        <el-form-item label="公司名称" prop="company">
          <el-input v-model="ruleForm.company"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
          <el-button @click="dialogFormVisible=false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
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
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '9-2',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        dialogFormVisible: false,
        custClass: []
      }
    },
    methods: {
      clearForm() {
        this.ruleForm = {}
      },
      search(value) {
        console.log(this.searchVal)
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        console.log(index, row)
        this.ruleForm = row
        this.dialogFormVisible = true
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          keyWord: this.searchVal
        }, '/carRecord/findCustomer.action', '/carRecord/findCustomer.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            delete this.ruleForm.vehicle_type
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/carRecord/updateCustomer.action' : '/carRecord/insertCustomer.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.dialogFormVisible = false
                  this.$refs[formName].resetFields();
                  this.notifyNoPath(res.msg)
                  this.handleCurrentChange(1)
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      getClass() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findClientType.action',
          data: this.ruleForm,
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.custClass = res.data
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
      this.handleCurrentChange(1)
      this.getClass()
    }
  })
</script>
</html>
