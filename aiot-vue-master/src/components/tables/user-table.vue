<!--
 * @FileDescription: 用户表组件
 * @Author: 范承祥
 * @Date: 2019/02/17
 * @LastEditors: 范承祥
 * @LastEditTime: 2020/07/31
 -->
<template>
    <el-card shadow="always">
        <el-row :gutter="20">
            <el-col :span="11" :offset="1">
                <el-input>

                </el-input>
            </el-col>
            <el-col :span="12">
                <div class="search">
                    <el-button type="primary"
                               icon="el-icon-search">
                        {{selectDesc}}
                    </el-button>
                </div>
            </el-col>
        </el-row>
        <el-table
                stripe
                :data="userTable.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                :size="fontSize"
                :fit=true
                :show-header="isShowLabel"
                :tooltip-effect="tooltipTheme">
            <el-table-column
                    v-for="(item,i) in labelList.slice(0,3)"
                    :fixed="item.isFixed"
                    :key="i"
                    :prop="item.data"
                    :label="item.label"
                    :sortable="isSortable"
                    :show-overflow-tooltip="isShowTip"
                    align="center">
            </el-table-column>
            <el-table-column :prop="labelList[3].data"
                             :label="labelList[3].label"
                             :sortable="isSortable"
                             :show-overflow-tooltip="isShowTip"
                             align="center">
                <template slot-scope="scope">
                    <el-tag :type="tagType(scope.row.rank)"
                            :size="tagSize">
                        {{scope.row.rank}}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column :prop="labelList[4].data"
                             :label="labelList[4].label"
                             :sortable="isSortable"
                             :show-overflow-tooltip="isShowTip"
                             align="center">
                <template slot-scope="scope">
                    <el-button
                            :size="buttonSize"
                            type="text"
                            @click="handleEdit(scope.$index)">
                        {{editDesc}}
                    </el-button>
<!--                    <el-button-->
<!--                            :size="buttonSize"-->
<!--                            type="text"-->
<!--                            @click.native.prevent="deleteRow(scope.$index, userTable)">-->
<!--                        {{deleteDesc}}-->
<!--                    </el-button>-->
                </template>
            </el-table-column>
        </el-table>
        <div class="pagination">
            <el-row>
                <el-col class="hidden-xs-only">
                    <el-pagination
                            :hide-on-single-page="isHide"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="userTable.length"
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
                            :total="userTable.length"
                            :page-size="pageSize"
                            :current-page.sync="currentPage"
                            @current-change="handleCurrentChange">
                    </el-pagination>
                </el-col>
            </el-row>
        </div>
        <el-row>
            <el-col>
                <el-drawer :size="drawerSize"
                           :visible.sync="isDrawerOpen">
                    <div class="drawerMenu">
                        <userForm :user="currentUser"></userForm>
                    </div>
                </el-drawer>
            </el-col>
        </el-row>
    </el-card>
</template>

<script>
    import UserForm from "../menus/user-form-menu";
    export default {
        name: "user-table",
        components: {UserForm},
        data(){
            return{
                // 用户集
                userTable:[
                    {name: "Francis", rank: "超级管理员", phone: "13888888888", email: "Francis@aiot.com", password: "88888888"},
                    {name: "Tony", rank: "管理员", phone: "13812347892", email: "Tony@aiot.com", password: "88888888"},
                    {name: "Mary", rank: "管理员", phone: "13814738928", email: "Mary@aiot.com", password: "88888888"},
                    {name: "John", rank: "监督员", phone: "13810283938", email: "John@aiot.com", password: "88888888"},
                    {name: "Mike", rank: "监督员", phone: "13384739288", email: "Mike@aiot.com", password: "88888888"},
                    {name: "Amy", rank: "监督员", phone: "13810283938", email: "Amy@aiot.com", password: "88888888"},
                    {name: "Adele", rank: "监督员", phone: "13383739288", email: "Adele@aiot.com", password: "88888888"}],

                // 标签集
                labelList: [
                    {label: "用户名", data: "name", isFixed: true},
                    {label: "联系电话", data: "phone", isFixed: false},
                    {label: "电子邮箱", data: "email", isFixed: false},
                    {label: "等级", data: "rank", isFixed: false},
                    {label: "操作", data: "edit", isFixed: true},],

                // 搜索提示
                selectDesc:"搜索",

                // 是否展示标签
                isShowLabel: true,

                // 是否可排序
                isSortable:false,

                // 字体大小
                fontSize: "medium",

                // 当前页面
                currentPage: 1,

                // 页面大小
                pageSize: 10,

                // 是否隐藏多余项
                isHide: false,

                // 是否显示提示
                isShowTip:false,

                // 提示主题
                tooltipTheme:"dark",

                // 提示大小
                tagSize: "medium",

                // 按钮大小
                buttonSize:"medium",

                // 修改提示
                editDesc:"修改",

                // 移除提示
                deleteDesc:"移除",

                // 当前用户
                currentUser:null,

                // 是否打开抽屉
                isDrawerOpen:false,

                // 用户信息
                titleDesc:"用户信息",

                // 抽屉大小
                drawerSize:"330px",
            }
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

            /**
             * 用户标签转换
             * @param rank 用户等级
             */
            tagType: function (rank) {
                switch (rank) {
                    case "超级管理员":
                        return ""
                    case "管理员":
                        return "success"
                    case "监督员":
                        return "warning"
                    default:
                        return "info"
                }
            },

            /**
             * 处理编辑用户信息
             * @param index 用户索引
             */
            handleEdit:function(index){
                this.currentUser=this.userTable[index]
                this.isDrawerOpen=true
            },

            /**
             * 删除用户
             * @param index 用户索引
             * @param rows 删除行数
             */
            deleteRow(index, rows) {
                rows.splice(index, 1);
            },

            /**
             * 处理菜单关闭
             */
            handleClose() {
            }
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
    .el-icon-edit{
    }
    .el-icon-close{
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
