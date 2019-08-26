<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.third}}</el-breadcrumb-item>
  </el-breadcrumb>
</el-container>
<el-card shadow="hover">
  <el-container class="main">
    <el-table
      v-loading="loading2"
      element-loading-text="拼命加载中"
      stripe
      size="small"
      element-loading-spinner="el-icon-loading"
      :data="tableData.data"
      style="width: 100%">
      <el-table-column label="商品编号" prop="commodity_number" show-overflow-tooltip></el-table-column>
      <el-table-column label="商品名称" prop="purchase" show-overflow-tooltip></el-table-column>
      <el-table-column label="型号" prop="type" show-overflow-tooltip></el-table-column>
      <el-table-column label="品牌" prop="brand" show-overflow-tooltip></el-table-column>
      <el-table-column label="数量" prop="number" show-overflow-tooltip></el-table-column>
    </el-table>
  </el-container>
</el-card>
<el-container class="page-box">
  <div class="block">
    <el-pagination @current-change="handleCurrentChange" layout="total,prev, pager, next, jumper"
                   :total="tableData.count"></el-pagination>
  </div>
</el-container>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '6-3',
        tableData: {
          data: [],
          count: 0
        },
        loading2: true,
        searchVal: ''
      }
    },
    methods: {
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page
        }, '/stock/inventoryWarning.action', '/stock/inventoryWarning.action')
      }
    },
    mounted() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
