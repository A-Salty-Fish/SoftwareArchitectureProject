<!--
 * @FileDescription: 顶部栏组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-header>
        <el-row>
            <el-col :span="12">
                <div class="logo">
                    <router-link to="/">
                        <img :src="logoSrc"/>
                    </router-link>
                </div>
            </el-col>
            <el-col :xs="8" :span="12">
                <avatarDropdown></avatarDropdown>
            </el-col>
            <el-col :xs="4" :sm="0" :md="0" :lg="0" :xl="0">
                <div class="menu">
                    <img :src="menuSrc"
                         @click="isDrawerOpen=true"/>
                </div>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-drawer
                        :size="drawerSize"
                        :visible.sync="isDrawerOpen">
                    <p>{{menuTitle}}</p>
                    <div class="drawerMenu">
                        <asideMenu></asideMenu>
                    </div>
                </el-drawer>
            </el-col>
        </el-row>
    </el-header>
</template>

<script>
    import logoSrc from '../../assets/aiot.png'
    import asideMenu from '../menus/aside-menu.vue'
    import menuSrc from '../../assets/menu.png'
    import AvatarDropdown from "../menus/avatar-menu";

    export default {
        name: "myHeader",
        components: {
            AvatarDropdown,
            asideMenu,
        },
        data() {
            return {
                // 图标
                logoSrc: logoSrc,

                // 菜单图标
                menuSrc: menuSrc,

                // 头像大小
                avatarSize: 30,

                //菜单提示
                menuTitle: "菜单",

                // 抽屉是否打开
                isDrawerOpen: false,

                // 抽屉大小
                drawerSize: "50%",
            }
        }
    }
</script>

<style scoped>
    .logo img {
        height: 30px;
    }

    .avatar {
        float: right;
    }

    .menu {
        float: right;
    }

    .menu img {
        height: 20px;
        margin-top: 5px;
        margin-bottom: 5px;
    }

    .el-drawer p {
        text-align: center;
        font-weight: bold;
    }

    .drawerMenu {
        text-align: center;
    }

    .el-header {
        padding: 15px 20px;
        /*border-bottom-width: 1px;*/
        /*border-bottom-color: #DCDFE6;*/
        /*border-bottom-style: solid;*/
    }
</style>
