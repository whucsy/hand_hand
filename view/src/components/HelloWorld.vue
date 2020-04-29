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
        <el-menu default-active="推荐" @select="selectItems">
          <el-menu-item v-for="item in navList" :key="item.name" :index="item.name">{{ item.name}}</el-menu-item>
        </el-menu>
      </el-aside>

      <el-main>
        <!--       筛选栏-->
        <div class="sort">
          <el-checkbox v-model="checked1">最新发布</el-checkbox>
          <el-checkbox v-model="checked2">酬金最高</el-checkbox>
        </div>
        <!--       任务浏览-->
<div>
        <span class="mission" v-for="n in mNumber">
        <div
          style="width:400px;border-radius: 4px;background-color: rgb(238, 241, 246);text-align: left;height:250px;margin-top:15px;margin-right:15px">
          <div>
            <span style="font-size: 20px;margin-left:10px;">{{ token.data.data.value[n-1].mtitle }}</span>
            <i class="el-icon-coin" style="margin-right:15px">{{ token.data.data.value[n-1].money }}</i>
          </div>
          <div
            style="width:380px;border-radius: 4px;background-color: rgb(255, 255, 255);margin-left:10px;margin-right:10px;margin-top:10px;height:155px">
              {{ token.data.data.value[n-1].missionInfo }}
          </div>
          <div style="align-items:center; display: -webkit-flex;">
            <span><el-avatar style="margin-top:10px;margin-left:10px"> user </el-avatar></span>
            <span style="margin-left:10px;">{{ token.data.data.value[n-1].uid }}</span>
          </div>
        </div>
</span>
</div>
<!--       分页-->
<div>
<el-pagination  @current-change="handleCurrentChange"
  background  layout="prev, pager, next" :current-page="currentPage"
  :total="total" hide-on-single-page style="white-space:normal">
</el-pagination>
</div>
      </el-main>
    </el-container>

    <!--   天梯排行-->
    <el-container>
      <el-footer style="background-color: #E9EEF3;height:200px">
<div style="text-align: left;font-size:30px">天梯排行</div>
<span class="rank" v-for="item in rankInfo">
<div style="text-align: center;line-height: 160px;margin:15px 25px 10px 25px;">
<div><el-avatar v-bind:src="item.icon" :size="100"></el-avatar></div>
<div>{{ item.userName }}</div>
</div>
</span>
      </el-footer>
    </el-container>
  </div>
</template>


<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {
        navList: [
          {name: '推荐'},
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
        checked1: false,
        checked2: false,
        token: null,
        mNumber: null,
        rankInfo:null,
  currentPage: 1,
  total:100,
  label:null,
  };
    },
    mounted() {
      //this.getMission();
      this.getRank();
      this.getMissionInfo();
    },
    methods: {
    //获取全部任务
      getMission() {
        this.$axios
          .get('/api/mission')
          .then(successResponse => {
            console.log(successResponse);
            if (successResponse.data.statusCode === 200) {
              this.token = successResponse;
              this.mNumber = Object.keys(successResponse.data.data.value).length;
              //console.log(this.token);
            }
          })
          .catch(failResponse => {
          })
      },
  //获取积分排行
  getRank() {
  this.$axios
  .get('/api/userAccount/ranks', {
  params: {
  size: 6
  }
  })
  .then(successResponse => {
  //console.log(successResponse);
  //console.log("1");
  this.rankInfo = successResponse.data;
  //console.log(this.rankInfo);
  })
  .catch(failResponse => {

  })
  },
  handleCurrentChange(val) {
  this.currentPage = val;
  console.log(this.currentPage);
  this.getMissionInfo();
  },
  //分页查询任务
  getMissionInfo() {
  this.$axios
  .get('/api/mission/page', {
  params: {
  page:this.currentPage,
  size:6,
  label:this.label,
  }
  })
  .then(successResponse => {
  console.log(successResponse);
  if (successResponse.data.statusCode === 200) {
  this.token = successResponse;
  this.mNumber = Object.keys(successResponse.data.data.value).length;
  //console.log(this.token);
  }
  })
  .catch(failResponse => {
  })
  },

  selectItems(index){
  console.log(index);
  this.currentPage = 1;
  if(index=='推荐'){
    //console.log('进入推荐选项');
    this.label = null;
  }else{
  this.label = index;
  }
  //console.log(this.label);
  this.getMissionInfo();
  },
    },
  }
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1,
  h2 {
    font-weight: normal;
  }

  a {
    color: #42b983;
  }

  span.mission div {
    float: left;
  }
  span.rank div {
    float: left;
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
