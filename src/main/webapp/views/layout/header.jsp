<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>喔驰后台管理系统</title>
  <link href="//lib.baomitu.com/element-ui/2.6.1/theme-chalk/index.css" rel="stylesheet">
  <script src="//lib.baomitu.com/jquery/3.3.1/jquery.min.js"></script>
  <script src="//lib.baomitu.com/vue/2.6.8/vue.min.js"></script>
  <!--<script src="//lib.baomitu.com/vue/2.6.8/vue.js"></script>-->
  <script src="//lib.baomitu.com/element-ui/2.6.1/index.js"></script>
  <link href="//lib.baomitu.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/static/css/page.css">
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
          <a v-else :key="index" :href="menu_a.path">
            <el-menu-item :index="index+''">
              <i :class="menu_a.icon"></i>
              <span slot="title">{{ menu_a.name }}</span>
            </el-menu-item>
          </a>
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
            <a href="/logout.action">
              <el-dropdown-item command="logout">退出</el-dropdown-item>
            </a>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-main>
