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
                    <i class="el-icon-message-solid"></i>
                    <span>信息管理</span>
                </template>
                <el-menu-item index="user" :route="{path: '/'}">
                    <i class="el-icon-user"></i>
                    <span>用户信息</span>
                </el-menu-item>
                <el-menu-item index="admin" :route="{path: '/'}" disabled="false">
                    <i class="el-icon-coffee-cup"></i>
                    <span>管理员信息</span>
                </el-menu-item>
                <el-menu-item index="admin" :route="{path: '/'}" disabled="false">
                    <i class="el-icon-info"></i>
                    <span>招生信息</span>
                </el-menu-item>
                <el-menu-item index="admin" :route="{path: '/'}" disabled="false">
                    <i class="el-icon-cpu"></i>
                    <span>招生员信息</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="1" disabled="false">
                <template #title>
                    <i class="el-icon-key"></i>
                    <span>权限管理</span>
                </template>
            </el-sub-menu>
            <el-sub-menu index="1" disabled="false">
                <template #title>
                    <i class="el-icon-setting"></i>
                    <span>系统设置</span>
                </template>
            </el-sub-menu>
        </el-menu>
    </div>
</template>