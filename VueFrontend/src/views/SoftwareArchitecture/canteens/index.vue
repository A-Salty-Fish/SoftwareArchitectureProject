<template>
  <div>
    <el-dialog
      title="警告"
      :visible.sync="InvalidInputDialogVisible"
      width="30%"
      :show-close="false"
    >
      <span>输入无效</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="InvalidInputDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="修改"
      :visible.sync="UpdatedialogVisible"
      width="30%"
    >
      <el-form :model="upDateData" :inline="true">
        <el-form-item label="序号">
          <el-input v-model="upDateData.id" :disabled="true" size="small" />
        </el-form-item>
        <el-form-item label="食堂名">
          <el-input v-model="upDateData.name" size="small" placeholder="菜名" />
        </el-form-item>
        <el-form-item label="位置">
          <el-select v-model="upDateData.position" size="small" placeholder="位置">
            <el-option v-for="(item, index) in positions" :key="index" :label="item" :value="item" />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="commitEdit">确 定</el-button>
      </span>
    </el-dialog>
    <el-divider />
    <el-row>
      <el-col :span="10"><br></el-col>
      <el-col :span="14">
        <el-form :inline="true" :model="addData">
          <el-form-item label="食堂名">
            <el-input v-model="addData.name" size="small" placeholder="食堂名" />
          </el-form-item>
          <el-form-item label="位置">
            <el-select v-model="addData.position" size="small" placeholder="位置">
              <el-option label="" value="" />
              <el-option label="信息学部" value="信息学部" />
              <el-option label="文理学部" value="文理学部" />
              <el-option label="工学部" value="工学部" />
              <el-option label="医学部" value="医学部" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="success" size="mini" @click="AddCanteen">添加</el-button>
            <el-button type="primary" size="mini" @click="Search">搜索</el-button>
            <el-button type="plain" size="mini" @click="getAllCanteen">刷新</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
    <el-table
      id="TableTop"
      :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
      style="width: 100%"
      @sort-change="SortById"
    >
      <el-table-column
        align="center"
        prop="id"
        label="编号"
        sortable="custom"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="食堂名"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="位置"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.position }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="操作"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="warning"
            @click="handleEdit(scope.row.id, scope.row)"
          >编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id, scope.row)"
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
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Index',
  data() {
    return {
      currentPage: 1,
      pageSize: 6,
      tableData: [],
      allData: [],
      InvalidInputDialogVisible: false,
      UpdatedialogVisible: false,
      positions: ['', '信息学部', '文理学部', '工学部', '医学部'],
      addData: {
        'id': -1,
        'name': '',
        'position': ''
      },
      upDateData: {
        'id': -1,
        'name': '',
        'position': ''
      },
      sortState: 0
    }
  },
  created() {
    var that = this
    that.getAllCanteen()
  },
  methods: {
    getAllCanteen() {
      var that = this
      axios.get('http://localhost:8080/canteen/GetAllCanteen').then(function(response) {
        that.allData = response.data
        that.tableData = response.data
        console.log(that.canteens)
      }).catch(function(error) {
        console.log(error)
      })
    },
    deleteCanteenById(id) {
      axios.delete('http://localhost:8080/canteen/DeleteCanteenById/' + id).then(function(response) {
        console.log(response.data)
      }).catch(function(error) {
        console.log(error)
      })
    },
    addCanteen() {
      var that = this
      axios({
        method: 'post',
        url: 'http://localhost:8080/canteen/AddCanteen',
        data: {
          'id': that.addData.id,
          'name': that.addData.name,
          'position': that.addData.position
        },
        transformRequest: [
          function(data) {
            let ret = ''
            for (const it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            ret = ret.substring(0, ret.lastIndexOf('&'))
            return ret
          }
        ],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }).then(function(response) {
        that.getAllCanteen()
      })
    },
    updateCanteen() {
      var that = this
      axios({
        method: 'post',
        url: 'http://localhost:8080/canteen/UpdateCanteen',
        data: {
          'id': that.upDateData.id,
          'name': that.upDateData.name,
          'position': that.upDateData.position
        },
        transformRequest: [
          function(data) {
            let ret = ''
            for (const it in data) {
              ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            ret = ret.substring(0, ret.lastIndexOf('&'))
            return ret
          }
        ],
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }).then(function(response) {
        that.getAllCanteen()
      })
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      location.href = '#TableTop'
    },
    IndexOfId(id) {
      var index = -1
      for (var i = 0; i < this.tableData.length; i++) {
        if (this.tableData[i].id === id) {
          index = i
        }
      }
      return index
    },
    handleDelete(id, row) {
      var index = this.IndexOfId(id)
      console.log('index:' + index)
      this.tableData.splice(index, 1)
      if (this.tableData.length % this.pageSize === 0) {
        this.currentPage--
      }
      console.log('id:' + id)
      this.deleteCanteenById(id)
    },
    handleEdit(id, row) {
      this.UpdatedialogVisible = true
      var index = this.IndexOfId(id)
      this.upDateData = JSON.parse(JSON.stringify(this.tableData[index]))
    },
    commitEdit() {
      this.updateCanteen()
      this.UpdatedialogVisible = false
    },
    AddCanteen() {
      var that = this
      if (that.addData.name === '' || that.addData.position === '') {
        that.InvalidInputDialogVisible = true
        return
      }
      console.log(that.addData)
      that.addCanteen()
    },
    Search() {
      var that = this
      that.currentPage = 1
      that.tableData = that.allData.filter(item => {
        return item.name.includes(that.addData.name) && item.position.includes((that.addData.position))
      })
      console.log(that.tableData)
    },
    SortById() {
      this.sortState = (this.sortState + 1) % 3
      if (this.sortState === 1) {
        this.tableData.reverse()
      } else if (this.sortState === 2) {
        this.tableData.reverse()
      }
      console.log(this.sortState)
    }
  }
}
</script>

<style scoped>
</style>
