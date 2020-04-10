<template>
<div>
<div>{{input}}</div>
<div>{{select}}</div>
</div>
</template>

<script>
 export default {
  name: 'searchResult',
  data() {
  return {
    input:'',
    select:'',
  }
  },
  mounted() {
  this.getParams();
  },
  methods: {
  getParams () {
  // 取到路由带过来的参数
  this.input = this.$route.params.input;
  this.select = this.$route.params.select;
  }
  },
  watch: {
  // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
  '$route': 'getParams'
  }
}
</script>

<style scoped>
</style>
