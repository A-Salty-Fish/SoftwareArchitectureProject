<template>
  <div>
    <el-row>
      <el-col :span="22"><br></el-col>
      <el-col :span="1">
        <el-button
          style="alignment: center"
          size="mini"
          type="success"
        >添加</el-button>
      </el-col>
    </el-row>
    <el-table
      id="TableTop"
      :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
      style="width: 100%">
      <el-table-column
        align='center'
        label="添加日期"
      >
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column
        align='center'
        prop="title"
        label="器材名"
      >
      </el-table-column>
      <el-table-column
        align='center'
        label="操作"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="handleRead(scope.$index, scope.row)">查看</el-button>
          <el-button
            size="mini"
            type="warning"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleEdit(scope.$index, scope.row)">删除</el-button>
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
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      :before-close="handleClose">
      <span>这是一段器材信息</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'Index',
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      tableData: [],
      dialogVisible: false
    }
  },
  created() {
    var that = this
    for (var i = 0; i < 147; i++) {
      that.tableData[i] = {
        date: '日期' + i,
        title: '器材' + i
      }
    }
  },
  methods: {
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      location.href = '#TableTop'
    },
    handleRead(index, row) {
      console.log('Read ' + 'index:' + index + 'row:' + row)
      this.dialogVisible = true
    },
    handleEdit(index, row) {
      console.log('Edit ' + 'index:' + index + 'row:' + row)
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    }
  }
}
</script>

<style scoped>

</style>
