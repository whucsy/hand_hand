<template>
<div>
<span class="mission" v-for="n in mNumber" v-if="select === '2'">
<div style="width:400px;border-radius: 4px;background-color: rgb(238, 241, 246);text-align: left;height:250px;margin-top:15px;margin-right:15px" >
<div>
<span style="font-size: 20px;margin-left:10px;">{{ token.data.data.value[n-1].mtitle }}</span>
<i class="el-icon-coin" style="margin-right:15px">{{ token.data.data.value[n-1].money }}</i>
</div>
<div style="width:380px;border-radius: 4px;background-color: rgb(255, 255, 255);margin-left:10px;margin-right:10px;margin-top:10px;height:155px">
{{ token.data.data.value[n-1].missionInfo }}
</div>
<div style="align-items:center; display: -webkit-flex;">
<span><el-avatar style="margin-top:10px;margin-left:10px"> user </el-avatar></span>
<span style="margin-left:10px;">{{ token.data.data.value[n-1].uid }}</span>
</div>
</div>
</span>
</div>
</template>

<script>
 export default {
  name: 'searchResult',
  data() {
  return {
    input:'',
    select:'',
  token: null,
  mNumber: null,
  }
  },
  mounted() {
  this.getParams();
  this.getMission();
  },
  methods: {
  getParams () {
  // 取到路由带过来的参数
  this.input = this.$route.params.input;
  this.select = this.$route.params.select;
  console.log(this.input);
  },
  getMission() {
  this.$axios
  .get('/api/mission/key', {
  params: {
    page:1,
  size:10,
  key:this.input,
  }
  })
  .then(successResponse => {
  console.log(successResponse);
  if (successResponse.data.statusCode === 200) {
  this.token = successResponse;
  this.mNumber = Object.keys(successResponse.data.data.value).length;
  console.log(this.token);
  }
  })
  .catch(failResponse => {
  })
  },
  },
  watch: {
  // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
  '$route': 'getParams'
  }
}
</script>

<style scoped>
</style>
