<template>
  <div>

    <el-container style="width: 1200px; border: 1px solid rgba(211,211,211,0.09);margin-left: 50px">
      <el-main>
        <el-tabs :tab-position="tabPosition" style="height: 1000px;" head="管理员中心">
          <el-tab-pane label="用户管理">
            <h2 style="float: left;margin-left: 10px">开发人员管理</h2>
            <el-table
              :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
              style="width: 90%">
              <el-table-column
                label="ID"
                prop="uid">
              </el-table-column>
              <el-table-column
                label="Name"
                prop="userName">
              </el-table-column>
              <el-table-column
                label="PhoneNumber"
                prop="phoneNumber">
              </el-table-column>
              <el-table-column
                align="right">
                <template slot="header" slot-scope="scope">
                  <el-input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"/>
                </template>
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    @click="handleEdit(scope.row)">Edit
                  </el-button>
                  <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.row)">Delete
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>
          <el-tab-pane label="消息管理">

          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "Manager.vue",
    data() {
      return {
        activeIndex: '1',
        tabPosition: 'left',
        tableData: [],
        search: ''
      };
    },
    created() {
      this.getAllManager();
    },

    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleEdit(row){
        //编辑管理员信息
      },
      handleDelete(){
        //删除管理员信息
      },
      getAllManager() {
        //获取所有管理员的信息
        this.$axios.get('/api/userAccount/manager')
          .then(successResponse => {
            if (successResponse.status === 200) {
              console.log(successResponse.data);
              this.tableData = successResponse.data.data.value;
            }
          })
          .catch(failResponse => {
            alert('获取管理员信息失败');
          })
      },
    }
  }
</script>

<style scoped>

</style>
