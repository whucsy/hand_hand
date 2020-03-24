import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserInfo from "../components/UserInfo";

Vue.use(Router)

export default new Router({
  // routes: [
  //   {
  //     path: '/',
  //     name: 'HelloWorld',
  //     component: HelloWorld
  //   },
  //   {
  //     path: '/UserInfo',//和router-link to相呼应，导航到/userInfo
  //     name: 'UserInfo',
  //     component: UserInfo
  //   }
  // ]
  routes: [{
    path: '/',
    name: 'HelloWorld',
    component:HelloWorld
  }, {
    path: '/components/HelloWorld',
    name: 'HelloWorld',
    component: HelloWorld
  },
    {
    path: '/components/UserInfo',
    name: 'UserInfo',
    component: UserInfo
  },
    // {
  //   path: '/personalCenter',
  //   name: 'personalCenter',
  //   component: personalCenter
  // }, {
  //   path: '/manageCenter',
  //   name: 'manageCenter',
  //   component: manageCenter
  // }
  ]
})
