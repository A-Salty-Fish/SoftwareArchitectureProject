<!--
 * @FileDescription: 设置菜单组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-aside class="settingsMenu">
        <el-row>
            <p class="settingsTitle">{{title}}</p>
        </el-row>
        <el-row>
            <p class="settingsDesc" v-show="!disabled">{{menuTitleDesc}}</p>
            <p class="stateDesc" v-show="disabled">{{stateDesc}}</p>
        </el-row>
        <div class="settingsMenu"  v-show="!disabled">
                <div class="rangeItem"
                     v-for="(item,i) in thresholdList"
                     :key="i">
                    <el-row>
                        <el-col :span="4">
                            <img :src="item.imgSrc">
                        </el-col>
                        <el-col :span="20">
                            <p class="thresholdItemDesc">{{item.name}}</p>
                        </el-col>
                    </el-row>
                    <el-row class="slider">
                        <el-slider v-model="item.value"
                                   :range="item.isRange"
                                   :min="item.min"
                                   :max="item.max"
                                   :marks="item.marks">

                        </el-slider>
                    </el-row>
                </div>
                <el-row v-for="(item,i) in settingsList"
                        :key="i">
                    <el-col :span="4">
                        <img :src="item.imgSrc">
                    </el-col>
                    <el-col :span="16">
                        <p class="settingsItemDesc">{{item.name}}</p>
                    </el-col>
                    <el-col :span="4">
                        <el-tooltip placement="top">
                            <div slot="content">
                                {{item.isActive | tip(item.isError)}}
                            </div>
                            <el-switch
                                    v-model="item.isActive"
                                    :disabled="item.isError">
                            </el-switch>
                        </el-tooltip>
                    </el-col>
                </el-row>
        </div>
    </el-aside>
</template>

<script>
    import light from '../../assets/light-icon.png'
    import co2 from '../../assets/co2-icon.png'
    import temperature from '../../assets/temperature-icon.png'
    import moisture from '../../assets/moisture-icon.png'
    import pressure from '../../assets/pressure-icon.png'
    import ph from '../../assets/ph-icon.png'
    import bugLight from '../../assets/bug-alert-light.png'
    import cool from '../../assets/cool.png'
    import drip from '../../assets/drip.png'
    import fertilize from '../../assets/fertilize.png'
    import humidify from '../../assets/humidify.png'
    import innerShade from '../../assets/inner-shade.png'
    import irrigate from '../../assets/irrigate.png'
    import outerSunshade from '../../assets/outer-sunshade.png'
    import rollCover from '../../assets/roll-cover.png'
    import shutter from '../../assets/shutter.png'
    import sprayPesticide from '../../assets/spray-pesticide.png'
    import warm from '../../assets/warm.png'
    import bugLightActive from '../../assets/bug-alert-light-active.png'
    import coolActive from '../../assets/cool-active.png'
    import dripActive from '../../assets/drip-active.png'
    import fertilizeActive from '../../assets/fertilize-active.png'
    import humidifyActive from '../../assets/humidify-active.png'
    import innerShadeActive from '../../assets/inner-shade-active.png'
    import irrigateActive from '../../assets/irrigate-active.png'
    import outerSunshadeActive from '../../assets/outer-sunshade-active.png'
    import rollCoverActive from '../../assets/roll-cover-active.png'
    import shutterActive from '../../assets/shutter-active.png'
    import sprayPesticideActive from '../../assets/spray-pesticide-active.png'
    import warmActive from '../../assets/warm-active.png'

    export default {
        name: "settings-menu",
        props: ["title", "isActive" ,"isError"],
        data() {
            return {
                // 菜单标题
                menuTitleDesc: "控制面板",

                // 滑动设置项集
                thresholdList:[
                    {name:"光照范围（lux）",imgSrc:light,value:[20,30],isRange:true,marks:{0:"0",20:"20",40:"40"},min:0,max:40},
                    {name:"CO2范围（ppm）",imgSrc:co2,value:[10,20],isRange:true,marks:{5:"5",15:"15",25:"25"},min:5,max:25},
                    {name:"空气温度范围（℃）",imgSrc:temperature,value:[10,20],isRange:true,marks:{0:"0",20:"20",40:"40"},min:0,max:40},
                    {name:"土壤湿度范围（%）",imgSrc:moisture,value:[50,75],isRange:true,marks:{0:"0",20:"20",50:"50",75:"75",100:"100"},min:0,max:100},
                    {name:"土壤压力范围（N）",imgSrc:pressure,value:[1,3],isRange:true,marks:{0:"0",2:"2",5:"5",7:"7",100:"10"},min:0,max:10},
                    {name:"土壤PH值范围（1）",imgSrc:ph,value:[6,7],isRange:true,marks:{0:"0",7:"7",14:"14"},min:0,max:14},
                ],

                // 设置项集
                settingsList: [
                    {name: "虫害预警灯", isActive: true, isError: false, imgSrc: bugLight, imgActiveSrc: bugLightActive},
                    {name: "降温", isActive: true, isError: false, imgSrc: cool, imgActiveSrc: coolActive},
                    {name: "滴灌", isActive: true, isError: false, imgSrc: drip, imgActiveSrc: dripActive},
                    {name: "施肥", isActive: true, isError: false, imgSrc: fertilize, imgActiveSrc: fertilizeActive},
                    {name: "加湿", isActive: true, isError: false, imgSrc: humidify, imgActiveSrc: humidifyActive},
                    {name: "内遮阴", isActive: true, isError: false, imgSrc: innerShade, imgActiveSrc: innerShadeActive},
                    {name: "灌溉", isActive: true, isError: false, imgSrc: irrigate, imgActiveSrc: irrigateActive},
                    {name: "外遮阳", isActive: true, isError: false, imgSrc: outerSunshade, imgActiveSrc: outerSunshadeActive},
                    {name: "卷被", isActive: true, isError: false, imgSrc: rollCover, imgActiveSrc: rollCoverActive},
                    {name: "卷帘", isActive: true, isError: false, imgSrc: shutter, imgActiveSrc: shutterActive},
                    {name: "施药", isActive: false, isError: true, imgSrc: sprayPesticide, imgActiveSrc: sprayPesticideActive},
                    {name: "加温", isActive: true, isError: false, imgSrc: warm, imgActiveSrc: warmActive},
                ],
            }
        },
        computed:{
            /**
             * 查询设置项是否可用
             * @returns {boolean|*} 设置项是否可用
             */
            disabled:function(){
                return !this.isActive||this.isError
            },

            /**
             * 状态提示转换
             * @returns {string}
             */
            stateDesc:function(){
                if (this.isActive == true) {
                    return "已启动"
                } else if (this.isError == true) {
                    return "故障"
                } else {
                    return "已关闭"
                }
            }
        },
        filters:{
            /**
             * 状态提示转换
             * @param isActive 是否开启
             * @param isError 是否故障
             * @returns {string} 状态提示
             */
            tip:function(isActive,isError){
                if (isActive == true) {
                    return "已启动"
                } else if (isError == true) {
                    return "故障"
                } else {
                    return "已关闭"
                }
            }
        }
    }
</script>

<style scoped>
    .el-row {
        padding: 4% 10%;
    }

    .el-row .slider{
        padding-top:0px;
    }

    .settingsMenu{
        height:140%;
    }

    img {
        margin-top: 0px;
        width: 75%;
    }

    p {
        margin-top: 0px;
        margin-bottom:0px;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
    }

    .settingsTitle {
        color: #597EF7;
        font-size: 20px;
        font-weight: bold;
    }

    .settingsDesc,.stateDesc{
        font-weight: bold;
    }
</style>
