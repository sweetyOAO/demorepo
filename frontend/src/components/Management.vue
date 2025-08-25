<template>
  <div class="management">

    <!-- 添加图书表单 -->
    <div class="form-section">
      <h3>{{ editingBook ? '编辑图书' : '添加新图书' }}</h3>
      <form @submit.prevent="editingBook ? updateBook() : addBook()">
        <div class="input-group">
          <label>书名</label>
          <input type="text" v-model="currentBook.title" required>
        </div>
        <div class="input-group">
          <label>作者</label>
          <input type="text" v-model="currentBook.author" required>
        </div>
        <div class="input-group">
          <label>ISBN</label>
          <input type="text" v-model="currentBook.isbn">
        </div>
        <div class="input-group">
          <label>出版社</label>
          <input type="text" v-model="currentBook.publisher">
        </div>
        <div class="input-group">
          <label>出版年份</label>
          <input type="number" v-model="currentBook.publish_year" min="1900" :max="new Date().getFullYear()">
        </div>
        <div class="input-group">
          <label>分类</label>
          <input type="text" v-model="currentBook.genre">
        </div>
        <div class="input-group">
          <label>馆藏数量</label>
          <input type="number" v-model="currentBook.total_copies">
        </div>
        <div class="input-group">
          <label>描述</label>
          <textarea v-model="currentBook.description"></textarea>
        </div>
        <div class="button-group">
          <button type="submit">{{ editingBook ? '更新' : '添加' }}</button>
          <button type="button" v-if="editingBook" @click="cancelEdit">取消</button>
          <button type="button" @click="fetchUsers">用户信息</button>
        </div>
      </form>
    </div>

    <!-- 图书列表 -->
    <div class="book-list">
      <h3>图书列表</h3>
      <table>
        <thead>
        <tr>
          <th>书名</th>
          <th>作者</th>
          <th>ISBN</th>
          <th>出版社</th>
          <th>年份</th>
          <th>馆藏</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="book in books" :key="book.id">
          <td>{{ book.title }}</td>
          <td>{{ book.author }}</td>
          <td>{{ book.isbn || '-' }}</td>
          <td>{{ book.publisher || '-' }}</td>
          <td>{{ book.publish_year || '-' }}</td>
          <td>{{ book.total_copies }}册</td>
          <td>
            <button @click="editBook(book)">编辑</button>
            <button @click="deleteBook(book.id)">删除</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>

    <!-- 用户列表 -->
    <div class="user-list" v-if="users.length">
      <h3>用户列表</h3>
      <table>
        <thead>
        <tr>
          <th>Email</th>
          <th>用户名</th>
          <th>管理员</th>
          <th>注册时间</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="u in users" :key="u.id">
          <td>{{ u.email }}</td>
          <td>{{ u.username || '-' }}</td>
          <td>{{ u.isAdmin ? '是' : '否' }}</td>
          <td>{{ u.createdAt }}</td>
        </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { supabase } from '../supabase'

const users = ref([])
const fetchUsers = async () => {
  try {
    const res = await fetch('http://localhost:9000/users/getusers')
    users.value = await res.json()
  } catch (err) {
    console.error('获取用户信息失败:', err)
  }
}
// 图书列表
const books = ref([])
// 当前编辑的图书
const currentBook = ref(createEmptyBook())
// 是否处于编辑模式
const editingBook = ref(null)

// 创建空图书对象
function createEmptyBook() {
  return {
    title: '',
    author: '',
    isbn: '',
    publisher: '',
    publish_year: '',
    genre: '',
    description: '',
    total_copies: 1,
    available_copies: 1
  }
}

// 获取图书列表
const fetchBooks = async () => {
  try {
    const { data, error } = await supabase
        .from('books')
        .select('*')
        .order('created_at', { ascending: false })

    if (error) throw error
    books.value = data
  } catch (error) {
    console.error('获取图书失败:', error)
  }
}

// 添加图书
const addBook = async () => {
  try {
    // 设置可借阅数量等于总馆藏数量
    const bookData = {
      ...currentBook.value,
      available_copies: currentBook.value.total_copies
    }

    const { error } = await supabase
        .from('books')
        .insert([bookData])

    if (error) throw error

    // 清空表单并刷新列表
    currentBook.value = createEmptyBook()
    await fetchBooks()
  } catch (error) {
    console.error('添加图书失败:', error)
  }
}

