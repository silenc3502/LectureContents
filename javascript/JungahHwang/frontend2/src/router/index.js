import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    // path: 실제 url 맵핑 경로
    path: '/test',
    // 보편적으로 name과 component는 같은 이름을 사용,
    // 눈에 보여질 페이지가 배치(보통 views 폴더에 생성)
    name: 'Test',
    component: Test
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
