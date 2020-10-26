<template>
  <div>
    <el-divider />
    <el-row>
      <el-col :span="10"><br></el-col>
      <el-col :span="14">
        <el-form :inline="true" :model="addData">
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
            <el-button type="primary" @click="SearchFood">搜索</el-button>
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
        label="编号"
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
      canteens: [],
      dialogVisible: false,
      addData: {
        'id': 0,
        'name': '',
        'canteen': '',
        'img_url': ''
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
    handleEdit(index, row) {
      console.log('Edit ' + 'index:' + index + 'row:' + row)
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
      console.log('id:' + id)
      axios.delete('http://localhost:8080/food/DeleteFoodById/' + id).then(function(response) {
        console.log(response.data)
      }).catch(function(error) {
        console.log(error)
      })
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    AddFood() {
      var that = this
      console.log(that.addData)
      axios({
        method: 'post',
        url: 'http://localhost:8080/food/AddFood',
        data: {
          'id': that.addData.id,
          'name': that.addData.name,
          'canteen': that.addData.canteen,
          'img_url': that.addData.img_url
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
        axios.get('http://localhost:8080/food/GetAllFood').then(function(response) {
          // console.log(response.data)
          that.tableData.push(response.data[response.data.length - 1])
        }).catch(function(error) {
          console.log(error)
        })
      })
    },
    SearchFood() {
      var that = this
      console.log(that.searchData.name + that.searchData.canteen)
    }
  }
}
</script>

<style scoped>

</style>
