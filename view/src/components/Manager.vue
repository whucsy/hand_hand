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
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="消息内容">
                <el-input type="textarea" v-model="form.info"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">发送</el-button>
              </el-form-item>
            </el-form>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
    <el-dialog
      title="提示"
      :visible.sync="centerDialogVisible"
      width="30%"
      center>
      <el-form :label-position=labelPosition model="EditForm">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="EditForm.userName" :value="nowManager.userName"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth">
          <el-input v-model="EditForm.phoneNumber" :value="nowManager.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input type="password" v-model="EditForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="座右铭" :label-width="formLabelWidth">
          <el-input v-model="EditForm.motto" :value="nowManager.motto"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
      <el-button @click="centerDialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="updateManager()">确 定</el-button>
      </span>
    </el-dialog>
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
        search: '',

        nowManager:'',//当前被点击的管理员

        /*修改框*/
        centerDialogVisible: false, //编辑框可不可见
        formLabelWidth: '80px',     //表单label宽度
        labelPosition: 'top',
        EditForm:{
          userName:'',
          phoneNumber:'',
          password:'',
          motto:''
        },


        /*消息发送表单*/
        form:{
          info:''
        }
      };
    },
    created() {
      this.getAllManager();
    },

    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleEdit(row) {
        //获取当前管理员
        for(let i = 0; i < this.tableData.length; i++){
          if(this.tableData[i].uid === row.uid){
            this.nowManager = this.tableData[i];
            break;
          }
        }
        //弹出编辑框
        this.centerDialogVisible = true
      },
      updateManager(){
        //更新管理员
        this.$axios.put('/api/userAccount',{
          "balance": this.nowManager.balance,
          "icon": this.nowManager.icon,
          "level": this.nowManager.level,
          "motto": this.EditForm.motto,
          "password": this.EditForm.password,
          "phoneNumber": this.EditForm.phoneNumber,
          "role": 1,
          "score": this.nowManager.score,
          "uid": this.nowManager.uid,
          "userName": this.EditForm.userName
        }).then(successResponse => {
          if (successResponse.status === 200) {
            alert('更新成功');
            this.getAllManager();
            this.centerDialogVisible = false;
          }
        }).catch(failResponse => {
          alert('更新失败')
        })
      },
      handleDelete(row) {
        //删除管理员信息
        this.$axios.delete('/api/userAccount',{
          params:{
            'uid': row.uid
          }
        }).then(successResponse => {
          if (successResponse.status === 200) {
            alert('删除成功');
            this.getAllManager();
          }
        }).catch(failResponse => {
          alert('删除失败')
        })
      },
      getAllManager() {
        //获取所有管理员的信息
        this.$axios.get('/api/userAccount/manager')
          .then(successResponse => {
            if (successResponse.status === 200) {
              this.tableData = successResponse.data.data.value;
            }
          })
          .catch(failResponse => {
            alert('获取管理员信息失败');
          })
      },

      //发送消息
      onSubmit(){

      }
    }
  }
</script>

<style scoped>

</style>
