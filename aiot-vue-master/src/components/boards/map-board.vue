<!--
 * @FileDescription: 地图组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-card shadow="always" :body-style="cardStyle">
        <el-container>
            <el-image :src="src">
            </el-image>
        </el-container>
    </el-card>
</template>

<script>
    import mapImg from '../../assets/map.jpg'
    export default {
        name: "map-board",
        data(){
            return {
                // 卡片样式
                cardStyle: "padding: 0px",

                // 地图
                src: mapImg
            }
        }
    }
</script>

<style scoped>
.el-card{
    padding:0px;
}
</style>
