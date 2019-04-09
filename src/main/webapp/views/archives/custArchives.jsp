<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round @click="dialogFormVisible=true">添加</el-button>
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
          <el-button size="mini" type="info" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button type="danger" size="mini" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="客户档案编辑" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form :model="ruleForm" ref="ruleForm" inline label-width="100px" :rules="rules">
        <el-form-item label="客户类型" prop="customer_type">
          <el-select style="width: 202px" v-model="ruleForm.customer_type" placeholder="请选择客户类型">
            <el-option v-for="item in custClass" :key="item.id" :label="item.type"
                       :value="item.type">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="区域" >
          <el-input v-model="ruleForm.area"></el-input>
        </el-form-item>
        <el-form-item label="客户姓名" prop="customer_name">
          <el-input v-model="ruleForm.customer_name"></el-input>
        </el-form-item>
        <el-form-item label="邮编" >
          <el-input v-model="ruleForm.postcode" type="number"></el-input>
        </el-form-item>
        <el-form-item label="电话号码" prop="phone_number">
          <el-input v-model="ruleForm.phone_number" type="number"></el-input>
        </el-form-item>
        <el-form-item label="省份">
          <el-input v-model="ruleForm.province"></el-input>
        </el-form-item>
        <el-form-item label="地区">
          <el-input v-model="ruleForm.region"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="传真" >
          <el-input v-model="ruleForm.fax"></el-input>
        </el-form-item>
        <el-form-item label="公司名称" >
          <el-input v-model="ruleForm.company"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
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
    mixins: [mixin, rules],
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
    	handleDelete(index,row){
    		this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
    	          confirmButtonText: '确定',
    	          cancelButtonText: '取消',
    	          type: 'warning'
    	        }).then(() => {
    	        	console.log(row)
    	        	$.ajax({
    	                type: 'post',
    	                url: '/carRecord/deleteCustomer.action',
    	                dataType: 'json',
    	                data:{id:row.id},
    	                success: (res) => {
    	                  if (res.code == 1) {
    	                	  this.handleCurrentChange(1)
    	                   this.notifyNoPath(res.msg)
    	                  } else {
    	                    this.notifyError(res.msg)
    	                  }
    	                },
    	                error: (res) => {
    	                  this.notifyError(res.msg)
    	                }
    	              })
    	        }).catch(() => {
    	          this.$message({
    	            type: 'info',
    	            message: '已取消删除'
    	          });          
    	        });
    	},
      clearForm() {
        this.ruleForm = {}
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        this.ruleForm = row
        this.dialogFormVisible = true
      },
      handleCurrentChange(page) {
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
                if (res.code == 1) {
                  this.dialogFormVisible = false
                  this.$refs[formName].resetFields();
                  this.notifyNoPath(res.msg)
                  this.handleCurrentChange(this.page)
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
      getClass() {
        $.ajax({
          type: 'post',
          url: '/carRecord/findClientType.action',
          data: this.ruleForm,
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.custClass = res.data
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
      this.handleCurrentChange(1)
      this.getClass()
    }
  })
</script>
</html>
