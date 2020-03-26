<template>
<div>
  <el-container style="width: 70%; border: 1px solid rgba(211,211,211,0.09);margin-left: 15%;height: 100%;margin-top: 10px">
      <el-main>
        <el-tabs :tab-position="tabPosition" style="height: 100%;" v-model="activeName" type="card" @tab-click="handleClick">
          <el-tab-pane label="账号资料" name="countInfo" ><CountInfo></CountInfo></el-tab-pane>
          <el-tab-pane label="我的任务">配置管理</el-tab-pane>
          <el-tab-pane label="我的收藏">角色管理</el-tab-pane>
          <el-tab-pane label="积分中心">定时任务补偿</el-tab-pane>
          <el-tab-pane label="我的钱包">定时任务补偿</el-tab-pane>
        </el-tabs>
      </el-main>
  </el-container>

</div>
</template>

<script>
    import HelloWorld from "./HelloWorld";
    import CountInfo from "./CountInfo";
    export default {
        name: "UserInfo",
      components: {CountInfo, HelloWorld},
      data() {
        return {
          tabPosition:'left',
          activeName:'countInfo'
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
