<template>
    <div>
        <el-menu
                style="width: 200px;min-height: calc(100vh - 50px)"
                default-active="user"
                :default-openeds="[1]"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">

            <el-sub-menu index="1">
                <template #title>
                    <i class="el-icon-setting"></i>
                    <span>信息管理</span>
                </template>
                <el-menu-item index="user" :route="{path: '/'}">
                    <i class="el-icon-info"></i>
                    <span>用户信息</span>
                </el-menu-item>
                <el-menu-item index="admin" :route="{path: '/'}">
                    <i class="el-icon-info"></i>
                    <span>管理员信息</span>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>
    </div>
</template>