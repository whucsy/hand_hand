import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserInfo from "../components/UserInfo";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/userInfo',//和router-link to相呼应，导航到/userInfo
      name: 'UserInfo',
      component: UserInfo
    }
  ]
})
