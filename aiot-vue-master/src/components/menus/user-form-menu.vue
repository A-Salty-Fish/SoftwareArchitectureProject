<!--
 * @FileDescription: 用户表格组件
 * @Author: 范承祥
 * @Date: 2020/03/06
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-aside class="userForm">
        <p class="infoTitle">{{titleDesc}}</p>
        <el-form :model="user" label-position="right" label-width="30%">
            <el-form-item :label="avatarDesc">
                <el-upload
                        class="avatar-uploader"
                        action="https://jsonplaceholder.typicode.com/posts/"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :before-upload="beforeAvatarUpload">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus"></i>
                </el-upload>
            </el-form-item>
            <el-form-item :label="nameDesc">
                <el-input v-model="user.name"></el-input>
            </el-form-item>
            <el-form-item :label="phoneDesc">
                <el-input v-model="user.phone"></el-input>
            </el-form-item>
            <el-form-item :label="emailDesc">
                <el-input v-model="user.email"></el-input>
            </el-form-item>
            <el-form-item :label="rankDesc">
                <el-select v-model="user.rank">
                    <el-option label="超级管理员" value="超级管理员"></el-option>
                    <el-option label="管理员" value="管理员"></el-option>
                    <el-option label="监督员" value="监督员"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                    <el-button type="primary" @click="onSubmit">{{submitDesc}}</el-button>
                    <el-button @click="cancel">{{cancelDesc}}</el-button>
            </el-form-item>
        </el-form>
    </el-aside>
</template>

<script>
    export default {
        name: "user-dialog",
        props:["user"],
        data(){
            return{
                // 标签位置
                labelPosition:"right",

                // 头像提示
                avatarDesc:"头像",

                // 用户信息提示
                titleDesc:"用户信息",

                // 用户名提示
                nameDesc:"用户名",

                // 联系电话提示
                phoneDesc:"联系电话",

                // 电子邮件提示
                emailDesc:"电子邮件",

                // 等级提示
                rankDesc:"等级",

                // 确认提示
                submitDesc:"确认",

                // 取消提示
                cancelDesc:"取消",

                // 头像URL
                imageUrl: "",
            }
        },
        methods:{
            /**
             * 处理上传头像
             * @param res
             * @param file
             */
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },

            /**
             * 检查头像大小
             * @param file
             * @returns {boolean|boolean} 是否符合标准
             */
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },

            /**
             * 提交更改
             */
            onSubmit:function(){

            },

            /**
             * 取消更改
             */
            cancel:function(){

            },
        }
    }
</script>

<style scoped>
    .userForm{
        padding-left:20px;
        padding-right:20px;
    }

    .infoTitle {
        color: #597EF7;
        font-size: 20px;
        font-weight: bold;
    }
</style>
