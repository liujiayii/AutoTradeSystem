<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>喔驰后台管理系统</title>
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="/AutoTradeSystem/static/css/pages.css">
    <!-- import Vue before Element -->
	<script src="https://unpkg.com/vue/dist/vue.js"></script>
	<!-- import JavaScript -->
	<script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="app">
    <el-container style="height: 100%">
        <el-header class="head">
            <div class="logo">喔驰后台管理系统</div>
            <a href="/AutoTradeSystem/logout.action"><img src="/AutoTradeSystem/static/images/close.png"/></a>
        </el-header>
        <el-container>
            <el-aside style="width: auto">
                <el-menu
                        :default-active="navActive"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                        @select="handleSelect"
                        :collapse="isCollapse"
                        unique-opened>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>客户信息</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item class="el-menu-item" index="1-1">车辆资源</el-menu-item>
                            <el-menu-item index="1-2">买车咨询</el-menu-item>
                            <el-menu-item index="1-3">置换车辆</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">交易管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="2-1">评估审核</el-menu-item>
                            <el-menu-item index="2-2">保险凭证</el-menu-item>
                            <el-menu-item index="2-3">分期管理</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title">
                            <i class="el-icon-document"></i>
                            <span slot="title">售车管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="3-1">选项1</el-menu-item>
                            <el-menu-item index="3-2">选项2</el-menu-item>
                            <el-menu-item index="3-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="4">
                        <template slot="title">
                            <i class="el-icon-setting"></i>
                            <span slot="title">车辆管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="4-1">选项1</el-menu-item>
                            <el-menu-item index="4-2">选项2</el-menu-item>
                            <el-menu-item index="4-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="5">
                        <template slot="title">
                            <i class="el-icon-setting"></i>
                            <span slot="title">财务管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="5-1">选项1</el-menu-item>
                            <el-menu-item index="5-2">选项2</el-menu-item>
                            <el-menu-item index="5-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="6">
                        <template slot="title">
                            <i class="el-icon-setting"></i>
                            <span slot="title">库存管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="6-1">选项1</el-menu-item>
                            <el-menu-item index="6-2">选项2</el-menu-item>
                            <el-menu-item index="6-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="7">
                        <template slot="title">
                            <i class="el-icon-setting"></i>
                            <span slot="title">人员管理</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="7-1">选项1</el-menu-item>
                            <el-menu-item index="7-2">选项2</el-menu-item>
                            <el-menu-item index="7-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container>
                <el-main>