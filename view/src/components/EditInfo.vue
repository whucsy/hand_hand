<template>
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ name: 'UserInfo' ,query:{active:true}}">TAB</el-breadcrumb-item>
<!--    <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>-->
<!--    <el-breadcrumb-item>活动列表</el-breadcrumb-item>-->
<!--    <el-breadcrumb-item>活动详情</el-breadcrumb-item>-->
  </el-breadcrumb>
</template>

<script>
    export default {
        name: "EditInfo"
    }
</script>

<style scoped>

</style>
