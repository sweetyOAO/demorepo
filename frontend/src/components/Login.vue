<template>
  <div class="app-container">
    <!-- 登录界面 -->
    <div class="login-container">
      <div class="header">
        <h2>登录Demo</h2>
      </div>

      <div class="form-container">
        <form @submit.prevent="handleLogin">
          <div class="input-group">
            <label for="email">邮箱</label>
            <i class="fas fa-envelope"></i>
            <input type="email" id="email" v-model="email" required placeholder="请输入邮箱">
          </div>

          <div class="input-group">
            <label for="password">密码</label>
            <i class="fas fa-lock"></i>
            <input type="password" id="password" v-model="password" required placeholder="请输入密码">
          </div>

          <div class="button-group">
            <button type="submit" class="login-btn" @click="handleLogin" :disabled="isLoading">
              <i class="fas fa-sign-in-alt"></i>
              {{ isLoading ? '登录' : '登录' }}
            </button>
            <button type="button" class="register-btn" @click="handleRegister" :disabled="isLoading">
              <i class="fas fa-user-plus"></i>
              {{ isLoading ? '注册' : '注册' }}
            </button>
          </div>
        </form>

        <div v-if="errorMessage" class="error-message">
          <i class="fas fa-exclamation-circle"></i>
          {{ errorMessage }}
        </div>

        <div v-if="successMessage" class="success-message">
          <i class="fas fa-check-circle"></i>
          {{ successMessage }}
        </div>

        <div class="demo-accounts">
          <p>测试账户：</p>
          <div class="account">
            <span>管理员: </span>
            <span>admin@example.com / admin123</span>
          </div>
          <div class="account">
            <span>普通用户: </span>
            <span>user@example.com / user123</span>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import { ref } from 'vue'
import { supabase } from '../supabase'
import { useRouter } from 'vue-router'

export default {
  name: 'LoginView',
  setup() {
    const router = useRouter()
    const email = ref('admin@example.com')
    const password = ref('admin123')
    const errorMessage = ref('')
    const successMessage = ref('')
    const isLoading = ref(false)
    const isLoggedIn = ref(false)

    const handleLogin = async () => {
      if (!email.value || !password.value) {
        errorMessage.value = '请输入邮箱和密码'
        return
      }

      isLoading.value = true
      errorMessage.value = ''
      successMessage.value = ''

      try {
        const { error } = await supabase.auth.signInWithPassword({
          email: email.value,
          password: password.value
        })

        if (error) throw error

        // 登录成功
        isLoggedIn.value = true
        successMessage.value = '登录成功！即将跳转'
        console.log('登录成功')

        setTimeout(() => {
          router.push('/management')
        }, 1500)
      } catch (error) {
        console.error('登录错误:', error)
        errorMessage.value = getLoginErrorMessage(error)
      } finally {
        isLoading.value = false
      }
    }

    const handleRegister = async () => {
      if (!email.value || !password.value) {
        errorMessage.value = '请输入邮箱和密码'
        return
      }

      isLoading.value = true
      errorMessage.value = ''
      successMessage.value = ''

      try {
        const { error } = await supabase.auth.signUp({
          email: email.value,
          password: password.value
        })

        if (error) throw error

        // 注册成功
        successMessage.value = '注册成功'
        console.log('注册成功')
      } catch (error) {
        console.error('注册错误:', error)
        errorMessage.value = getRegisterErrorMessage(error)
      } finally {
        isLoading.value = false
      }
    }

    const getLoginErrorMessage = (error) => {
      switch (error.message) {
        case 'Invalid login credentials':
          return '邮箱或密码错误，请重试或点击注册按钮创建新账户'
        case 'Email not confirmed':
          return '请先验证您的邮箱'
        default:
          return `登录失败: ${error.message}`
      }
    }

    const getRegisterErrorMessage = (error) => {
      switch (error.message) {
        case 'User already registered':
          return '该邮箱已被注册，请直接登录'
        case 'Password should be at least 6 characters':
          return '密码长度至少为6个字符'
        default:
          return `注册失败: ${error.message}`
      }
    }

    return {
      email,
      password,
      errorMessage,
      successMessage,
      isLoading,
      isLoggedIn,
      handleLogin,
      handleRegister
    }
  }
}
</script>

<style scoped>
/* 基础样式 */
.login-container {
  max-width: 400px;
  margin: 10vh auto;
  padding: 2rem;
  border-radius: 8px;
  background: #0f172a; /* 深蓝色科技感背景 */
  color: #e2e8f0; /* 浅灰色文字 */
  box-shadow: 0 4px 20px rgba(7, 89, 133, 0.5); /* 蓝色阴影 */
}

.header {
  text-align: center;
  margin-bottom: 1.5rem;
}

.header h2 {
  font-size: 1.8rem;
  color: #38bdf8; /* 科技蓝标题 */
  letter-spacing: 1px;
}

/* 输入框样式 */
.input-group {
  position: relative;
  margin-bottom: 1.5rem;
}

.input-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: 500;
}

.input-group i {
  position: absolute;
  left: 12px;
  top: 40px;
  color: #60a5fa; /* 蓝色图标 */
}

.input-group input {
  width: 100%;
  max-width: 300px;
  padding: 0.8rem;
  box-sizing: border-box;
  background: rgba(30, 41, 59, 0.7); /* 深蓝输入框背景 */
  border: 1px solid #1e293b;
  border-radius: 6px;
  color: #f1f5f9;
  font-size: 1rem;
  transition: all 0.2s;
  overflow: hidden;
}

.input-group input:focus {
  outline: none;
  border-color: #38bdf8;
  box-shadow: 0 0 0 3px rgba(56, 189, 248, 0.2);
}

.input-group input::placeholder {
  color: #94a3b8;
}

/* 按钮样式 */
.button-group {
  display: flex;
  gap: 1rem;
  margin-top: 1.5rem;
}

button {
  flex: 1;
  padding: 0.9rem;
  border-radius: 6px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.login-btn {
  background: #0ea5e9; /* 科技蓝按钮 */
  color: white;
  border: none;
}

.login-btn:hover:not(:disabled) {
  background: #0284c7;
}

.register-btn {
  background: transparent;
  color: #0ea5e9;
  border: 1px solid #0ea5e9;
}

.register-btn:hover:not(:disabled) {
  background: rgba(14, 165, 233, 0.1);
}

button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

/* 消息提示 */
.error-message, .success-message {
  padding: 0.8rem;
  border-radius: 6px;
  margin: 1rem 0;
  font-size: 0.9rem;
  display: flex;
  align-items: center;
  gap: 0.6rem;
}

.error-message {
  background: rgba(220, 38, 38, 0.15);
  color: #f87171;
  border: 1px solid rgba(220, 38, 38, 0.3);
}

.success-message {
  background: rgba(34, 197, 94, 0.15);
  color: #4ade80;
  border: 1px solid rgba(34, 197, 94, 0.3);
}

/* 测试账户 */
.demo-accounts {
  margin-top: 1.5rem;
  padding-top: 1.2rem;
  border-top: 1px solid #1e293b;
  font-size: 0.85rem;
  color: #94a3b8;
}

.demo-accounts p {
  margin-bottom: 0.5rem;
}

.account {
  background: rgba(30, 41, 59, 0.5);
  padding: 0.8rem;
  border-radius: 6px;
  margin-bottom: 0.7rem;
}

.account span:first-child {
  font-weight: 500;
}
</style>