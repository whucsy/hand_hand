<template>
<div>
<!--    //导航栏-->
    <el-menu :default-active="this.$route.path" class="el-menu-demo" router mode="horizontal" @select="handleSelect" >
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="3" disabled>消息中心</el-menu-item>
      <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
    </el-menu>


  <el-container style="width: 1000px; border: 1px solid rgba(211,211,211,0.09);margin-left: 200px;">
      <el-main>
        <el-tabs :tab-position="tabPosition" style="height: 200px;" head="个人中心">
          <el-tab-pane label="用户管理">用户管理</el-tab-pane>
          <el-tab-pane label="配置管理">配置管理</el-tab-pane>
          <el-tab-pane label="角色管理">角色管理</el-tab-pane>
          <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
        </el-tabs>
      </el-main>
  </el-container>

</div>
</template>

<script>
    export default {
        name: "UserInfo",
      data() {
        return {
          activeIndex: '1',
          tabPosition:'left'
        };
      },

      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }



</script>

<style scoped>
</style>
