<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round onclick="window.location.href = 'carEdit.jsp'">添加</el-button>
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
      <el-table-column label="姓名" prop=customer_name show-overflow-tooltip></el-table-column>
      <el-table-column label="手机号码" prop="phone_code" show-overflow-tooltip></el-table-column>
      <el-table-column label="车牌号" prop=vehicle_number show-overflow-tooltip></el-table-column>
      <el-table-column label="送检人（驾驶员）" prop="driver_name" show-overflow-tooltip></el-table-column>
      <el-table-column label="车型" prop="vehicle_type" show-overflow-tooltip></el-table-column>
      <el-table-column label="车名" prop="range_rover" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="info" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="车辆档案" :visible.sync="dialogFormVisible" @close="clearForm">

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
        navActive: '9-1',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        dialogFormVisible: false
      }
    },
    methods: {
      clearForm() {
        this.ruleForm = {}
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        this.ruleForm = row
        window.location.href = 'carEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          keyWord: this.searchVal
        }, '/carRecord/findCarArchives.action', '/carRecord/findCarArchives.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/carRecord/updateDriver.action' : '/carRecord/insertDriver.action',
              data: JSON.stringify(this.ruleForm),
              contentType: 'application/json; charset=UTF-8',
              dataType: 'json',
              success: (res) => {
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
            return false;
          }
        })
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
