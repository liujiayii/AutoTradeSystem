<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">员工管理</div>
</el-container>
<el-card shadow="hover">
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-input v-model="ruleForm.id"></el-input>
      <el-row>
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="职位" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="密码" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</el-card>

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
        navActive: '7-1',
        isCollapse: false,
        tableData: {
          data: [],
          count: 0
        },
        ruleForm:{},
        searchVal: '',
        loading2: true
      }
    },
    methods: {
      //时间格式化
      dateFormat: function (row, column) {
        let date = new Date(row.create_time);
        let y = date.getFullYear();
        let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : datetime.getMonth() + 1;
        let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return y + "-" + m + "-" + d;
      },
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href = 'carResourcesEdit.jsp?id=' + row.id
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
              this.tableData.data = res.data
              this.tableData.count = res.count
              this.loading2 = false
            } else {
              console.log('aa')
              this.$alert(res.msg, '提示', {
                type: 'error',
                confirmButtonText: '确定'
              });
            }
          },
          error: (res) => {
            this.$alert(res.msg, '提示', {
              type: 'error',
              confirmButtonText: '确定'
            });
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
