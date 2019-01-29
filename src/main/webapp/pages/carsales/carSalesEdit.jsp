<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/head.jsp" %>
<!-- Form -->
<el-container class="secondNav">
    <div class="title" @click="isCollapse = !isCollapse">车辆资源</div>
</el-container>
<el-container class="main" style="width: 800px">
    <el-form :model="ruleForm" ref="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm">
        <el-form-item label="售车信息"></el-form-item>
        <el-row>
            <el-col :span="12">
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="ruleForm.name"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="ruleForm.phone"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-form-item label="联系地址" prop="address">
            <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="车辆信息"></el-form-item>
        <el-row>
            <el-col :span="12">
                <el-form-item label="车型" prop="vehicle_type">
                    <el-input v-model="ruleForm.vehicle_type"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="品牌" prop="brand">
                    <el-input v-model="ruleForm.brand"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="使用年限" prop="service_life">
                    <el-input v-model="ruleForm.service_life"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="公里数" prop="kilometres">
                    <el-input v-model="ruleForm.kilometres"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="有无重大事故" prop="major_accidents">
                    <el-radio-group v-model="ruleForm.major_accidents">
                        <el-radio border label="1">有</el-radio>
                        <el-radio border label="0">无</el-radio>
                    </el-radio-group>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="粗略报价" prop="offer">
                    <el-input v-model="ruleForm.offer"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="24">
                <el-form-item label="维修记录" prop="maintenance_record">
                    <el-input type="textarea" :rows="2" v-model="ruleForm.maintenance_record"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
        </el-form-item>
    </el-form>
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
                navActive: '1-1',
                isCollapse: false,
                ruleForm: {
                    name: '',
                    phone: '',
                    address: '',
                    vehicle_type: '',
                    brand: '',
                    service_life: '',
                    kilometres: '',
                    major_accidents: '0',
                    maintenance_record: '',
                    offer: ''
                },
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'}
                    ],
                    phone: [
                        {required: true, message: '请输入电话', trigger: 'blur'}
                    ],
                    address: [
                        {required: true, message: '请输入地址', trigger: 'blur'}
                    ],
                    vehicle_type: [
                        {required: true, message: '请输入车型', trigger: 'blur'}
                    ],
                    brand: [
                        {required: true, message: '请输入品牌', trigger: 'blur'}
                    ],
                    service_life: [
                        {required: true, message: '请输入使用年限', trigger: 'blur'}
                    ],
                    kilometres: [
                        {required: true, message: '请输入公里数', trigger: 'blur'}
                    ],
                    offer: [
                        {required: true, message: '请填写粗略报价', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        $.ajax({
                            type: 'post',
                            url: '/insertAllSellingCustomer.action',
                            data: this.ruleForm,
                            dataType: 'json',
                            success: (res) => {
                                console.log(res)
                                if (res.code == 1) {
                                    this.$notify({
                                        title: '提示',
                                        message: res.msg,
                                        position: 'bottom-right',
                                        offset: 300,
                                        type: 'success',
                                        onClose() {
                                            window.location.href = "carResources.jsp"
                                        }
                                    })
                                } else {
                                    this.$notify.error({
                                        title: '提示',
                                        message: res.msg,
                                        position: 'bottom-right',
                                        offset: 300
                                    })
                                }
                            },
                            error: (res) => {
                                console.log(res)
                                this.$notify.error({
                                    title: '提示',
                                    message: res.msg,
                                    position: 'bottom-right',
                                    offset: 300
                                })
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            },
            // 获取地址栏参数，name:参数名称
            getHrefParam(key) {
                var s = window.location.href;
                var reg = new RegExp(key + "=\\w+");
                var rs = reg.exec(s);
                if (rs === null || rs === undefined) {
                    return "";
                } else {
                    return rs[0].split("=")[1];
                }
            }
        },
        created() {
            this.getHrefParam('id')
        }
    })
</script>
</html>
