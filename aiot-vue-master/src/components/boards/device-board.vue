<!--
 * @FileDescription: 设备看板组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-card shadow="always">
        <el-row :gutter="20">
            <el-col :span="6">
                <transition name="el-fade-in">
                    <img class="deviceState" :src="stateImg"/>
                </transition>
            </el-col>

            <el-col :span="12">
                <p class="deviceName">{{title}}</p>
                <p class=""></p>
            </el-col>
            <el-col :span="6">
                <div class="deviceSwitch">
                    <el-tooltip
                            :content="tip"
                            placement="top">
                        <el-switch v-model="isActive"
                                   :disabled="isError"
                                   :active-text="activeDesc"
                                   :inactive-text="inactiveDesc">
                        </el-switch>
                    </el-tooltip>
                </div>
            </el-col>
        </el-row>
        <el-row>
            <p class="infoItem">{{stateDesc}}{{tip}}</p>
            <p class="infoItem"
               v-for="(item,i) in deviceInfoList"
               :key="i">
                {{item.name}}:{{item.data}}
            </p>
        </el-row>
        <el-row>
            <p class="moduleDesc"
               v-show="isShow">
                {{moduleDesc}}
            </p>
        </el-row>
        <el-row class="moduleList"
                v-show="isShow">
            <el-col>
                <div class="moduleItem"
                     v-for="(item,i) in settingsList"
                     :key="i">
                    <img v-show="item.isActive"
                         :src="item.imgActiveSrc" />
                </div>
            </el-col>
        </el-row>
        <el-row>
            <div class="settingsImg">
                <i class="el-icon-setting"
                   @click="isDrawerOpen">
                </i>
            </div>
        </el-row>
        <el-drawer :size="settingsMenuSize"
                   :visible.sync="isSettingsOpen">
            <settingsMenu :title="title"
                          :isActive="isActive"
                          :isError="isError"></settingsMenu>
        </el-drawer>
    </el-card>
</template>

<script>
    import on from '../../assets/on.png'
    import off from '../../assets/off.png'
    import error from '../../assets/error.png'
    import settingsMenu from '../menus/settings-menu.vue'

    export default {
        name: "device-board",
        props: ["title", "isActive", "isError"],
        components: {
            settingsMenu
        },
        data() {
            return {
                // 开关开启描述
                activeDesc: "",

                // 开关关闭描述
                inactiveDesc: "",

                // 设置菜单大小
                settingsMenuSize: "330",

                // 设置菜单是否开启
                isSettingsOpen: false,

                // 状态提示
                stateDesc: "运行状态：",

                // 模块提示
                moduleDesc: "已开启模块",

                // 设备信息集
                deviceInfoList: [
                    {name: "设备号", data: "12896492749"},
                    {name: "固件版本", data: "2.3.0"},
                    {name: "硬件版本", data: "1.0"},
                    {name: "MAC地址", data: "11:22:33:44:55:66"},
                ],
            }
        },
        methods: {
            /**
             * 抽屉是否打开
             */
            isDrawerOpen: function () {
                this.isSettingsOpen = true
            }
        },
        computed: {
            /**
             * 切换图标
             */
            stateImg: function () {
                if (this.isActive == true) {
                    return on
                } else if (this.isError == true) {
                    return error
                } else {
                    return off
                }
            },

            /**
             * 切换提示
             * @returns {string} 提示
             */
            tip: function () {
                if (this.isActive == true) {
                    return "已启动"
                } else if (this.isError == true) {
                    return "故障"
                } else {
                    return "已关闭"
                }
            },

            /**
             * 获得设置项列表
             * @returns {*} 设置项列表
             */
            settingsList: function () {
                return settingsMenu.data().settingsList
            },

            /**
             * 是否展示开关
             * @returns {*|boolean} 是否展示
             */
            isShow: function () {
                return this.isActive && !this.isError
            },
        },
    }
</script>

<style scoped>
    .moduleList{
        padding-left:20px;
        padding-right: 20px;
    }

    .moduleItem {
        width: 10%;
        float: left;
    }

    .moduleItem img {
        width: 100%;
    }

    .infoItem {
        color: #565656;
        font-size: 14px;
        padding-left: 20px;
    }

    .moduleDesc{
        color: #565656;
        font-size: 14px;
        font-weight: bold;
        text-align: center;
    }

    .deviceState {
        width: 100%;
    }

    .deviceSwitch {
        float: right;
    }

    .deviceName {
        font-size: larger;
        font-weight: bold;
    }

    .settingsImg {
        float: right;
    }

    .settingsImg i {
        font-size: large;
    }
</style>
