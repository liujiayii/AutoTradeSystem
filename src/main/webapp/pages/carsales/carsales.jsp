<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
    <div class="title" @click="isCollapse = !isCollapse">售车管理</div>
    <el-button class="btn" type="primary" @click="dialogFormVisible = true" icon="el-icon-plus" round>添加</el-button>
</el-container>
<el-container class="main">
    <el-table v-loading="loading2"
              element-loading-text="拼命加载中"
              stripe
              element-loading-spinner="el-icon-loading"
              :data="tableData.data"
              style="width: 100%">
        <el-table-column label="创建时间" prop="create_time" :formatter="dateFormat"></el-table-column>
        <el-table-column label="姓名" prop="name"></el-table-column>
        <el-table-column label="电话" prop="phone"></el-table-column>
        <el-table-column label="地址" prop="address"></el-table-column>
        <el-table-column label="车型" prop="vehicle_type"></el-table-column>
        <el-table-column label="首付款" prop="first_payment"></el-table-column>
        <el-table-column align="right">
            <template slot="header" slot-scope="scope">
                <el-input v-model="search" placeholder="输入关键词进行搜索"/>
            </template>
            <template slot-scope="scope">
                <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
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
                navActive: '3-1',
                isCollapse: false,
                tableData: {
                    data: [],
                    count: 0
                },
                search: '',
                loading2: true,
                dialogFormVisible: false,
                formLabelWidth: '120px'
            }
        },
        methods: {
            //时间格式化
            dateFormat: function (row, column) {
                let date = new Date(row.create_time);
                let y = date.getFullYear();
                let m = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : datetime.getMonth() + 1;
                let d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                return y + "-" + m + "-" + d;
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
                    url: '/sellCar/findByLimit.action',
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
