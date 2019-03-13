<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round @click="dialogFormVisible = true">添加</el-button>
  <el-dialog title="添加部门" :visible.sync="dialogFormVisible" width="500px" @close="closeForm">
    <el-form :model="form">
      <el-form-item label="部门名称" :label-width="formLabelWidth"
                    :rules="[{required: true, message: '请输入部门名称', trigger: 'blur'}]">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="info" @click="insert">确 定</el-button>
    </div>
  </el-dialog>
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
      <el-table-column label="部门id" prop="id" show-overflow-tooltip></el-table-column>
      <el-table-column label="部门名称" prop="department" show-overflow-tooltip></el-table-column>
      <el-table-column label="创建时间" prop="create_time" show-overflow-tooltip :formatter="dateFormat"></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search" disabled/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="handleEdit(scope.$index, scope.row)">删除</el-button>
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

<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '5-1',
        tableData: {
          data: [],
          count: 0
        },
        form: {
          name: ''
        },
        searchVal: '',
        loading2: true,
        dialogFormVisible: false,
        formLabelWidth: '120px'
      }
    },
    methods: {
      closeForm() {
        this.form = {name: ''}
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      insert() {
        this.dialogFormVisible = false
        $.ajax({
          type: 'post',
          url: '/department/insertDepartment.action',
          data: {
            department: this.form.name
          },
          dataType: 'json',
          success: (res) => {
            if (res.code == 1) {
              this.handleCurrentChange(this.page)
              this.notifyNoPath(res.msg)
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      handleEdit(index, row) {
        this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          $.ajax({
            type: 'post',
            url: '/department/deleteById.action',
            data: {
              id: row.id
            },
            dataType: 'json',
            success: (res) => {
              if (res.code == 1) {
                this.handleCurrentChange(this.page)
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
          this.$notify.info({
            title: '提示',
            message: '已取消'
          });
        });
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/department/selectAll.action', '')
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
