<!--
 * @FileDescription: 设备管理页面
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-main class="equipments">
        <el-row :gutter="20">
            <el-col :xs="24" :span="8"
                    v-for="(item,i) in deviceList"
                    :key="i">
                <device-board
                        :title="item.name"
                        :isActive="item.isActive"
                        :isError="item.isError">
                </device-board>
            </el-col>
        </el-row>
    </el-main>
</template>

<script>
    import deviceBoard from '../components/boards/device-board.vue'

    export default {
        name: "equipment",
        components:{
            deviceBoard,
        },
        data(){
            return {
                // 设备集
                deviceList:[
                    {name:"1号棚",isActive:true,isError:false,},
                    {name:"2号棚",isActive:true,isError:false,},
                    {name:"3号棚",isActive:true,isError:false,},
                    {name:"4号棚",isActive:true,isError:false,},
                    {name:"5号棚",isActive:true,isError:false,},
                    {name:"6号棚",isActive:true,isError:false,},
                    {name:"7号棚",isActive:true,isError:false,},
                    {name:"8号棚",isActive:false,isError:true,},
                    {name:"森林区",isActive:false,isError:false,},
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
