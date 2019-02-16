<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">维修明细</div>
</el-container>

<el-tabs v-model="activeName" @tab-click="handleClick">
  <el-tab-pane label="工单明细" name="first">
    <el-card shadow="hover">
      <el-container class="main">
        <el-form :model="ruleForm" inline ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-row>
            <el-col :span="24">
              <el-form-item label="客户基本信息"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="内部工号" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="车型分类" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="工号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="分店店铺" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="进厂时间" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="业务员" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车辆号码" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="使用性质" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="VIN号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="内部编号" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车型" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="车名" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="机型" prop="phone">
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
          <el-form-item label="车身颜色" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="产品属性"></el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="运营单位" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="运营车队" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="联系人" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="联系电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="运营路别" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="首站" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="末站" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-row>
            <el-col :span="24">
              <el-form-item label="送检人员"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="送检人" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="手机" prop="phone">
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
              <el-form-item label="车辆信息"></el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="车辆备注" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="延误原因" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="维修进度"></el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="剩余油料" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="行驶里程" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="预约进厂日期" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="预约完工日期" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="维修类别" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="维修方式" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="修理定额" prop="phone">
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
  <el-tab-pane label="修理工单" name="second">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="项目名称" prop="name" show-overflow-tooltip></el-table-column>
          <el-table-column label="工种" prop="address" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计工时" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计工时单价" prop="brand" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计工时费" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际工时" prop="brand" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际工时单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际工时费" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="维修人员" prop="brand" show-overflow-tooltip></el-table-column>
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
  </el-tab-pane>
  <el-tab-pane label="材料明细" name="third">
    <el-card shadow="hover">
      <el-container class="main">
        <el-table v-loading="loading2"
                  element-loading-text="拼命加载中"
                  stripe
                  size="small"
                  element-loading-spinner="el-icon-loading"
                  :data="tableData.data"
                  style="width: 100%">
          <el-table-column label="商品编号" prop="name" show-overflow-tooltip></el-table-column>
          <el-table-column label="商品名称" prop="address" show-overflow-tooltip></el-table-column>
          <el-table-column label="车型" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计数量" prop="brand" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="预计金额" prop="brand" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际数量" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际单价" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="实际金额" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="质量" prop="vehicle_type" show-overflow-tooltip></el-table-column>
          <el-table-column label="原厂编号" prop="brand" show-overflow-tooltip></el-table-column>
        </el-table>
      </el-container>
    </el-card>
  </el-tab-pane>
</el-tabs>

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
        navActive: '8-1',
        activeName: 'first',
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
      //时间格式化
      dateFormat: function (row, column) {
        let date = new Date(row.create_time);
        let y = date.getFullYear();
        let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return y + "-" + m + "-" + d;
      },
      search(value) {
        console.log(this.searchVal)
        this.getTable(1)
      },
      handleEdit(index, row) {
        console.log(index, row);
        window.location.href='formEdit.jsp'
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
