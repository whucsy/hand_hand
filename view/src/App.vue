<template>
  <div id="app">
    <!--      导航栏-->
    <el-menu :default-active="this.$route.path" class="el-menu-demo" router mode="horizontal" @open="handleOpen"
             @close="handleClose">
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
        {{ item.navItem }}
      </el-menu-item>
      <!--      头像-->
      <router-link to="UserInfo">
        <el-avatar icon="el-icon-user-solid" size="50px" style="margin-top:10px"></el-avatar>
      </router-link>

      <!--       登录按钮-->
      <el-button type="text" @click="loginFormVisible = true" size="30px">登录</el-button>
      <el-dialog style="text-align: left" :visible.sync="loginFormVisible" title="登录账号" width="40%">
        <el-form :label-position=labelPosition model="loginForm">
          <el-form-item label="账号" :label-width="formLabelWidth">
            <el-input v-model="loginForm.count" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="密码" :label-width="formLabelWidth">
            <el-input type="password" v-model="loginForm.loginPass" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="loginFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="login">确 定</el-button>
        </div>
      </el-dialog>

      <!--        //注册按钮-->
      <el-button type="text" @click="registerFormVisible = true">注册</el-button>
      <el-dialog style="text-align: left" :visible.sync="registerFormVisible" title="注册账号" width="40%">
        <el-form :model="registerForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
                 class="demo-ruleForm">
          <el-form-item label="手机号码" prop="phoneNumber">
            <el-input v-model.number="registerForm.phoneNumber"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="registerForm.pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="registerForm.checkPass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="registerFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
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
        labelPosition: 'top',
        loginFormVisible: false,
        registerFormVisible: false,
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
          {name: '/components/HelloWorld', navItem: '主页'},
          {name: '/components/UserInfo', navItem: '个人中心'},
          {name: '/publishProject', navItem: '发布项目'},
          {name: '/personalCenter', navItem: '个人中心'},
          {name: '/manageCenter', navItem: '管理员中心'},
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
            alert('注册成功!');
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

      //登录
      login() {
        this.$axios
          .get('/api/userAccount/login', {
            params: {
              phoneNumber: this.loginForm.count,
              password: this.loginForm.loginPass
            }
          })
          .then(successResponse => {
            console.log(successResponse);
            if (successResponse.data.status === 200) {
              this.token = successResponse.data.token;
              console.log(this.token)
            }
          })
          .catch(failResponse => {
          })
      },

      //注册
      register() {
        this.$axios
          .post('/api/userAccount', {
            phoneNumber: this.registerForm.phoneNumber,
            password: this.registerForm.pass
          })
          .then(successResponse => {
            console.log(successResponse)
            if (successResponse.data.status === 200) {
              this.token = successResponse.data.token;
              console.log(this.token)
            }
          })
          .catch(failResponse => {
          })
      }

    },
  }
</script>

<style>
  .menu-right{
    /*margin-top:80px;*/
  }
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;

  }
</style>
