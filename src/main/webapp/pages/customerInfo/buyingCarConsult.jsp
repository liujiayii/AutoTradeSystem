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
             onclick="window.location.href='buyingCarConsultEdit.jsp'">添加
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
      <el-table-column label="车型" prop="intention" show-overflow-tooltip></el-table-column>
      <el-table-column label="预算" prop="budget" show-overflow-tooltip></el-table-column>
      <el-table-column label="创建时间" prop="createTime" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
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
        navActive: '1-2',
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
        window.location.href = 'buyingCarConsultEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/selectAllBuyingCustomer.action', '/selectByBuyingCustomer.action')
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
