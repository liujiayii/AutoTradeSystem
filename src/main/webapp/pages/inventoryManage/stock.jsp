<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">库存详情</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round
             onclick="window.location.href='stockEdit.jsp'">添加
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

      <el-table-column label="商品编号" prop="commodity_number" show-overflow-tooltip></el-table-column>
      <el-table-column label="商品名称" prop="purchase" show-overflow-tooltip></el-table-column>
      <el-table-column label="型号" prop="type" show-overflow-tooltip></el-table-column>
      <el-table-column label="品牌" prop="brand" show-overflow-tooltip></el-table-column>
       <el-table-column label="数量" prop="number" show-overflow-tooltip></el-table-column>
     
   
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
        navActive: '6-1',
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
        window.location.href = 'stockEdit.jsp?id=' + row.id
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          searchKeyWords: this.searchVal
        }, '/stock/selectStock.action', '/stock/selectStock.action')
      }
    },
    created() {
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
