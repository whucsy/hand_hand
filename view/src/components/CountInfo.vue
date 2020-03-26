<template>
<div>
  <el-row class="demo-avatar demo-basic">
    <!--    头像-->
    <el-col :span="6">
      <el-avatar icon="el-icon-user-solid" :size="120" style="margin-left: 30px"></el-avatar>
    </el-col>
    <!--    信息-->
    <el-col :span="18">
      <div style="width:400px;text-align: left;height:150px">
        <div>
          <span style="font-size: 30px;margin-left:5px;"><b>用户名</b></span>
          <i class="el-icon-medal" style="margin-right:15px;size: 15px">level</i>
        </div>
        <div style="width:380px;margin-left:15px;margin-right:10px;margin-top:10px;">
          <span>id:123</span>
          <span style="margin-left: 30px">积分: 0</span>
        </div>
        <div style="margin-top: 17px;margin-left: 10px">
          <span>个性签名：手拉手</span>
        </div>
      </div>
    </el-col>
  </el-row>

  <el-divider content-position="left">基础信息</el-divider>

  <el-row class="demo-avatar demo-basic">
    <el-col :span="12"><span>年龄：12</span></el-col>
    <el-col :span="12"><span>性别：女</span></el-col>
  </el-row>
  <el-row class="demo-avatar demo-basic">
    <el-col :span="12"><span>所在地：湖北</span></el-col>
    <el-col :span="12"><span>性别：女</span></el-col>
  </el-row>

  <el-divider content-position="left">账号设置</el-divider>

  <el-row class="demo-avatar demo-basic">
    <el-col :span="12">
      <div>

      </div>
    </el-col>
    <el-col :span="12">
      <div>

      </div>
    </el-col>
  </el-row>


</div>

<!--  <el-container-->
<!--    style="width: 100%; border: 1px solid rgba(211,211,211,0.09);height: 100%;margin-left: 20px;margin-top: 10px">-->
<!--    <el-aside width="150px" style="margin-top: 20px">-->
<!--      <el-avatar icon="el-icon-user-solid" :size="120" style="margin-left: 10px"></el-avatar>-->
<!--    </el-aside>-->
<!--    <el-main>-->
<!--      <div style="width:400px;text-align: left;height:180px">-->
<!--        <div>-->
<!--          <span style="font-size: 30px;margin-left:5px;"><b>用户名</b></span>-->
<!--          <i class="el-icon-medal" style="margin-right:15px;size: 15px">level</i>-->
<!--        </div>-->
<!--        <div style="width:380px;margin-left:15px;margin-right:10px;margin-top:10px;">-->
<!--          <span>id:123</span>-->
<!--          <span style="margin-left: 30px">积分: 0</span>-->
<!--        </div>-->
<!--        <div style="margin-top: 17px;margin-left: 10px">-->
<!--          <span>个性签名：手拉手</span>-->
<!--        </div>-->
<!--      </div>-->
<!--      <el-divider><i class="el-icon-mobile-phone"></i></el-divider>-->
<!--    </el-main>-->
<!--  </el-container>-->
</template>

<script>
  export default {
    name: "CountInfo"
  }
</script>

<style scoped>
  .el-row {
    margin-bottom: 10px;
  }

  .el-col {
    border-radius: 4px;
  }

  .user_name {
    max-height: 36px;
  }

  .larger-row {
    max-height: 150px;
  }
</style>
