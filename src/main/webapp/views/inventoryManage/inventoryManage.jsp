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
             onclick="window.location.href='inventoryEdit.jsp'">添加
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

      <el-table-column label="采购人" prop="name" show-overflow-tooltip></el-table-column>
      <el-table-column label="采购项目" prop="purchase" show-overflow-tooltip></el-table-column>
      <el-table-column label="类型" prop="type" show-overflow-tooltip></el-table-column>
      <el-table-column label="总金额" prop="purchaseMoney" show-overflow-tooltip></el-table-column>
      <el-table-column label="采购时间" prop="createTime" :formatter="dateFormat" show-overflow-tooltip></el-table-column>

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
        navActive: '6-2',
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
        window.location.href = 'inventoryEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        this.getTable({
          limit: 10,
          page,
          searchKeyWords: this.searchVal
        }, '/purchase/showAllPurchase.action', '/purchase/searchPurchase.action')
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
