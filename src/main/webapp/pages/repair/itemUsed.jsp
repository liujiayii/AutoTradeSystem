<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">项目用料</div>
</el-container>
<el-tabs v-model="activeName" @tab-click="handleClick">
  <el-tab-pane label="项目分类" name="first">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="项目分类" prop="name" show-overflow-tooltip></el-table-column>
          <el-table-column label="项目编号" prop="address" show-overflow-tooltip></el-table-column>
          <el-table-column label="项目名称" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="工种" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="编辑" align="right">
            <template slot-scope="scope">
              <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-container>
    </el-card>
  </el-tab-pane>
  <el-tab-pane label="用料明细" name="second">
    <el-card shadow="hover">
      <el-container class="main">
        <el-row>
          <el-col :span="24">
            <el-form :model="ruleForm" ref="ruleForm" inline label-width="130px" class="demo-ruleForm">
              <el-form-item label="项目分类">
                <el-input v-model="ruleForm.type"></el-input>
              </el-form-item>
              <el-form-item label="项目编号">
                <el-input v-model="ruleForm.type"></el-input>
              </el-form-item>
              <el-form-item label="项目名称">
                <el-input v-model="ruleForm.type"></el-input>
              </el-form-item>
              <el-form-item label="工种">
                <el-input v-model="ruleForm.type"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="24">
            <el-table v-loading="loading2"
                      element-loading-text="拼命加载中"
                      stripe
                      size="small"
                      element-loading-spinner="el-icon-loading"
                      :data="tableData.data"
                      style="width: 100%">
              <el-table-column label="分类编号" prop="name" show-overflow-tooltip></el-table-column>
              <el-table-column label="维修车型分类" prop="address" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时1" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时1单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时2" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时2单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时3" prop="vehicle_type" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时3单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
            </el-table>
          </el-col>
        </el-row>
      </el-container>
    </el-card>
  </el-tab-pane>
</el-tabs>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '8-5',
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
