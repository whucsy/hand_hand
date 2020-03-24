<template>
	<div>
		<el-container style=" border: 1px solid #eee">
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
<!--       左侧导航栏-->
			<el-aside width="200px" style="background-color: rgb(238, 241, 246)">
				<el-menu :default-openeds="['1', '3']" >
<el-menu-item v-for="(item,i) in navList" :key="i">{{ item.name}}</el-menu-item>


				</el-menu>
			</el-aside>

			<el-main>
<!--       任务浏览-->
        <div style="width:400px;border-radius: 4px;background-color: rgb(238, 241, 246);text-align: left;height:250px">
          <div>
            <span style="font-size: 20px;margin-left:10px;">任务标题</span>
            <i class="el-icon-coin" style="margin-right:15px">30</i>
          </div>
          <div
            style="width:380px;border-radius: 4px;background-color: rgb(255, 255, 255);margin-left:10px;margin-right:10px;margin-top:10px;height:155px">
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
  return {
  navList: [
  {name: '全部'},
  {name: '美术'},
  {name: '计算机'},
  {name: '美工'},
  {name: '视频'},
  {name: '摄影'},
  {name: '英文'},
  {name: '论文'},
  {name: '经济'},
  {name: '文章'},
  {name: '数学'},
  {name: '物理'},
  {name: '游戏'},
  {name: '音乐'},
  {name: '书法'},
  {name: '外语'},
  ],
  };
  },
	}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
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
