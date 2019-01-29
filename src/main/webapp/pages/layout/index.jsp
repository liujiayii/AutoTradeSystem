<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>喔驰后台管理系统</title>
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="/static/css/pages.css">
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
            <a href="/logout.action"><img src="/AutoTradeSystem/static/images/close.png"/></a>
        </el-header>
        <el-container>
            <el-aside style="width: auto">
                <el-menu
                        :default-active="navActive"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                        @select="handleRoute"
                        :collapse="isCollapse"
                        unique-opened>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="menu-ico"><img src="/static/images/1.png"></i>
                            <span>客户信息</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1">车辆资源</el-menu-item>
                            <el-menu-item index="1-2">买车咨询</el-menu-item>
                            <el-menu-item index="1-3">置换车辆</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="menu-ico"><img src="/static/images/2.png"></i>
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
                            <i class="menu-ico"><img src="/static/images/3.png"></i>
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
                            <i class="menu-ico"><img src="/static/images/4.png"></i>
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
                            <i class="menu-ico"><img src="/static/images/5.png"></i>
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
                            <i class="menu-ico"><img src="/static/images/6.png"></i>
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
                            <i class="menu-ico"><img src="/static/images/7.png"></i>
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
                    <!-- Form -->
                    <el-container class="secondNav">
                        <div class="title" @click="isCollapse = !isCollapse">买车咨询</div>
                        <!--<el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">-->
                        <!--<el-radio-button :label="false">展开</el-radio-button>-->
                        <!--<el-radio-button :label="true">收起</el-radio-button>-->
                        <!--</el-radio-group>-->
                        <el-button class="btn" type="primary" @click="dialogFormVisible = true" icon="el-icon-plus"
                                   round>添加
                        </el-button>
                        <el-dialog title="车辆信息" :visible.sync="dialogFormVisible">
                            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                                     class="demo-ruleForm">
                                <el-row>
                                    <el-col :span="12">
                                        <el-form-item label="姓名：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="电话：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-form-item label="地址：" prop="name">
                                    <el-input v-model="ruleForm.name"></el-input>
                                </el-form-item>
                                <el-form-item label="原车信息："></el-form-item>
                                <el-row>
                                    <el-col :span="12">
                                        <el-form-item label="车型：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="车牌号：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="使用年限：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="维修记录：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="公里数：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-form-item label="报价：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-form-item label="新车信息："></el-form-item>
                                <el-row>
                                    <el-col :span="12">
                                        <el-form-item label="车型：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>

                                    <el-col :span="12">
                                        <el-form-item label="车牌号：" prop="name">
                                            <el-input v-model="ruleForm.name"></el-input>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-form-item label="报价：" prop="name">
                                    <el-input v-model="ruleForm.name"></el-input>
                                </el-form-item>
                                <el-form-item label="备注" prop="desc">
                                    <el-input type="textarea" v-model="ruleForm.desc"></el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                                </el-form-item>
                            </el-form>
                            <!--<div slot="footer" class="dialog-footer">-->
                            <!--<el-button @click="dialogFormVisible = false">取 消</el-button>-->
                            <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
                            <!--</div>-->
                        </el-dialog>
                    </el-container>

                    <el-table v-loading="loading2"
                              element-loading-text="拼命加载中"
                              element-loading-spinner="el-icon-loading"
                              :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                              style="width: 100%">
                        <el-table-column label="创建时间" prop="date"></el-table-column>
                        <el-table-column label="姓名" prop="name"></el-table-column>
                        <el-table-column label="电话" prop="phone"></el-table-column>
                        <el-table-column label="地址" prop="position"></el-table-column>
                        <el-table-column label="车型" prop="phone"></el-table-column>
                        <el-table-column label="报价" prop="position"></el-table-column>
                        <el-table-column align="right">
                            <template slot="header" slot-scope="scope">
                                <el-input v-model="search" size="mini" placeholder="输入关键字搜索"/>
                            </template>
                            <template slot-scope="scope">
                                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <el-container class="page-box">
                        <div class="block">
                            <el-pagination
                                    @current-change="handleCurrentChange"
                                    layout="prev, pager, next, jumper"
                                    :total="total">
                            </el-pagination>
                        </div>
                    </el-container>
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
                navActive: '1-2',
                visible: false,
                isCollapse: false,
                total: 100,
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }],
                search: '',
                currentPage3: 5,
                loading2: true,
                ruleForm: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入活动名称', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    region: [
                        {required: true, message: '请选择活动区域', trigger: 'change'}
                    ],
                    date1: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    date2: [
                        {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
                    ],
                    resource: [
                        {required: true, message: '请选择活动资源', trigger: 'change'}
                    ],
                    desc: [
                        {required: true, message: '请填写活动形式', trigger: 'blur'}
                    ]
                },
                dialogFormVisible: false,
                formLabelWidth: '120px'
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            handleRoute(index, indexPath) {
                console.log(index)
                switch (index) {
                    case '1-1' :
                        window.location.href = '../customerInfo/carResources.jsp'
                        break
                    case '1-2':
                        window.location.href = '../customerInfo/buyingCarConsult.jsp'
                        break
                    case '1-3':
                        window.location.href = '../customerInfo/replaceCar.jsp'
                        break
                }
            },
            handleEdit(index, row) {
                console.log(index, row);
            },
            handleDelete(index, row) {
                console.log(index, row);
            },
            handleCurrentChange(val) {
                console.log(val)
                console.log(`当前页: ${val}`);
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        mounted() {
            setTimeout(() => {
                this.loading2 = false
            }, 2000);
        }
    })
</script>
</html>

