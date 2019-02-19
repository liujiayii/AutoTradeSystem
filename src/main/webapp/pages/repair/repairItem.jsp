<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">维修项目</div>
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
              <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">工时</el-button>
              <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-container>
    </el-card>
  </el-tab-pane>
  <el-tab-pane label="项目明细" name="second">
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
                      style="width: 100%"
                      @cell-click="cellEdit">
              <el-table-column label="分类编号" prop="name" show-overflow-tooltip></el-table-column>
              <el-table-column label="维修车型分类" prop="address" show-overflow-tooltip></el-table-column>
              <el-table-column label="工时1" prop="vehicle_type" show-overflow-tooltip>
                <template slot-scope="scope">
                  <el-input v-if="showEdit.id==scope.row.id && showEdit.col==scope.column.label" size="mini"
                            v-model="tableData.data[scope.$index].vehicle_type" @blur="handOut"></el-input>
                  <span v-else>{{tableData.data[scope.$index].vehicle_type}}</span>
                </template>
              </el-table-column>
              <el-table-column label="工时1单价" prop="vehicle_type" show-overflow-tooltip>
                <template slot-scope="scope">
                  <el-input v-if="showEdit.id==scope.row.id && showEdit.col==scope.column.label" size="mini"
                            v-model="tableData.data[scope.$index].vehicle_type" @blur="handOut"></el-input>
                  <span v-else>{{tableData.data[scope.$index].vehicle_type}}</span>
                </template>
              </el-table-column>
              <el-table-column label="工时2" prop="vehicle_type" show-overflow-tooltip>
                <template slot-scope="scope">
                  <el-input v-if="showEdit.id==scope.row.id && showEdit.col==scope.column.label" size="mini"
                            v-model="tableData.data[scope.$index].vehicle_type" @blur="handOut"></el-input>
                  <span v-else>{{tableData.data[scope.$index].vehicle_type}}</span>
                </template>
              </el-table-column>
              <el-table-column label="工时2单价" prop="vehicle_type" show-overflow-tooltip>
                <template slot-scope="scope">
                  <el-input v-if="showEdit.id==scope.row.id && showEdit.col==scope.column.label" size="mini"
                            v-model="tableData.data[scope.$index].vehicle_type" @blur="handOut"></el-input>
                  <span v-else>{{tableData.data[scope.$index].vehicle_type}}</span>
                </template>
              </el-table-column>
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
        navActive: '8-4',
        activeName: 'second',
        tableData: {
          data: [],
          count: 0
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        showEdit: {
          id: '',
          col: ''
        }
      }
    },
    methods: {
      handOut(){
        this.showEdit.id = ''
        this.showEdit.col =''
      },
      cellEdit(row, column, cell, event) {
        this.showEdit.id = row.id
        this.showEdit.col = column.label
        console.log(row, column)
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      search(value) {
        console.log(this.searchVal)
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'formEdit.jsp'
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/selectAllSellingCustomer.action', '/selectByCustomer.action')
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
      this.handleCurrentChange(1)
    }
  })
</script>
</html>
