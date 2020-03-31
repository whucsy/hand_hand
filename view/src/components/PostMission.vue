<template>
  <div style="margin-top:40px; margin-left: 350px;margin-right: 350px; ">
    <el-form :model="postForm" :rules="rules"  ref="postForm" label-width="150px" label-position="top" style="text-align: left" class="demo-postForm" >
<!--   通过rules属性传入约定的验证规则，并将Form-Item的prop属性设置为需校验的字段名-->
      <el-form-item label="任务标题" prop="title">
        <el-input v-model="postForm.title"></el-input>
      </el-form-item>

      <el-form-item label="任务描述" prop="desc">
        <el-input type="textarea" :rows="6" v-model="postForm.desc" ></el-input>
      </el-form-item>

      <el-form-item label="上传文件">
        <el-upload
          class="upload-demo"
          action="https://jsonplaceholder.typicode.com/posts/"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-remove="beforeRemove"
          multiple
          :limit="3"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">可以上传多个文件，不超过500kb</div>
        </el-upload>
      </el-form-item>


      <el-form-item label="截止日期" required>
      <el-col :span="11">
        <el-form-item prop="date1">
          <el-date-picker type="date" placeholder="选择日期" v-model="postForm.date1" style="width: 95%;"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col class="line" :span="1">-</el-col>
      <el-col :span="11">
        <el-form-item prop="date2">
          <el-time-picker placeholder="选择时间" v-model="postForm.date2" style="width: 95%;"></el-time-picker>
        </el-form-item>
      </el-col>
    </el-form-item>

      <el-form-item label="有效期" >
        <el-col :span="11">
          <el-form-item >
            <el-date-picker type="date" placeholder="选择日期" v-model="postForm.date3" style="width: 95%;"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col class="line" :span="1">-</el-col>
        <el-col :span="11">
          <el-form-item>
            <el-time-picker placeholder="选择时间" v-model="postForm.date4" style="width: 95%;"></el-time-picker>
          </el-form-item>
        </el-col>
      </el-form-item>


      <el-form-item label="酬金">
        <el-input v-model="postForm.money" ></el-input>
      </el-form-item>

      <el-form-item label="任务需要人数">
        <el-input v-model="postForm.peopleAmount" ></el-input>
      </el-form-item>


      <el-form-item label="修改次数">
        <el-select v-model="postForm.changeNumber" placeholder="请选择可修改次数">
          <el-option label="0" value=0></el-option>
          <el-option label="1" value=1></el-option>
          <el-option label="2" value=2></el-option>
          <el-option label="3" value=3></el-option>
        </el-select>
      </el-form-item>



      <el-form-item label="标签(最多选三个)" >
        <el-checkbox-group v-model="postForm.label" :max="3">
          <el-checkbox label="计算机" name="type"></el-checkbox>
          <el-checkbox label="视频" name="type"></el-checkbox>
          <el-checkbox label="图片" name="type"></el-checkbox>
          <el-checkbox label="美工" name="type"></el-checkbox>
          <el-checkbox label="摄影" name="type"></el-checkbox>
          <el-checkbox label="英语" name="type"></el-checkbox>
          <el-checkbox label="美术" name="type"></el-checkbox>
          <el-checkbox label="论文" name="type"></el-checkbox>
          <el-checkbox label="经济" name="type"></el-checkbox>
          <el-checkbox label="文章" name="type"></el-checkbox>
          <el-checkbox label="游戏" name="type"></el-checkbox>
          <el-checkbox label="数学" name="type"></el-checkbox>
          <el-checkbox label="物理" name="type"></el-checkbox>
          <el-checkbox label="外语" name="type"></el-checkbox>
          <el-checkbox label="书法" name="type"></el-checkbox>
        </el-checkbox-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submit('postForm')" >立即发布</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
  export default {
    name: "PostMission",
    data() {
      return {
        postForm: {
          title: '',
          desc: '',
          changeNumber: 1,
          //截止日期
          date1: '',
          date2: '',
          //有效期
          date3: '',
          date4: '',
          label: [],
          resource: '',
          peopleAmount: 1,
          money:0,
          fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
        },
        rules: {
          title: [
            { required: true, message: '请输入任务标题', trigger: 'blur' },
            { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
          ],
          date1: [
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          date2: [
            { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写任务详细描述', trigger: 'blur' }
          ]
        }
      };
    },

    methods: {
      submit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.postMission();
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      //发布任务
      postMission(){
        this.$axios.post('/api/mission/',{
          changeNumber: this.postForm.changeNumber,
          deadline: this.postForm.date1+' '+this.postForm.date2,
          existenceDate: this.postForm.date3+' '+this.postForm.date4,
          label1: this.postForm.label[0],
          label2: this.postForm.label[1],
          label3: this.postForm.label[2],
          missionInfo: this.postForm.desc,
          money: this.postForm.money,
          mtitle: this.postForm.title,
          peopleAmount: this.postForm.peopleAmount,
          uid: 1
        }).then(successResponse => {
          if (successResponse.status === 200) {
            alert('发布成功')
          }
        }).catch(failResponse => {
          alert('发布失败')
        })
      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      }
    }
  }

</script>

<style scoped>

</style>
