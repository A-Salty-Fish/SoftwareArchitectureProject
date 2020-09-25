<!--
 * @FileDescription: 用户密码组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div class="password">
        <p class="infoTitle">{{titleDesc}}</p>
        <el-form :model="user" label-position="right" label-width="30%">
            <el-form-item :label="oldPasswordDesc" prop="password">
                <el-input v-model="oldPassword" type="password"></el-input>
            </el-form-item>
            <el-form-item :label="newPasswordDesc" prop="newPassword">
                <el-input v-model="newPassword" type="password"></el-input>
            </el-form-item>
            <el-form-item :label="confirmPasswordDesc" prop="checkPassword">
                <el-input v-model="confirmPassword" type="password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">{{summitDesc}}</el-button>
                <el-button>{{cancelDesc}}</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "user-password",
        props:["user"],
        data(){
            return {
                // 修改密码提示
                titleDesc:"密码修改",

                // 原密码提示
                oldPasswordDesc:"原密码",

                // 新密码提示
                newPasswordDesc:"新密码",

                // 确认密码提示
                confirmPasswordDesc:"确认密码",

                // 确认提示
                summitDesc:"确认",

                // 取消提示
                cancelDesc:"取消",

                // 原密码
                oldPassword:"",

                // 新密码
                newPassword:"",

                // 确认密码
                confirmPassword:"",

                // 密码约束规则
                ruleList:{
                    password:[{

                    }],
                    newPassword:[{

                    }],
                    checkPassword:[{

                    }]
                }
            }
        },
        methods:{
            /**
             * 确认修改密码
             */
            onSubmit:function(){

            }
        }
    }
</script>

<style scoped>
    .password{
        padding-left:20px;
        padding-right:20px;
    }

    .infoTitle {
        color: #597EF7;
        font-size: 20px;
        font-weight: bold;
    }
</style>
