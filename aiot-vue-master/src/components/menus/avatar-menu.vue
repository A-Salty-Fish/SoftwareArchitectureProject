<!--
 * @FileDescription: 头像下拉菜单组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div class="avatar">
        <el-dropdown @command="handleCommand">
            <el-avatar icon="el-icon-user-solid"
                       :size="avatarSize"></el-avatar>
            <el-dropdown-menu slot="dropdown">
                <el-row>
                    <el-col :span="12">
                        <div class="avatarImg">
                            <el-avatar icon="el-icon-user-solid"
                                       :size="avatarSize"></el-avatar>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div class="editImg">
                            <i class="el-icon-edit"
                               @click="openDrawer"></i>
                        </div>
                    </el-col>
                </el-row>
                <el-row>
                    <p class="infoDesc">{{nameDesc}}{{userInfo.name}}</p>
                    <p class="infoDesc">{{rankDesc}}
                        <el-tag :type="tagType"
                                :size="tagSize">
                            {{userInfo.rank}}
                        </el-tag>
                    </p>
                    <p class="infoDesc">{{phoneDesc}}{{userInfo.phone}}</p>
                    <p class="infoDesc">{{emailDesc}}{{userInfo.email}}</p>
                </el-row>
                <el-divider></el-divider>
                <el-dropdown-item v-for="(item,i) in menuList"
                                  :key="i"
                                  :icon="item.icon"
                                  :command="i">
                    {{item.name}}
                </el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
        <el-row>
            <el-col>
                <el-drawer :size="drawerSize"
                           :visible.sync="isDrawerOpen">
                    <div class="drawerMenu">
                        <userForm v-if="isForm==true" :user="userInfo"></userForm>
                        <userPassword v-else :user="userInfo"></userPassword>
                    </div>
                </el-drawer>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import userForm from './user-form-menu.vue'
    import UserPassword from "./user-password-menu";

    export default {
        name: "avatar-dropdown",
        components: {
            UserPassword,
            userForm,
        },
        data() {
            return {
                // 头像大小
                avatarSize: 30,

                // 标签大小
                tagSize: "small",

                // 用户名提示
                nameDesc: "用户名：",

                //用户等级提示
                rankDesc: "等级：",

                // 联系电话提示
                phoneDesc: "联系电话：",

                // 电子邮箱提示
                emailDesc: "电子邮箱：",

                // 菜单项
                menuList: [
                    {name: '修改密码', icon: 'el-icon-key'},
                    {name: '退出', icon: 'el-icon-bottom-right'}
                ],

                // 用户信息
                userInfo: {
                    name: "Francis",
                    rank: "超级管理员",
                    phone: "13888888888",
                    email: "Francis@aiot.com",
                    password: "88888888",
                },

                // 下拉菜单大小
                drawerSize: "330px",

                // 是否抽屉打开
                isDrawerOpen: false,

                // 是否展示用户表格
                isForm:true,
            }
        },
        computed: {
            /**
             * 用户与标签类型转换
             * @returns {string} 标签类型
             */
            tagType: function () {
                switch (this.userInfo.rank) {
                    case "超级管理员":
                        return ""
                    case "管理员":
                        return "success"
                    case "监督员":
                        return "warning"
                    default:
                        return "info"
                }
            }
        },
        methods: {
            /**
             * 开启抽屉
             */
            openDrawer: function () {
                this.isForm=true
                this.isDrawerOpen = true
            },

            /**
             * 处理菜单点击事件
             * @param command
             */
            handleCommand(command) {
                switch (command) {
                    case 0:
                        this.changePassword()
                        break
                    case 1:
                        this.logout()
                        break
                    default:
                }
            },

            /**
             * 更改密码
             */
            changePassword(){
                this.isForm=false
                this.isDrawerOpen=true
            },

            /**
             * 退出
             */
            logout:function(){

            }
        }
    }
</script>

<style scoped>
    .el-row {
        margin-top: 10px;
    }

    .el-divider {
        width: 80%;
        margin: 10px 20px;
    }

    .avatarImg {
        padding-left: 20px;
        height: 30px;
    }

    .editImg {
        padding-right: 20px;
        float: right;
    }

    .editImg i {
        font-size: 18px;
    }

    .infoDesc {
        color: #565656;
        font-size: 14px;
        padding-left: 20px;
        padding-right: 20px;
    }

    .infoTitle {
        color: #597EF7;
        font-size: 20px;
        font-weight: bold;
    }
</style>
