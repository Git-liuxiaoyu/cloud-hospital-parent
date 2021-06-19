<template>
  <div class="wrapper">
    <!-- 头部 -->
    <el-row class="l-head">
      <el-col :span="10" :push="1" class="l-head-zj">
<!--         <i class="glyphicon glyphicon-leaf"></i>-->
        <span style="line-height: 60px;">小蜗牛医院管理系统</span>
      </el-col>
    </el-row>

    <el-container>
      <!-- 中左 -->
      <!-- default-active默认显示高亮 -->
      <el-aside width="200px" class="main-left">
        <el-menu class="el-menu-vertical-demo" :router="true" background-color="#F5F5F5"
          :unique-opened="true" default-active="index">

          <el-menu-item index="index">
            <i class="glyphicon glyphicon-home"></i>
            <span slot="title">系统首页</span>
          </el-menu-item>

          <el-submenu :index="item.id + ''" v-for="item in menu" :key="item.id">
            <template slot="title">
              <i class="glyphicon glyphicon-list"></i>
              <span>{{ item.name }}</span>
            </template>

            <el-menu-item-group>
              <el-menu-item :index="son.href" v-for="son in item.children" :key="son.id">
                <i class="glyphicon glyphicon-align-left"></i>
                <span>{{ son.name }}</span>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <!-- 中右 -->
      <el-main class="main-right">
        <router-view/>
      </el-main>

    </el-container>
  </div>
</template>

<script>
export default {
  name: "home"
}
</script>

<style scoped>
.main-left {
  background-color: #f5f5f5;
  height: 90vh;
  overflow-y: auto;
}

.main-right {
  background-color: white;
  height: 90vh;
  overflow-y: auto;
}

.wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100%;
}

.l-head {
  background-color: #438eb9;
}

.l-head-zj {
  font-size: 30px;
  margin-left: 20px;
  color: white;
  line-height: 65px;
  height: 10vh;
}

</style>
