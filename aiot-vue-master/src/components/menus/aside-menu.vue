<!--
 * @FileDescription: 侧边导航组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div class="asideMenu">
        <el-menu :router=true
                 :default-active="this.$route.path"
                 mode="vertical">
            <el-menu-item v-for="(item,i) in navList"
                          :key="i"
                          :index="item.name" :route="item.name">
                <i :class="item.icon"></i>
                <span slot="title">{{item.navItem}}</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "asideMenu",
        data(){
            return {
                // 导航项列表
                navList: [
                    {name: '/home', navItem: '农场概览', icon: 'el-icon-s-home'},
                    {name: '/statistics', navItem: '数据统计', icon: 'el-icon-s-data'},
                    {name: '/equipments', navItem: '设备管理', icon: 'el-icon-s-tools'},
                    {name: '/users', navItem: '用户管理', icon: 'el-icon-user-solid'}
                ],
            }
        }
    }
</script>

<style scoped>
    .asideMenu{
        padding-top: 20px;
    }
    .el-menu{
        border-right-width:0px;
        border-right-color: #E6E6E6;
        border-right-style: solid;
    }
</style>
