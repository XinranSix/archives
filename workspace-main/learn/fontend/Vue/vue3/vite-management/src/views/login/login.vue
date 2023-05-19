<template>
  <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      :rules="rules"
      class="demo-ruleForm"
  >
    <el-form-item prop="username">
      <el-input v-model="ruleForm.username" type="text" autocomplete="off"/>
    </el-form-item>
    <el-form-item prop="pwd">
      <el-input
          v-model="ruleForm.pwd"
          type="password"
          autocomplete="off"
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="loginFn()">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup lang="ts">
import {ref, reactive, toRefs} from 'vue'

let {ruleForm} = toRefs(reactive({
  ruleForm: {
    username: '',
    pwd: ''
  }
}))

const validatePwd = (rule: unknown, value: string | undefined, callBack: (msg?: string) => void) => {
  if (!value) {
    callBack('密码不能为空')
  } else {
    callBack()
  }
}

const rules = reactive({
  username: [
    {required: true, message: '用户名不能为空', trigger: 'blur'}
  ],
  pwd: [{validator: validatePwd, trigger: 'blur'}],
})

let ruleFormRef = ref()

const loginFn = () => {
  ruleFormRef.value.validate().then(() => {
    console.log('校验通过')
  }).catch(() => {
    console.log('校验不通过')
  })
}
</script>

<style scoped>

</style>
