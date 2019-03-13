<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->
<el-container class="secondNav">
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item><a href="/views/index/index.jsp">首页</a></el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.first}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{breadcrumb.second}}</el-breadcrumb-item>
  </el-breadcrumb>
  <el-button type="info" id="printBtn">打印</el-button>
</el-container>
<template v-if="type=='data'">
  <el-card shadow="hover">
    <div style="width: 1000px;border: 1px #000 solid;margin: 0 auto" class="print-box">
      <div style="display: flex;flex-direction: column;justify-content: center;padding: 10px">
        <p style="text-align:center;font-family:宋体; font-size:18pt; font-weight:bold; text-decoration:underline">
          喔驰汽贸汽修领料单</p>
        <p style="font-family:宋体; font-size:12pt;">
          <span style="font-weight:bold">客户名称：</span>{{tableData.name}}
          <span style="font-weight:bold"> 打印日期：</span>{{tableData.printDate}}
        </p>
        <table cellspacing="0" cellpadding="0" border="1"
               style="border-collapse:collapse;font-family:宋体; font-size:10.5pt;width: 100%;">
          <tr style="height:38.05pt; font-weight:bold; text-align:center;vertical-align:middle">
            <td>商品名称</td>
            <td>型号</td>
            <td>数量</td>
            <td>单价</td>
            <td>总额</td>
          </tr>
          <template v-for="(item,index) in tableData.materials">
            <tr style="height:17.9pt; vertical-align:middle;text-align:center">
              <td>{{item.name}}</td>
              <td>{{item.model}}</td>
              <td>{{item.number}}</td>
              <td>{{item.price}}</td>
              <td>{{item.money}}</td>
            </tr>
          </template>
          <tr style="height:37.2pt">
            <td colspan="10">
              <span style="font-weight:bold; ">本页合计：</span>
              <span>{{tableData.length}}项  {{tableData.ChineseChar}}</span>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </el-card>
