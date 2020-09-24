<template>
  <div>
    <el-button type="text" @click="open">{{NoticeTitle}}</el-button>
    <el-divider />
  </div>
</template>

<script>
export default {
  name: 'Notice',
  data() {
    return {
    }
  },
  props: {
    NoticeTitle: {
      type: String,
      default: '未获取到公告标题'
    },
    NoticeContent: {
      type: String,
      default: '未获取到公告内容'
    }
  },
  methods: {
    open() {
      this.$confirm(this.NoticeContent, this.NoticeTitle, {
        confirmButtonText: '确定',
        showCancelButton: false,
        type: 'info',
        center: true
      }).then(() => {
      }).catch(() => {
      })
    }
  }
}
</script>

<style scoped>

</style>
