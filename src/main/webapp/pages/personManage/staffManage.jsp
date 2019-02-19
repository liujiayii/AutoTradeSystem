<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">员工管理</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round
             onclick="window.location.href='staffEdit.jsp'">添加
  </el-button>
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
      <el-table-column label="姓名" prop="name" show-overflow-tooltip></el-table-column>
      <el-table-column label="电话" prop="phone" show-overflow-tooltip></el-table-column>
      <el-table-column label="地址" prop="address" show-overflow-tooltip></el-table-column>
      <el-table-column label="部门" prop="postId" show-overflow-tooltip></el-table-column>
      <el-table-column label="职位" prop="departmentId" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
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
        navActive: '7-1',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true
      }
    },
    methods: {
      search(value) {
        console.log(this.searchVal)
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'staffEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/staff/selectAll.action', '/staff/hybridSelect.action')
      }
    },
    mounted() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
