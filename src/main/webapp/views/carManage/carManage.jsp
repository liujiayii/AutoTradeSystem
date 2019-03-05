<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button class="btn" type="info" icon="el-icon-plus" round
             onclick="window.location.href='carManageEdit.jsp'">添加
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
      <el-table-column label="车型" prop="vehicle_type" show-overflow-tooltip></el-table-column>
      <el-table-column label="车牌" prop="brand" show-overflow-tooltip></el-table-column>
      <el-table-column label="进价（元）" prop="selling_price" show-overflow-tooltip></el-table-column>
      <el-table-column label="颜色" prop="color" show-overflow-tooltip></el-table-column>
      <el-table-column label="进店时间" prop="create_time" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
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
        navActive: '4-1',
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
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        window.location.href = 'carManageEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/Vehichle/selectAll.action', '/Vehichle/hybridSelect.action')
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
