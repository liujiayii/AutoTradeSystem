<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
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
          <el-button v-if="scope.row.beOverdue!=1" size="mini" @click="updateStateRow(scope.$index, scope.row)">编辑
          </el-button>
          <el-dialog title="" :visible.sync="dialogFormVisible" width="400px">
            <el-form :model="row">
              <el-form-item label="分期状态" label-width="120px">
                <el-select v-model="row.beOverdue" placeholder="请选择分期状态">
                  <el-option label="还款中" :value="0" disabled></el-option>
                  <el-option label="已还款" :value="1"></el-option>
                  <el-option label="已逾期" :value="2"></el-option>
                </el-select>
              </el-form-item>
            </el-form>
            <div class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="updateState(scope.$index, scope.row)">确 定</el-button>
            </div>
          </el-dialog>
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
        ruleForm: {},
        tableData: {
          data: [],
          count: 0
        },
        loading2: true,
        dialogFormVisible: false,
        row: {}
      }
    },
    methods: {
      format(row, column) {
        return row.beOverdue === 0 ? '还款中' : row.beOverdue === 1 ? '已还款' : '逾期'
      },
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      updateStateRow(index, row) {
        this.dialogFormVisible = true
        console.log(row)
        console.log(index)
        this.row = row
      },
      updateState() {
        console.log(this.row)
        console.log(this.ruleForm.beOverdue)
        $.ajax({
          type: 'post',
          url: '/byStages/updateDetailsInstallments.action',
          contentType: "application/json",
          data: JSON.stringify(this.row),
          dataType: 'json',
          success: (res) => {
            this.dialogFormVisible = false
            window.location.reload()
            if (res.code == 1) {
              this.$notify({
                title: '成功',
                message: res.msg,
                type: 'success',
                position: 'bottom-right',
                offset: 300
              });
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
