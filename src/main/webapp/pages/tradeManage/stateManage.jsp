<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">分期管理</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round
             onclick="window.location.href='stateEdit.jsp'">添加
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
      <el-table-column label="姓名" prop="buyingCustomer.name" show-overflow-tooltip></el-table-column>
      <el-table-column label="电话" prop="buyingCustomer.phone" show-overflow-tooltip></el-table-column>
      <el-table-column label="地址" prop="buyingCustomer.address" show-overflow-tooltip></el-table-column>
      <el-table-column label="总期数" prop="totalPeriod" show-overflow-tooltip></el-table-column>
      <el-table-column label="每期还款金额" prop="monthlySupply" show-overflow-tooltip></el-table-column>
      <el-table-column label="状态" prop="type" :formatter="typeFormat" show-overflow-tooltip></el-table-column>
      <el-table-column label="创建时间" prop="createTime" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入姓名或电话进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" @click="handleState(scope.$index, scope.row)">分期</el-button>
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
<el-footer>{{footer}}</el-footer>
</el-container>
</el-container>
</el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '2-3',
        tableData: {
          data: [],
          count: 0
        },
        dialogFormVisible: false,
        searchVal: '',
        loading2: true
      }
    },
    methods: {
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
      },
      typeFormat(row, column, cellValue, index) {
        return cellValue == 0 ? '还款中' : cellValue == 1 ? '已还款' : '已逾期'
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'stateEdit.jsp?id=' + row.id
      },
      handleState(index, row) {
        console.log(index, row);
        window.location.href = 'stateUpdate.jsp?id=' + row.id
      },
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      getTable(page) {
        this.loading2 = true
        $.ajax({
          type: 'post',
          url: this.searchVal.length == 0 ? '/byStages/showByStages.action' : '/byStages/searchByStages.action',
          data: {
            limit: 10,
            page: page,
            searchField: this.searchVal
          },
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.tableData.data = res.data
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
