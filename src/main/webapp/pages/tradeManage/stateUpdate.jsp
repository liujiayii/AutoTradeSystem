<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">分期管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id" type="hidden"></el-input>
      <el-form-item label="客户信息"></el-form-item>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="地址" prop="address">
            <el-input v-model="ruleForm.address" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </el-container>
</el-card>
<el-card shadow="hover">
  <el-container class="main" style="margin-top: 20px">
    <el-table v-loading="loading2"
              element-loading-text="拼命加载中"
              stripe
              size="small"
              element-loading-spinner="el-icon-loading"
              :data="tableData.data"
              style="width: 100%">
      <el-table-column label="还款日" prop="repaymentDate" :formatter="dateFormat" show-overflow-tooltip></el-table-column>
      <el-table-column label="当前期数" prop="nowStage" show-overflow-tooltip></el-table-column>
      <el-table-column label="当月还款" prop="byStages.monthlySupply" show-overflow-tooltip></el-table-column>
      <el-table-column label="还款状态" prop="beOverdue" :formatter="format" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
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
        navActive: '2-3',
        isCollapse: false,
        ruleForm: {},
        tableData: {
          data: [],
          count: 0
        },
        loading2: true
      }
    },
    methods: {
      format: function (row, column) {
        return row.beOverdue === 0 ? '还款中' : row.beOverdue === 1 ? '已还款' : '逾期'
      },
      //时间格式化
      dateFormat: function (row, column) {
        let date = new Date(row.repaymentDate);
        let y = date.getFullYear();
        let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return y + "-" + m + "-" + d;
      },
      // 获取地址栏参数，name:参数名称
      getHrefParam(key) {
        var s = window.location.href;
        var reg = new RegExp(key + "=\\w+");
        var rs = reg.exec(s);
        if (rs === null || rs === undefined) {
          return "";
        } else {
          return rs[0].split("=")[1];
        }
      },
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      getTable(page) {
        this.loading2 = true
        $.ajax({
          type: 'post',
          url: '/byStages/showDetailsByStages.action',
          data: {
            limit: 10,
            page: page,
            //id: this.ruleForm.id
            id: this.getHrefParam('id')
          },
          dataType: 'json',
          success: (res) => {
            console.log("分期详情：" + JSON.stringify(res))
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
    created() {
      if (this.getHrefParam('id')) {
        $.ajax({
          type: 'post',
          url: '/byStages/showBuyingCustomer.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.ruleForm = res.data
              this.getTable(1)
            }
          },
          error: (res) => {
            console.log(res)
          }
        })
      }
    }
  })
</script>
</html>