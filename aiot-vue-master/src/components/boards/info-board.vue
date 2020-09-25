<!--
 * @FileDescription: 信息看板组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-card shadow="always" :body-style="cardStyle">
        <el-row :gutter="20">
            <el-col :span="12">
                <div class="image"><img :src="src"/></div>
            </el-col>
            <el-col :span="12">
                <p class="title">{{title}}</p>
                <p class="date">{{samplingTime}}</p>
                <p class="date">{{date}}</p>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-table
                        :data="tableData"
                        :size="fontSize"
                        :fit=true
                        :show-header="isShowLabel"
                        max-height="200px">
                    <el-table-column prop="sensorName" :label="area" align="center">
                    </el-table-column>
                    <el-table-column :prop="select" :label="detail" align="center">
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
    </el-card>
</template>

<script>
    export default {
        name: "info-board",
        props: ['title', 'unit', 'src', 'select'],
        data() {
            return {
                // 卡片样式
                cardStyle: "padding: 15px",

                // 采样时间提示
                samplingTime: "采样时间：",

                // 采样时间
                date: "2020-02-06 22:59",

                // 数据集
                tableData: [
                    {sensorName: "1号棚", date:"2020-02-06 22:59",light:"12.0",co2:"101.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {sensorName: "2号棚", date:"2020-02-06 21:59",light:"13.0",co2:"102.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {sensorName: "3号棚", date:"2020-02-06 20:59",light:"14.0",co2:"103.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {sensorName: "4号棚", date:"2020-02-06 19:59",light:"15.0",co2:"105.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {sensorName: "5号棚", date:"2020-02-06 18:59",light:"15.0",co2:"106.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {sensorName: "6号棚", date:"2020-02-06 17:59",light:"15.0",co2:"102.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {sensorName: "7号棚", date:"2020-02-06 16:59",light:"12.0",co2:"102.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {sensorName: "1号棚", date:"2020-02-17 15:59",light:"14.0",co2:"103.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {sensorName: "2号棚", date:"2020-02-17 14:59",light:"17.0",co2:"105.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {sensorName: "3号棚", date:"2020-02-17 13:59",light:"18.0",co2:"107.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {sensorName: "4号棚", date:"2020-02-17 12:59",light:"19.0",co2:"109.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {sensorName: "5号棚", date:"2020-02-17 11:59",light:"11.0",co2:"109.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {sensorName: "6号棚", date:"2020-02-17 10:59",light:"14.0",co2:"110.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {sensorName: "7号棚", date:"2020-02-17 09:59",light:"16.0",co2:"111.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {sensorName: "1号棚", date:"2020-02-18 08:59",light:"18.0",co2:"112.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {sensorName: "2号棚", date:"2020-02-18 07:59",light:"19.0",co2:"120.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {sensorName: "3号棚", date:"2020-02-18 06:59",light:"13.0",co2:"122.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {sensorName: "4号棚", date:"2020-02-18 05:59",light:"14.0",co2:"133.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {sensorName: "5号棚", date:"2020-02-18 04:59",light:"16.0",co2:"112.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {sensorName: "6号棚", date:"2020-02-18 03:59",light:"16.0",co2:"110.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {sensorName: "7号棚", date:"2020-02-18 02:59",light:"17.0",co2:"104.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {sensorName: "1号棚", date:"2020-02-18 01:59",light:"17.0",co2:"105.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {sensorName: "2号棚", date:"2020-02-18 00:59",light:"18.0",co2:"106.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {sensorName: "3号棚", date:"2020-02-18 22:59",light:"19.0",co2:"101.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {sensorName: "4号棚", date:"2020-02-18 23:59",light:"17.0",co2:"109.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {sensorName: "5号棚", date:"2020-02-18 21:59",light:"16.0",co2:"101.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {sensorName: "6号棚", date:"2020-02-18 20:59",light:"17.0",co2:"103.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {sensorName: "7号棚", date:"2020-02-18 19:59",light:"18.0",co2:"104.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"}],

                // 是否展示标签
                isShowLabel: true,

                // 区域提示
                area: "区域",

                // 字体大小
                fontSize: "medium"
            }
        },
        computed:{
            /**
             * 进行数据单位填充
             * @returns {string} 带单位数据
             */
            detail:function(){
                return "数据（"+this.unit+"）"
            }
        },
        mounted() {

        }
    }
</script>

<style scoped>
    .image{
        padding:0px;
        text-align: center;
    }

    img{
        width:87px;
    }

    .title {
        margin-top: 10px;
        margin-bottom: 0px;
        font-size:20px;
        font-weight: bold;
    }

    .date {
        margin-bottom: 5px;
        margin-top: 5px;
        font-size:10px;
        color: #565656
    }

    .el-row {
        margin-bottom: 20px;
        padding-left: 0px;
        padding-right: 0px;
    }

</style>
