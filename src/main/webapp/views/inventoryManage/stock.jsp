<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
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
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row,'yes')">领料</el-button>
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row,'no')">退料</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog :title="form.type=='yes' ? '领料' : '退料'" :visible.sync="dialogFormVisible" width="500px"
               @close="closeDia">
      <el-form :model="form" label-width="120px" ref="form">
        <el-form-item label="数量:" prop="number" :rules="[{ required: true, message: '数量不能为空'}]">
          <el-input v-model="form.number" type="number"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="info" @click="save('form')">确 定</el-button>
      </div>
    </el-dialog>
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
        loading2: true,
        dialogFormVisible: false,
        form: {
          type: '',
          number: '',
          num: '',
          commodity_number: ''
        }
      }
    },
    methods: {
      closeDia() {
        this.form = {type: '', number: '', num: '', commodity_number: ''}
      },
      save(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.form.number > this.form.num && this.form.type == 'yes'){
              this.notifyError('领料大于库存')
            }else {
              $.ajax({
                              type: 'post',
                              url: '/stock/updateByPrimaryKey.action',
                              data: JSON.stringify(this.form),
                              dataType: 'json',
                              contentType: "application/json",
                              success: (res) => {
                                if (res.code == 1) {
                                  this.dialogFormVisible = false
                                  this.handleCurrentChange(1)
                                  this.notifyNoPath(res.msg)
                                } else {
                                  this.notifyError(res.msg)
                                }
                              },
                              error: (res) => {
                                this.notifyError(res.msg)
                              }
                            })
            }
          } else {
            return false;
          }
        })
      },
      search(value) {
        this.handleCurrentChange(1)
      },
      handleEdit(index, row, type) {
        this.dialogFormVisible = true
        this.form.type = type
        this.form.num = row.number
        this.form.commodity_number = row.commodity_number
      },
      handleCurrentChange(page) {
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
