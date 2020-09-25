<!--
 * @FileDescription: 用户管理页面
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-main class="users">
        <userTable></userTable>
    </el-main>
</template>

<script>
    import userTable from '../components/tables/user-table.vue'

    export default {
        name: "users",
        components:{
            userTable,
        },
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
