<template>
  <div style="padding: 10px">
    <!--功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary" disabled>导入</el-button>
      <el-button type="primary" disabled>导出</el-button>
    </div>

    <!--搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="输入关键字" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>
    </div>

    <!--数据展示区域-->
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="userId" label="账号" sortable/>
      <el-table-column prop="userPwd" label="密码"/>
      <el-table-column prop="userName" label="姓名"/>

      <el-table-column label="操作" >
        <template #default="scope">
          <el-button size="mini" type="text" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除吗?" @confirm="handleDelete(scope.row.userId)">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <div style="margin: 10px 0">
      <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              v-model:currentPage="currentPage"
              :page-sizes="[5, 10, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户账号">
            <el-input v-model="form.userId" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="用户密码">
            <el-input v-model="form.userPwd" style="width: 80%"></el-input>
          </el-form-item>
          <el-form-item label="用户名称">
            <el-input v-model="form.userName" style="width: 80%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
        </template>
      </el-dialog>

    </div>
  </div>
</template>

<script>


import request from "../utils/request";

export default {
  name: 'Home',
  components: {

  },
  data(){
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [

      ]
    }
  },
  /*页面加载时调用查询*/
  created() {
    this.load()
  },
  methods: {
    /*查询*/
    load(){
      request.get("/api/userController/findPage",{
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    /*新增按钮*/
    add(){
      this.dialogVisible = true
      this.form = {}
    },
    /*新增按钮的确认按钮or编辑的确认按钮*/
    save(){
      if(this.form.userId){//有主键更新
        request.put("/api/userController/updateUser",this.form).then(res =>{
          console.log(res)
          if (res.code === '0'){
            this.$messageBox({
              type: "success",
              message: "更新成功"
            })
          }else {
            this.$messageBox({
              type: "error",
              message: res.msq
            })
          }
        this.load() //刷新表格的数据
        this.dialogVisible = false //关闭弹窗
        })
      }else {//无主键新增
        request.post("/api/userController/insertUser",this.form).then(res =>{
          console.log(res)
          if (res.code === '0'){
            this.$messageBox({
              type: "success",
              message: "新增成功"
            })
          }else {
            this.$messageBox({
              type: "error",
              message: res.msq
            })
          }
          this.load() //刷新表格的数据
          this.dialogVisible = false //关闭弹窗
        })
      }

    },
    /*编辑弹窗*/
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete( id ){
      console.log(id )
      request.delete("/api/userController/deleteUser/" + id).then(res =>{
        if (res.code === '0'){
          this.$messageBox({
            type: "success",
            message: "删除成功"
          })
        }else {
          this.$messageBox({
            type: "error",
            message: res.msq
          })
        }
        this.load() //删除完刷新表格

      })
    },
    /*改变当前每页的个数触发*/
    handleSizeChange(pageSize){
      this.pageSize=pageSize
      this.load()
    },
    /*改变当前页码触发*/
    handleCurrentChange(pageNum){
      this.pageNum=pageNum
      this.load()
    }

  }
}
</script>
