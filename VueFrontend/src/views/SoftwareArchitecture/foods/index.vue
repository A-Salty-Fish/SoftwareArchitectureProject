<template>
  <div>
    <el-divider />
    <el-row>
      <el-col :span="12"><br></el-col>
      <el-col :span="12">
        <el-form :inline="true" :model="addData" class="demo-form-inline">
          <el-form-item label="菜名">
            <el-input v-model="addData.name" placeholder="菜名" />
          </el-form-item>
          <el-form-item label="食堂">
            <el-select v-model="addData.canteen" placeholder="食堂">
              <el-option v-for="(item) in canteens" :key="item.id" :label="item.name" :value="item.name" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="success" @click="AddFood">添加</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-table
      id="TableTop"
      :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
      style="width: 100%"
    >
      <el-table-column
        align="center"
        label="序号"
      >
        <template slot-scope="scope">
          <i class="el-icon-s-flag" />
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="菜名"
      >
        <template slot-scope="scope">
          <i class="el-icon-food" />
          <span style="margin-left: 10px">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="食堂"
      >
        <template slot-scope="scope">
          <i class="el-icon-s-shop" />
          <span style="margin-left: 10px">{{ scope.row.canteen }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="操作"
      >
        <template slot-scope="scope">
          <!--          <el-button-->
          <!--            size="mini"-->
          <!--            type="primary"-->
          <!--            @click="handleRead(scope.$index, scope.row)">查看</el-button>-->
          <el-button
            size="mini"
            type="warning"
            @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleEdit(scope.$index, scope.row)"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: center;margin-top: 30px;">
      <el-pagination
        :current-page="currentPage"
        :page-size="pageSize"
        :pager-count="5"
        layout="total, pager"
        :total="tableData.length"
        @current-change="handleCurrentChange"
      />
    </div>
    <!--    <el-dialog-->
    <!--      title="详细信息"-->
    <!--      :visible.sync="dialogVisible"-->
    <!--      :before-close="handleClose">-->
    <!--      <span>{{}}</span>-->
    <!--      <span slot="footer" class="dialog-footer">-->
    <!--    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
    <!--  </span>-->
    <!--    </el-dialog>-->
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Index',
  data() {
    return {
      currentPage: 1,
      pageSize: 12,
      tableData: [],
      canteens: [],
      dialogVisible: false,
      addData: {
        id: 0,
        name: '',
        canteen: ''
      }
    }
  },
  created() {
    var that = this
    axios.get('http://localhost:8080/food/GetAllFood').then(function(response) {
      that.tableData = response.data
      console.log(that.tableData)
    }).catch(function(error) {
      console.log(error)
    })
    axios.get('http://localhost:8080/canteen/GetAllCanteen').then(function(response) {
      that.canteens = response.data
      console.log(that.canteens)
    }).catch(function(error) {
      console.log(error)
    })
  },
  methods: {
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      location.href = '#TableTop'
    },
    // handleRead(index, row) {
    //   console.log('Read ' + 'index:' + index + 'row:' + row)
    //   this.dialogVisible = true
    // },
    handleEdit(index, row) {
      console.log('Edit ' + 'index:' + index + 'row:' + row)
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    AddFood() {
      console.log(this.addData)
    }
  }
}
</script>

<style scoped>

</style>
