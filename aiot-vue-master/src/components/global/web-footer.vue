<!--
 * @FileDescription: 版权信息组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-footer>
        <div class="copyright">
            <p>Designed by Francis</p>
            <p>Powered by Vue, Element UI</p>
        </div>
    </el-footer>
</template>

<script>
    export default {
        name: "myFooter"
    }
</script>

<style scoped>
    .copyright {
        text-align: center;
    }

    .copyright p {
        margin: 5px;
        color: #565656;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        font-size: 12px;
    }
</style>
