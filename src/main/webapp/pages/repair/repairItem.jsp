<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<el-container class="secondNav">
  <div class="title" @click="isCollapse = !isCollapse">维修项目</div>
  <el-button class="btn" type="primary" icon="el-icon-plus" round @click="dialogFormVisibless = true">添加</el-button>
  <el-dialog title="项目编辑" :visible.sync="dialogFormVisibless" width="500px" @close="close">
    <el-form :model="ruleForm" label-width="100px" inline ref="ruleForm">
      <el-form-item label="项目分类">
        <el-autocomplete v-model="ruleForm.names" :fetch-suggestions="querySearch" placeholder="请输入内容"
                         @select="handleSelect"></el-autocomplete>
      </el-form-item>
      <el-form-item label="项目名称">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
        <el-button @click="dialogFormVisibless = false">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
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
      <el-table-column label="项目编号" prop="id" show-overflow-tooltip></el-table-column>
      <el-table-column label="项目分类" prop="names" show-overflow-tooltip></el-table-column>
      <el-table-column label="项目名称" prop="name" show-overflow-tooltip></el-table-column>
      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input v-model="searchVal" placeholder="输入关键词进行搜索" @input="search"/>
        </template>
        <template slot-scope="scope">
          <!--<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
          <el-button size="mini" @click="handleEdit1(scope.$index, scope.row)">工时</el-button>
          <el-button size="mini" @click="handleEdit2(scope.$index, scope.row)">材料</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="请选择工时" :visible.sync="dialogFormVisible" width="80%">
      <el-table v-loading="loading2"
                element-loading-text="拼命加载中"
                stripe
                size="small"
                element-loading-spinner="el-icon-loading"
                :data="diaTableData.carType"
                border
                style="width: 100%">
        <el-table-column label="车型\客户类型" prop="vehicle_classification" show-overflow-tooltip></el-table-column>
        <template v-for="(item,index) in diaTableData.custType">
          <el-table-column :label="'编号'+item.id+':'+item.type+'(工时/单价)'" show-overflow-tooltip>
            <template slot-scope="scope">
              <template v-for="(d,i) in diaTableData.data">
                <template v-if="item.id == d.maintenance_parts_id && scope.row.id==d.vehicle_classification_id">
                  <el-checkbox style="margin-right: 0" v-model="d.select"></el-checkbox>
                  <el-input style="width: 42%" size="mini" v-model="d.price" placeholder="单价"></el-input>
                  <el-input style="width: 42%" size="mini" v-model="d.houser" placeholder="工时"></el-input>
                </template>
                <template v-else>
                  <!--<el-checkbox style="margin-right: 0" v-model="d[parseInt(item.id)+parseInt(scope.row.id)]['select']"></el-checkbox>
                  <el-input style="width: 42%" size="mini" v-model="d[parseInt(item.id)+parseInt(scope.row.id)]['price']" placeholder="单价"></el-input>
                  <el-input style="width: 42%" size="mini" v-model="d[parseInt(item.id)+parseInt(scope.row.id)]['houser']" placeholder="工时"></el-input>-->
                </template>
              </template>
            </template>
          </el-table-column>
        </template>
      </el-table>
      <span slot="footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
       </span>
    </el-dialog>
    <el-dialog title="请选择材料" :visible.sync="dialogFormVisibles" width="500px">
      <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px">
        <el-form-item v-for="(item, index) in dynamicValidateForm.domains" :label="'材料' + (index + 1)" :key="item.key"
                      :prop="'domains.' + index + '.value'"
                      :rules="{ required: true, message: '材料不能为空', trigger: 'blur'}">
          <el-input v-model="item.value">
            <el-button slot="append" @click.prevent="removeDomain(item)">删除</el-button>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm2('dynamicValidateForm')">提交</el-button>
          <el-button @click="addDomain">新增材料</el-button>
          <el-button @click="resetForm('dynamicValidateForm')">重置</el-button>
        </el-form-item>
      </el-form>
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
        navActive: '8-2',
        activeName: 'first',
        tableData: {
          data: [],
          count: 0
        },
        diaTableData: {
          custType: [],
          carType: [],
          data: []
        },
        searchVal: '',
        loading2: true,
        ruleForm: {},
        dialogFormVisible: false,
        dialogFormVisibles: false,
        dialogFormVisibless: false,
        dynamicValidateForm: {
          domains: [{
            value: ''
          }]
        },
        restaurants: []
      }
    },
    methods: {
      close() {
        this.ruleForm = {}
      },
      save() {
        $.ajax({
          type: 'post',
          url: '/Project/Addrepair.action',
          data: JSON.stringify(this.diaTableData.data),
          contentType: 'application/json',
          dataType: 'json',
          success: (res) => {
            alert(res)
            if (res.code == 1) {
              this.notifyNoPath(res.msg)
              this.dialogFormVisible = false
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      con(e) {
        console.log(e)
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      removeDomain(item) {
        var index = this.dynamicValidateForm.domains.indexOf(item)
        if (index !== -1) {
          this.dynamicValidateForm.domains.splice(index, 1)
        }
      },
      addDomain() {
        this.dynamicValidateForm.domains.push({
          value: '',
          key: Date.now()
        });
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      search(value) {
        console.log(this.searchVal)
        this.handleCurrentChange(1)
      },
      handleEdit(index, row) {
        console.log(index, row)
        this.ruleForm = row
        this.dialogFormVisibless = true
      },
      handleEdit1(index, row) {
        console.log(index, row)
        $.ajax({
          type: 'post',
          url: '/Project/selcectByproject.action',
          data: {id: row.id},
          dataType: 'json',
          success: (res) => {
            console.log(res.data)
            if (res.code == 1) {
              for (let i = 0; i < this.diaTableData.carType.length * this.diaTableData.custType.length; i++) {
                for (let n = 0; n < res.data.length; n++) {
                  if (res.data[n].maintenance_parts_id == this.diaTableData.custType[i].id && res.data[n].vehicle_classification_id == this.diaTableData.carType[i].id) {

                  } else {
                    res.data.push({
                      maintenance_parts_id: this.diaTableData.custType[i].id,
                      vehicle_classification_id: this.diaTableData.carType[i].id,
                      price: 0,
                      houser: 0
                    })
                  }
                }
              }
              this.diaTableData.data = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
        //this.diaTableData.data.id = row.id
        console.log(this.diaTableData.data.id)
        this.dialogFormVisible = true
      },
      handleEdit2(index, row) {
        console.log(index, row)
        this.dialogFormVisibles = true
      },
      handleCurrentChange(page) {
        console.log(page)
        this.getTable({
          limit: 10,
          page,
          s: this.searchVal
        }, '/Project/selectAll.action', '/Project/selectAllbytype.action')
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/Project/insertAll.action' : '/Project/insertAll.action',
              data: this.ruleForm,
              dataType: 'json',
              success: (res) => {
                console.log(res)
                if (res.code == 1) {
                  this.dialogFormVisibless = false
                  this.notifyNoPath(res.msg)
                } else {
                  this.notifyError(res.msg)
                }
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      submitForm2(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(this.ruleForm)
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
      getCust() {
        $.ajax({
          type: 'post',
          url: '/Project/selectMaintenance.action',
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.diaTableData.custType = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      getCarType() {
        $.ajax({
          type: 'post',
          url: '/Project/selecttype.action',
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              this.diaTableData.carType = res.data
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      },
      querySearch(queryString, cb) {
        var restaurants = this.restaurants;
        var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (restaurant) => {
          return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      handleSelect(item) {
        console.log(item);
      },
      getLoad() {
        $.ajax({
          type: 'post',
          url: '/Project/selectAllByString.action',
          dataType: 'json',
          success: (res) => {
            console.log(res)
            if (res.code == 1) {
              let r = []
              for (let i = 0; i < res.data.length; i++) {
                r.push({'value': res.data[i].name})
              }
              console.log(r)
              this.restaurants = r;
            } else {
              this.notifyError(res.msg)
            }
          },
          error: (res) => {
            this.notifyError(res.msg)
          }
        })
      }
    },
    mounted() {
      this.handleCurrentChange(1)
      this.getCust()
      this.getCarType()
      this.getLoad()
    }
  })
</script>
</html>
