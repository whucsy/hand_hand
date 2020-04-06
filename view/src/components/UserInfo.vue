<template>
<div>
  <el-container style="width: 900px; border: 1px solid rgba(211,211,211,0.09);margin-left: 200px;height: 100%;margin-top: 10px">
      <el-main>
        <el-tabs :tab-position="tabPosition" style="height: 100%" v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="账号资料" name="0" >
            <div>
              <el-row style="height: 150px">
                <!--    头像-->
                <el-col :span="6">
                  <el-avatar :src="imageSrc" :fit="fit" :size="120" style="margin-left: 30px"></el-avatar>
                </el-col>
                <!--    信息-->
                <el-col :span="18">
                  <div style="width:400px;text-align: left;height:150px">
                    <div>
                      <span style="font-size: 30px;margin-left:5px;"><b>{{userName}}</b></span>
                      <i class="el-icon-medal" style="margin-right:15px;size: 15px">{{level}}</i>
                    </div>
                    <div style="width:380px;margin-left:15px;margin-right:10px;margin-top:10px;">
                      <span>id：</span><span>{{uid}}</span>
                      <span style="margin-left: 30px">积分：</span><span>{{score}}</span>
                      <span style="margin-left: 30px">余额：</span><span>{{balance}}</span>
                    </div>
                    <div style="margin-top: 17px;margin-left: 10px">
                      <span>个性签名：</span><span>{{motto}}</span>
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
                <el-row>
                  <el-col :span="12"><span>年龄：</span><span>{{age}}</span></el-col>
                  <el-col :span="12"><span>性别：</span><span>{{sex}}</span></el-col>
                </el-row>
                <el-row class="demo-avatar demo-basic" style="margin-top: 30px">
                  <el-col :span="12"><span>所在地：</span><span>{{address}}</span></el-col>
                  <el-col :span="12"><span>账号类型：</span><span>{{userType}}</span></el-col>
                </el-row>
              </div>
              <el-divider content-position="right">账号设置</el-divider>

              <el-row style="text-align: left; margin-left: 20px">
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
          <el-tab-pane label="任务和收藏" name="1">
            <div>
              <el-container>
                <el-header style="text-align: left;font-size: x-large;height: 30px">我的任务及收藏</el-header>
                <el-main style="margin-left: 10px">
                  <el-tabs v-model="activeName_1" @tab-click="handleClick">
                    <el-tab-pane label="发布" name="first">发布任务</el-tab-pane>
                    <el-tab-pane label="接受" name="second">接受任务</el-tab-pane>
                    <el-tab-pane label="收藏" name="third">我的收藏</el-tab-pane>
                  </el-tabs>
                </el-main>
              </el-container>
            </div>


          </el-tab-pane>
<!--          <el-tab-pane label="我的收藏" name="2" >角色管理</el-tab-pane>-->
          <el-tab-pane label="积分中心" name="3">定时任务补偿</el-tab-pane>
          <el-tab-pane label="我的钱包" name="4">定时任务补偿</el-tab-pane>
          <el-tab-pane name="5">
            <div style="width: 70%">
              <el-page-header @back="goBack" content="修改信息"></el-page-header>
              <div style="margin-top: 50px;margin-left: 50px">
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="用户名">
                    <el-input v-model="form.userName"></el-input>
                  </el-form-item>
                  <el-form-item label="性别">
                  <el-radio-group v-model="form.sex">
                    <el-radio label="0">男</el-radio>
                    <el-radio label="1">女</el-radio>
                  </el-radio-group>
                  </el-form-item>
                  <el-form-item label="个性签名">
                    <el-input type="textarea" v-model="form.motto"></el-input>
                  </el-form-item>
                  <el-form-item label="生日">
                    <el-date-picker v-model="form.date" type="date" style="width: 100%"></el-date-picker>
                  </el-form-item>
                  <el-form-item label="学历">
                    <el-select v-model="form.education" style="width: 100%">
                      <el-option label="本科在读" value="shanghai"></el-option>
                      <el-option label="研究生在读" value="beijing"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="学校名称">
                    <el-input v-model="form.school"></el-input>
                  </el-form-item>
                  <el-form-item label="户籍">
                    <el-input v-model="form.location"></el-input>
                  </el-form-item>
                  <el-form-item label="当前住址">
                    <el-input v-model="form.address"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="onSubmit">保存更改</el-button>
                    <el-button>取消</el-button>
                  </el-form-item>
                </el-form>

              </div>

            </div>


          </el-tab-pane>
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

          tabPosition: 'left',
          activeName: '0',
          //账号资料 name=0
          fit: 'contain',
          imageSrc: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
          age: this.getCookie('age'),
          sex: 'sex',
          motto: this.getCookie('motto'),
          userName: this.getCookie('userName'),
          score: this.getCookie('score'),
          uid: this.getCookie('uid'),
          level: this.getCookie('level'),
          address: this.getCookie('address'),
          userType: 'userType',
          balance: this.getCookie('balance'),

          //我的任务 name=1
          activeName_1: 'first',

          //修改信息 name=5
          form: {
            userName: this.getCookie('userName'),
            company: 'company',
            date: new Date,
            education: 'education',
            location: 'location',
            realName: 'realName',
            sex: '0',
            motto: this.getCookie('motto'),
            school: 'school',
            studentNo: 'studentNo',
            idNumber: 'idNumber',
            userType: 'userType',
            address: 'address',
          },


        };
      },
      created() {
          this.getInfoById();
      },

      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClick(tab,event) {

        },
        //根据id查询用户信息
        getInfoById(){
          this.$axios
          .get('api/userInfo/uid',{
            params: {
              uid: this.getCookie('uid')
            }
          })
          .then(successResponse => {
            console.log(successResponse);
            if(successResponse.status === 200){
              var expiredays = 7;
              this.setCookie('address', successResponse.data.address, expiredays);
            }
          })
        },


        //账号资料 name=0
        editInfo() {
          this.activeName='5';
        },

        //修改信息 name=5
        goBack() {
          this.activeName='0';
        },
        onSubmit() {

        }
      }
    }



</script>

<style scoped>
</style>
