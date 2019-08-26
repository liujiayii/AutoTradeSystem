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
  <el-container class="main" style="width: 736px">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
      <el-col :span="12">
        <el-form-item label="采购人" prop="name">
          <el-input v-model="ruleForm.name" :disabled="Boolean(ruleForm.id)"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="总金额" prop="purchaseMoney">
          <el-input v-model="ruleForm.purchaseMoney" type="number" :disabled="Boolean(ruleForm.id)"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="采购时间" prop="createTime">
          <el-date-picker v-model="ruleForm.createTime" type="date" placeholder="选择日期"
                          :disabled="Boolean(ruleForm.id)"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="制单人" prop="singName">
          <el-input v-model="ruleForm.singName" :disabled="Boolean(ruleForm.id)"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="备注" prop="remark">
          <el-input v-model="ruleForm.remark"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="入库" prop="library">
          <el-select v-model="ruleForm.library" placeholder="请选择" :disabled="Boolean(ruleForm.id)">
            <el-option label="是" :value="0"></el-option>
            <el-option label="否" :value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-table :data="tableData" style="width: 100%" size="mini">
        <el-table-column prop="purchase" label="商品名称"></el-table-column>
        <el-table-column prop="type" label="型号"></el-table-column>
        <el-table-column prop="brand" label="品牌"></el-table-column>
        <el-table-column prop="commodityNumber" label="配件编号"></el-table-column>
        <el-table-column prop="quantity" label="采购数量"></el-table-column>
        <el-table-column prop="priace" label="单价"></el-table-column>
        <el-table-column v-if="!Boolean(ruleForm.id)">
          <template slot="header">
            <el-button @click="dialogFormVisible=true" size="small">新增采购</el-button>
          </template>
          <template slot-scope="scope">
            <el-button @click="handleDelete(scope.row)" type="danger" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-col :span="12">
        <el-button type="info" @click="submitForm('ruleForm')">确定</el-button>
        <el-button @click="goBack">返回</el-button>
      </el-col>
    </el-form>
    <el-dialog title="采购项目" :visible.sync="dialogFormVisible" @closed="form={}">
      <el-form :model="form" label-width="120px" inline>
        <el-form-item label="商品名称">
          <el-input v-model="form.purchase" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="型号">
          <el-input v-model="form.type" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="品牌">
          <el-input v-model="form.brand" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品编号">
          <el-input v-model="form.commodityNumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="采购数量">
          <el-input v-model="form.quantity" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="单价">
          <el-input v-model="form.priace" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addItem">确 定</el-button>
      </div>
    </el-dialog>
  </el-container>
</el-card>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin, rules],
    data: function () {
      return {
        navActive: '6-2',
        ruleForm: {
          name: '',
          singName: '',
          purchaseMoney: '',
          createTime: '',
          remark: ''
        },
        form: {},
        dialogFormVisible: false,
        tableData: []
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let cacheObj = {}, type = [], brand = [], purchase = [], commodityNumber = [], quantity = [], priace = []
            if (this.ruleForm.id) {
              cacheObj ={id: this.ruleForm.id, remark: this.ruleForm.remark}
            } else {
              for (let i = 0; i < this.tableData.length; i++) {
                type.push(this.tableData[i].type)
                brand.push(this.tableData[i].brand)
                purchase.push(this.tableData[i].purchase)
                commodityNumber.push(this.tableData[i].commodityNumber)
                quantity.push(this.tableData[i].quantity)
                priace.push(this.tableData[i].priace)
              }
              cacheObj = {
                ...this.ruleForm,
                type: type.join(','),
                brand: brand.join(','),
                purchase: purchase.join(','),
                commodityNumber: commodityNumber.join(','),
                quantity: quantity.join(','),
                priace: priace.join(','),
              }
            }
            $.ajax({
              type: 'post',
              url: this.ruleForm.id ? '/purchase/updatePurchaseById.action' : '/purchase/insertPurchase.action',
              data: cacheObj,
              traditional: true,
              dataType: 'json',
              success: (res) => {
                this.notifySuc(res.msg, 'inventoryManage.jsp')
              },
              error: (res) => {
                this.notifyError(res.msg)
              }
            })
          } else {
            return false;
          }
        })
      },
      addItem() {
        this.tableData = [...this.tableData, this.form]
        this.dialogFormVisible = false
      },
      handleDelete(index) {
        this.tableData.splice(index, 1)
      }
    },
    created() {
      if (this.getHrefParam('id')) {
        $.ajax({
          type: 'post',
          url: '/purchase/selectPurchaseById.action',
          data: {id: this.getHrefParam('id')},
          dataType: 'json',
          success: (res) => {
            this.ruleForm = res.data.purchases[0]
            this.tableData = res.data.purchases
            console.log(this.tableData)
          },
        })
      }
    }
  })
</script>
</html>
