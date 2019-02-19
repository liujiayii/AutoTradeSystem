<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">车辆档案</div>
</el-container>

<el-tabs v-model="activeName" @tab-click="handleClick">
  <el-tab-pane label="客户档案" name="first">
    <el-card shadow="hover">
      <el-container class="main">
        <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col :span="24">
              <el-form-item label="基本信息"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="客户编号" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="类型" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="区域" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="客户名称" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮编" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="省份" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="地区" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="地址" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="手机" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="传真" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-container>
    </el-card>
  </el-tab-pane>
  <el-tab-pane label="添加信息" name="second">
    <el-card shadow="hover">
      <el-container class="main">
        <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col :span="24">
              <el-form-item label="车辆信息"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="车辆号码" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="来源" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="性质" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车型" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车名" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="厂牌" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="发动机号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="底盘号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="变速箱号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="类别" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="机型" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="VIN号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="内部编号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车身颜色" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车型分类" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="车主信息"></el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="车主名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="地址" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="邮编" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="联系电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="驾驶人员"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="驾驶员" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="手机" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="副驾驶员" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="驾驶证号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="保险归属"></el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="三包单位" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="经销商" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="车辆备注" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
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
