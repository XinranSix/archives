<template>
  <div :xl="6" :lg="7" class="bg-login">
    <!--logo-->
    <el-image src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/logo.svg" class="logo"/>
    <!--标题-->
    <el-row type="flex" class="row-bg row-two" justify="center" align="middle">
      <el-col :span="6"></el-col>
      <el-col :span="6">
        <!--标题-->
        <h1 class="title">个人图书管理系统</h1>
      </el-col>
      <el-col :span="6"></el-col>
    </el-row>
    <!--form表单-->
    <el-row type="flex" class="row-bg card" justify="center" align="bottom">
      <el-col :span="7" class="login-card">
        <!--loginForm-->
        <el-form :model="loginForm" :rules="rules" ref="loginForm" label-width="21%" class="loginForm">
          <el-form-item label="账户" prop="username" style="width: 380px">
            <el-input v-model="loginForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password" style="width: 380px">
            <el-input type="password" v-model="loginForm.password"></el-input>
          </el-form-item>
          <el-form-item label="验证码" prop="code" style="width: 380px">
            <el-input v-model="loginForm.code" class="code-input" style="width: 70%;float: left"></el-input>
            <!--验证码图片-->
            <el-image :src="codeImg" class="codeImg"></el-image>
          </el-form-item>
          <el-form-item label="记住密码" prop="remember">
            <el-switch v-model="loginForm.remember"></el-switch>
          </el-form-item>
          <el-form-item class="btn-ground">
            <el-button type="primary" @click="submitForm('loginForm')">立即登陆</el-button>
            <el-button @click="resetForm('loginForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import {ref, reactive} from 'vue'

interface LoginFormItf {
  username: string,
  password: string,
  code: string,
  remember: boolean,
  codeToken: string
}

let loginForm = reactive<LoginFormItf>({
  username: '',
  password: '',
  code: '',
  remember: false,
  codeToken: ''
})

interface RulesItf {
  username: Array<Object>,
  password: Array<Object>
  code: Array<Object>
}

let rules = reactive<RulesItf>({
  username: [
    {required: true, message: '请输入账户', trigger: 'blur'},
    {min: 3, max: 10, message: '长度在 3 到 10 个字符的账户', trigger: 'blur'}
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 6, max: 15, message: '长度在 6 到 15 个字符的密码', trigger: 'blur'}
  ],
  code: [
    {required: true, message: '请输入验证码', trigger: 'blur'},
    {min: 5, max: 5, message: '长度为 5 个字符', trigger: 'blur'}
  ]
})

// const submitForm = (formName: any) => {
//   this.$refs[formName].validate((valid) => {
//     if (valid) {
//       // 表单验证成功
//       alert('submit')
//     } else {
//       console.log('error submit!!');
//       return false;
//     }
//   });
// }


//     // 提交表单
//     submitForm(formName) {

//     },
//     // 重置表单
//     resetForm(formName) {
//       this.$refs[formName].resetFields();
//     }


</script>

<style scoped lang="less">
.codeImg {
  /*让验证码图片飘在右边*/
  float: right;
  /*设置一些圆角边框*/
  border-radius: 3px;
  /*设置宽度*/
  width: 26%;
}

.bg-login {
  height: 100%;
  background-image: url("https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/411845.jpg");
  background-size: 100%;

}

.btn-ground {
  text-align: center;
}

.logo {
  margin: 30px;
  height: 70px;
  width: 70px;
  position: fixed;
}

.title {
  text-shadow: -3px 3px 1px #5f565e;
  text-align: center;
  margin-top: 60%;
  color: #41b9a6;
  font-size: 40px;
}

.login-card {
  background-color: #ffffff;
  opacity: 0.9;
  box-shadow: 0 0 20px #ffffff;
  border-radius: 10px;
  padding: 40px 40px 30px 15px;
  width: auto;
}
</style>
