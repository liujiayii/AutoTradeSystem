<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">部门管理</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round @click="dialogFormVisible = true">添加</el-button>
  <el-dialog title="添加部门" :visible.sync="dialogFormVisible">
    <el-form :model="form">
      <el-form-item label="活动名称" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="insert">确 定</el-button>
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
        navActive: '5-3',
        isCollapse: false,
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
      //时间格式化
      dateFormat: function (row, column) {
        let date = new Date(row.create_time);
        let y = date.getFullYear();
        let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return y + "-" + m + "-" + d;
      },
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
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
            console.log(res)
            this.getTable(1)
            this.$notify({
              title: '成功',
              message: res.msg,
              type: 'success'
            });
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
      },
      handleEdit(index, row) {
        console.log(index, row);
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
              console.log(res)
              this.getTable(1)
              this.$notify({
                title: '成功',
                message: res.msg,
                type: 'success'
              });
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
        }).catch(() => {
          this.$notify.info({
            title: '消息',
            message: '已取消'
          });
        });
      },
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      getTable(page) {
        this.loading2 = true
        $.ajax({
          type: 'post',
          url: this.searchVal.length == 0 ? '/department/selectAll.action' : '',
          data: {
            limit: 10,
            page: page,
            s: this.searchVal
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              if (res.data != 'null') {
                this.tableData.data = res.data
              } else {
                this.tableData.data = []
                this.$notify.error({
                  title: '警告',
                  message: res.msg,
                  position: 'bottom-right',
                  offset: 300
                })
              }
              this.tableData.count = res.count
              this.loading2 = false
            } else {
              console.log('aa')
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
    mounted() {
      this.getTable(1)
    }
  })
</script>
</html>
