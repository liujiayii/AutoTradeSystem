<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
    <div class="title" @click="isCollapse = !isCollapse">财务管理</div>
    <!--<el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">-->
    <!--<el-radio-button :label="false">??</el-radio-button>-->
    <!--<el-radio-button :label="true">??</el-radio-button>-->
    <!--</el-radio-group>-->
    <el-button class="btn" type="primary" @click="dialogFormVisible = true" icon="el-icon-plus" round>添加
    </el-button>
    <el-dialog title="????" :visible.sync="dialogFormVisible">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                 class="demo-ruleForm">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="???" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="???" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="???" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="?????"></el-form-item>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="???" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="????" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="?????" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="?????" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="????" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="???" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="?????"></el-form-item>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="???" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>

                <el-col :span="12">
                    <el-form-item label="????" prop="name">
                        <el-input v-model="ruleForm.name"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="???" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="??" prop="desc">
                <el-input type="textarea" v-model="ruleForm.desc"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">????</el-button>
                <el-button @click="resetForm('ruleForm')">??</el-button>
            </el-form-item>
        </el-form>
        <!--<div slot="footer" class="dialog-footer">-->
        <!--<el-button @click="dialogFormVisible = false">? ?</el-button>-->
        <!--<el-button type="primary" @click="dialogFormVisible = false">? ?</el-button>-->
        <!--</div>-->
    </el-dialog>
</el-container>
<el-container class="main">
<el-table v-loading="loading2"
          element-loading-text="拼命加载中"
          stripe
          element-loading-spinner="el-icon-loading"
          :data="tableData.data"
          @cell-dblclick="celledit"
          class="tb-edit"
          style="width: 100%">
    <el-table-column label="销售" prop="date"></el-table-column>
    <el-table-column label="姓名" prop="names"></el-table-column>
    <el-table-column label="收入" prop="phone"></el-table-column>
    <el-table-column label="收入项目" prop="position"></el-table-column>
    <el-table-column prop="names" label="姓名"></el-table-column>
    <el-table-column label="金额" prop="position"></el-table-column>
    <el-table-column label="金额" prop="position"></el-table-column>
    <el-table-column label="哈哈哈">
        <template slot-scope="scope">
            <el-input class="input-box" v-model="scope.row.name" placeholder="请输入内容" @change="handleEdits(scope.$index, scope.row)"></el-input>
            <span>{{scope.row.name}}</span>
        </template>
    </el-table-column>
</el-table>
</el-container>
<el-container class="page-box">
    <div class="block">
        <el-pagination
                @current-change="handleCurrentChange"
                layout="total,prev, pager, next, jumper"
                :total="tableData.count">
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
                navActive: '5-1',
                isCollapse: false,
                tableData: {
                    data: [],
                    count: 0
                },
                search: '',
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
                        {required: true, message: '???????', trigger: 'blur'},
                        {min: 3, max: 5, message: '??? 3 ? 5 ???', trigger: 'blur'}
                    ],
                    region: [
                        {required: true, message: '???????', trigger: 'change'}
                    ],
                    date1: [
                        {type: 'date', required: true, message: '?????', trigger: 'change'}
                    ],
                    date2: [
                        {type: 'date', required: true, message: '?????', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '???????????', trigger: 'change'}
                    ],
                    resource: [
                        {required: true, message: '???????', trigger: 'change'}
                    ],
                    desc: [
                        {required: true, message: '???????', trigger: 'blur'}
                    ]
                },
                dialogFormVisible: false,
                formLabelWidth: '120px'
            }
        },
        methods: {
            celledit(row, column, cell, event) {
                console.log('----')
                console.log(row)

            },
            handleEdits(index, row) {
                console.log(index, row);
            },
            handleEdit(index, row) {
                console.log(index, row);
            },
            handleDelete(index, row) {
                console.log(index, row);
            },
            handleCurrentChange(val) {
                this.getTable(val)
                console.log(val)
                console.log(`???: ${val}`);
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            getTable(page) {
                this.loading2 = true
                $.ajax({
                    type: 'post',
                    url: '/selectAllSellingCustomer.action',
                    data: {
                        limit: 10,
                        page: page
                    },
                    dataType: 'json',
                    success: (res) => {
                        console.log(res)
                        if (res.code == 1) {
                            this.tableData.data = res.data
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
            }
        },
        mounted() {
            this.getTable(1)
        }
    })
</script>
</html>
