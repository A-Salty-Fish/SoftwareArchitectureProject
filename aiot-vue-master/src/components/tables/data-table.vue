<!--
 * @FileDescription: 数据表组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <div class="table">
        <el-card shadow="always">
            <el-row class="hidden-xs-only"
                    :gutter="20">
                <el-col :span="10">
                    <div class="picker">
                        <el-date-picker
                                v-model="dateTimeValue"
                                type="datetimerange"
                                :picker-options="pickerOptions"
                                :range-separator="rangeDesc"
                                :start-placeholder="startDesc"
                                :end-placeholder="endDesc"
                                size="large">
                        </el-date-picker>
                    </div>
                </el-col>
                <el-col :span="7">
                    <div class="search">
                        <el-button type="primary"
                                   icon="el-icon-search">
                            {{selectDesc}}
                        </el-button>
                    </div>
                </el-col>
                <el-col :span="7">
                    <div class="export">
                        <el-button icon="el-icon-download">
                            {{exportDesc}}
                        </el-button>
                    </div>
                </el-col>
            </el-row>
            <el-row class="hidden-sm-and-up">
                <el-col :span="24">
                    <div class="picker">
                        <el-date-picker
                                v-model="dateTimeValue"
                                type="datetime"
                                :placeholder="placeholderDesc"
                                size="large">
                        </el-date-picker>
                    </div>
                </el-col>
                    <el-col :span="12">
                        <div class="search">
                            <el-button type="primary"
                                       icon="el-icon-search">
                            </el-button>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div class="export">
                            <el-button icon="el-icon-download">
                            </el-button>
                        </div>
                    </el-col>
            </el-row>
            <el-table
                    stripe
                    :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                    :size="fontSize"
                    :fit=true
                    :show-header="isShowLabel"
                    :tooltip-effect="tooltipTheme">
                <el-table-column
                        v-for="(item,i) in labelList"
                        :fixed="item.isFixed"
                        :key="i"
                        :prop="item.data"
                        :label="item.label"
                        :sortable="isSortable"
                        :show-overflow-tooltip="isShowTip"
                        align="center">
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-row>
                    <el-col class="hidden-xs-only">
                        <el-pagination
                                :hide-on-single-page="isHide"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="tableData.length"
                                :page-sizes="[10, 20, 50, 100]"
                                :page-size="pageSize"
                                :current-page.sync="currentPage"
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange">
                        </el-pagination>
                    </el-col>
                    <el-col class="hidden-sm-and-up">
                        <el-pagination
                                small
                                :hide-on-single-page="isHide"
                                layout="prev, pager, next"
                                :total="tableData.length"
                                :page-size="pageSize"
                                :current-page.sync="currentPage"
                                @current-change="handleCurrentChange">
                        </el-pagination>
                    </el-col>
                </el-row>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "table-view",
        data() {
            return {
                // 日期时间选择题选项
                pickerOptions: {
                    shortcuts: [{
                        text: '最近一周',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近一个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近三个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },

                // 日期时间选择器默认值
                dateTimeValue:"",

                // 日期时间选择器占位符
                placeholderDesc:"选择时间日期",

                // 范围提示
                rangeDesc:"至",

                // 开始时间提示
                startDesc:"起始时间",

                // 结束时间提示
                endDesc:"结束时间",

                // 查询提示
                selectDesc:"查询",

                // 导出提示
                exportDesc:"导出",

                // 数据集
                tableData: [
                    {name: "1号棚", date:"2020-02-06 22:59",light:"12.0",co2:"101.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {name: "2号棚", date:"2020-02-06 21:59",light:"13.0",co2:"102.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {name: "3号棚", date:"2020-02-06 20:59",light:"14.0",co2:"103.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {name: "4号棚", date:"2020-02-06 19:59",light:"15.0",co2:"105.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {name: "5号棚", date:"2020-02-06 18:59",light:"15.0",co2:"106.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {name: "6号棚", date:"2020-02-06 17:59",light:"15.0",co2:"102.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {name: "7号棚", date:"2020-02-06 16:59",light:"12.0",co2:"102.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {name: "1号棚", date:"2020-02-17 15:59",light:"14.0",co2:"103.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {name: "2号棚", date:"2020-02-17 14:59",light:"17.0",co2:"105.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {name: "3号棚", date:"2020-02-17 13:59",light:"18.0",co2:"107.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {name: "4号棚", date:"2020-02-17 12:59",light:"19.0",co2:"109.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {name: "5号棚", date:"2020-02-17 11:59",light:"11.0",co2:"109.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {name: "6号棚", date:"2020-02-17 10:59",light:"14.0",co2:"110.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {name: "7号棚", date:"2020-02-17 09:59",light:"16.0",co2:"111.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {name: "1号棚", date:"2020-02-18 08:59",light:"18.0",co2:"112.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {name: "2号棚", date:"2020-02-18 07:59",light:"19.0",co2:"120.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {name: "3号棚", date:"2020-02-18 06:59",light:"13.0",co2:"122.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {name: "4号棚", date:"2020-02-18 05:59",light:"14.0",co2:"133.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {name: "5号棚", date:"2020-02-18 04:59",light:"16.0",co2:"112.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {name: "6号棚", date:"2020-02-18 03:59",light:"16.0",co2:"110.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {name: "7号棚", date:"2020-02-18 02:59",light:"17.0",co2:"104.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"},
                    {name: "1号棚", date:"2020-02-18 01:59",light:"17.0",co2:"105.0",soilMoisture: "10.0",soilPressure:"12.0",soilPh:"7.0",soilTemperature:"18.0"},
                    {name: "2号棚", date:"2020-02-18 00:59",light:"18.0",co2:"106.0",soilMoisture: "12.0",soilPressure:"13.0",soilPh:"7.0",soilTemperature:"19.0"},
                    {name: "3号棚", date:"2020-02-18 22:59",light:"19.0",co2:"101.0",soilMoisture: "14.0",soilPressure:"14.0",soilPh:"6.8",soilTemperature:"17.0"},
                    {name: "4号棚", date:"2020-02-18 23:59",light:"17.0",co2:"109.0",soilMoisture: "9.0",soilPressure:"12.0",soilPh:"7.1",soilTemperature:"15.0"},
                    {name: "5号棚", date:"2020-02-18 21:59",light:"16.0",co2:"101.0",soilMoisture: "11.0",soilPressure:"15.0",soilPh:"6.9",soilTemperature:"21.0"},
                    {name: "6号棚", date:"2020-02-18 20:59",light:"17.0",co2:"103.0",soilMoisture: "8.0",soilPressure:"11.0",soilPh:"7.3",soilTemperature:"16.0"},
                    {name: "7号棚", date:"2020-02-18 19:59",light:"18.0",co2:"104.0",soilMoisture: "10.5",soilPressure:"10.0",soilPh:"7.1",soilTemperature:"14.0"}],

                // 是否展示标签
                isShowLabel: true,

                // 是否可排序
                isSortable:false,

                // 标签集
                labelList: [
                    {label: "区域", data: "name", isFixed: true},
                    {label: "采样时间", data: "date", isFixed: true},
                    {label: "光照强度（lux）", data: "light", isFixed: false},
                    {label: "CO2浓度（ppm）", data: "co2", isFixed: false},
                    {label: "空气温度（℃）", data: "soilTemperature", isFixed: false},
                    {label: "土壤湿度（%）", data: "soilMoisture", isFixed: false},
                    {label: "土壤压力（N）", data: "soilPressure", isFixed: false},
                    {label: "土壤PH（1）", data: "soilPh", isFixed: false}],

                // 字体大小
                fontSize: "medium",

                // 当前页码
                currentPage: 1,

                // 页面大小
                pageSize: 10,

                // 是否隐藏多余列
                isHide: false,

                // 排序规则
                sortRules:{prop: 'date', order: 'descending'},

                // 是否展示提示
                isShowTip:false,

                // 提示主题
                tooltipTheme:"dark",
            }
        },
        mounted: function () {

        },
        methods: {
            /**
             * 处理页面大小变化
             * @param pageSize 页面大小
             */
            handleSizeChange: function (pageSize) {
                this.pageSize = pageSize
            },

            /**
             * 处理当前页面变化
             * @param currentPage 当前页面
             */
            handleCurrentChange: function (currentPage) {
                this.currentPage = currentPage
            },
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
    .picker{
        text-align: center;
    }

    .search{
        text-align: left;
    }

    .export{
        text-align: right;
    }

    .pagination {
        padding-top: 20px;
        text-align: center;
    }
</style>
