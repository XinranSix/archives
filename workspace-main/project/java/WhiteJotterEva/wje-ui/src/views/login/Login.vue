<template>
  <body id="paper">
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox class="login_remember" v-model="checked"
                 label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
      <!--      <router-link to="register" style="width: 100%"><el-button type="primary" style="width: 100%;background: #505458;border: none">注册</el-button></router-link>-->
    </el-form-item>
  </el-form>
  </body>
</template>

<script setup lang="ts">
import {reactive, ref} from 'vue'
import axios from '@/utils/request'
import {ElMessage} from 'element-plus'
import {useRouter, Router} from 'vue-router'
import {mapMutations} from 'vuex'

// 创建路由对象
const router: Router = useRouter()

let loginForm = reactive({
  username: 'admin',
  password: 'admin'
})

let checked = ref<boolean>(true)

let loading = ref<boolean>(false)

let rules = reactive({
  username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
  password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
})

const login = () => {
  // console.log(loginForm)
  axios.post('/login', loginForm).then(res => {
    console.log(res.data)
    if (res.data.flag) {
      ElMessage({
        message: res.data.message,
        type: 'success',
      })
      router.push('/index')
    } else {
      ElMessage({
        message: res.data.message,
        type: 'error',
      })
    }
  })

}
</script>
<style scoped lang="less">
#paper {
  background: url('../../assets/img/bg/eva1.jpg') no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: 0;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
