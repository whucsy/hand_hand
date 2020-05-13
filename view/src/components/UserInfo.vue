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
                  <el-avatar :src="icon" :fit="fit" :size="120" style="margin-left: 30px"></el-avatar>
                </el-col>
                <!--    信息-->
                <el-col :span="18">
                  <div style="width:400px;text-align: left;height:150px">
                    <div>
                      <span style="font-size: 30px;margin-left:5px;"><b>{{userName}}</b></span>
                      <i class="el-icon-medal" style="margin-right:15px;size: 15px">{{level}}</i>
                      <el-popover placement="top-start" width="50" trigger="hover" content="修改昵称">
                        <i class="el-icon-edit" @click="editAccountInfo" slot="reference"></i>
                      </el-popover>
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

              <el-divider content-position="right">完善个人信息
                <el-popover placement="top-start" width="50" trigger="hover" content="点击修改信息">
                  <i class="el-icon-edit" @click="editUserInfo" slot="reference"></i>
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
                  <el-row style="margin-top: 5px; font-size: small"><span>已绑定：</span><span>{{phoneNumber}}</span></el-row>
                </el-col>
                <el-col :span="3" style="font-size: 60px;color: #909399"><i class="el-icon-lock"></i></el-col>
                <el-col :span="9" style="margin-top: 10px">
                  <el-row><el-link type="info" style="font-size: large" :underline="false"><b>修改密码</b></el-link>></el-row>
                  <!--          <el-row><span></span></el-row>-->
                </el-col>
              </el-row>
            </div>
          </el-tab-pane>

<!--          我的任务及收藏-->
          <el-tab-pane label="任务和收藏" name="1">
            <div>
              <el-container>
                <el-header style="text-align: left;font-size: x-large;height: 30px">我的任务及收藏</el-header>
                <el-main style="margin-left: 10px">
                  <el-tabs v-model="activeName_1" @tab-click="handleClick">
<!--                    我发布的任务-->
                    <el-tab-pane label="发布" name="first">
                      <span class="mission" v-for="n in publishCount">
                        <div style="width:43%;background-color: rgb(247, 247, 255);text-align: left;height:100px;margin-top:15px;margin-left:20px">
                            <el-col :span="20">
                              <div>
                                <!--                                标题-->
                                <div style="margin-top: 10px;width: 98%;height: 25px;margin-left: 10px">
                                  <span style="font-size: 20px"><b>{{myPublish.value[n-1].mtitle | ellipsis}}</b></span>
                                </div>
                                <!--                                详细信息-->
                                <div style="margin-left:10px;width: 98%;margin-top: 10px">
                                    <span style="font-size: 14px">{{myPublish.value[n-1].missionInfo | ellipsis}}</span>
                                </div>
                                <div style="margin-left: 10px;margin-top: 10px;font-size: x-small;color: #606266">
                                  <!--                                发布日期-->
                                  <span >{{myPublish.value[n-1].publishTime}}</span>
                                  <!--                                  酬金-->
                                  <i class="el-icon-coin" style="margin-right:5px;margin-left: 50px">{{myPublish.value[n-1].money}}</i>
                                </div>
                              </div>
                            </el-col>
                            <el-col :span="4" style="margin-top: 25px">
                              <i class="el-icon-circle-check" style="font-size: 40px;color: #409EFF"></i>
                            </el-col>
                        </div>
                      </span>
                    </el-tab-pane>
<!--                   我接受的任务 -->
                    <el-tab-pane label="接受" name="second">
                      <span class="mission" v-for="n in publishCount">
                        <div style="width:43%;background-color: rgb(247, 247, 255);text-align: left;height:100px;margin-top:15px;margin-left:20px">
                          <el-col :span="6" style="margin-top: 25px">
                            <el-avatar :src="icon" :fit="fit" :size="60" style="margin-left: 10px"></el-avatar>
                          </el-col>
                          <el-col :span="16">
                            <div>
                              <div style="margin-top: 10px;width: 98%;height: 25px;margin-left: 10px">
                                <span style="font-size: 20px"><b>超级超级标题</b></span>
                              </div>
                              <div style="margin-left:10px;width: 98%;margin-top: 10px">
                                  <span style="font-size: 14px">详细描述</span>
                              </div>
                              <div style="margin-left: 10px;margin-top: 10px;font-size: x-small;color: #606266">
                                <span >2020-4-15</span>
                                <i class="el-icon-coin" style="margin-right:5px;margin-left: 50px">酬金</i>
                              </div>
                            </div>
                          </el-col>
                          <el-col :span="2" style="margin-top: 5px">
                            <i class="el-icon-circle-check" style="font-size: 20px;color: #409EFF"></i>
                          </el-col>
                        </div>
                      </span>
                    </el-tab-pane>
