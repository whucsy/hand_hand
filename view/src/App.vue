<template>
  <div id="app">
    <!--      导航栏-->
    <el-menu :default-active="this.$route.path" class="el-menu-demo" router mode="horizontal" @open="handleOpen"
             @close="handleClose">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>

      <el-menu-item>
        <el-input placeholder="搜索" v-model="input" class="input-with-select">
          <el-select v-model="select" slot="prepend" placeholder="请选择">
            <el-option label="uid" value="1"></el-option>
            <el-option label="任务名" value="2"></el-option>
            <el-option label="mid" value="3"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search" @click="getResult"></el-button>
        </el-input>
      </el-menu-item>

<!--      如果cookie中没有用户信息-->
      <div style="text-align: right; margin-top: 12px" v-if="showLogin === ''">
        <!--      头像-->
          <i class="el-icon-user" style="margin-top:10px;margin-right: 10px"></i>
        <!--       登录按钮-->
        <el-button type="text" @click="loginFormVisible = true" size="30px">登录</el-button>
        <el-dialog style="text-align: left" :visible.sync="loginFormVisible" title="登录账号" width="40%">
          <el-form :label-position=labelPosition :model="loginForm" @submit.native.prevent>
            <el-form-item label="账号" :label-width="formLabelWidth">
              <el-input v-model="loginForm.count" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="formLabelWidth">
              <el-input type="password" v-model="loginForm.loginPass" autocomplete="off" show-password></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="loginFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="login">确 定</el-button>
          </div>
        </el-dialog>

        <el-divider direction="vertical"></el-divider>

        <!--        //注册按钮-->
        <el-button style="margin-right: 10px" type="text" @click="registerFormVisible = true">注册</el-button>
        <el-dialog style="text-align: left" :visible.sync="registerFormVisible" title="注册账号" width="40%">
          <el-form :model="registerForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
                   class="demo-ruleForm">
            <el-form-item label="手机号码" prop="phoneNumber">
              <el-input v-model.number="registerForm.phoneNumber"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input type="password" v-model="registerForm.pass" autocomplete="off" show-password></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="registerForm.checkPass" autocomplete="off" show-password></el-input>
            </el-form-item>
            <el-form-item>
              <el-button @click="registerFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
      </div>

<!--      如果cookie中有用户信息-->
      <div style="text-align: right;margin-top: 8px" v-else class="demo-type">
        <!--      头像-->
        <router-link to="/components/UserInfo">
          <el-avatar :src="imageScr" :fit="fit" style="margin-bottom: -10px"></el-avatar>
        </router-link>
        <span style="font-size: large;margin-left: 10px">{{showLogin}}</span>
        <el-divider direction="vertical"></el-divider>
        <el-button style="margin-right: 10px;font-size: small" type="text" @click="exit">退出登录</el-button>
      </div>


    </el-menu>

    <router-view class="menu-right"/>
  </div>
</template>

<script>
  export default {
    name: 'App',

    data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('手机号不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          }
            // } else {
            //   if (value.length !== 11) {
            //     callback(new Error('手机号格式不正确'));
          //   }
          else {
            callback();
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.registerForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.registerForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      var token = "";
      return {
        fit: 'contain',
        imageScr: "../static/head/h1.jpg",//'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
        labelPosition: 'top',
        loginFormVisible: false,
        showLogin: this.getCookie('userName'),
        registerFormVisible: false,
        input: '',
        select: '',

  loginForm: {
          count: '',
          loginPass: ''
        },
        formLabelWidth: '80px',

        registerForm: {
          pass: '',
          checkPass: '',
          phoneNumber: ''
        },
        activeIndex: '1',
        navList: [
          {name: '/', navItem: '主页'},
          // {name: '/components/UserInfo', navItem: '个人中心'},
          {name: '/personalCenter', navItem: '分类'},
          {name: '/components/Manager', navItem: '管理员中心'},
          {name: '/components/PostMission', navItem: '发布任务'},
        ],
        rules: {
          pass: [{
            validator: validatePass,
            trigger: 'blur'
          }],
          checkPass: [{
            validator: validatePass2,
            trigger: 'blur'
          }],
          phoneNumber: [{
            validator: checkAge,
            trigger: 'blur'
          }]
        },
      };
    },
    created() {
      if(this.getCookie('token') !== ''){
        this.getUidByToken();
      }
    },

    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      //注册表格点击提交
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.register();
          } else {
            alert("注册失败!");
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      getResult() {
        this.$router.push({path: '/components/searchResult',name:'searchResult',params:{name:'name',input:this.input,select:this.select}})
      },
      //登录
      login() {
        //此处不是传递json对象，而是传递键值对
        this.$axios
          .post('/api/userAccount/login', this.$qs.stringify({
            phoneNumber: this.loginForm.count,
            password: this.loginForm.loginPass
          }))
          .then(successResponse => {
            console.log(successResponse);
            if (successResponse.status === 200) {
              console.log('登录成功');
              //根据登录成功返回的token设置cookie
              this.token = successResponse.data.token;
              this.setCookie('token',successResponse.data.token,7);
              this.getUidByToken();
              alert('登录成功');
              this.loginFormVisible = false;
            }
          })
          .catch(failResponse => {
          })
      },

      //设置cookie
      getUidByToken() {
        this.$axios
          .get('/api/userAccount/token', {
            params: {
              token: this.getCookie('token')
            }
          })
          .then(successResponse => {
            console.log(successResponse);
            if (successResponse.status === 200) {
              var expiredays = 7;
              this.setCookie('uid', successResponse.data.uid, expiredays);
              // this.setCookie('userName',successResponse.data.userName,expiredays);
              //更新导航栏
              this.showLogin=successResponse.data.userName;//this.getCookie('userName');
              this.imageScr=successResponse.data.icon;
            }
          })
      },

      //退出登录
      exit() {
        //1.清除cookie
        this.clearAllCookie();
        //更新导航栏
        this.$router.push('/components/HelloWorld');
        this.showLogin = '';
      },

      //清除所有cookie函数
      clearAllCookie() {
        var date = new Date();
        date.setTime(date.getTime() - 10000);
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        // console.log("需要删除的cookie名字：" + keys);
        if (keys) {
          for (var i = keys.length; i--;) {
            document.cookie = keys[i] + "=; expire=" + date.toGMTString() + "; path=/";
          }
        }
        // console.log(document.cookie);
      },
      //注册
      register() {
        this.$axios
          .post('/api/userAccount', {
            phoneNumber: this.registerForm.phoneNumber,
            password: this.registerForm.pass
          })
          .then(successResponse => {
            // console.log(successResponse);
            if (successResponse.status === 200) {
              // this.token = successResponse.data.token;
              // console.log(this.token);
              console.log('注册成功');
              alert('注册成功!');
              this.resetForm('ruleForm');
              this.registerFormVisible = false;
            }
          })
          .catch(failResponse => {
            alert('注册失败！');
          })
      }

    },
  }
</script>

<style>
  .menu-right {
    /*margin-top:80px;*/
  }

    .input-with-select .el-input-group__prepend {
    background-color: #fff;
    }
    .el-select .el-input {
    width: 130px;
    }


    #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;

  }
</style>
