<!--
 * @FileDescription: 图表组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div class="chart">
        <el-row :gutter="20">
            <el-col :xs="24" :span="16">
                <lineChart></lineChart>
            </el-col>
            <el-col :xs="24" :span="8">
                <pieChart></pieChart>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :xs="24" :span="12">
                <bar-chart></bar-chart>
            </el-col>
            <el-col :xs="24" :span="12">
                <calendarChart></calendarChart>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import lineChart from '../charts/line-chart.vue'
    import barChart from '../charts/bar-chart.vue'
    import pieChart from '../charts/pie-chart.vue'
    import calendarChart from '../charts/calendar-chart.vue'

    export default {
        name: "chart-view",
        components:{
            lineChart,
            barChart,
            pieChart,
            calendarChart,
        }
    }
</script>

<style scoped>

</style>
