
<template>
    <div style="height: 50px; background-color: #222831; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
        <div style="width: 200px;padding-left: 30px;font-weight: bold;color: #E8E8E8">后台管理</div>
        <div style="flex: 1"></div>
        <div style="width: 100px">
            <el-dropdown :hide-on-click="false">
                <span style="color: #E8E8E8" class="el-dropdown-link" >
                  设置<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item disabled>个人信息</el-dropdown-item>
                        <el-dropdown-item disabled>退出系统</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>