<template>
	<div>
		<el-container style=" border: 1px solid #eee">
			<!--      //顶部导航栏-->
			<el-header style="background-color: #eeeeee; text-align: right; font-size: 30px;">

				<!--      头像-->
				<el-avatar icon="el-icon-user-solid" size="50px" style="margin-top:10px"></el-avatar>

				<!--       登录按钮-->
				<el-button type="text" @click="loginFormVisible = true" size="30px">登录</el-button>
				<el-dialog style="text-align: left" :visible.sync="loginFormVisible" title="登录账号" width="40%">
					<el-form :label-position=labelPosition model="loginForm">
						<el-form-item label="账号" :label-width="formLabelWidth">
							<el-input v-model="loginForm.name" autocomplete="off"></el-input>
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
					<el-form :model="registerForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
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
							<el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-form>
				</el-dialog>
			</el-header>
			<!--       广告栏-->
			<el-main>
				<div class="block">
					<el-carousel height="150px">
						<el-carousel-item v-for="item in 4" :key="item">
							<h3 class="small">{{ item }}</h3>
						</el-carousel-item>
					</el-carousel>
				</div>
			</el-main>
		</el-container>


		<el-container>
			<el-aside width="200px" style="background-color: rgb(238, 241, 246)">
				<el-menu :default-openeds="['1', '3']">
					<el-submenu index="1">
						<template slot="title"><i class="el-icon-message"></i>导航一</template>
						<el-menu-item-group>
							<template slot="title">分组一</template>
							<el-menu-item index="1-1">选项1</el-menu-item>
							<el-menu-item index="1-2">选项2</el-menu-item>
						</el-menu-item-group>
						<el-menu-item-group title="分组2">
							<el-menu-item index="1-3">选项3</el-menu-item>
						</el-menu-item-group>
						<el-submenu index="1-4">
							<template slot="title">选项4</template>
							<el-menu-item index="1-4-1">选项4-1</el-menu-item>
						</el-submenu>
					</el-submenu>
					<el-submenu index="2">
						<template slot="title"><i class="el-icon-menu"></i>导航二</template>
						<el-menu-item-group>
							<template slot="title">分组一</template>
							<el-menu-item index="2-1">选项1</el-menu-item>
							<el-menu-item index="2-2">选项2</el-menu-item>
						</el-menu-item-group>
						<el-menu-item-group title="分组2">
							<el-menu-item index="2-3">选项3</el-menu-item>
						</el-menu-item-group>
						<el-submenu index="2-4">
							<template slot="title">选项4</template>
							<el-menu-item index="2-4-1">选项4-1</el-menu-item>
						</el-submenu>
					</el-submenu>

					<el-submenu index="3">
						<template slot="title"><i class="el-icon-setting"></i>导航三</template>
						<el-menu-item-group>
							<template slot="title">分组一</template>
							<el-menu-item index="3-1">选项1</el-menu-item>
							<el-menu-item index="3-2">选项2</el-menu-item>
						</el-menu-item-group>
						<el-menu-item-group title="分组2">
							<el-menu-item index="3-3">选项3</el-menu-item>
						</el-menu-item-group>
						<el-submenu index="3-4">
							<template slot="title">选项4</template>
							<el-menu-item index="3-4-1">选项4-1</el-menu-item>
						</el-submenu>
					</el-submenu>
				</el-menu>
			</el-aside>

			<el-main>
<!--       任务浏览-->
<div style="width:400px;border-radius: 4px;background-color: rgb(238, 241, 246);text-align: left;height:250px">
<div >
<span style="font-size: 20px;margin-left:10px;">任务标题</span>
<i class="el-icon-coin" style="margin-right:15px">30</i>
</div>
<div style="width:380px;border-radius: 4px;background-color: rgb(255, 255, 255);margin-left:10px;margin-right:10px;margin-top:10px;height:155px">
任务描述任务描述任务描述任务描述任务描述任务描述任务描述任务描述任务描述任务描述任务描述任务描述
</div>
<div style="align-items:center; display: -webkit-flex;">
<span><el-avatar style="margin-top:10px;margin-left:10px"> user </el-avatar></span>
<span style="margin-left:10px;">name</span>
</div>
</div>

			</el-main>
		</el-container>
	</div>
</template>


<script>
	export default {
		name: 'HelloWorld',
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
			var token = ""
			return {
				msg: 'Welcome to Your Vue.js App',
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
				}
			};
		},
		methods: {
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if (valid) {
						alert('submit!');
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},

			//登录
			login(){
				this.$axios
				  .get('/userAccount/login', {
					  phoneNumber: this.loginForm.count,
					  password: this.loginForm.loginPass
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
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	h1,
	h2 {
		font-weight: normal;
	}

	a {
		color: #42b983;
	}

	.el-carousel__item h3 {
		color: #475669;
		font-size: 14px;
		opacity: 0.75;
		line-height: 150px;
		margin: 0;
	}

	.el-carousel__item:nth-child(2n) {
		background-color: #99a9bf;
	}

	.el-carousel__item:nth-child(2n+1) {
		background-color: #d3dce6;
	}
</style>
