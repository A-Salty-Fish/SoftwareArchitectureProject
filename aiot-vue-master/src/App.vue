<!--
 * @FileDescription: 主页面
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div id="app">
        <el-row>
            <el-col>
                <myHeader></myHeader>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="4">
                <asideMenu class="hidden-xs-only"></asideMenu>
            </el-col>
            <el-col :xs="24" :span="20">
                <router-view></router-view>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <myFooter></myFooter>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import myHeader from './components/global/web-header.vue'
    import asideMenu from './components/menus/aside-menu.vue'
    import myFooter from './components/global/web-footer.vue'

    export default {
        name: 'app',
        components: {
            myHeader,
            asideMenu,
            myFooter
        },
        data() {
            return {}
        }
    }
</script>

<style>
    .el-pager li.number{
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
    }
</style>
