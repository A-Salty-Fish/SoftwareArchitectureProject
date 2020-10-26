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
        <el-form-item label="评论">
          <el-input v-model="upDateData.content" size="small" placeholder="评论" />
        </el-form-item>
        <el-form-item label="用户id">
          <el-input v-model="upDateData.user_id" size="small" placeholder="用户id" />
        </el-form-item>
        <el-form-item label="菜名">
          <el-input v-model="upDateData.food_name" size="small" placeholder="菜名" />
        </el-form-item>
        <el-form-item label="食堂">
          <el-select v-model="upDateData.canteen" size="small" placeholder="权限">
            <el-option v-for="(item, index) in canteens" :key="index" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="评星">
          <el-select v-model="upDateData.stars" size="small">
            <el-option v-for="(item, index) in starsArr" :key="index" :label="item" :value="item" />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="commitEdit">确 定</el-button>
      </span>
    </el-dialog>
    <el-divider />
    <el-row>
      <el-col :span="1"><br></el-col>
      <el-col :span="23">
        <el-form :inline="true" :model="addData">
          <el-form-item label="菜名">
            <el-input v-model="addData.food_name" size="small" placeholder="菜名" />
          </el-form-item>
          <el-form-item label="食堂">
            <el-select v-model="addData.canteen" size="small" placeholder="">
              <el-option v-for="(item, index) in canteens" :key="index" :label="item" :value="item" />
            </el-select>
          </el-form-item>
          <el-form-item label="评论">
            <el-input v-model="addData.content" size="small" placeholder="评论" />
          </el-form-item>
          <el-form-item label="评星">
            <el-select v-model="addData.stars" size="small" placeholder="">
              <el-option v-for="(item, index) in starsArr" :key="index" :label="item" :value="item" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="success" size="mini" @click="AddComment">添加</el-button>
            <el-button type="primary" size="mini" @click="Search">搜索</el-button>
            <el-button type="plain" size="mini" @click="getAllComment">刷新</el-button>
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
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="编号">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="评价内容">
              <span>{{ props.row.content }}</span>
            </el-form-item>
            <el-form-item label="用户id">
              <span>{{ props.row.user_id }}</span>
            </el-form-item>
            <el-form-item label="菜名">
              <span>{{ props.row.food_name }}</span>
            </el-form-item>
            <el-form-item label="食堂">
              <span>{{ props.row.canteen }}</span>
            </el-form-item>
            <el-form-item label="评星">
              <span>{{ props.row.stars }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
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
        label="菜名"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.food_name }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="评星"
      >
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.stars }}</span>
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
      canteens: [],
      starsArr: ['', 1, 2, 3, 4, 5],
      addData: {
        'id': 0,
        'content': '',
        'user_id': 0,
        'food_name': '',
        'canteen': '',
        'stars': 0
      },
      upDateData: {
        'id': 0,
        'content': '',
        'user_id': 0,
        'food_name': '',
        'canteen': '',
        'stars': 0
      },
      sortState: 0
    }
  },
  created() {
    var that = this
    that.getAllComment()
    that.getAllCanteen()
  },
  methods: {
    getAllComment() {
      var that = this
      axios.get('http://localhost:8080/comment/GetAllComment').then(function(response) {
        that.allData = response.data
        that.tableData = response.data
        console.log(that.allData)
      }).catch(function(error) {
        console.log(error)
      })
    },
    getAllCanteen() {
      var that = this
      axios.get('http://localhost:8080/canteen/GetAllCanteen').then(function(response) {
        that.canteens = response.data
        that.canteens.unshift({
          'name': ''
        })
        console.log(that.canteens)
      }).catch(function(error) {
        console.log(error)
      })
    },
    deleteCommentById(id) {
      axios.delete('http://localhost:8080/comment/DeleteCommentById/' + id).then(function(response) {
        console.log(response.data)
      }).catch(function(error) {
        console.log(error)
      })
    },
    addComment() {
      var that = this
      axios({
        method: 'post',
        url: 'http://localhost:8080/comment/AddComment',
        data: {
          'id': that.addData.id,
          'content': that.addData.content,
          'user_id': that.addData.user_id,
          'food_name': that.addData.food_name,
          'canteen': that.addData.canteen,
          'stars': that.addData.stars
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
        that.getAllComment()
      })
    },
    updateComment() {
      var that = this
      axios({
        method: 'post',
        url: 'http://localhost:8080/comment/UpdateComment',
        data: {
          'id': that.upDateData.id,
          'content': that.upDateData.content,
          'user_id': that.upDateData.user_id,
          'food_name': that.upDateData.food_name,
          'canteen': that.upDateData.canteen,
          'stars': that.upDateData.stars
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
        that.getAllComment()
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
      this.deleteCommentById(id)
    },
    handleEdit(id, row) {
      var index = this.IndexOfId(id)
      this.upDateData.id = this.tableData[index].id
      this.upDateData.content = this.tableData[index].content
      this.upDateData.user_id = this.tableData[index].user_id
      this.upDateData.food_name = this.tableData[index].food_name
      this.upDateData.canteen = this.tableData[index].canteen
      this.upDateData.stars = this.tableData[index].stars
      this.UpdatedialogVisible = true
      console.log(this.upDateData)
    },
    commitEdit() {
      this.updateComment()
      this.UpdatedialogVisible = false
    },
    AddComment() {
      var that = this
      if (that.addData.name === '' || that.addData.author_level === '') {
        that.InvalidInputDialogVisible = true
        return
      }
      console.log(that.addData)
      that.addComment()
    },
    Search() {
      var that = this
      that.currentPage = 1
      that.tableData = that.allData.filter(item => {
        console.log(item.author_level)
        console.log(item.author_level)
        return item.name.includes(that.addData.name) && item.author_level === that.addData.author_level
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
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>