<!--                    我收藏的任务-->
                    <el-tab-pane label="收藏" name="third">
                      <span class="mission" v-for="n in collectionCount">
                        <div style="width:43%;background-color: rgb(247, 247, 255);text-align: left;height:100px;margin-top:15px;margin-left:20px">
                          <el-col :span="6" style="margin-top: 25px">
                            <el-avatar :src="icon" :fit="fit" :size="60" style="margin-left: 10px"></el-avatar>
                          </el-col>
                          <el-col :span="16">
                              <div>
                                <div style="margin-top: 10px;width: 98%;height: 25px;margin-left: 10px">
                                  <span style="font-size: 20px"><b>{{myCollection.value[n-1].mtitle | ellipsis}}</b></span>
                                </div>
                                <div style="margin-left:10px;width: 98%;margin-top: 10px">
                                    <span style="font-size: 14px">{{myCollection.value[n-1].missionInfo | ellipsis}}</span>
                                </div>
                                <div style="margin-left: 10px;margin-top: 10px;font-size: x-small;color: #606266">
                                  <span >{{myCollection.value[n-1].publishTime}}</span>
                                  <i class="el-icon-coin" style="margin-right:5px;margin-left: 50px">{{myCollection.value[n-1].money}}</i>
                                </div>
                              </div>
                            </el-col>
                          <el-col :span="2">
                            <i class="el-icon-star-on" style="font-size: 25px;color: rgb(255,225,0)"></i>
                          </el-col>
                        </div>
                      </span>
                    </el-tab-pane>
                  </el-tabs>
                </el-main>
              </el-container>
            </div>
          </el-tab-pane>

<!--          <el-tab-pane label="我的收藏" name="2" >角色管理</el-tab-pane>-->
          <el-tab-pane label="积分中心" name="3">定时任务补偿</el-tab-pane>
          <el-tab-pane label="我的钱包" name="4">定时任务补偿</el-tab-pane>

<!--          修改信息-->
          <el-tab-pane name="5" disabled>
            <div style="width: 70%">
              <el-page-header @back="goBack" content="修改信息"></el-page-header>
              <div style="margin-top: 50px;margin-left: 50px">
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="真实姓名">
                    <el-input v-model="realName"></el-input>
                  </el-form-item>
                  <el-form-item label="性别">
                  <el-radio-group v-model="form.sex">
                    <el-radio label="0">男</el-radio>
                    <el-radio label="1">女</el-radio>
                  </el-radio-group>
                  </el-form-item>
                  <el-form-item label="身份证号">
                    <el-input type="textarea" v-model="idNumber"></el-input>
                  </el-form-item>
                  <el-form-item label="生日">
                    <el-date-picker v-model="form.date" type="date" style="width: 100%"></el-date-picker>
                  </el-form-item>
                  <el-form-item label="学历">
                    <el-select v-model="education" style="width: 100%">
                      <el-option label="本科在读" value="shanghai"></el-option>
                      <el-option label="研究生在读" value="beijing"></el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="学校名称">
                    <el-input v-model="school"></el-input>
                  </el-form-item>
                  <el-form-item label="学号">
                    <el-input v-model="studentNo"></el-input>
                  </el-form-item>
                  <el-form-item label="户籍">
                    <el-input v-model="location"></el-input>
                  </el-form-item>
                  <el-form-item label="当前住址">
                    <el-input v-model="address"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitUserEdit">保存更改</el-button>
<!--                    <el-button>取消</el-button>-->
                  </el-form-item>
                </el-form>

              </div>

            </div>


          </el-tab-pane>
<!--          修改昵称和个性签名-->
          <el-tab-pane name="6" disabled>
            <div style="width: 70%">
              <el-page-header @back="goBack" content="修改昵称"></el-page-header>
              <div style="margin-top: 50px;margin-left: 50px">
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="用户名">
                    <el-input v-model="userName"></el-input>
                  </el-form-item>
                  <el-form-item label="个性签名">
                    <el-input type="textarea" v-model="motto"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitAccountEdit">保存更改</el-button>
