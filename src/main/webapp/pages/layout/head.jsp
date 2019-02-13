<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>喔驰后台管理系统</title>
  <!-- import CSS -->
  <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
  <link rel="stylesheet" href="/static/css/pages.css">
  <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
  <!-- import Vue before Element -->
  <script src="https://unpkg.com/vue/dist/vue.js"></script>
  <!-- import JavaScript -->
  <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="app" v-cloak>
  <el-container style="height: 100%">
    <el-header class="head">
      <div>喔驰后台管理系统</div>
      <a href="/logout.action"><img src="/static/images/close.png"/></a>
    </el-header>
    <el-container>
      <el-aside style="width: auto">
        <el-menu
                :default-active="navActive"
                class="el-menu-vertical-demo"
                :collapse="isCollapse"
                unique-opened>
          <el-submenu index="1">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/1.png"></i>
              <span>客户信息</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/customerInfo/carResources.jsp">
                <el-menu-item index="1-1">车辆资源</el-menu-item>
              </a>
              <a href="/pages/customerInfo/buyingCarConsult.jsp">
                <el-menu-item index="1-2">买车咨询</el-menu-item>
              </a>
              <a href="/pages/customerInfo/replaceCar.jsp">
                <el-menu-item index="1-3">置换车辆
                </el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/2.png"></i>
              <span slot="title">交易管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/tradeManage/evaluation.jsp">
                <el-menu-item index="2-1">评估审核</el-menu-item>
              </a>
              <a href="/pages/tradeManage/insurance.jsp">
                <el-menu-item index="2-2">保险凭证</el-menu-item>
              </a>
              <a href="/pages/tradeManage/stateManage.jsp">
                <el-menu-item index="2-3">分期管理</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/3.png"></i>
              <span slot="title">售车管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/carSales/booking.jsp">
                <el-menu-item index="3-1">订车管理</el-menu-item>
              </a>

              <a href="/pages/carSales/carSales.jsp">
                <el-menu-item index="3-2">售车管理</el-menu-item>
              </a>

              <a href="/pages/carSales/carSales.jsp">
                <el-menu-item index="3-3">退车管理</el-menu-item>
              </a>

            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/4.png"></i>
              <span slot="title">车辆管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/carManage/carManage.jsp">
                <el-menu-item index="4-1">车辆管理</el-menu-item>
              </a>
              <a href="/pages/carManage/carinformation.jsp">
                <el-menu-item index="4-2">车辆信息</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/5.png"></i>
              <span slot="title">财务管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/financialManage/income.jsp">
                <el-menu-item index="5-1">收入管理</el-menu-item>
              </a>
              <a href="/pages/financialManage/expend.jsp">
                <el-menu-item index="5-2">支出管理</el-menu-item>
              </a>
              <a href="/pages/financialManage/branch.jsp">
                <el-menu-item index="5-3">部门管理</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="6">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/6.png"></i>
              <span slot="title">库存管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/inventoryManage/inventoryManage.jsp">
                <el-menu-item index="6-1">汽车配件</el-menu-item>
              </a>
              <a href="/pages/inventoryManage/inventoryManage.jsp">
                <el-menu-item index="6-2">其他</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="7">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/7.png"></i>
              <span slot="title">公司管理</span>
            </template>
            <el-menu-item-group>
              <!-- <a href="/pages/personManage/staffManage.jsp">
                     <el-menu-item index="7-1">公司管理</el-menu-item>
                 </a> -->
              <a href="/pages/personManage/staffManage.jsp">
                <el-menu-item index="7-1">员工管理</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="7-2">权限管理</el-menu-item>
              </a>

            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="8">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/7.png"></i>
              <span slot="title">维修管理</span>
            </template>
            <el-menu-item-group>
              <a href="/pages/repair/form.jsp">
                <el-menu-item index="8-1">维修工单</el-menu-item>
              </a>

              <a href="/pages/personManage/staffManage.jsp">
                <el-menu-item index="8-2">维修车型分类</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="8-3">维修工时计算</el-menu-item>
              </a>
              <a href="/pages/personManage/staffManage.jsp">
                <el-menu-item index="8-4">维修项目定义</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="8-5">维修项目用料</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="9">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/7.png"></i>
              <span slot="title">维修档案</span>
            </template>
            <el-menu-item-group>

              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="9-1">客户档案</el-menu-item>
              </a>
              <a href="/pages/personManage/staffManage.jsp">
                <el-menu-item index="9-2">车辆档案</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="9-3">员工档案</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="9-4">驾驶员信息档案</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="10">
            <template slot="title">
              <i class="menu-ico"><img src="/static/images/7.png"></i>
              <span slot="title">报表管理</span>
            </template>
            <el-menu-item-group>

              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="10-1">维修报表</el-menu-item>
              </a>
              <a href="/pages/personManage/staffManage.jsp">
                <el-menu-item index="10-2">售车报表</el-menu-item>
              </a>
              <a href="/pages/personManage/accessManage.jsp">
                <el-menu-item index="10-3">进车报表</el-menu-item>
              </a>

            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
        <el-container>
          <el-main>