// 编辑图书
const editBook = (book) => {
  editingBook.value = book.id
  currentBook.value = { ...book }
}

// 更新图书
const updateBook = async () => {
  try {
    // 计算新的可借阅数量
    const originalBook = books.value.find(b => b.id === editingBook.value)
    const copiesDiff = currentBook.value.total_copies - originalBook.total_copies

    const updatedBook = {
      ...currentBook.value,
      available_copies: originalBook.available_copies + copiesDiff
    }

    const { error } = await supabase
        .from('books')
        .update(updatedBook)
        .eq('id', editingBook.value)

    if (error) throw error

    // 重置编辑状态
    cancelEdit()
    await fetchBooks()
  } catch (error) {
    console.error('更新图书失败:', error)
  }
}

// 取消编辑
const cancelEdit = () => {
  editingBook.value = null
  currentBook.value = createEmptyBook()
}

// 删除图书
const deleteBook = async (id) => {
  if (!confirm('确定要删除这本图书吗?')) return

  try {
    const { error } = await supabase
        .from('books')
        .delete()
        .eq('id', id)

    if (error) throw error
    await fetchBooks()
  } catch (error) {
    console.error('删除图书失败:', error)
  }
}

// 初始化获取图书
onMounted(fetchBooks)
</script>

<style scoped>
/* 基础样式 */
.management {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background: #121212;
  color: #f5f5f5;
  box-sizing: border-box; /* 防止溢出 */
}

/* 表单区域 */
.form-section {
  margin-bottom: 30px;
  padding: 20px;
  background: #222;
  border-radius: 8px;
}

.input-group {
  margin-bottom: 15px;
}

.input-group label {
  display: block;
  margin-bottom: 8px;
  color: #e0e0e0;
  font-weight: 500;
}

.input-group input,
.input-group textarea {
  width: 100%;
  padding: 12px;
  background: #333;
  border: 1px solid #555;
  color: #fff;
  border-radius: 4px;
  box-sizing: border-box; /* 关键：防止输入框溢出 */
}

.input-group textarea {
  min-height: 100px;
}

/* 按钮组 */
.button-group {
  display: flex;
  gap: 12px;
  margin-top: 18px;
  flex-wrap: wrap; /* 小屏幕自动换行 */
}

button {
  padding: 10px 16px;
  border-radius: 4px;
  font-weight: 600;
  cursor: pointer;
  flex: 1; /* 按钮自动填充剩余空间 */
  min-width: 120px; /* 避免过度压缩 */
}

button:first-child {
  background: #4361ee;
  color: white;
}

button:last-child {
  background: transparent;
  color: #4361ee;
  border: 1px solid #4361ee;
}

/* 表格优化 */
.book-list {
  overflow-x: auto; /* 小屏幕横向滚动 */
}

.book-list table {
  width: 100%;
  min-width: 600px; /* 最小宽度保证表格结构 */
  border-collapse: collapse;
  margin-top: 24px;
}

th, td {
  padding: 12px;
  text-align: left;
  white-space: nowrap; /* 防止文字换行混乱 */
}

th {
  background: #222;
  color: #64ffda;
  border-bottom: 2px solid #64ffda;
}

td {
  border-bottom: 1px solid #444;
}

tr:hover {
  background: #1e1e1e;
}

/* ---------- 响应式适配 ---------- */
/* 平板及以下设备 */
@media (max-width: 768px) {
  .management {
    padding: 15px; /* 减少内边距 */
  }
  .form-section {
    padding: 15px;
  }
  /* 按钮组垂直排列 */
  .button-group {
    flex-direction: column;
  }
}

/* 手机设备 */
@media (max-width: 480px) {
  .management {
    padding: 10px;
  }
  .form-section {
    padding: 12px;
  }
  /* 隐藏非核心表格列 */
  th:nth-child(4), td:nth-child(4), /* 出版社 */
  th:nth-child(5), td:nth-child(5) /* 年份 */ {
    display: none;
  }
}
</style>