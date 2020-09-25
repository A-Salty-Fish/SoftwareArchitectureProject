<!--
 * @FileDescription: 数据统计页面
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-main class="statistics">
        <el-row>
            <el-col>
                <el-menu :router=true
                         :default-active="this.$route.path"
                         mode="horizontal">
                    <el-menu-item v-for="(item,i) in navList"
                                  :key="i"
                                  :index="item.name" :route="item.name">
                        <i :class="item.icon"></i>
                        <span slot="title">{{item.navItem}}</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <router-view></router-view>
            </el-col>
        </el-row>
    </el-main>
</template>

<script>
    export default {
        name: "statistics",
        data(){
            return {
                // 导航项列表
                navList:[
                    {name:"/statistics/table-view",navItem:"表格视图",icon:"el-icon-s-grid"},
                    {name:"/statistics/chart-view",navItem:"图表视图",icon:"el-icon-s-data"},
                ]
            }
        }
    }
</script>

<style scoped>
    .el-row {
        margin-bottom: 10px;
    }

    .el-col {
        border-radius: 5px;
        margin-bottom: 10px;
    }
</style>
