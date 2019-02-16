<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>喔驰后台管理系统</title>
  <link href="https://cdn.bootcss.com/element-ui/2.5.3/theme-chalk/index.css" rel="stylesheet">
  <link rel="stylesheet" href="/static/css/page.css">
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/vue/2.6.4/vue.min.js"></script>
  <script src="https://cdn.bootcss.com/element-ui/2.5.3/index.js"></script>
  <script src="/static/js/utils.js"></script>
</head>
<body>
<div id="app" v-cloak>
  <el-container style="height: 100%">
    <el-aside style="width: auto">
      <div class="logo">{{logo}}</div>
      <el-menu
              :default-active="navActive"
              class="el-menu-vertical-demo"
              :collapse="isCollapse"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
              unique-opened>
        <template v-for="(menu_a,index) in menu">
          <el-submenu v-if="menu_a.child" :key="index" :index="index+''">
            <template slot="title">
              <i :class="menu_a.icon"></i>
              <span slot="title">{{ menu_a.name }}</span>
            </template>
            <el-menu-item-group>
              <a v-for="(menu_c,index_c) in menu_a.child" :href="menu_c.path"
                 :key="index_c">
                <el-menu-item :index="index+'-'+(index_c+1)">{{ menu_c.name }}</el-menu-item>
              </a>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item v-else :index="index+''" :key="index">
            <i :class="menu_a.icon"></i>
            <span slot="title">{{ menu_a.name }}</span>
          </el-menu-item>
        </template>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header class="head">
    <span class="ico" @click="isCollapse = !isCollapse">
     <i class="fa fa-indent fa-lg"></i>
    </span>
        <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link" style="color:#fff;cursor: pointer">
          ${user.name}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="a">基本资料</el-dropdown-item>
            <el-dropdown-item command="b">修改密码</el-dropdown-item>
            <el-dropdown-item command="logout" divided>
              <a href="/logout.action">退出</a>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-main>
