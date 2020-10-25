<template>
  <div class="dashboard-container">
    <div class="dashboard-text">name: {{ resres }}</div>
    <el-button type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="TestClick()">Login</el-button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import axios from 'axios'

export default {
  name: 'Dashboard',
  data() {
    return {
      resres: 'no data'
    }
  },
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  methods: {
    TestClick() {
      axios.get('http://localhost:8080/canteen/GetCanteenByName/食堂').then(function(response) {
        console.log(response.data)
      })
        .catch(function(error) {
          console.log(error)
        })
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
