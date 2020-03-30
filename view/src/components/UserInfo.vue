<template>
<div>
  <el-container style="width: 70%; border: 1px solid rgba(211,211,211,0.09);margin-left: 15%;height: 100%;margin-top: 10px">
      <el-main>
        <el-tabs :tab-position="tabPosition" style="height: 100%" v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="账号资料" name="0" >
            <div>
              <el-row class="demo-avatar demo-basic" style="height: 150px">
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
              <el-divider content-position="right">基础信息
                <el-popover placement="top-start" width="50" trigger="hover" content="点击修改信息">
                  <i class="el-icon-edit" @click="editInfo" slot="reference"></i>
                </el-popover>
              </el-divider>

              <div style="height: 100px; text-align: left; margin-left: 20px">
                <el-row class="demo-avatar demo-basic" style="">
                  <el-col :span="12"><span :data="age">年龄：</span></el-col>
                  <el-col :span="12"><span>性别：女</span></el-col>
                </el-row>
                <el-row class="demo-avatar demo-basic" style="margin-top: 30px">
                  <el-col :span="12"><span>所在地：湖北</span></el-col>
                  <el-col :span="12"><span>性别：女</span></el-col>
                </el-row>
              </div>
              <el-divider content-position="right">账号设置</el-divider>

              <el-row class="demo-avatar demo-basic" style="text-align: left; margin-left: 20px">
                <el-col :span="3" style="font-size: 60px;color: #909399"><i class="el-icon-mobile"></i></el-col>
                <el-col :span="9" style="margin-top: 10px">
                  <el-row><el-link type="info" style="font-size: large" :underline="false"><b>修改绑定手机号</b></el-link>></el-row>
                  <el-row style="margin-top: 5px; font-size: small"><span>已绑定：</span></el-row>
                </el-col>
                <el-col :span="3" style="font-size: 60px;color: #909399"><i class="el-icon-lock"></i></el-col>
                <el-col :span="9" style="margin-top: 10px">
                  <el-row><el-link type="info" style="font-size: large" :underline="false"><b>修改密码</b></el-link>></el-row>
                  <!--          <el-row><span></span></el-row>-->
                </el-col>
              </el-row>
            </div>
          </el-tab-pane>
          <el-tab-pane label="我的任务" name="1">配置管理</el-tab-pane>
          <el-tab-pane label="我的收藏" name="2" >角色管理</el-tab-pane>
          <el-tab-pane label="积分中心" name="3">定时任务补偿</el-tab-pane>
          <el-tab-pane label="我的钱包" name="4">定时任务补偿</el-tab-pane>
          <el-tab-pane name="5" disabled:true>
            <el-page-header @back="goBack" content="修改信息">
            </el-page-header>
          </el-tab-pane>
        </el-tabs>
      </el-main>
  </el-container>

</div>
</template>

<script>
    import HelloWorld from "./HelloWorld";
    import CountInfo from "./CountInfo";
    import EditInfo from "./EditInfo";
    export default {
        name: "UserInfo",
      data() {
        return {
          tabPosition: 'left',
          activeName: '0',
          age: '12',
        };
      },

      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClick(tab,event) {

        },
        editInfo() {
          this.activeName='5';
        },
        goBack() {
          this.activeName='0';
        }
      }
    }



</script>

<style scoped>
</style>
