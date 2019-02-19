<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">维修账单</div>
</el-container>
<el-card shadow="hover">
  <div slot="header"><span>账单明细</span></div>
  <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px">
    <el-form-item label="工单号" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="车牌号" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="车主姓名" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="结算日期" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="分店" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
    <el-form-item label="对方单位" prop="phone">
      <el-input v-model="ruleForm.phone"></el-input>
    </el-form-item>
  </el-form>
</el-card>
<el-card style="margin: 20px 0" shadow="hover">
  <div slot="header"><span>工时费明细</span></div>
  <el-table v-loading="loading2"
            element-loading-text="拼命加载中"
            stripe
            size="small"
            element-loading-spinner="el-icon-loading"
            :data="tableData.data"
            style="width: 100%">
    <el-table-column label="项目编号" prop="name" show-overflow-tooltip></el-table-column>
    <el-table-column label="项目名称" prop="address" show-overflow-tooltip></el-table-column>
    <el-table-column label="工种" prop="vehicle_type" show-overflow-tooltip></el-table-column>
    <el-table-column label="工时" prop="brand" show-overflow-tooltip></el-table-column>
    <el-table-column label="工时费" prop="vehicle_type" show-overflow-tooltip></el-table-column>
    <el-table-column label="实际工时" prop="brand" show-overflow-tooltip></el-table-column>
    <el-table-column label="实际工时费" prop="vehicle_type" show-overflow-tooltip></el-table-column>
    <el-table-column label="查看详情">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
      </template>
    </el-table-column>
  </el-table>
</el-card>
<el-card shadow="hover">
  <div slot="header"><span>材料费明细</span></div>
  <el-table v-loading="loading2"
            element-loading-text="拼命加载中"
            stripe
            size="small"
            element-loading-spinner="el-icon-loading"
            :data="tableData.data"
            style="width: 100%">
    <el-table-column label="零件编号" prop="name" show-overflow-tooltip></el-table-column>
    <el-table-column label="零件名称" prop="address" show-overflow-tooltip></el-table-column>
    <el-table-column label="单位" prop="vehicle_type" show-overflow-tooltip></el-table-column>
    <el-table-column label="数量" prop="brand" show-overflow-tooltip></el-table-column>
    <el-table-column label="单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
    <el-table-column label="金额" prop="brand" show-overflow-tooltip></el-table-column>
    <el-table-column label="查看详情">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
      </template>
    </el-table-column>
  </el-table>
</el-card>

<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '8-2',
        activeName: 'second',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {}
      }
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'formEdit.jsp'
      },
      handleCurrentChange(val) {
        this.getTable(val)
        console.log(val)
      },
      getTable(page) {
        this.loading2 = true
        $.ajax({
          type: 'post',
          url: this.searchVal.length == 0 ? '/selectAllSellingCustomer.action' : '/selectByCustomer.action',
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
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
          } else {
            console.log('error submit!!');
            return false;
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
