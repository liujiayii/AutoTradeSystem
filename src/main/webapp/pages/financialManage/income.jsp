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
             onclick="window.location.href='financialEdit.jsp?type=income'">添加
  </el-button>
</el-container>
<el-container style="justify-content: center;margin-bottom: 20px">
  <el-radio-group v-model="branch" @change="change">
    <el-radio-button v-for="item in branchData" :key="item.id" :label="item.department"></el-radio-button>
  </el-radio-group>
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
      <el-table-column label="创建时间" prop="createTime" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
      <el-table-column label="日期" prop="data" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
      <el-table-column label="姓名" prop="name" show-overflow-tooltip></el-table-column>
      <el-table-column label="项目" prop="income" show-overflow-tooltip></el-table-column>
      <el-table-column label="摘要" prop="incomeDetailed" show-overflow-tooltip></el-table-column>
      <el-table-column label="金额" prop="incomeMoney" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-container>
</el-card>
<el-dialog title="编辑" :visible.sync="dialogFormVisible" width="500px">
  <el-form :model="ruleForm" label-width="100px" ref="ruleForm" :rules="rules" inline>
    <el-form-item prop="departmentId" label="部门">
      <el-select style="width: 202px" v-model="ruleForm.departmentId" placeholder="请选择部门">
        <el-option v-for="item in branchData" :label="item.department" :value="item.department"
                   :key="item.id"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item prop="name" label="姓名">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="项目名称">
      <el-input v-model="ruleForm.income"></el-input>
    </el-form-item>
    <el-form-item label="金额">
      <el-input v-model="ruleForm.incomeMoney" type="number"></el-input>
    </el-form-item>
    <el-form-item label="摘要">
      <el-input style="width: 202px" type="textarea" v-model="ruleForm.incomeDetailed"></el-input>
    </el-form-item>
    <el-form-item label="日期">
      <el-date-picker style="width: 202px" v-model="ruleForm.data" type="date" value-format="timestamp" placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="info" @click="submit">确 定</el-button>
  </div>
</el-dialog>
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
        navActive: '5-2',
        tableData: {
          data: [],
          count: 0
        },
        ruleForm: {},
        dialogFormVisible: false,
        searchVal: '',
        loading2: true,
        branch: '财务部',
        branchData: []
      }
    },
    methods: {
      search(value) {
        console.log(this.searchVal)
        this.handleCurrentChange(1)
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal,
          department_id: this.branch
        }, '/Incom/selectIncomByDepartmentId.action', '/Incom/hybridSelect.action')
      },
      getBranch() {
        $.ajax({
          type: 'post',
          url: '/department/selectAll.action',
          data: {
            limit: 100,
            page: 1
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.branchData = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      change(val) {
        this.notifyNoPath(val)
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        this.ruleForm = row
        this.dialogFormVisible = !this.dialogFormVisible
      },
      submit() {
        $.ajax({
          type: 'post',
          url: '/Incom/updateById.action',
          data: JSON.stringify(this.ruleForm),
          contentType: 'application/json; charset=UTF-8',
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.dialogFormVisible = false
              this.notifyNoPath(res.msg)
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
      this.getBranch()
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