<!--                    <el-button>取消</el-button>-->
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
          icon: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
          age: '',
          sex: '女',
          motto: '',
          userName: '',
          score: '',
          uid: this.getCookie('uid'),
          level: '',
          address: '',
          userType: '',
          balance: '',
          phoneNumber: '',

          //我的任务 name=1
          activeName_1: 'first',
          publishCount: null,
          myPublish: null,

          receiveCount: null,
          myReceive: null,

          collectionCount: null,
          myCollection: null,



          //修改信息 name=5
          form: {
            sex: '1',
            date: new Date,
          },
          company: '',
          education: '',
          location: '',
          realName: '',
          school: '',
          studentNo: '',
          idNumber: '',
        };
      },
      created() {
          this.getUserInfoById();
          this.getCountInfoByToken();
      },
      mounted() {
          this.getMyPublish();
          this.getMyCollection();
      },
               //过滤器限制长度
          filters: {
    ellipsis (value) {
      if (!value) return '';
      if (value.length > 10) {
        return value.slice(0,10) + '...'
      }
      return value
    }
  },

      methods: {
        handleClick(tab,event) {
        },

        //根据token查询账户信息
        getCountInfoByToken() {
          this.$axios
            .get('/api/userAccount/token', {
              params: {
                token: this.getCookie('token')
              }
            })
            .then(successResponse => {
              if (successResponse.status === 200) {
                this.balance = successResponse.data.balance;
                this.icon = successResponse.data.icon;
                this.level = successResponse.data.level;
                this.motto = successResponse.data.motto;
                this.phoneNumber = successResponse.data.phoneNumber;
                this.password = successResponse.data.password;
                this.role = successResponse.data.role;
                this.score = successResponse.data.score;
                this.userName = successResponse.data.userName;
              }
            })
        },
        //根据id查询用户信息
        getUserInfoById(){
          this.$axios
          .get('api/userInfo/uid',{
            params: {
              uid: this.getCookie('uid')
            }
          })
          .then(successResponse => {
            if(successResponse.status === 200){
              this.address = successResponse.data.address;
              this.realName = successResponse.data.realName;
              this.idNumber = successResponse.data.idNumber;
              this.age = successResponse.data.age;
              this.studentNo = successResponse.data.studentNo;
              this.school = successResponse.data.school;
              this.education = successResponse.data.education;
              this.company = successResponse.data.company;
              this.location = successResponse.data.location;
              this.userType = successResponse.data.userType;
            }
          })
          .catch(failResponse=>{
            this.createUserInfo();
            console.log('获取用户信息失败');
          })
        },
        //创建用户信息表
        createUserInfo(){
          this.$axios
            .post('api/userInfo', {
              uid: this.getCookie('uid')
            })
            .then(successResponse=>{
              if(successResponse.status === 200){
                console.log('增加信息表成功');
              }
            })
            .catch(failResponse=>{
              console.log('创建用户信息表失败');
            });
        },

        //账号资料 name=0
        editUserInfo() {
          this.activeName='5';
        },
        submitUserEdit() {
          this.$axios
          .post('api/userInfo',{
            uid: this.uid,
            address: this.address,
            age: this.age,
            company: this.company,
            education: this.education,
            idNumber: this.idNumber,
            location: this.location,
            realName: this.realName,
            school: this.school,
            studentNo: this.studentNo,
            userType: this.userType
          })
          .then(successResponse=>{
            if(successResponse.status === 200){
              console.log(successResponse.status);
              alert('修改成功');
              this.activeName='0';
              this.getUserInfoById();
            }
          })
          .catch(failResponse=>{
            alert('提交失败');
          })
        },
        //修改用户名或者个性签名
        editAccountInfo(){
          this.activeName = '6'
        },
        submitAccountEdit() {
          this.$axios
          .put('api/userAccount',{
            uid: this.uid,
            balance: this.balance,
            icon: this.icon,
            level: this.level,
            motto: this.motto,
            password: this.password,
            phoneNumber: this.phoneNumber,
            role: this.role,
            score: this.score,
            userName: this.userName
          })
          .then(successResponse=>{
            if(successResponse.status === 200){
              console.log('修改账户信息成功');
              alert("修改成功");
              this.activeName='0';
              this.getCountInfoByToken();
              // app.showLogin = this.userName;
            }
          })
          .catch(failResponse=>{

          })
        },

        //我的发布 name=1
        getMyPublish(){
          this.$axios
          .get('/api/mission/uid',{
            params:{
              uid: this.getCookie('uid')
            }
          })
          .then(successRespond => {
            if(successRespond.data.statusCode === 200){
              console.log("我的发布");
              if(successRespond.data.data.value !== null){
                this.publishCount = successRespond.data.data.value.length;
                this.myPublish = successRespond.data.data;
              }else{
                this.publishCount = 0;
              }
            }
          })
        },
        //我收藏的任务
        getMyCollection(){
          this.$axios
          .get('/api/saveList/uid',{
            params:{
              uid: this.getCookie('uid')
            }
          })
          .then(successRespond => {
            if(successRespond.data.statusCode === 200){
              console.log("我的收藏");
              if(successRespond.data.data.value !== null){
                this.collectionCount = successRespond.data.data.value.length;
                this.myCollection = successRespond.data.data;
              }else{
                this.collectionCount = 0;
              }
            }
          })
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
  span.mission div {
    float: left;
  }
</style>
