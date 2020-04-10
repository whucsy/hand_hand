import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import UserInfo from "../components/UserInfo";
import Manager from "../components/Manager";
import PostMission from "../components/PostMission";
import searchResult from "../components/searchResult";
Vue.use(Router);

export default new Router({
  routes: [
    {
    path: '/',
    name: 'HelloWorld',
    component:HelloWorld
  },
    {
    path: '/components/HelloWorld',
    name: 'HelloWorld',
    component: HelloWorld
  },
    {
      //个人中心
    path: '/components/UserInfo',
    name: 'UserInfo',
    component: UserInfo
  },
  //   {
  //   path: '/components/CountInfo',
  //   name: 'CountInfo',
  //   component: CountInfo
  // },
  //   {
  //   path: '/components/EditInfo',
  //   name: 'EditInfo',
  //   component: EditInfo
  // },
  {
    //管理员中心
    path: '/components/Manager',
    name: 'Manager',
    component: Manager
  }
  //   path: '/manageCenter',
  //   name: 'manageCenter',
  //   component: manageCenter
  // }
    ,
    {
      //发布任务
      path: '/components/PostMission',
      name: 'PostMission',
      component: PostMission
    }
    ,
    {
      //搜索结果
      // path: '/components/searchResult',
      path: '/components/searchResult/:input',
      name: 'searchResult',
      component: searchResult
    }
  ]
})
