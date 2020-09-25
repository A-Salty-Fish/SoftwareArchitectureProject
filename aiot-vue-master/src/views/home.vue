<!--
 * @FileDescription: 农场概览页面
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-main class="home">
        <el-row>
            <el-col>
                <mapBoard>

                </mapBoard>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :xs="24" :span="8"
                    v-for="(item,i) in labelList"
                    :key="i">
                <info-board
                        :title="item.label"
                        :src="item.iconSrc"
                        :select="item.data"
                        :unit="item.unit">
                </info-board>
            </el-col>
        </el-row>
    </el-main>
</template>

<script>
    import mapBoard from '../components/boards/map-board.vue'
    import infoBoard from '../components/boards/info-board.vue'
    import lightSrc from '../assets/light.png'
    import co2Src from '../assets/co2 .png'
    import moistureSrc from '../assets/soil-moisture.png'
    import phSrc from '../assets/soil-ph.png'
    import pressureSrc from '../assets/soil-pressure.png'
    import temperatureSrc from '../assets/temperature.png'

    export default {
        name: "home",
        components: {
            mapBoard,
            infoBoard
        },
        data() {
            return {
                // 湿度图标
                moistureSrc: moistureSrc,

                //PH值图标
                phSrc: phSrc,

                // 压力图标
                pressureSrc: pressureSrc,

                // 温度图标
                temperatureSrc: temperatureSrc,

                // 标签集
                labelList: [
                    {label:"光照强度",unit:"lx",iconSrc:lightSrc,data:"light",isFixed:false},
                    {label:"CO2浓度",unit:"ppm",iconSrc:co2Src,data:"co2",isFixed:false},
                    {label:"空气温度",unit:"℃",iconSrc:temperatureSrc,data:"soilTemperature",isFixed:false},
                    {label:"土壤湿度",unit:"%",iconSrc:moistureSrc,data:"soilMoisture",isFixed:false},
                    {label:"土壤压力",unit:"N",iconSrc:pressureSrc,data:"soilPressure",isFixed:false},
                    {label:"土壤PH",unit:"1",iconSrc:phSrc,data:"soilPh",isFixed:false}],
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .el-row {
        margin-bottom: 10px;
    }

    .el-col {
        border-radius: 5px;
        margin-bottom: 10px;
    }
</style>