</template>
<template v-if="type=='balance'">
  <el-card shadow="hover">
    <div style="width: 1000px;border: 1px #000 solid;margin: 0 auto" class="print-box">
      <div style="display: flex;flex-direction: column;justify-content: center;padding: 10px">
        <p style="text-align:center;font-family:宋体; font-size:18pt; font-weight:bold">结算单</p>
        <table cellspacing="0" cellpadding="0" border="1"
               style="border-collapse:collapse;text-align:center;font-size:10.5pt;vertical-align:middle;width: 100%">
          <tr style="height:24pt;font-family:宋体;font-weight: bold">
            <td colspan="10">单号</td>
            <td colspan="7">页码</td>
            <td colspan="9">打印时间</td>
            <td colspan="4">客服代表</td>
          </tr>
          <tr style="height:24pt">
            <td colspan="10">{{tableData.order_number}}</td>
            <td colspan="7">第1页</td>
            <td colspan="9">{{tableData.nowDate}}</td>
            <td colspan="4"></td>
          </tr>
          <tr style="height:28pt;font-weight: bold">
            <td colspan="10">客户信息</td>
            <td colspan="20">车辆信息</td>
          </tr>
          <tr style="height:24pt">
            <td colspan="10">姓名：{{tableData.customer_name}}</td>
            <td colspan="6">车型：{{tableData.range_rover}}</td>
            <td colspan="14">VIN码：{{tableData.vin}}</td>
          </tr>
          <tr style="height:24pt">
            <td colspan="10">地址：{{tableData.address}}</td>
            <td colspan="6">车牌：{{tableData.vehicle_number}}</td>
            <td colspan="14">发动机号：{{tableData.engine_number}}</td>
          </tr>
          <tr style="height:24pt">
            <td colspan="10">电话：{{tableData.move_number}}</td>
            <td colspan="6">颜色：{{tableData.color}}</td>
            <td colspan="7">行驶里程：{{tableData.road_haul}}</td>
            <td colspan="7">存</td>
          </tr>
          <tr style="height:24pt">
            <td colspan="15">预约时间：{{tableData.appo_date}}</td>
            <td colspan="15">完工时间：{{tableData.sColse_date}}</td>
          </tr>
          <tr style="height:24pt;font-weight: bold">
            <td colspan="30">维修明细</td>
          </tr>
          <tr style="height:24pt;font-weight: bold">
            <td colspan="2">序号</td>
            <td colspan="10">维修内容</td>
            <td colspan="6">工时</td>
            <td colspan="3">工时费</td>
            <td colspan="4">状态</td>
            <td colspan="5">备注</td>
          </tr>
          <template v-for="(item,index) in tableData.billProject">
            <tr style="height:28.35pt">
              <td colspan="2">{{item.id}}</td>
              <td colspan="10">{{item.name}}</td>
              <td colspan="6">{{item.working_hours}}</td>
              <td colspan="3">{{item.money}}</td>
              <td colspan="4">正常</td>
              <td colspan="5"></td>
            </tr>
          </template>
          <tr style="height:24pt;font-weight: bold">
            <td colspan="2">序号</td>
            <td colspan="10">配件名称</td>
            <td colspan="3">数量</td>
            <td colspan="3">单价</td>
            <td colspan="3">零件费</td>
            <td colspan="4">状态</td>
            <td colspan="5">备注</td>
          </tr>
          <template v-for="(item,index) in tableData.billParts">
            <tr style="height:28.35pt">
              <td colspan="2">{{item.id}}</td>
              <td colspan="10">{{item.name}}</td>
              <td colspan="3">{{item.number}}</td>
              <td colspan="3">{{item.price}}</td>
              <td colspan="3">{{item.money}}</td>
              <td colspan="4">正常</td>
              <td colspan="5"></td>
            </tr>
          </template>
          <tr style="height:24pt">
            <td rowspan="2" colspan="2" style="font-weight: bold">维修费用</td>
            <td colspan="3" style="font-weight: bold">工时费用：</td>
            <td colspan="6">{{tableData.hour_cost}}</td>
            <td rowspan="2" style="font-weight: bold">实收费用</td>
            <td colspan="6" style="font-weight: bold">总计：</td>
            <td colspan="3">{{tableData.count_money}}</td>
            <td colspan="5" style="font-weight: bold">服务代表签字</td>
            <td colspan="4" style="font-weight: bold">客户签字</td>
          </tr>
          <tr style="height:24pt">
            <td style="font-weight: bold" colspan="3">零件费用：</td>
            <td colspan="6">{{tableData.materials}}</td>
            <td style="font-weight: bold" colspan="6">实收：</td>
            <td colspan="3">{{tableData.money}}</td>
            <td rowspan="2" colspan="5"></td>
            <td rowspan="2" colspan="4"></td>
          </tr>
          <tr style="height:24pt">
            <td colspan="13"></td>
            <td style="font-weight: bold" colspan="3">结算方式</td>
            <td style="font-weight: bold" colspan="3">{{tableData.type}}</td>
          </tr>
          <tr style="height:24pt">
            <td style="font-weight: bold" colspan="5">协议单位名称：</td>
            <td colspan="11">{{tableData.company}}</td>
            <td style="font-weight: bold" colspan="2">备注：</td>
            <td colspan="12">{{tableData.remark}}</td>
          </tr>
        </table>
        <div style="display: flex;justify-content: space-between">
          <p>一式三联：客户、客户服务代表、财务各一联</p>
          <p style="padding-right: 50pt"> 操作员：</p>
        </div>
      </div>
    </div>
  </el-card>
</template>
<%@ include file="../layout/footer.jsp" %>
<script src="//lib.baomitu.com/PrintArea/2.4.1/jquery.PrintArea.min.js"></script>
<script>
  //打印
  $(document).ready(function () {
    $("#printBtn").click(function () {
      $(".print-box").printArea()
    })
  })
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '8-1',
        tableData: {},
        type: this.getHrefParam('type')
      }
    },
    methods: {},
    created() {
      $.ajax({
        type: 'post',
        url: this.type == 'data' ? '/carRecord/printMaterials.action' : '/bill/creatBill.action',
        data: this.type == 'data' ? {id: this.getHrefParam('id')} : {repair_id: this.getHrefParam('id')},
        dataType: 'json',
        success: (res) => {
          if (res.code == 1) {
            this.tableData = res.data
            this.tableData.nowDate = (new Date()).toLocaleString()
          } else {
            this.notifyError(res.msg)
          }
        },
        error: (res) => {
          this.notifyError(res.msg)
        }
      })
    }
  })
</script>
</html>
