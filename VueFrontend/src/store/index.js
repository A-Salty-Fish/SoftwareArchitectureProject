import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import app from './modules/app'
import settings from './modules/settings'
import user from './modules/user'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    rootHeadUrl: 'http://localhost:8080/',
    userHeadUrl: 'http://localhost:8080/user/',
    foodHeadUrl: 'http://localhost:8080/food/',
    canteenHeadUrl: 'http://localhost:8080/canteen/',
    commentHeadUrl: 'http://localhost:8080/comment/'
  },
  modules: {
    app,
    settings,
    user
  },
  getters
})

export default store
