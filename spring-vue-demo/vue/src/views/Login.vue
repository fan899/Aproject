<template>
    <div style="width: 100%; height: 100vh; background-color: darkslateblue;overflow: hidden">
        <div style="width: 400px;margin: 150px auto">
            <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 15px">欢迎登录</div>
            <el-form ref="form" :model="form" size="normal">
                <el-form-item>
                    <el-input prefix-icon="el-icon-user" v-model="form.adminId"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input prefix-icon="el-icon-lock" v-model="form.adminPwd" show-password></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button style="width: 100%" type="primary" @click="login">登录</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import request from "../utils/request";

    export default {
        name: "Login",
        data(){
            return{
                form:{}
            }
        },
        methods: {
            /*登录*/
            login(){
                request.post("/api/adminController/login",this.form).then(res =>{
                    if (res.code === '0'){
                        this.$messageBox({
                            type: "success",
                            message: "登录成功"
                        })
                        this.$router.push("/home")  /*登录成功后跳转到后台页面*/
                    }else {
                        this.$messageBox({
                            type: "error",
                            message: "用户名或密码错误！"
                        })
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>